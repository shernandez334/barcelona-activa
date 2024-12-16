package cat.itacademy.s05.t01.controllers;

import cat.itacademy.s05.t01.controller.PlayerController;
import cat.itacademy.s05.t01.model.Player;
import cat.itacademy.s05.t01.repository.PlayerRepository;
import cat.itacademy.s05.t01.services.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    private  Player player1 = new Player();
    private  Player player2 = new Player();

    @BeforeEach
    void setUp(){
        player1.setPlayer_id(1L);
        player1.setPlayerName("PlayerOne");

        player2.setPlayer_id(2L);
        player2.setPlayerName("PlayerTwo");
    }

    @Test
    void testPlayerGetRanking(){
        when(playerService.getRanking()).thenReturn(Flux.just(player1, player2));
        Flux<Player> result = playerController.getPlayerRanking();
        assertEquals(2, result.collectList().block().size());
        verify(playerService, times(1)).getRanking();
    }

    @Test
    void testChangePlayerNameInGame(){
        Long playerId = 1L;
        String newPlayerName = "NewPlayerName";

        when(playerService.changePlayerName(playerId, newPlayerName)).thenReturn(Mono.just(newPlayerName));
        Mono<String> result = playerController.changePlayerNameInGame(playerId, newPlayerName);
        String updatedName = result.block();
        assertEquals(newPlayerName, updatedName);
        verify(playerService, times(1)).changePlayerName(playerId, newPlayerName);
    }
}