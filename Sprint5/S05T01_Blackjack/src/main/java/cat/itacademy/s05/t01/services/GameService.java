package cat.itacademy.s05.t01.services;

import cat.itacademy.s05.t01.exception.GameNotFoundException;
import cat.itacademy.s05.t01.model.Game;
import cat.itacademy.s05.t01.model.Player;
import cat.itacademy.s05.t01.repository.GameRepository;
import cat.itacademy.s05.t01.repository.PlayerRepository;
import cat.itacademy.s05.t01.services.Blackjack.BlackjackLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GameService {
   private final GameRepository gameRepository;
   private final PlayerRepository playerRepository;

   @Autowired
   public GameService(GameRepository gameRepository, PlayerRepository playerRepository) {
      this.gameRepository = gameRepository;
      this.playerRepository = playerRepository;
   }

   public Mono<String> createNewGame(String playerName) {
      Player newPlayer = new Player();
      newPlayer.setName(playerName);

      return playerRepository.save(newPlayer)
              .flatMap(savedPlayer -> {
                 Game game = new Game();
                 game.addPlayer(savedPlayer);
                 return gameRepository.save(game)
                         .map(savedGame -> "Game created successfully with Game ID: " + savedGame.getId());
              })
              .onErrorResume(e -> {
                 System.err.println("Failed to create game or player: " + e.getMessage());
                 return Mono.just("Failed to create game: " + e.getMessage());
              });
   }

   public Mono<Game> getGame(String gameId){
      return gameRepository.findById(gameId)
              .doOnNext(System.out::println)
              .switchIfEmpty(Mono.error(new GameNotFoundException("Game with id " + gameId + " not found.")));
   }

   public Mono<String> playGame(String gameId, String playType){
      return gameRepository.findById(gameId)
              .flatMap(game -> BlackjackLogic.playBlackjack(game, playType)
                      .flatMap(response ->
                              Flux.fromIterable(game.getPlayers())
                                      .flatMap(player -> playerRepository.updatePlayerPoints(String.valueOf(player.getPlayer_id()), player.getPoints()))
                                      .then()
                                      .then(gameRepository.save(game))
                                      .thenReturn(response)
                      )
              );
   }

   public Mono<String> deleteGame(String id){
      return gameRepository.deleteById(id)
              .then(Mono.just("The game " + id + " has been deleted."))
              .switchIfEmpty(Mono.error(new GameNotFoundException("Game with id " + id + " not found.")));
   }


}