package cat.itacademy.s04.t02.n01.repository;

import cat.itacademy.s04.t02.n01.model.FruitModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<FruitModel, Long> {
}