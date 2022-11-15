package com.coffeeandcards;

import java.util.Scanner;

public class BlackJack {
    private static BlackJack blackJackInstance = null;
    private DeckUtility deckUtility;
    private Dealer dealer;
    private User user;
    public static final int MAX_VALUE_ALLOWED_IN_HAND = 21;

    private BlackJack(DeckUtility deckUtility, Dealer dealer, User user) {
        setDeckUtility(deckUtility);
        setDealer(dealer);
        setUser(user);
    }

    public static BlackJack createBlackJackGame() {
        if (blackJackInstance == null) {
            blackJackInstance = new BlackJack(new DeckUtility(), new Dealer(), new User());
        }
        return blackJackInstance;
    }

    public void setUpGame() {
        //Fill a List<Card> with 52 cards
        deckUtility.fillDeckWithCards();
        //Shuffle the cards
        deckUtility.shuffleCards(deckUtility.getDeckOfCardsAsAList());
        //Place them into a stack
        deckUtility.placeCardsIntoAStack(deckUtility.getDeckOfCardsAsAList());
        dealer.dealCards();
        dealer.changeValueOfAce();
        user.changeValueOfAce();
    }


    public void finalInformationOfUser(User theUser) {
        theUser.displayUserHand();
        System.out.println("The final value of your hand is: " + theUser.currentValueOfUserHand());
    }

    public void finalInformationOfDealer(Dealer theDealer) {
        theDealer.checkForDealerMinimumHandValue();
        theDealer.displayDealerHand();
        System.out.println("The dealer's hand is worth: " + theDealer.showDealerCardValues());
    }

    public void userInstantWin() {
        if (user.currentValueOfUserHand() == MAX_VALUE_ALLOWED_IN_HAND) {
            System.out.println("How lucky are you?! You started with 21. You win!");
        }
    }

    public boolean checkIfPlayerWantsToStartANewRound(Scanner scanner) {
        String playAgain;
        boolean doesPlayerWantToPlayAgain = true;
        System.out.println(BlackJackClientUtility.playAgainMessage());
        playAgain = scanner.nextLine();
        while (!playAgain.equalsIgnoreCase("No") &&
        !playAgain.equalsIgnoreCase("Yes")) {
            System.out.println("Invalid input, please type 'yes' or 'no'");
            playAgain = scanner.nextLine();
        }
        if (playAgain.equalsIgnoreCase("No")) {
            doesPlayerWantToPlayAgain = false;
            System.out.println(BlackJackClientUtility.exitMessage());
            System.exit(0);
        }
        if (playAgain.equalsIgnoreCase("Yes")) {
            blackJackInstance = null;
        }
        return doesPlayerWantToPlayAgain;
    }

    public void decideTheWinner() {
        int valueOfUserHand = user.currentValueOfUserHand();
        int valueOfDealerHand = dealer.getIntValueOfDealerHand();
        int twentyOne = MAX_VALUE_ALLOWED_IN_HAND;

        if ((valueOfUserHand == twentyOne) &&
                (valueOfDealerHand != twentyOne)) {
            System.out.println("You hit 21! You win!");
        }
        if ((valueOfUserHand < twentyOne) &&
                (valueOfUserHand > valueOfDealerHand)) {
            System.out.println("Congratulations, you win!");
        }
        if ((valueOfUserHand <= twentyOne) &&
                (valueOfDealerHand > twentyOne)) {
            System.out.println("Dealer bust. You win!");
        }
        if ((valueOfDealerHand > valueOfUserHand) &&
                (valueOfDealerHand <= twentyOne)) {
            System.out.println("Better luck next time. Dealer wins.");
        }
        if (valueOfUserHand > twentyOne) {
            System.out.println("Why didn't you stay? You lose!");
        }
        if ((valueOfUserHand > twentyOne) &&
                (valueOfDealerHand > twentyOne)) {
            System.out.println("You both busted - TOO BAD, SO SAD!");
        }
        if ((valueOfUserHand == twentyOne) &&
                (valueOfDealerHand == twentyOne)) {
            System.out.println("What are the odds!? It's a draw!");
        }
        if (valueOfUserHand == valueOfDealerHand) {
            System.out.println("You and the dealer ended up with the same value! It's a draw.");
        }
    }

    public DeckUtility getDeckUtility() {
        return deckUtility;
    }

    public void setDeckUtility(DeckUtility deckUtility) {
        this.deckUtility = deckUtility;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static BlackJack getBlackJackInstance() {
        return blackJackInstance;
    }

    public static void setBlackJackInstance(BlackJack blackJackInstance) {
        BlackJack.blackJackInstance = blackJackInstance;
    }
}
