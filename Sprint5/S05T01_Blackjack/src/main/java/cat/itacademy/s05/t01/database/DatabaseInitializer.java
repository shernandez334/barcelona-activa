package cat.itacademy.s05.t01.database;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;

@Service
@Profile("!test")
public class DatabaseInitializer {
    private final DatabaseClient databaseClient;

    public DatabaseInitializer(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @PostConstruct
    public void initDatabase() {
        ensurePlayersTableExists();
    }

    public void ensurePlayersTableExists(){
        databaseClient.sql("""
                        CREATE TABLE IF NOT EXISTS players (
                            player_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            player_name VARCHAR(255) NOT NULL,
                            points INT DEFAULT 0
                        );
                        """)
                .fetch()
                .rowsUpdated()
                .doOnTerminate(() -> System.out.println("Table 'players' ensured to exist."))
                .doOnError(error -> System.err.println("Error creating table: " + error.getMessage()))
                .subscribe();
    }
}