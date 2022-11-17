package com.coffeeandcards;

import com.coffeeandcards.blackjack.BlackJack;
import com.coffeeandcards.deck.Card;
import com.coffeeandcards.deck.CardRank;
import com.coffeeandcards.deck.CardSuit;
import com.coffeeandcards.players.Dealer;
import org.junit.Before;
import org.junit.Test;

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
    public void testDisplayCurrentDealerHandAsCards() {
    }

    @Test
    public void testShowDealerCardValuesIfUserTurnCompleted() {
        List<Card> testListOfCards = new ArrayList<>();
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        blackJackInstance.getDealer().setDealerHand(testListOfCards);
        blackJackInstance.getUser().setTurnCompleted(true);
        int actualValue = blackJackInstance.getDealer().displayCurrentDealerHandAsValues();
        int expectedValue = 18;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testShowDealerCardValuesIfUserTurnIsNotCompleted() {
        List<Card> testListOfCards = new ArrayList<>();
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        blackJackInstance.getDealer().setDealerHand(testListOfCards);
        blackJackInstance.getUser().setTurnCompleted(false);
        int actualValue = blackJackInstance.getDealer().displayCurrentDealerHandAsValues();
        int expectedValue = 8;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testDealerHandValueIfValueLessThan17ShouldIncreaseInValue() {
        List<Card> testListOfCards = new ArrayList<>();
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.SIX));
        Dealer theDealer = blackJackInstance.getDealer();
        theDealer.setDealerHand(testListOfCards);
        List<Card> dealerHand = blackJackInstance.getDealer().getDealerHand();
        int valueOfDealerHandBefore = currentValueOfHandTestVersion(dealerHand);
        blackJackInstance.getDealer().checkForDealerMinimumHandValue();
        int valueOfDealerHandAfter = currentValueOfHandTestVersion(dealerHand);
        assertTrue(valueOfDealerHandAfter > valueOfDealerHandBefore);
    }

    @Test
    public void testDealerHandValueIfValueLessThan17ShouldIncreaseDealerHandSize() {
        List<Card> testListOfCards = new ArrayList<>();
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.SIX));
        Dealer theDealer = blackJackInstance.getDealer();
        theDealer.setDealerHand(testListOfCards);
        List<Card> dealerHand = blackJackInstance.getDealer().getDealerHand();
        int sizeOfDealerHandBefore = dealerHand.size();
        blackJackInstance.getDealer().checkForDealerMinimumHandValue();
        int sizeOfDealerHandAfter = dealerHand.size();
        assertTrue(sizeOfDealerHandAfter > sizeOfDealerHandBefore);
    }

    @Test
    public void testDealerHandValueIfValueGreaterThanOrEqualTo17ShouldNotChangeValue() {
        List<Card> testListOfCards = new ArrayList<>();
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        blackJackInstance.getDealer().setDealerHand(testListOfCards);
        List<Card> dealerHand = blackJackInstance.getDealer().getDealerHand();
        int valueOfDealerHandBefore = currentValueOfHandTestVersion(dealerHand);
        blackJackInstance.getDealer().checkForDealerMinimumHandValue();
        int valueOfDealerHandAfter = currentValueOfHandTestVersion(dealerHand);
        assertEquals(valueOfDealerHandAfter, valueOfDealerHandBefore);
    }

    @Test
    public void testDealerHandValueIfValueGreaterThanOrEqualTo17ShouldNotChangeSize() {
        List<Card> testListOfCards = new ArrayList<>();
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        blackJackInstance.getDealer().setDealerHand(testListOfCards);
        List<Card> dealerHand = blackJackInstance.getDealer().getDealerHand();
        int sizeOfDealerHandBefore = dealerHand.size();
        blackJackInstance.getDealer().checkForDealerMinimumHandValue();
        int sizeOfDealerHandAfter = dealerHand.size();
        assertEquals(sizeOfDealerHandAfter, sizeOfDealerHandBefore);
    }

    private int currentValueOfHandTestVersion(List<Card> listOfCards) {
        int currentValueOfHand = 0;
        for (Card card : listOfCards) {
            int valueOfCard = card.getCardRank().getCardValue();
            currentValueOfHand += valueOfCard;
        }
        return currentValueOfHand;
    }

}