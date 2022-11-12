package com.coffeeandcards;

import java.util.ArrayList;
import java.util.List;

public class User implements IPlayer {
    private List<Card> userHand = new ArrayList<>();
    private int valueOfPlayerHand = 0;
    private boolean turnCompleted;

    public void getCard() {
        userHand.add(BlackJack.
                getBlackJackInstance().
                getDeckUtility().
                drawCardFromDeck());
    }

    @Override
    public void keepHand() {
        setTurnCompleted(true);
        System.out.println("User turn is over. Let's see what the dealer has!");

    }

    public int valueOfUserHand() {
        for (Card card : userHand) {
            valueOfPlayerHand += card.getCardRank().getValue();
        }
        return valueOfPlayerHand;
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
}



