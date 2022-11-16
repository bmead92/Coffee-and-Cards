package com.coffeeandcards.players;

import com.coffeeandcards.blackjack.BlackJack;
import com.coffeeandcards.deck.Card;
import com.coffeeandcards.deck.CardRank;
import com.coffeeandcards.deck.DeckUtility;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Card> userHand = new ArrayList<>();
    private boolean turnCompleted;
    private int intValueOfUserHand = 0;
    private final DeckUtility theDeckUtility = BlackJack.getBlackJackInstance().getDeckUtility();

    public void userDrawCardFromDeck() {
        int intValueOfUserHand = getIntValueOfUserHand();
        Card drawnCard = theDeckUtility.drawCardFromDeck();
        intValueOfUserHand += drawnCard.
                getCardRank().
                getValue();
        userHand.add(drawnCard);
        setUserHand(userHand);
        setIntValueOfUserHand(intValueOfUserHand);
        userCheckForAcesAndUpdateValueIfNecessary();
    }

    public void endTurn() {
        setTurnCompleted(true);
        System.out.println("User turn is over. Let's see what the dealer has!");
    }

    public void userCheckForAcesAndUpdateValueIfNecessary() {
        for (Card card : userHand) {
            CardRank cardRank = card.getCardRank();
            if (getIntValueOfUserHand() > BlackJack.MAX_VALUE_ALLOWED_IN_HAND &&
                    cardRank.equals(CardRank.ACE)) {
                cardRank.setValue(1);
            }
        }
    }

    public int currentValueOfUserHand() {
        int currentValueOfUserHand = 0;
        for (Card card : userHand) {
            currentValueOfUserHand += card.
                    getCardRank().
                    getValue();
        }
        setIntValueOfUserHand(currentValueOfUserHand);
        return currentValueOfUserHand;
    }

    public void displayUserHand() {
        StringBuilder display = new StringBuilder();
        System.out.println("Your cards: ");
        for (Card card : userHand) {
            CardRank cardRank = card.getCardRank();
            String cardIcon = card.getCardSuit().getIcon();
            if (cardRank.equals(CardRank.ACE) ||
                    cardRank.equals(CardRank.KING) ||
                    cardRank.equals(CardRank.QUEEN) ||
                    cardRank.equals(CardRank.JACK)) {
                char firstCharInCardRank = cardRank.name().charAt(0);
                display.append(firstCharInCardRank).append("  ").append(firstCharInCardRank).append("\n");
                display.append(" ").append(cardIcon).append("\n");
                display.append(firstCharInCardRank).append("  ").append(firstCharInCardRank).append("\n");
            } else {
                int cardValue = cardRank.getValue();
                display.append(cardValue).append("  ").append(cardValue).append("\n");
                display.append(" ").append(cardIcon).append("\n");
                display.append(cardValue).append("  ").append(cardValue).append("\n");
            }
        }
        System.out.println(display);
    }

    public boolean isTurnCompleted() {
        return turnCompleted;
    }

    public void setTurnCompleted(boolean turnCompleted) {
        this.turnCompleted = turnCompleted;
    }

    public List<Card> getUserHand() {
        return userHand;
    }

    public void setUserHand(List<Card> userHand) {
        this.userHand = userHand;
    }

    public void setIntValueOfUserHand(int intValueOfUserHand) {
        this.intValueOfUserHand = intValueOfUserHand;
    }

    public int getIntValueOfUserHand() {
        return intValueOfUserHand;
    }
}



