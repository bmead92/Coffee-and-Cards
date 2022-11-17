package com.coffeeandcards.deck;

public enum CardRank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    KING(10),
    QUEEN(10),
    ACE(11),
    A_DEMOTED_ACE(1);

    private final int cardValue;

    CardRank(final int cardValue) {
        this.cardValue = cardValue;
    }

    public int getCardValue() {
        return cardValue;
    }
}


