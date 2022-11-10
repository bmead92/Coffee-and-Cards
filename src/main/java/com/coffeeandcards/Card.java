package com.coffeeandcards;

import java.util.ArrayList;
import java.util.Collection;

public class Card {
    private Collection<Card> deckofCards;
    private CardSuit suit;
    private CardRank value;


    public Card(CardSuit suit, CardRank value) {
        setSuit(suit);
        setValue(value);
    }

    public static Collection<Card> fillDeckWithCards() {
        Collection<Card> deckOfCards = new ArrayList<>();
        CardRank[] cardRanks = CardRank.values();
        CardSuit[] cardSuits = CardSuit.values();
        for (int i = 0; i < CardRank.values().length; i++) {
            for (int j = 0; j < CardSuit.values().length; j++) {
                deckOfCards.add(new Card(cardSuits[j], cardRanks[i]));
            }
        }
        return deckOfCards;
    }


    public String toString() {
        return "Card: " + getCardRank() + " of " + getCardSuit().getIcon() +
                "\n Worth " + getCardRank().getValue() + "\n";
    }

    public CardSuit getCardSuit() {
        return suit;
    }

    public CardRank getCardRank() {
        return value;
    }

    public Collection<Card> getDeckofCards() {
        return deckofCards;
    }

    public void setDeckofCards(Collection<Card> deckofCards) {
        this.deckofCards = deckofCards;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public void setValue(CardRank value) {
        this.value = value;
    }
}
