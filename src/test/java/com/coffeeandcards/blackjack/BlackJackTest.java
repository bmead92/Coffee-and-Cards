package com.coffeeandcards.blackjack;

import com.coffeeandcards.deck.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BlackJackTest {
    private BlackJack blackJackInstance;
    private List<Card> testListOfCards;

    @Before
    public void setUp() {
        BlackJack.createBlackJackGame();
        blackJackInstance = BlackJack.getBlackJackInstance();
        blackJackInstance.setUpGame();
        testListOfCards = new ArrayList<>();
    }

    @Test // Once we run the method the size of dealer hand must be 2
    public void testInitialDealOfCards(){

    }

    @Test
    public void testUserInstantWin(){

    }



}
