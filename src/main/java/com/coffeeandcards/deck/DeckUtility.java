package com.coffeeandcards.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Utility class for managing a deck of cards.
 * Upon creation, the desk is a List, but is better represented as a Stack.
 * This class provides those utilities while separating its functionality from the Card class.
 */
public class DeckUtility {
    private List<Card> deckOfCardsAsAList = new ArrayList<>();
    private final Stack<Card> deckOfCardsAsAStack = new Stack<>();

    public void fillDeckWithCards() {
        CardRank[] cardRanks = CardRank.values();
        CardSuit[] cardSuits = CardSuit.values();
        for (CardRank cardRank : cardRanks) {
            if (cardRank.equals(CardRank.A_DEMOTED_ACE)) {
                continue;
            }
            for (CardSuit cardSuit : cardSuits) {
                deckOfCardsAsAList.add(new Card(cardSuit, cardRank));
            }
        }
    }

    public void shuffleCards(final List<Card> deckOfCards) {
        this.deckOfCardsAsAList = deckOfCards;
        Collections.shuffle(deckOfCardsAsAList);
    }

    public void placeCardsIntoAStack(final List<Card> deckOfCards) {
        for (Card card : deckOfCards) {
            deckOfCardsAsAStack.push(card);
        }
    }

    public List<Card> getDeckOfCardsAsAList() {
        return deckOfCardsAsAList;
    }

    public Stack<Card> getDeckOfCardsAsAStack() {
        return deckOfCardsAsAStack;
    }

}
