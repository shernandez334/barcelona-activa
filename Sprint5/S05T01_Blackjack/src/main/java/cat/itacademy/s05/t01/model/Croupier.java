package cat.itacademy.s05.t01.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Croupier {
    private List<Card> hand = new ArrayList<>();

    public List<Card> getHand(){
        return this.hand;
    }

    public void addCard(Card card){
        this.hand.add(card);
    }
}