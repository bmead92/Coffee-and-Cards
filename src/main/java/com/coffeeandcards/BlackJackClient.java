package com.coffeeandcards;

import java.util.Scanner;

public class BlackJackClient {
    public static void main(String[] args) {
        System.out.println(BlackJackClientUtility.welcomeMessage());

        BlackJack blackJackGame = BlackJack.createBlackJackGame();
        blackJackGame.setUpGame();
        Dealer theDealer = blackJackGame.getDealer();
        User theUser = blackJackGame.getUser();

        System.out.println("The dealer face-up card has a value of: " + theDealer.showDealerCardValues());
        theUser.displayUserHand();
        System.out.println("The current value of your hand is: " + theUser.currentValueOfUserHand());
        System.out.println("Would you like to Hit or Stay? Enter your choice below: ");

        Scanner userInput = new Scanner(System.in);
        while (true) {
            String userSelection = userInput.nextLine();
            if (!(!userSelection.equalsIgnoreCase("Hit") ||
                            !userSelection.equalsIgnoreCase("Stay"))) break;
            System.out.println("Invalid input. Please enter 'Hit' or 'Stay': ");
            if (userSelection.equalsIgnoreCase("Hit")) {
                theUser.drawCardFromDeck();
                System.out.println("The new value of your hand is: " + theUser.currentValueOfUserHand());
            }
            if (userSelection.equalsIgnoreCase("Stay")) {
                theUser.endTurn();
            }
        }

        theDealer.checkForDealerMinimumHandValue();
        theDealer.displayDealerHand();
        System.out.println("The dealer's hand is worth: " + theDealer.showDealerCardValues());
        blackJackGame.decideTheWinner();
        userInput.close();
        System.out.println(BlackJackClientUtility.exitMessage());
        System.exit(0);
    }
}
