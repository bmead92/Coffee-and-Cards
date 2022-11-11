package com.coffeeandcards;

public class User implements IPlayer {

    public void getCard() {
        DeckUtility deckUtility = Dealer.deckUtility;
        deckUtility.drawCardFromDeck();
    }

    @Override
    public void keepHand() {

    }

    @Override
    public int displayCards() {
        return 0;
    }
}
