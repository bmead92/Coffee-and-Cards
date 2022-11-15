package com.coffeeandcards;

import java.util.Scanner;

public class BlackJackClient {
    public static void main(String[] args) {
        System.out.println(BlackJackClientUtility.welcomeMessage());

        BlackJack blackJackGame = BlackJack.createBlackJackGame();
        blackJackGame.setUpGame();
        Dealer theDealer = blackJackGame.getDealer();
        User theUser = blackJackGame.getUser();

        boolean userTurnEnded = false;

        System.out.println("The dealer face-up card has a value of: " + theDealer.showDealerCardValues());
        theUser.displayUserHand();
        System.out.println("The current value of your hand is: " + theUser.currentValueOfUserHand());

        Scanner userInput = new Scanner(System.in);
        if(theUser.currentValueOfUserHand() == BlackJack.MAX_VALUE_ALLOWED_IN_HAND){
            userTurnEnded = true;
            theUser.displayUserHand();
            System.out.println("The final value of your hand is: " + theUser.currentValueOfUserHand());
            blackJackGame.userInstantWin();
            userInput.close();
            blackJackGame.endGame();
        }

        while (!userTurnEnded) {
            System.out.println("Would you like to Hit or Stay? Enter your choice below: ");
            String userSelection = userInput.nextLine();
            if (userSelection.equalsIgnoreCase("Hit")) {
                theUser.drawCardFromDeck();
                if(theUser.currentValueOfUserHand() > BlackJack.MAX_VALUE_ALLOWED_IN_HAND){
                    userTurnEnded = true;
                    theUser.displayUserHand();
                    System.out.println("The final value of your hand is: " + theUser.currentValueOfUserHand());
                    blackJackGame.decideTheWinner();
                    userInput.close();
                    blackJackGame.endGame();
                } else if(theUser.currentValueOfUserHand() == BlackJack.MAX_VALUE_ALLOWED_IN_HAND){
                    userTurnEnded = true;
                    theUser.displayUserHand();
                    System.out.println("The final value of your hand is: " + theUser.currentValueOfUserHand());
                    blackJackGame.decideTheWinner();
                    userInput.close();
                    blackJackGame.endGame();
                }
                theUser.displayUserHand();
                System.out.println("The new value of your hand is: " + theUser.currentValueOfUserHand());
            }
            if (userSelection.equalsIgnoreCase("Stay")) {
                theUser.displayUserHand();
                System.out.println("The final value of your hand is: " + theUser.currentValueOfUserHand());
                userTurnEnded = true;
                theUser.endTurn();
            }
            else {
                System.out.println("Invalid entry. Enter 'Hit' or 'Stay': ");
            }
        }

        theDealer.checkForDealerMinimumHandValue();
        theDealer.displayDealerHand();
        System.out.println("The dealer's hand is worth: " + theDealer.showDealerCardValues());
        blackJackGame.decideTheWinner();
        userInput.close();
        blackJackGame.endGame();
    }
}
