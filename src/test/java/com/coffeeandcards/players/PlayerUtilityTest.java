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

import static com.coffeeandcards.players.PlayerUtility.*;
import static org.junit.Assert.*;

public class PlayerUtilityTest {
    private BlackJack blackJackInstance;
    private List<Card> testListOfCards;
    private PlayerUtility playerUtility;
    @Before
    public void setUp() {
        BlackJack.createBlackJackGame();
        blackJackInstance = BlackJack.getBlackJackInstance();
        blackJackInstance.setUpGame();
        testListOfCards = new ArrayList<>();
        playerUtility = BlackJack.getBlackJackInstance().getPlayerUtility();
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithOnlyAnAce() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(11, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndTwo() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TWO));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(13, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndThree() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.THREE));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(14, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndFour() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.FOUR));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(15, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndFive() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.FIVE));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(16, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndSix() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.SIX));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(17, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndSeven() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.SEVEN));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(18, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndEight() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(19, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndNine() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.NINE));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(20, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndTen() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndJack() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.JACK));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndQueen() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.QUEEN));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndKing() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.KING));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryWithAceAndAce() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(2, currentValueOfHandTestVersion(testListOfCards));
    }

    @Test
    public void testCheckForAcesAndUpdateValueIfNecessaryTriggersUpdate() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.KING));
        testListOfCards.add(new Card(CardSuit.DIAMONDS, CardRank.ACE));
        testListOfCards = playerUtility.checkForAcesAndUpdateValueIfNecessary(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(testListOfCards));
    }
    @Test
    public void testDrawCardFromDeckIncreasesHandValue() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TWO));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.THREE));
        int valueOfCardsBeforeDrawing = currentValueOfHandTestVersion(testListOfCards);
        assertEquals(5, valueOfCardsBeforeDrawing);
        testListOfCards.add(new Card(CardSuit.DIAMONDS, CardRank.FIVE));
        blackJackInstance.getDeckUtility().placeCardsIntoAStack(testListOfCards);
        playerUtility.drawCardFromDeck(blackJackInstance.getDeckUtility().getDeckOfCardsAsAStack());
        int valueOfCardsAfterDrawing = currentValueOfHandTestVersion(testListOfCards);
        assertEquals(10, valueOfCardsAfterDrawing);
    }
    @Test
    public void testDrawCardFromDeckIncreasesHandSize() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TWO));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.THREE));
        int sizeOfTheHandBeforeDrawing = testListOfCards.size();
        assertEquals(2, sizeOfTheHandBeforeDrawing);
        testListOfCards.add(new Card(CardSuit.DIAMONDS, CardRank.FIVE));
        blackJackInstance.getDeckUtility().placeCardsIntoAStack(testListOfCards);
        playerUtility.drawCardFromDeck(blackJackInstance.getDeckUtility().getDeckOfCardsAsAStack());
        int sizeOfHandAfterDrawing = testListOfCards.size();
        assertEquals(3, sizeOfHandAfterDrawing);
    }
    @Test
    public void testCurrentValueOfHand() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TWO));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.THREE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.FIVE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        int actualValue = playerUtility.currentValueOfHand(testListOfCards);
        assertEquals(18, actualValue);
    }
    @After
    public void tearDown() {
        BlackJack.setBlackJackInstance(null);
        testListOfCards.clear();
        playerUtility.setCopyOfList(testListOfCards);
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