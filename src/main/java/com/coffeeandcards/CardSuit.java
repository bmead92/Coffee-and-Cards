package com.coffeeandcards;

public enum CardSuit {
    SPADES("\u2660\uFE0F"),
    HEARTS("\u2665\uFE0F"),
    DIAMONDS("\u2666\uFE0F"),
    CLUBS("\u2663\uFE0F");
    private final String icon;
    CardSuit(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
