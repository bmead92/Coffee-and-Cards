package com.coffeeandcards.blackjack;

import com.coffeeandcards.deck.CardSuit;

public class BlackJackClientUtility {
    public static String welcomeMessage() {
        return CardSuit.HEARTS.getIcon() +
                CardSuit.CLUBS.getIcon() +
                "Welcome to Coffee and Cards, a BlackJack experience in Java!" +
                CardSuit.DIAMONDS.getIcon() +
                CardSuit.SPADES.getIcon() +
                "\n\n The objective is to get your hand value as close to 21 as possible without going over." +
                "\n If you hit 21, you win! If you go over 21, you lose. If the dealer has a better hand than you" +
                "\n and your hand values are both under 21, the dealer wins." +
                "\n The dealer will start with one card face-up and one card face down, but the dealer must have" +
                "\n a minimum value of 17 in their hand, so the player should strive to have a hand worth above" +
                "\n 17 and below 21. When you 'Stay', if the dealer does not have 17, they will draw up. " +
                "\n if the dealer busts during this process, you win!" +
                "\n-------------------------------------------------------------------------------------------\n";
    }

    public static String playAgainMessage() {
        return "Would you like to play again? Enter 'Yes' or 'No':";
    }
    public static String exitMessage() {
        return "----------------------------------------------------------------------------------------------" +
                "\nThank you for playing Coffee and Cards!" +
                "\nThis game was created in Java by Bryce Meadors, Kiaya Anderson, and Lok Tamang." +
                "\nIt was created for TLGLearning evaluation purposes.";
    }
}
