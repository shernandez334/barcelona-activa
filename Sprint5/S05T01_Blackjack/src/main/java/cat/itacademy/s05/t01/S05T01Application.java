package cat.itacademy.s05.t01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "cat.itacademy.s05.t01.repository")
public class S05T01Application {
	public static void main(String[] args) {
		SpringApplication.run(S05T01Application.class, args);
	}
}