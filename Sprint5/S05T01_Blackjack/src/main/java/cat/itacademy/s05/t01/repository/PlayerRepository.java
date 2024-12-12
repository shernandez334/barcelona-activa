package cat.itacademy.s05.t01.repository;

import cat.itacademy.s05.t01.model.Player;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PlayerRepository extends R2dbcRepository<Player, Long> {
    @Query("UPDATE players SET points = :points WHERE player_id = :playerId")
    Mono<Void> updatePlayerPoints(String playerId, int points);

    @Query("UPDATE players SET player_name = :playerName WHERE player_id = :playerId")
    Mono<Void> updatePlayerName(String playerId, String playerName);
}