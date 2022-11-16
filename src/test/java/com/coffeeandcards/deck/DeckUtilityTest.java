package com.coffeeandcards.deck;

import com.coffeeandcards.blackjack.BlackJack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeckUtilityTest {

    private BlackJack blackJackInstance;
    private DeckUtility deckUtility;

    @Before
    public void setUp() {
        BlackJack.createBlackJackGame();
        blackJackInstance = BlackJack.getBlackJackInstance();
        deckUtility = blackJackInstance.getDeckUtility();
    }

    @Test
    public void testFillDeckWithCards() {
        deckUtility.fillDeckWithCards();
        int deckSize = deckUtility.getDeckOfCardsAsAList().size();
        assertEquals(52, deckSize);
    }

    @Test
    public void testPlaceCardsIntoAStack() {
        List<Card> testCards = new ArrayList<>();
        testCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        testCards.add(new Card(CardSuit.SPADES, CardRank.FIVE));
        testCards.add(new Card(CardSuit.CLUBS, CardRank.SIX));
        testCards.add(new Card(CardSuit.DIAMONDS, CardRank.TWO));
        deckUtility.placeCardsIntoAStack(testCards);
        int size = deckUtility.getDeckOfCardsAsAStack().size();
        assertEquals(4, size);
    }
}