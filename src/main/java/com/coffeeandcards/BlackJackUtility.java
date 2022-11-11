package com.coffeeandcards;

public class BlackJackUtility {
    public static String welcomeMessage() {
        return CardSuit.HEARTS.getIcon() +
                CardSuit.CLUBS.getIcon() +
                "Welcome to Coffee and Cards, a BlackJack experience in Java!" +
                CardSuit.DIAMONDS.getIcon() +
                CardSuit.SPADES.getIcon();
    }

    public static String startGame() {
        return "Your current hand value is " + //add player hand value here
                "\nWould you like to hit or stay?";
    }

    public static String exitMessage() {
        return "Thank you for playing Coffee and Cards!" +
                "\nThis game was created in Java by Bryce Meadors, Kiaya Anderson, and Lok Tamang." +
                "\nIt was created for TLGLearning evaluation purposes.";
    }
}
