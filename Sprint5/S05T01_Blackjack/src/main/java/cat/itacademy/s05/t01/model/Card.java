package cat.itacademy.s05.t01.model;

import cat.itacademy.s05.t01.enums.CardValue;
import cat.itacademy.s05.t01.enums.Suit;

public class Card {
    private final CardValue cardValue;
    private final Suit suit;

    public Card(CardValue cardValue, Suit suit){
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public int getCardValue(){
        return this.cardValue.getCardValue();
    }
    public String getSuit(){
        return this.suit.getEmoji();
    }

    public String toString(){
        return this.getSuit() + " " + this.getCardValue();
    }
}