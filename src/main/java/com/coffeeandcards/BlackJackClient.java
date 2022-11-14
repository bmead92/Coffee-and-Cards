package com.coffeeandcards;

import java.util.Scanner;

public class BlackJackClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(BlackJackClientUtility.welcomeMessage());
        //global static reference point that also ensures only 1 Dealer, 1 User, and 1 deck of cards.
        BlackJack blackJackGame = BlackJack.createBlackJackGame();
        blackJackGame.setUpGame();
        System.out.println("The dealer face-up card is worth: " + blackJackGame.getDealer().valueOfDealerHand());
        blackJackGame.getUser().displayUserHand();
        System.out.println("Your current hand value is: " + blackJackGame.getUser().valueOfUserHand());
        System.out.println("Would you like to Hit or Stay?");
        //TODO: Try-catch block for user input to handle exceptions
//        String inputSelection = scanner.next();
//        while(!inputSelection.equalsIgnoreCase("Hit") ||
//                !inputSelection.equalsIgnoreCase("Stay")) {
//            System.out.println("Please enter either 'Hit' or 'Stay'");
//            inputSelection = scanner.next();
//        }
//        if (inputSelection.equalsIgnoreCase("Hit")) {
//            //TODO: if the user selects 'Hit', they draw a card from the deck and add it to their hand
//        }
//        else if (inputSelection.equalsIgnoreCase("Stay")) {
//            //TODO: if the user selects 'Stay', their turn ends and the game proceeds
        blackJackGame.getUser().keepHand();
//        }
        System.out.println("The dealer's hand is worth: " + blackJackGame.getDealer().valueOfDealerHand());
        blackJackGame.decideTheWinner();
        scanner.close();
        System.out.println(BlackJackClientUtility.exitMessage());
        System.exit(0);
    }
}
