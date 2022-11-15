package com.coffeeandcards;

public class BlackJackClientUtility {
    public static String welcomeMessage() {
        return CardSuit.HEARTS.getIcon() +
                CardSuit.CLUBS.getIcon() +
                "Welcome to Coffee and Cards, a BlackJack experience in Java!" +
                CardSuit.DIAMONDS.getIcon() +
                CardSuit.SPADES.getIcon() +
                "\n Basic instructions of game: " +
                "\n The objective is to get your hand value as close to 21 as possible without going over." +
                "\n If you hit 21, you win! If you go over, you lose. If the dealer has a better hand than you" +
                "\n and your hand values are both under 21, the dealer wins." +
                "\n-------------------------------------------------------------------------------------------";
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
