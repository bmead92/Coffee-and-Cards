package com.coffeeandcards.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {
    private BlackJack blackJackInstance;

    @Before
    public void setUp() {
        BlackJack.createBlackJackGame();
        blackJackInstance = BlackJack.getBlackJackInstance();
        blackJackInstance.setUpGame();
    }

    @Test
    public void testInitialDealOfCards(){
        blackJackInstance.initialDealOfCards();
        int actualValue = blackJackInstance.getCardsDealt();
        assertEquals(2, actualValue);
    }

    @Test
    public void testInitialDealOfDealerHandCards(){
        blackJackInstance.initialDealOfCards();
        int actualValue = blackJackInstance.getDealer().getDealerHand().size();
        assertEquals(2, actualValue);
    }

    @Test
    public void testInitialDealOfUserHandCards(){
        blackJackInstance.initialDealOfCards();
        int actualValue = blackJackInstance.getUser().getUserHand().size();
        assertEquals(2, actualValue);
    }
}
