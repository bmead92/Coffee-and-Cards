package client;

import com.coffeeandcards.blackjack.BlackJack;
import com.coffeeandcards.blackjack.BlackJackClientUtility;
import com.coffeeandcards.players.Dealer;
import com.coffeeandcards.players.User;

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
        boolean userTurnEnded = false;

        theDealer.displayDealerHand();
        System.out.println("The dealer face-up card has a value of: " + theDealer.showDealerCardValues());
        theUser.displayUserHand();
        System.out.println("The current value of your hand is: " + theUser.currentValueOfUserHand());

            if (theUser.currentValueOfUserHand() == BlackJack.MAX_VALUE_ALLOWED_IN_HAND) {
                userTurnEnded = true;
                theUser.displayUserHand();
                System.out.println("The final value of your hand is: " + theUser.currentValueOfUserHand());
                blackJackGame.userInstantWin();
                doesPlayerWantToPlayAgain = blackJackGame.checkIfPlayerWantsToStartANewRound(userInput);
            }

            while (!userTurnEnded) {
                System.out.println("Would you like to Hit or Stay? Enter your choice below: ");
                String userSelection = userInput.nextLine();
                boolean invalidInput = !userSelection.equalsIgnoreCase("Hit") &&
                        !userSelection.equalsIgnoreCase("Stay");
                if (invalidInput) {
                    System.out.println("Invalid entry. Enter 'Hit' or 'Stay': ");
                }
                if (userSelection.equalsIgnoreCase("Hit")) {
                    theUser.userDrawCardFromDeck();
                    if (theUser.currentValueOfUserHand() > BlackJack.MAX_VALUE_ALLOWED_IN_HAND) {
                        userTurnEnded = true;
                        blackJackGame.finalInformationOfUser(theUser);
                        blackJackGame.decideTheWinner();
                        doesPlayerWantToPlayAgain = blackJackGame.checkIfPlayerWantsToStartANewRound(userInput);
                    }
                    if (theUser.currentValueOfUserHand() == BlackJack.MAX_VALUE_ALLOWED_IN_HAND) {
                        userTurnEnded = true;
                        blackJackGame.finalInformationOfUser(theUser);
                        blackJackGame.decideTheWinner();
                        doesPlayerWantToPlayAgain = blackJackGame.checkIfPlayerWantsToStartANewRound(userInput);
                    } else {
                        theUser.displayUserHand();
                        System.out.println("The new value of your hand is: " + theUser.currentValueOfUserHand());
                    }
                }
                if (userSelection.equalsIgnoreCase("Stay")) {
                    blackJackGame.finalInformationOfUser(theUser);
                    userTurnEnded = true;
                    theUser.endTurn();
                    blackJackGame.finalInformationOfDealer(theDealer);
                    blackJackGame.decideTheWinner();
                    doesPlayerWantToPlayAgain = blackJackGame.checkIfPlayerWantsToStartANewRound(userInput);
                }
            }
        }
        userInput.close();
    }
}
