package com.coffeeandcards;

public class User implements IPlayer {
    private final BlackJack blackJack;
    private int valueOfPlayerHand = 0;
    private boolean turnCompleted;

    public User(BlackJack blackJackInstance) {
        this.blackJack = blackJackInstance;
    }

    public void getCard() {
        blackJack.getDeckUtility().drawCardFromDeck();
    }

    @Override
    public void keepHand() {
        setTurnCompleted(true);
        System.out.println("User turn is over.");

    }
    @Override
    public int displayCards() {
        return 0;
    }

    public boolean isTurnCompleted() {
        return turnCompleted;
    }

    public void setTurnCompleted(boolean turnCompleted) {
        this.turnCompleted = turnCompleted;
    }
}



