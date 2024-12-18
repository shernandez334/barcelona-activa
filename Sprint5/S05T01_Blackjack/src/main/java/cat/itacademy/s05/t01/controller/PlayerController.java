package cat.itacademy.s05.t01.controller;

import cat.itacademy.s05.t01.model.Player;
import cat.itacademy.s05.t01.services.PlayerService;
import cat.itacademy.s05.t01.services.interfaces.IPlayerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlayerController {

    private final IPlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @Operation(
            summary = "Get player ranking",
            description = "Retrieves a list of all players ranked by their performance. The ranking is sorted based on player scores."
    )
    @GetMapping("/ranking")
    public Flux<Player> getPlayerRanking(){
        return playerService.getRanking();
    }

    @Operation(
            summary = "Change player name in a game",
            description = "Updates the name of a player in an ongoing game. Requires the player's ID and the new name as input."
    )
    @PostMapping("player/{playerId}")
    public Mono<String> changePlayerNameInGame(@PathVariable Long playerId, @RequestBody String newPlayerName){
        return playerService.changePlayerName(playerId, newPlayerName);
    }
}