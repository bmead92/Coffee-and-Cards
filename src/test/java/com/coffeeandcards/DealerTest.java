package com.coffeeandcards;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DealerTest {

    private BlackJack blackJackInstance;

    @Before
    public void setUp() {
        BlackJack.createBlackJackGame();
        blackJackInstance = BlackJack.getBlackJackInstance();
        blackJackInstance.setUpGame();
    }

    @Test
    public void testDealerDrawCardFromDeck() {
        int actualValue = blackJackInstance.getDealer().getDealerHand().size();
        blackJackInstance.getDealer().drawCardFromDeck();
        assertEquals(2, actualValue);
        actualValue = blackJackInstance.getDealer().getDealerHand().size();
        blackJackInstance.getDealer().drawCardFromDeck();
        assertEquals(3, actualValue);
        actualValue = blackJackInstance.getDealer().getDealerHand().size();
        blackJackInstance.getDealer().drawCardFromDeck();
        assertEquals(4, actualValue);
    }

    @Test
    public void testDealerHandValueIfValueLessThan17() {
        List<Card> testListOfCards = new ArrayList<>();
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.SIX));
        blackJackInstance.getDealer().setDealerHand(testListOfCards);
        int valueOfDealerHandBefore = blackJackInstance.getDealer().currentValueOfDealerHand();
        blackJackInstance.getDealer().checkForDealerMinimumHandValue();
        int valueOfDealerHandAfter = blackJackInstance.getDealer().currentValueOfDealerHand();
        assertTrue(valueOfDealerHandAfter > valueOfDealerHandBefore);
//        assertTrue(valueOfDealerHandAfter >= Dealer.MINIMUM_DEALER_HAND_VALUE);
    }

    @Test
    public void testDealerHandValueIfValueGreaterThan17() {
        List<Card> testListOfCards = new ArrayList<>();
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        blackJackInstance.getDealer().setDealerHand(testListOfCards);
        int valueOfDealerHandBefore = blackJackInstance.getDealer().currentValueOfDealerHand();
        blackJackInstance.getDealer().checkForDealerMinimumHandValue();
        int valueOfDealerHandAfter = blackJackInstance.getDealer().currentValueOfDealerHand();
        assertTrue(valueOfDealerHandAfter == valueOfDealerHandBefore);
    }


    @Test
    public void testDealerChangeValueOfAce() {
        List<Card> testListOfCards = new ArrayList<>();
        blackJackInstance.getDealer().setDealerHand(testListOfCards);
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        blackJackInstance.getDealer().changeValueOfAce();
        int actualValue = testListOfCards.get(0).getCardRank().getValue();
        assertEquals(11, actualValue);

        testListOfCards.add(new Card(CardSuit.SPADES, CardRank.ACE));
        blackJackInstance.getDealer().changeValueOfAce();
        actualValue = testListOfCards.get(0).getCardRank().getValue();
        assertEquals(1, actualValue);
        testListOfCards.add(new Card(CardSuit.DIAMONDS, CardRank.ACE));
        blackJackInstance.getDealer().changeValueOfAce();
        actualValue = testListOfCards.get(0).getCardRank().getValue();
        assertEquals(1, actualValue);
    }

    @Test
    public void testDisplayDealerHand() {

    }

    @Test
    public void testCurrentValueOfDealerHand() {
        List<Card> testListOfCards = new ArrayList<>();
        blackJackInstance.getDealer().setDealerHand(testListOfCards);
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        int actualValue = blackJackInstance.getDealer().currentValueOfDealerHand();
        assertEquals(8, actualValue);
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.JACK));
        actualValue = blackJackInstance.getDealer().currentValueOfDealerHand();
        assertEquals(18, actualValue);
    }

    @Test
    public void testDealCards() {
    }
}