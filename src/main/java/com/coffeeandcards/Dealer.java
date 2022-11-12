package com.coffeeandcards;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements IPlayer {
    public static final int MINIMUM_DEALER_HAND_VALUE = 17;
    public static final int STARTING_NUMBER_OF_CARDS = 2;
    private int valueOfDealerHand = 0;
    private List<Card> dealerHand = new ArrayList<>();

    /**
     * The dealer has to have a hand value of at least 17, getCard() is run until that minimum is met.
     * getCard() is also run if the dealer wishes to 'Hit' and get a new card.
     */
    @Override
    public void getCard() {
        //TODO: Draw a card from the deck until the dealer has the min
        Card drawnCard = BlackJack.
                getBlackJackInstance().
                getDeckUtility().
                drawCardFromDeck();
        if (valueOfDealerHand < MINIMUM_DEALER_HAND_VALUE) { // maybe need to push this into another method?
            valueOfDealerHand += drawnCard.
                    getCardRank()
                    .getValue();
            dealerHand.add(drawnCard);
        } else {
            valueOfDealerHand += drawnCard.
                    getCardRank().
                    getValue();
            dealerHand.add(drawnCard);
        }
        setDealerHand(dealerHand);
    }

    @Override
    public void keepHand() {
        System.out.println("The dealer has ended their turn." +
                "\nDealer has: " + getValueOfDealerHand());
    }

    /**
     * Because the dealer is dealt a face-down and a face-up card,displayCards will show one card
     * to the user at the start. When the user ends their turn, the dealer will reveal the rest of their cards.
     * @return int currentValueOfHand
     */

    public int valueOfDealerHand() {
        int currentValueOfHand = 0;
        boolean isUserTurnCompleted = BlackJack.
                getBlackJackInstance().
                getUser().
                isTurnCompleted();
        int valueOfCardOne = dealerHand.
                get(0).
                getCardRank().
                getValue();
        int valueOfCardTwo = dealerHand.
                get(1).
                getCardRank().
                getValue();
        if (isUserTurnCompleted) {
             currentValueOfHand = valueOfCardOne +
                    valueOfCardTwo;
        } else {
            currentValueOfHand = valueOfCardOne;
        }
        return currentValueOfHand;
    }

    public void dealCards() {
        //TODO: The dealer needs to shuffle the deck of cards
        // and deal 2 cards to every player and themself.
        int numberOfCardsDealtToEachPlayer = 0;
        while (numberOfCardsDealtToEachPlayer < STARTING_NUMBER_OF_CARDS) {
            //add cards to players hands
            getCard(); // dealer implementation of draw/hit/getCard
            BlackJack.
                    getBlackJackInstance().
                    getUser().
                    getCard(); // user implementation of draw/hit/getCard
            numberOfCardsDealtToEachPlayer++;
        }
    }

    public int getValueOfDealerHand() {
        return valueOfDealerHand;
    }

    public void setValueOfDealerHand(int valueOfDealerHand) {
        this.valueOfDealerHand = valueOfDealerHand;
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(List<Card> dealerHand) {
        this.dealerHand = dealerHand;
    }



}
