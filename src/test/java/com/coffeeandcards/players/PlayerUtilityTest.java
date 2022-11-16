package com.coffeeandcards.players;

import com.coffeeandcards.blackjack.BlackJack;
import com.coffeeandcards.deck.Card;
import com.coffeeandcards.deck.CardRank;
import com.coffeeandcards.deck.CardSuit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.coffeeandcards.players.PlayerUtility.checkForAcesAndUpdateValueIfNecessary;
import static org.junit.Assert.*;

public class PlayerUtilityTest {
    private BlackJack blackJackInstance;
    private List<Card> testListOfCards;

    @Before
    public void setUp() {
        BlackJack.createBlackJackGame();
        blackJackInstance = BlackJack.getBlackJackInstance();
        blackJackInstance.setUpGame();
        testListOfCards = new ArrayList<>();
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithOnlyAnAce() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(11, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndTwo() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TWO));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(13, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndThree() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.THREE));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(14, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndFour() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.FOUR));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(15, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndFive() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.FIVE));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(16, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndSix() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.SIX));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(17, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndSeven() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.SEVEN));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(18, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndEight() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(19, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndNine() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.NINE));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(20, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndTen() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndJack() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.JACK));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndQueen() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.QUEEN));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndKing() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.KING));
        System.out.println(currentValueOfHandTestVersion(testListOfCards));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        System.out.println(currentValueOfHandTestVersion(testListOfCards));
        assertEquals(21, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndAce() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(2, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testDrawCardFromDeck() {
    }

    @Test
    public void testCurrentValueOfHand() {
    }


    @After
    public void tearDown() {
        testListOfCards.clear();
    }
    private int currentValueOfHandTestVersion(List<Card> listOfCards) {
        int currentValueOfHand = 0;
        for (Card card : listOfCards) {
            int valueOfCard = card.getCardRank().getValue();
            currentValueOfHand += valueOfCard;
        }
        return currentValueOfHand;
    }
}