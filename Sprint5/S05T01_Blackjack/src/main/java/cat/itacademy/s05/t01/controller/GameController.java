package cat.itacademy.s05.t01.controller;

import cat.itacademy.s05.t01.model.Game;
import cat.itacademy.s05.t01.services.interfaces.IGameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/game")
public class GameController {

    private final IGameService iGameService;

    @Autowired
    public GameController(IGameService iGameService) {
        this.iGameService = iGameService;
    }

    @Operation(
            summary = "Create a new Blackjack game",
            description = "Initializes a new Blackjack game with the provided player's name."
    )
    @PostMapping("/new")
    public Mono<String> createBlackJackGame(@RequestBody String playerName){
        return iGameService.createNewGame(playerName);
    }

    @Operation(
            summary = "Retrieve game details",
            description = "Fetches the current state and details of a Blackjack game based on its unique game ID."
    )
    @GetMapping("/{gameId}")
    public Mono<Game> getBlackjackGame(@PathVariable String gameId){
        return iGameService.getGame(gameId);
    }

    @Operation(
            summary = "Play a Blackjack game turn",
            description = "Executes a game turn for the specified Blackjack game. The play request must include the player's action, such as 'hit' or 'stand'."
    )
    @PostMapping("/{gameId}/play")
    public Mono<String> playBlackjack(@PathVariable String gameId, @RequestBody String playRequest) {
        playRequest = playRequest.trim().toLowerCase();
        return iGameService.playGame(gameId, playRequest);
    }

    @Operation(
            summary = "Delete a Blackjack game",
            description = "Deletes an existing Blackjack game based on its unique game ID."
    )
    @DeleteMapping("/{gameId}/delete")
    public Mono<String> deleteBlackjackGame(@PathVariable String gameId){
        return iGameService.deleteGame(gameId);
    }
}