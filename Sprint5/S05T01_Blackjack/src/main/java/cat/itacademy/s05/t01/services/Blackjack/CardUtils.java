package cat.itacademy.s05.t01.services.Blackjack;

import cat.itacademy.s05.t01.enums.CardValue;
import cat.itacademy.s05.t01.enums.PlayerType;
import cat.itacademy.s05.t01.enums.Suit;
import cat.itacademy.s05.t01.model.Card;
import cat.itacademy.s05.t01.model.Game;
import cat.itacademy.s05.t01.model.Player;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CardUtils {
    private static Random random = new Random();

    public CardValue randomizeCardValue(){
        int randomIndex = random.nextInt(CardValue.values().length);
        return CardValue.values()[randomIndex];
    }

    public Suit randomizeSuit(){
        int randomIndex = random.nextInt(Suit.values().length);
        return Suit.values()[randomIndex];
    }

    public void setTwoCardsDeck(Game game, PlayerType playerType){
        addCardToDeck(game, playerType);
        addCardToDeck(game, playerType);
    }

    public void addCardToDeck(Game game, PlayerType playerType){
        Card card = new Card(randomizeCardValue(), randomizeSuit());
        if (playerType.equals(PlayerType.PLAYER)){
            game.getPlayerHand().add(card);
        } else if (playerType.equals(PlayerType.CROUPIER)) {
          game.getCroupierHand().add(card);
        }
    }

    public void clearDecks(Game game){
        game.getPlayerHand().clear();
        game.getCroupierHand().clear();
    }

    public List <Card> getHandByPlayerType(Game game, PlayerType playerType){
        List<Card> cards = (playerType == PlayerType.PLAYER)
                ? game.getPlayerHand()
                : game.getCroupierHand();
        return cards;
    }

    public String showCardsInHand(Game game, PlayerType playerType){
        List<Card> cardsInHand = getHandByPlayerType(game, playerType);
        String cardList = cardsInHand.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
        return playerType + " cards: " + cardList + "\n";
    }

    public int countHandValue(Game game, PlayerType playerType){
        int handValue = 0;
        int aceCount = 0;
        List<Card> cardsInHand = getHandByPlayerType(game, playerType);
        for (Card card : cardsInHand) {
            int cardValue = card.getCardValue();
            if (cardValue == 1) {
                aceCount++;
                handValue += 11;
            } else {
                handValue += cardValue;
            }
        }
        while (handValue > 21 && aceCount > 0) {
            handValue -= 10;
            aceCount--;
        }
        return handValue;
    }

    public void addPointToPlayer(Game game){
        game.getPlayers().get(0).addPoint();
    }
}