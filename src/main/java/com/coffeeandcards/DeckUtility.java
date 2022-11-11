package com.coffeeandcards;

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
    private List<Card> deckOfCardsAsAList;
    private Stack<Card> deckOfCardsAsAStack;
    private List<Card> discardPile = new ArrayList<>();

    private int cardsLeftInDeck = deckOfCardsAsAStack.size();

    private int cardsInDiscardPile = discardPile.size();

    public void fillDeckWithCards() {
        List<Card> deckOfCards = new ArrayList<>();
        CardRank[] cardRanks = CardRank.values();
        CardSuit[] cardSuits = CardSuit.values();
        for (int i = 0; i < CardRank.values().length; i++) {
            for (int j = 0; j < CardSuit.values().length; j++) {
                deckOfCards.add(new Card(cardSuits[j], cardRanks[i]));
            }
        }
        setDeckOfCardsAsAList(deckOfCards);
    }

    public void shuffleCards(List<Card> deckOfCards) {
        Collections.shuffle(deckOfCards);
    }

    public void placeCardsIntoAStack(List<Card> deckOfCards) {
        Stack<Card> deckOfCardsInAStack = new Stack<>();
        for (Card card : deckOfCards) {
            deckOfCardsInAStack.push(card);
        }
        setDeckOfCardsAsAStack(deckOfCardsInAStack);
    }

    public Card drawCardFromDeck() {
        return getDeckOfCardsAsAStack().pop();
    }

    public void addToDiscardPile(Card card) {
        getDiscardPile().add(card);
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

    public List<Card> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(List<Card> discardPile) {
        this.discardPile = discardPile;
    }
}
