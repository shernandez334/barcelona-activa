package cat.itacademy.s05.t01.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "players")
public class Player {
    @Id
    private Long player_id;
    private String player_name;
    private int points;

    public Player(){
        this.points = 0;
    }

    public Long getPlayer_id() {
        return player_id;
    }
    public int getPoints(){
        return this.points;
    }

    public void setName(String name) {
        this.player_name = name;
    }
    public void setPlayerName(String player_name) {
        this.player_name = player_name;
    }
    public void setPlayer_id(Long player_id){
        this.player_id = player_id;
    }

    public void addPoint(){
        this.points++;
    }
}