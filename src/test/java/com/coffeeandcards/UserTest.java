package com.coffeeandcards;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

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
    public void testUserDrawCardFromDeck() {
        blackJackInstance.getUser().drawCardFromDeck();
        int actualValue = blackJackInstance.
                getUser().
                getUserHand().
                get(0).
                getCardRank().
                getValue();
        assertEquals(10, actualValue);
    }

    @Test
    public void testUserEndTurnUpdatesTurnCompletedBoolean() {
        blackJackInstance.getUser().endTurn();
        boolean actualValue = blackJackInstance.getUser().isTurnCompleted();
        assertEquals(true, actualValue);
    }

    @Test
    public void testUserChangeValueOfAce() {
//        verify();
    }

    @Test
    public void testCurrentValueOfUserHand() {
    }

    @Test
    public void testDisplayUserHand() {
    }
}