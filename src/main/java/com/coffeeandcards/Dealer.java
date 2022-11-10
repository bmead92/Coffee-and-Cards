package com.coffeeandcards;

import java.util.Collection;

public class Dealer implements IPlayer{
    public static final int MINIMUM_DEALER_HAND_VALUE = 17;
    /**
     * getCard() is run when the user enters 'Hit'.
     * The player will get a card from the deck.
     * @return int - The value of the card they draw.
     */
    @Override
    public int getCard() {
        //TODO: Draw a card from the deck until the dealer
        //has a value of at least 17
        //if (handValue < Min constant) {
        //draw()
        return 0;
    }

    @Override
    public void keepHand() {
        System.out.println("Your turn has ended.\n" +
                "Let's see what the dealer has.\n");
    }

    @Override
    public int displayValue() {
        boolean isUserTurnCompleted = false;
        int valueOfCardOne = 0;
        int valueOfCardTwo = 0;
        if (isUserTurnCompleted) {
            int currentValueOfHand = valueOfCardOne +
                    valueOfCardTwo;
        }
        int currentValueOfHand = valueOfCardOne;
        return currentValueOfHand;
    }

    public Card dealCards(Collection<Card> deckOfCards) {
        //TODO: The dealer needs to shuffle the deck of cards
        // and deal 2 cards to every player and themself.
        return null;
    }
}
