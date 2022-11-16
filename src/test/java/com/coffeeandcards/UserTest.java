package com.coffeeandcards;

import com.coffeeandcards.blackjack.BlackJack;
import com.coffeeandcards.deck.Card;
import com.coffeeandcards.deck.CardRank;
import com.coffeeandcards.deck.CardSuit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    private BlackJack blackJackInstance;

    @Before
    public void setUp() {
        BlackJack.createBlackJackGame();
        blackJackInstance = BlackJack.getBlackJackInstance();
        blackJackInstance.setUpGame();
    }

    @Test
    public void testUserDrawCardFromDeckAddsACardToTheUsersHand() {
        int actualValue = blackJackInstance.
                getUser().
                getUserHand().size();
        assertEquals(2, actualValue);
        blackJackInstance.getUser().userDrawCardFromDeck();
        actualValue = blackJackInstance.getUser().
                getUserHand().
                size();
        assertEquals(3, actualValue);
        blackJackInstance.getUser().userDrawCardFromDeck();
        actualValue = blackJackInstance.getUser().
                getUserHand().
                size();
        assertEquals(4, actualValue);
    }

    @Test
    public void testUserEndTurnUpdatesTurnCompletedBoolean() {
        boolean actualValue = blackJackInstance.getUser().isTurnCompleted();
        assertFalse(actualValue);
        blackJackInstance.getUser().endTurn();
        actualValue = blackJackInstance.getUser().isTurnCompleted();
        assertTrue(actualValue);
    }

    @Test
    public void testUserChangeValueOfAce() {
        List<Card> testListOfCards = new ArrayList<>();
        blackJackInstance.getUser().setUserHand(testListOfCards);
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        blackJackInstance.getUser().userCheckForAcesAndUpdateValueIfNecessary();
        int actualValue = testListOfCards.get(0).getCardRank().getValue();
        assertEquals(11, actualValue);
        testListOfCards.add(new Card(CardSuit.SPADES, CardRank.ACE));
        blackJackInstance.getUser().userCheckForAcesAndUpdateValueIfNecessary();
        actualValue = testListOfCards.get(0).getCardRank().getValue();
        assertEquals(1, actualValue);
    }

    @Test
    public void testCurrentValueOfUserHand() {
        List<Card> testListOfCards = new ArrayList<>();
        blackJackInstance.getUser().setUserHand(testListOfCards);
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.KING));
        int actualValue = blackJackInstance.getUser().currentValueOfUserHand();
        assertEquals(10, actualValue);
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.QUEEN));
        actualValue = blackJackInstance.getUser().currentValueOfUserHand();
        assertEquals(20, actualValue);
    }

    @Test
    public void testDisplayUserHand() {
    }
}