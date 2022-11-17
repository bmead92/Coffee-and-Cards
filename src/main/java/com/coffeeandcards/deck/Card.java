package com.coffeeandcards.deck;

public class Card {
    private CardSuit cardSuit;
    private CardRank cardRank;

    public Card(CardSuit cardSuit, CardRank cardRank) {
        setCardSuit(cardSuit);
        setCardRank(cardRank);
    }

    public void setCardSuit(final CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public void setCardRank(final CardRank cardRank) {
        this.cardRank = cardRank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

}
