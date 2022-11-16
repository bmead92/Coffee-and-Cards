package com.coffeeandcards.deck;

public class Card {
    private CardSuit suit;
    private CardRank value;

    public Card(CardSuit suit, CardRank value) {
        setSuit(suit);
        setValue(value);
    }

    public CardSuit getCardSuit() {
        return suit;
    }

    public CardRank getCardRank() {
        return value;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public void setValue(CardRank value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card: " + getCardRank() + " of " + getCardSuit().getIcon() +
                "\n Worth " + getCardRank().getValue() + "\n";
    }

}
