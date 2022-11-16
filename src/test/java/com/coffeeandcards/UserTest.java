package com.coffeeandcards;

import com.coffeeandcards.blackjack.BlackJack;
import org.junit.Before;

public class UserTest {
    private BlackJack blackJackInstance;

    @Before
    public void setUp() {
        BlackJack.createBlackJackGame();
        blackJackInstance = BlackJack.getBlackJackInstance();
        blackJackInstance.setUpGame();
    }

}