package com.coffeeandcards;

import java.util.Scanner;

public class BlackJackClient {
    public static void main(String[] args) {
        //global static reference point that also ensures only 1 Dealer, 1 User, and 1 deck of cards.
        BlackJack blackJackGame = BlackJack.createBlackJackGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println(BlackJackUtility.welcomeMessage());
        //TODO: Try-catch block for user input to handle exceptions
//        String inputSelection = scanner.next();
//        if (inputSelection.equalsIgnoreCase("Hit")) {
//            TODO: if the user selects 'Hit', they draw a card from the deck and add it to their hand
//        }
//        else if (inputSelection.equalsIgnoreCase("Stay")) {
//            //TODO: if the user selects 'Stay', their turn ends and the game proceeds
//        }
        scanner.close();
        System.out.println(BlackJackUtility.exitMessage());
        blackJackGame.setGameStatus(false);
        System.exit(0);
    }
}
