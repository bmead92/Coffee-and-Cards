package com.coffeeandcards;

public class BlackJackClientUtility {
    public static String welcomeMessage() {
        return CardSuit.HEARTS.getIcon() +
                CardSuit.CLUBS.getIcon() +
                "Welcome to Coffee and Cards, a BlackJack experience in Java!" +
                CardSuit.DIAMONDS.getIcon() +
                CardSuit.SPADES.getIcon() +
                "\n-------------------------------------------------------------------------------------------";
    }

    public static String exitMessage() {
        return "----------------------------------------------------------------------------------------------" +
                "\nThank you for playing Coffee and Cards!" +
                "\nThis game was created in Java by Bryce Meadors, Kiaya Anderson, and Lok Tamang." +
                "\nIt was created for TLGLearning evaluation purposes.";
    }
}
