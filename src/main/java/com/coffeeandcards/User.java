package com.coffeeandcards;

import java.util.ArrayList;
import java.util.List;

public class User implements IPlayer {
    private List<Card> userHand = new ArrayList<>();
    private boolean turnCompleted;

    public void drawCardFromDeck() {
        userHand.add(BlackJack.
                getBlackJackInstance().
                getDeckUtility().
                drawCardFromDeck());
        changeValueOfAce();
    }

    @Override
    public void endTurn() {
        setTurnCompleted(true);
        System.out.println("User turn is over. Let's see what the dealer has!");

    }

    @Override
    public void changeValueOfAce() {
        for (Card card : userHand) {
            if (currentValueOfUserHand() > BlackJack.MAX_VALUE_ALLOWED_IN_HAND &&
                    card.getCardRank().equals(CardRank.ACE)) {
                card.getCardRank().setValue(1);
            }
        }
    }

    public int currentValueOfUserHand() {
        int currentValueOfUserHand = 0;
        for (Card card : userHand) {
            currentValueOfUserHand += card.getCardRank().
                    getValue();
        }
        return currentValueOfUserHand;
    }

    public void displayUserHand() {
        StringBuilder display = new StringBuilder();
        System.out.print("Your current hand ");
        for (Card card : userHand) {
            display.append(card.getCardRank()).append(" of ").append(card.getCardSuit().getIcon());
        }
        System.out.println(display.toString());
    }

    public boolean isTurnCompleted() {
        return turnCompleted;
    }

    public void setTurnCompleted(boolean turnCompleted) {
        this.turnCompleted = turnCompleted;
    }
}



