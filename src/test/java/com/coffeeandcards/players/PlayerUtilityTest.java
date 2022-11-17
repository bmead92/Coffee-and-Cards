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
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithOnlyAnAce() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(11, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithAceAndTwo() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TWO));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(13, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithAceAndThree() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.THREE));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(14, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithAceAndFour() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.FOUR));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(15, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithAceAndFive() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.FIVE));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(16, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithAceAndSix() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.SIX));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(17, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithAceAndSeven() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.SEVEN));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(18, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithAceAndEight() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(19, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithAceAndNine() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.NINE));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(20, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithAceAndTen() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.TEN));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryAceAndJack() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.JACK));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryAceAndQueen() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.QUEEN));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }
    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryAceAndKing() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.KING));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }

    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryWithAceAndAce() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(12, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }

    @Test
    public void ttestCheckForAcesAndChangeCardRankIfNecessaryTriggers() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.KING));
        testListOfCards.add(new Card(CardSuit.DIAMONDS, CardRank.KING));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(21, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }

    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryMultipleAcesAndDemotesBoth() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.KING));
        testListOfCards.add(new Card(CardSuit.DIAMONDS, CardRank.ACE));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(12, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
    }

    @Test
    public void testCheckForAcesAndChangeCardRankIfNecessaryTriggersUpdateTwoAcesButOnlyDemotesOne() {
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.ACE));
        testListOfCards.add(new Card(CardSuit.HEARTS, CardRank.EIGHT));
        testListOfCards.add(new Card(CardSuit.DIAMONDS, CardRank.ACE));
        testListOfCards = playerUtility.checkForAcesAndChangeCardRankIfNecessary(testListOfCards);
        playerUtility.setCopyOfList(testListOfCards);
        assertEquals(20, currentValueOfHandTestVersion(playerUtility.getCopyOfList()));
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