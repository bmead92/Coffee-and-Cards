package com.coffeeandcards;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DealerTest {

    BlackJack blackJackInstance;

    @Before
    public void setUp() {
        BlackJack.createBlackJackGame();
        blackJackInstance = BlackJack.getBlackJackInstance();
        blackJackInstance.setUpGame();
    }

    //test 1: if the dealer hand value is less than 17,
    //invoke drawCardFromDeck method and make it greater than 17
    @Test
    public void test_if_dealer_card_is_less_than_17() {
//  returns intValueOfDealerHand greater than 17
        blackJackInstance.getDealer().getIntValueOfDealerHand();
        blackJackInstance.getDealer().checkForDealerMinimumHandValue();
        int expectedValue = 10;
        Assert.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testKeepHand() {
    }

    @Test
    public void testDisplayValue() {
    }

    @Test
    public void testDealCards() {
    }
}