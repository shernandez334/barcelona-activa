package cat.itacademy.s05.t01.repository;

import cat.itacademy.s05.t01.model.Player;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PlayerRepository extends R2dbcRepository<Player, Long> {
    @Modifying
    Mono<Void> updatePlayerPoints(String playerId, int points);

    @Modifying
    Mono<Void> updatePlayerName(String playerId, String playerName);
}