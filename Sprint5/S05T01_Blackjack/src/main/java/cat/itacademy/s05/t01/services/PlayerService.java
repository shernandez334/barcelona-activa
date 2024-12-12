package cat.itacademy.s05.t01.services;

import cat.itacademy.s05.t01.model.Player;
import cat.itacademy.s05.t01.repository.GameRepository;
import cat.itacademy.s05.t01.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

     @Autowired
    public PlayerService (GameRepository gameRepository, PlayerRepository playerRepository){
         this.playerRepository = playerRepository;
         this.gameRepository = gameRepository;
     }

     public Flux<Player> getRanking(){
         return this.playerRepository.findAll()
                 .sort(Comparator.comparingInt(Player::getPoints).reversed());
     }

     public Mono<String> changePlayerName(Long playerId, String newPlayerName){
         return playerRepository.findById(playerId)
                 .flatMap(player -> {
                     player.setName(newPlayerName);
                     return playerRepository.save(player)
                             .then(updatePlayerNameInGames(playerId, newPlayerName))
                             .thenReturn("Player name updated successfully.");
                 })
                 .switchIfEmpty(Mono.error(new RuntimeException("Player with ID " + playerId + " not found.")));
     }

    private Mono<Void> updatePlayerNameInGames(Long playerId, String newPlayerName) {
        return gameRepository.findAll()
                .filter(game -> game.getPlayers().stream()
                        .anyMatch(player -> player.getPlayer_id().equals(playerId)))
                .flatMap(game -> {
                    game.getPlayers().stream()
                            .filter(player -> player.getPlayer_id().equals(playerId))
                            .forEach(player -> player.setName(newPlayerName));
                    return gameRepository.save(game);
                })
                .then();
    }
}