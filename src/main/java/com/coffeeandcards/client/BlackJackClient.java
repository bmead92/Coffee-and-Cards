package com.coffeeandcards.client;

import com.coffeeandcards.blackjack.BlackJack;
import com.coffeeandcards.blackjack.BlackJackClientUtility;
import com.coffeeandcards.players.Dealer;
import com.coffeeandcards.players.PlayerUtility;
import com.coffeeandcards.players.User;

import static com.coffeeandcards.players.PlayerUtility.*;

import java.util.Scanner;

public class BlackJackClient {
    public static void main(String[] args) {
        boolean doesPlayerWantToPlayAgain = true;
        Scanner userInput = new Scanner(System.in);
        while (doesPlayerWantToPlayAgain) {
        System.out.println(BlackJackClientUtility.welcomeMessage());
        BlackJack blackJackGame = BlackJack.createBlackJackGame();
        blackJackGame.setUpGame();
        Dealer theDealer = blackJackGame.getDealer();
        User theUser = blackJackGame.getUser();
        PlayerUtility playerUtility = blackJackGame.getPlayerUtility();
        boolean userTurnEnded = false;
        final String bold = "\033[1m";
        final String unBold = "\033[0m";
        theDealer.displayCurrentDealerHandAsCards();
        System.out.println("The dealer face-up card has a value of: " + theDealer.displayCurrentDealerHandAsValues());
        System.out.println("Your starting cards: ");
        playerUtility.displayCardsInHand(theUser.getUserHand());
        System.out.println("The current value of your hand is: " + playerUtility.currentValueOfHand(theUser.getUserHand()));
            if (playerUtility.currentValueOfHand(theUser.getUserHand()) == BlackJack.MAX_VALUE_ALLOWED_IN_HAND) {
                userTurnEnded = true;
                blackJackGame.userInstantWin();
                doesPlayerWantToPlayAgain = blackJackGame.checkIfPlayerWantsToStartANewRound(userInput);
            }
            while (!userTurnEnded) {
                System.out.println("Would you like to" + bold + " Hit or Stay? " + unBold +
                        "Enter your choice below: ");
                String userSelection = userInput.nextLine();
                boolean userSelectedHit = userSelection.equalsIgnoreCase("Hit");
                boolean userSelectedStay = userSelection.equalsIgnoreCase("Stay");
                boolean invalidInput = !userSelectedHit && !userSelectedStay;
                if (invalidInput) {
                    System.out.println("Invalid entry. Enter" + bold + " 'Hit' or 'Stay': " + unBold);
                }
                if (userSelectedHit) {
                    playerUtility.drawCardFromDeck(theUser.getUserHand());
                    if (playerUtility.currentValueOfHand(theUser.getUserHand()) > BlackJack.MAX_VALUE_ALLOWED_IN_HAND) {
                        userTurnEnded = true;
                        blackJackGame.finalInformationOfUser(theUser);
                        blackJackGame.decideTheWinner();
                        doesPlayerWantToPlayAgain = blackJackGame.checkIfPlayerWantsToStartANewRound(userInput);
                    }
                    if (playerUtility.currentValueOfHand(theUser.getUserHand()) == BlackJack.MAX_VALUE_ALLOWED_IN_HAND) {
                        userTurnEnded = true;
                        blackJackGame.finalInformationOfUser(theUser);
                        blackJackGame.decideTheWinner();
                        doesPlayerWantToPlayAgain = blackJackGame.checkIfPlayerWantsToStartANewRound(userInput);
                    } else {
                        playerUtility.displayCardsInHand(theUser.getUserHand());
                        System.out.println("The new value of your hand is: " +
                                playerUtility.currentValueOfHand(theUser.getUserHand()));
                    }
                }
                if (userSelectedStay) {
                    blackJackGame.finalInformationOfUser(theUser);
                    userTurnEnded = true;
                    theUser.setTurnCompleted(true);
                    System.out.println("User turn is over. Let's see what the dealer has!");
                    blackJackGame.finalInformationOfDealer(theDealer);
                    blackJackGame.decideTheWinner();
                    doesPlayerWantToPlayAgain = blackJackGame.checkIfPlayerWantsToStartANewRound(userInput);
                }
            }
        }
        userInput.close();
    }
}
