package com.coffeeandcards.players;

import com.coffeeandcards.blackjack.BlackJack;
import com.coffeeandcards.deck.Card;
import com.coffeeandcards.deck.CardRank;
import com.coffeeandcards.deck.DeckUtility;

import java.util.List;

public class PlayerUtility {
    public static void checkForAcesAndUpdateValueIfNecessary(List<Card> theListOfCardsToCheck) {
        int valueOfHandBeingPassedIn = currentValueOfHand(theListOfCardsToCheck);
        for (Card card : theListOfCardsToCheck) {
            if (valueOfHandBeingPassedIn > BlackJack.MAX_VALUE_ALLOWED_IN_HAND &&
                    card.getCardRank().equals(CardRank.ACE)) {
                card.getCardRank().setValue(1);
            }
        }
    }
    public static void drawCardFromDeck(List<Card> theListOfCards) {
        DeckUtility theDeckUtility = BlackJack.getBlackJackInstance().getDeckUtility();
        Card drawnCard = theDeckUtility.getDeckOfCardsAsAStack().pop();
        theListOfCards.add(drawnCard);
        checkForAcesAndUpdateValueIfNecessary(theListOfCards);
    }
    public static int currentValueOfHand(List<Card> listOfCards) {
        int currentValueOfHand = 0;
        for (Card card : listOfCards) {
            int valueOfCard = card.getCardRank().getValue();
            currentValueOfHand += valueOfCard;
        }
        return currentValueOfHand;
    }
    public static void displayCardsInHand(List<Card> listOfCards) {
        StringBuilder display = new StringBuilder();
        for (Card card : listOfCards) {
            CardRank cardRank = card.getCardRank();
            String cardIcon = card.getCardSuit().getIcon();
            boolean cardIsAFaceCard = cardRank.equals(CardRank.ACE) ||
                    cardRank.equals(CardRank.KING) ||
                    cardRank.equals(CardRank.QUEEN) ||
                    cardRank.equals(CardRank.JACK);
            if (cardIsAFaceCard) {
                char firstCharInCardRank = cardRank.name().charAt(0);
                display.append(firstCharInCardRank).append("  ")
                        .append(firstCharInCardRank).append("\n");
                display.append(" ").append(cardIcon).append("\n");
                display.append(firstCharInCardRank).append("  ")
                        .append(firstCharInCardRank).append("\n");
            } else {
                int cardValue = cardRank.getValue();
                display.append(cardValue).append("  ").append(cardValue).append("\n");
                display.append(" ").append(cardIcon).append("\n");
                display.append(cardValue).append("  ").append(cardValue).append("\n");
            }
        }
        System.out.println(display);
    }
}
