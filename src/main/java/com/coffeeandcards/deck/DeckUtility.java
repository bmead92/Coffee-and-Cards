package com.coffeeandcards.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Utility class for managing a deck of cards.
 * Upon creation, the desk is a List, but is better represented as a Stack.
 * A deck should also be easy to shuffle at-will.
 * This class provides those utilities while separating its functionality from the Card class.
 */
public class DeckUtility {
    private List<Card> deckOfCardsAsAList = new ArrayList<>();
    private Stack<Card> deckOfCardsAsAStack = new Stack<>();

    public void fillDeckWithCards() {
        List<Card> deckOfCards = deckOfCardsAsAList;
        CardRank[] cardRanks = CardRank.values();
        CardSuit[] cardSuits = CardSuit.values();
        for (CardRank cardRank : cardRanks) {
            if (cardRank.equals(CardRank.A_DEMOTED_ACE)) {
                continue;
            }
            for (CardSuit cardSuit : cardSuits) {
                deckOfCards.add(new Card(cardSuit, cardRank));
            }
        }
        setDeckOfCardsAsAList(deckOfCards);
    }

    public void shuffleCards(List<Card> deckOfCards) {
        this.deckOfCardsAsAList = deckOfCards;
        Collections.shuffle(deckOfCardsAsAList);
    }

    public void placeCardsIntoAStack(List<Card> deckOfCards) {
        for (Card card : deckOfCards) {
            deckOfCardsAsAStack.push(card);
        }
    }

    public List<Card> getDeckOfCardsAsAList() {
        return deckOfCardsAsAList;
    }

    public void setDeckOfCardsAsAList(List<Card> deckOfCardsAsAList) {
        this.deckOfCardsAsAList = deckOfCardsAsAList;
    }

    public Stack<Card> getDeckOfCardsAsAStack() {
        return deckOfCardsAsAStack;
    }

    public void setDeckOfCardsAsAStack(Stack<Card> deckOfCardsAsAStack) {
        this.deckOfCardsAsAStack = deckOfCardsAsAStack;
    }
}
