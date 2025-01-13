package cat.itacademy.s05.t02.repository;

import cat.itacademy.s05.t02.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
