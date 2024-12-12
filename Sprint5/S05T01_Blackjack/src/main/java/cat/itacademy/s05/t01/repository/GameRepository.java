package cat.itacademy.s05.t01.repository;

import cat.itacademy.s05.t01.model.Game;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface GameRepository extends ReactiveMongoRepository<Game, String> {}