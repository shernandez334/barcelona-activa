package cat.itacademy.s05.t01.controller;

import cat.itacademy.s05.t01.model.Player;
import cat.itacademy.s05.t01.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/ranking")
    public Flux<Player> getPlayerRanking(){
        return playerService.getRanking();
    }

    @PostMapping("player/{playerId}")
    public Mono<String> changePlayerNameInGame(@PathVariable Long playerId, @RequestBody String newPlayerName){
        return playerService.changePlayerName(playerId, newPlayerName);
    }
}