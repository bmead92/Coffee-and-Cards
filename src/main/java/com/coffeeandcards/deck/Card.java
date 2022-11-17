package com.coffeeandcards.deck;

public class Card {
    private CardSuit cardSuit;
    private CardRank getCardValue;

    public Card(CardSuit suit, CardRank value) {
        setCardSuit(suit);
        setGetCardValue(value);
    }

    public CardRank getCardRank() {
        return getCardValue;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public void setGetCardValue(CardRank getCardValue) {
        this.getCardValue = getCardValue;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public CardRank getGetCardValue() {
        return getCardValue;
    }

}
