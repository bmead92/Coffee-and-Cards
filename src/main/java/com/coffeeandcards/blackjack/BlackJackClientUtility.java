package com.coffeeandcards.blackjack;

import com.coffeeandcards.deck.CardSuit;

public class BlackJackClientUtility {
    public static String welcomeMessage() {
        final String bold = "\033[1m";
        final String unBold = "\033[0m";
        return "\n" + CardSuit.HEARTS.getIcon() +
                CardSuit.CLUBS.getIcon() +
                "Welcome to Coffee and Cards, a BlackJack experience in Java!" +
                CardSuit.DIAMONDS.getIcon() +
                CardSuit.SPADES.getIcon() +
                "\n                            Basic Rules:" +
                "\nThe objective is to get your hand value as close to 21 as possible without going over." +
                "\n 1. If you hit 21, you win! If you go over 21, you lose." +
                "\n 2. If the dealer has a better hand than you, the dealer wins." +
                "\n 3. When you 'Stay', if the dealer does not have 17, they will draw up." +
                "\n    If the dealer busts during this process, you win!" +
                "\n-------------------------------------------------------------------------------------------\n" +
                "                            " + bold + "Let's play!\n" + unBold;
    }

    public static String playAgainMessage() {
        return "Would you like to play again? Enter 'Yes' or 'No':";
    }

    public static String exitMessage() {
        final String TM = "\u2122";
        return "----------------------------------------------------------------------------------------------" +
                "\nThank you for playing Coffee and Cards!" +
                "\nThis game was created in Java by Bryce Meadors, Kiaya Anderson, and Lok Tamang." +
                "\nIt was created for TLGLearning" + TM + " evaluation purposes.";
    }
}
