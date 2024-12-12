package cat.itacademy.s05.t01.controller;

import cat.itacademy.s05.t01.model.Game;
import cat.itacademy.s05.t01.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/new")
    public Mono<String> createBlackJackGame(@RequestBody String playerName){
        return gameService.createNewGame(playerName);
    }

    @GetMapping("/{gameId}")
    public Mono<Game> getBlackjackGame(@PathVariable String gameId){
        return gameService.getGame(gameId);
    }

    @PostMapping("/{gameId}/play")
    public Mono<String> playBlackjack(@PathVariable String gameId, @RequestBody String playRequest){
        playRequest = playRequest.trim().toLowerCase();
        return gameService.playGame(gameId, playRequest);
    }

    @DeleteMapping("/{gameId}/delete")
    public Mono<String> deleteBlackjackGame(@PathVariable String gameId){
        return gameService.deleteGame(gameId);
    }
}