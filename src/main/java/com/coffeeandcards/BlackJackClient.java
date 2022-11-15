package com.coffeeandcards;

import java.util.Scanner;

public class BlackJackClient {
    public static void main(String[] args) {
        System.out.println(BlackJackClientUtility.welcomeMessage());

        BlackJack blackJackGame = BlackJack.createBlackJackGame();
        blackJackGame.setUpGame();

        System.out.println("The dealer face-up card has a value of: " + blackJackGame.getDealer().showDealerCardValues());
        blackJackGame.getUser().displayUserHand();
        System.out.println("The current value of your hand is: " + blackJackGame.getUser().currentValueOfUserHand());
        System.out.println("Would you like to Hit or Stay? Enter your choice below: ");

        Scanner userInput = new Scanner(System.in);
        while (!userInput.nextLine().equalsIgnoreCase("Hit") ||
                !userInput.nextLine().equalsIgnoreCase("Stay")) {
            System.out.println("Invalid input. Please enter 'Hit' or 'Stay': ");
            if (userInput.nextLine().equalsIgnoreCase("Hit")) {
                blackJackGame.getUser().drawCardFromDeck();
                System.out.println("The new value of your hand is: " + blackJackGame.getUser().currentValueOfUserHand());
            }
            if (userInput.nextLine().equalsIgnoreCase("Stay")) {
                blackJackGame.getUser().endTurn();
            }
        }

        blackJackGame.getDealer().checkForDealerMinimumHandValue();
        blackJackGame.getDealer().displayDealerHand();
        System.out.println("The dealer's hand is worth: " + blackJackGame.getDealer().showDealerCardValues());
        blackJackGame.decideTheWinner();
        userInput.close();
        System.out.println(BlackJackClientUtility.exitMessage());
        System.exit(0);
    }
}
