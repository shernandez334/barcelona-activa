package cat.itacademy.s05.t01.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Game {
    @Id
    private String id;
    private List<Player> players = new ArrayList<>();
    private List<Card> playerHand = new ArrayList<>();
    private List<Card> croupierHand = new ArrayList<>();

    public Game(){

    }

    public String getId(){
        return this.id;
    }
    public List<Player> getPlayers(){
        return this.players;
    }

    public List<Card> getPlayerHand(){
        return this.playerHand;
    }
    public List<Card> getCroupierHand(){
        return this.croupierHand;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }
}