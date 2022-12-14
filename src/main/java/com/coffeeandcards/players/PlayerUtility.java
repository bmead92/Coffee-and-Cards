package com.coffeeandcards.players;

import com.coffeeandcards.blackjack.BlackJack;
import com.coffeeandcards.deck.Card;
import com.coffeeandcards.deck.CardRank;
import com.coffeeandcards.deck.DeckUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * PlayerUtility class holds methods that control the behavior of the Dealer and User hands during
 * the course of the game.
 */

public class PlayerUtility {
    private List<Card> copyOfList;

    public List<Card> checkForAcesAndChangeCardRankIfNecessary(final List<Card> theListOfCardsToCheck) {
        List<Card> copyOfList = new ArrayList<>(theListOfCardsToCheck);
        for (Card card : copyOfList) {
            int currentValueOfHand = currentValueOfHand(theListOfCardsToCheck);
            boolean currentCardIsAceAndNeedsValueChangedToOne
                    = currentValueOfHand > BlackJack.MAX_VALUE_ALLOWED_IN_HAND &&
                    card.getCardRank().equals(CardRank.ACE);
            if (currentCardIsAceAndNeedsValueChangedToOne) {
                card.setCardRank(CardRank.A_DEMOTED_ACE);
            }
        }
        return copyOfList;
    }


    public void drawCardFromDeck(List<Card> theListOfCards) {
        DeckUtility theDeckUtility = BlackJack.getBlackJackInstance().getDeckUtility();
        Card drawnCard = theDeckUtility.getDeckOfCardsAsAStack().pop();
        theListOfCards.add(drawnCard);
        checkForAcesAndChangeCardRankIfNecessary(theListOfCards);
    }

    public int currentValueOfHand(final List<Card> listOfCards) {
        int currentValueOfHand = 0;
        for (Card card : listOfCards) {
            int valueOfCard = card.getCardRank().getCardValue();
            currentValueOfHand += valueOfCard;
        }
        return currentValueOfHand;
    }

    public void displayCardsInHand(final List<Card> listOfCards) {
        StringBuilder display = new StringBuilder();
        for (Card card : listOfCards) {
            CardRank cardRank = card.getCardRank();
            String cardIcon = card.getCardSuit().getIcon();
            boolean cardIsAFaceCard = cardRank.equals(CardRank.ACE) ||
                    cardRank.equals(CardRank.KING) ||
                    cardRank.equals(CardRank.QUEEN) ||
                    cardRank.equals(CardRank.JACK) ||
                    cardRank.equals(CardRank.A_DEMOTED_ACE);
            if (cardIsAFaceCard) {
                char firstCharInCardRank = cardRank.name().charAt(0);
                display.append(firstCharInCardRank).append("  ")
                        .append(firstCharInCardRank).append("\n");
                display.append(" ").append(cardIcon).append("\n");
                display.append(firstCharInCardRank).append("  ")
                        .append(firstCharInCardRank).append("\n");
            } else {
                int cardValue = cardRank.getCardValue();
                display.append(cardValue).append("  ").append(cardValue).append("\n");
                display.append(" ").append(cardIcon).append("\n");
                display.append(cardValue).append("  ").append(cardValue).append("\n");
            }
        }
        System.out.println(display);
    }

    public List<Card> getCopyOfList() {
        return copyOfList;
    }

    public void setCopyOfList(final List<Card> copyOfList) {
        this.copyOfList = copyOfList;
    }
}
