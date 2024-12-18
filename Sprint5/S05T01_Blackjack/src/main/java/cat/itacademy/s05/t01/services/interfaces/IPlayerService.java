package cat.itacademy.s05.t01.services.interfaces;

import cat.itacademy.s05.t01.model.Player;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPlayerService {
    public Flux<Player> getRanking();
    public Mono<String> changePlayerName(Long playerId, String newPlayerName);
    public Mono<Void> updatePlayerNameInGames(Long playerId, String newPlayerName);
}
