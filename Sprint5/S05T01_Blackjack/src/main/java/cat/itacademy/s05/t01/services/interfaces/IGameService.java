package cat.itacademy.s05.t01.services.interfaces;

import cat.itacademy.s05.t01.model.Game;
import reactor.core.publisher.Mono;

public interface IGameService{
    public Mono<String> createNewGame(String playerName);
    public Mono<Game> getGame(String gameId);
    public Mono<String> playGame(String gameId, String playType);
    public Mono<String> deleteGame(String id);
}
