package com.coffeeandcards;

public class Dealer implements IPlayer {
    public static final DeckUtility deckUtility = new DeckUtility();
    public static final int MINIMUM_DEALER_HAND_VALUE = 17;

    public static final int STARTING_NUMBER_OF_CARDS = 2;
    private int valueOfHand = 0;

    /**
     * The dealer has to have a hand value of at least 17, getCard() is run until that minimum is met.
     * getCard() is also run if the dealer wishes to 'Hit' and get a new card.
     */
    @Override
    public void getCard() {
        //TODO: Draw a card from the deck until the dealer has the min
        int valueOfHand = getValueOfHand();
        if (valueOfHand < MINIMUM_DEALER_HAND_VALUE) {
            Card drawnCard = deckUtility.drawCardFromDeck();
            valueOfHand += drawnCard.getCardRank().getValue();
        }
        setValueOfHand(valueOfHand);
    }

    @Override
    public void keepHand() {
        System.out.println("The dealer has ended their turn." +
                "\nDealer has: " + getValueOfHand());
    }

    @Override
    public int displayCards() {
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

    public void dealCards() {
        //TODO: The dealer needs to shuffle the deck of cards
        // and deal 2 cards to every player and themself.
        int numberOfCardsDealtToEachPlayer = 0;
        while (numberOfCardsDealtToEachPlayer > STARTING_NUMBER_OF_CARDS) {
            //add cards to players hands
            numberOfCardsDealtToEachPlayer++;
        }
    }

    public int getValueOfHand() {
        return valueOfHand;
    }

    public void setValueOfHand(int valueOfHand) {
        this.valueOfHand = valueOfHand;
    }

    public DeckUtility getDeckUtility() {
        return deckUtility;
    }

}
