package com.coffeeandcards.players;

import com.coffeeandcards.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Card> userHand = new ArrayList<>();
    private boolean turnCompleted;

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



