package cat.itacademy.s05.t01.services.Blackjack;

import cat.itacademy.s05.t01.enums.PlayerType;
import cat.itacademy.s05.t01.model.Game;
import reactor.core.publisher.Mono;

public class BlackjackLogic {
    public static CardUtils cardUtils = new CardUtils();

    public static Mono<String> playBlackjack(Game game, String playRequest){
        switch (playRequest){
            case "start" -> {
                return startBlackjackGame(game);
            }
            case "hit" -> {
                return hitBlackjack(game);
            }
            case "stand" -> {
                return standBlackjack(game);
            }
            default -> {
                return Mono.just("Invalid option.");
            }
        }
    }

    public static Mono<String> startBlackjackGame(Game game){
        cardUtils.clearDecks(game);
        cardUtils.setTwoCardsDeck(game, PlayerType.PLAYER);
        return Mono.just("You started a Blackjack game.\n" +
                "Your hand: " + cardUtils.showCardsInHand(game, PlayerType.PLAYER) +
                "Stand or Hit");
    }

    public static Mono<String> hitBlackjack(Game game) {
        cardUtils.addCardToDeck(game, PlayerType.PLAYER);
        int playerHandValue = cardUtils.countHandValue(game, PlayerType.PLAYER);
        String resultAfterHitting;
        if (playerHandValue > 21){
            resultAfterHitting = "Busted";
        } else {
            resultAfterHitting = "Stand or Hit?";
        }
        String playerHand =  cardUtils.showCardsInHand(game, PlayerType.PLAYER);
        return Mono.just(playerHand + "Hand Value: " + playerHandValue + "\n" + resultAfterHitting);
    }

    public static Mono<String> standBlackjack(Game game){
        cardUtils.setTwoCardsDeck(game, PlayerType.CROUPIER);
        int playerHandValue = cardUtils.countHandValue(game, PlayerType.PLAYER);
        int croupierCardValue = cardUtils.countHandValue(game, PlayerType.CROUPIER);
        String gameResult;
        while (playerHandValue > croupierCardValue && croupierCardValue < 21){
            cardUtils.addCardToDeck(game, PlayerType.CROUPIER);
            croupierCardValue = cardUtils.countHandValue(game, PlayerType.CROUPIER);
        }
        if (croupierCardValue == playerHandValue){
            gameResult = "Tie. No points";
        } else if (croupierCardValue <= 21 && croupierCardValue > playerHandValue){
            gameResult = "The croupier wins.";
        } else {
            cardUtils.addPointToPlayer(game);
            gameResult = "You win." + "\n"
                    + "Points: " + game.getPlayers().get(0).getPoints();
        }
        String playersHand = cardUtils.showCardsInHand(game, PlayerType.PLAYER) + cardUtils.showCardsInHand(game, PlayerType.CROUPIER);
        return Mono.just( playersHand + gameResult);
    }
}