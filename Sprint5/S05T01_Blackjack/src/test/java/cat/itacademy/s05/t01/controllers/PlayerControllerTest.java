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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    private final Player player1 = new Player();
    private final Player player2 = new Player();

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


}