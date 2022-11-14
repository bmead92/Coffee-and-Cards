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
            valueOfPlayerHand += card.getCardRank().
                    getValue();
        }
        setValueOfPlayerHand(valueOfPlayerHand);
        return valueOfPlayerHand;
    }

    public void displayUserHand() {
        StringBuilder display = new StringBuilder();
        System.out.print("Your current hand: ");
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

    public List<Card> getUserHand() {
        return userHand;
    }

    public void setUserHand(List<Card> userHand) {
        this.userHand = userHand;
    }

    public int getValueOfPlayerHand() {
        return valueOfPlayerHand;
    }

    public void setValueOfPlayerHand(int valueOfPlayerHand) {
        this.valueOfPlayerHand = valueOfPlayerHand;
    }
}



