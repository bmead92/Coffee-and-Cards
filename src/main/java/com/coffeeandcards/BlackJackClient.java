package com.coffeeandcards;

import java.util.Scanner;

public class BlackJackClient {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println(BlackJackClientUtility.welcomeMessage());

        BlackJack blackJackGame = BlackJack.createBlackJackGame();
        blackJackGame.setUpGame();

        System.out.println("The dealer face-up card has a value of: " + blackJackGame.getDealer().showDealerCardValues());
        blackJackGame.getUser().displayUserHand();
        System.out.println("The current value of your hand is: " + blackJackGame.getUser().currentValueOfUserHand());
        System.out.println("Would you like to Hit or Stay? Enter your choice below: ");
//        userInput.nextLine();

        if(userInput.nextLine().equalsIgnoreCase("Hit")) {
            blackJackGame.getUser().drawCardFromDeck();
            System.out.println("The new value of your hand is: " + blackJackGame.getUser().currentValueOfUserHand());
        }
        userInput.nextLine();


        //TODO: Try-catch block for user input to handle exceptions
//        String inputSelection = userInput.next();
//        while(!inputSelection.equalsIgnoreCase("Hit") ||
//                !inputSelection.equalsIgnoreCase("Stay")) {
//            System.out.println("Please enter either 'Hit' or 'Stay'");
//            inputSelection = userInput.next();
//        }
//        if (inputSelection.equalsIgnoreCase("Hit")) {
//            //TODO: if the user selects 'Hit', they draw a card from the deck and add it to their hand
        //blackJackGame.getUser.drawCardFromDeck();
//        }
//        else if (inputSelection.equalsIgnoreCase("Stay")) {
//            //TODO: if the user selects 'Stay', their turn ends and the game proceeds
        blackJackGame.getUser().endTurn();
        blackJackGame.getDealer().checkForDealerMinimumHandValue();

        blackJackGame.getDealer().displayDealerHand();
        System.out.println("The dealer's hand is worth: " + blackJackGame.getDealer().showDealerCardValues());
        blackJackGame.decideTheWinner();
        userInput.close();
        System.out.println(BlackJackClientUtility.exitMessage());
        System.exit(0);
    }
}
