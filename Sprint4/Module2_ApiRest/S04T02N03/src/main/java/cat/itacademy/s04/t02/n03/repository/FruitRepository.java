package cat.itacademy.s04.t02.n03.repository;

import cat.itacademy.s04.t02.n03.model.FruitModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitRepository extends MongoRepository<FruitModel, Long> {
}