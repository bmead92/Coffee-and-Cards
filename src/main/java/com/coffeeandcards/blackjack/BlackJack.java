package com.coffeeandcards.blackjack;

import com.coffeeandcards.deck.Card;
import com.coffeeandcards.players.Dealer;
import com.coffeeandcards.deck.DeckUtility;
import com.coffeeandcards.players.PlayerUtility;
import com.coffeeandcards.players.User;

import java.util.List;
import java.util.Scanner;

public class BlackJack {
    public static final int MAX_VALUE_ALLOWED_IN_HAND = 21;
    public static final int STARTING_NUMBER_OF_CARDS = 2;
    private static BlackJack blackJackInstance = null;
    private DeckUtility deckUtility;
    private Dealer dealer;
    private User user;
    private PlayerUtility playerUtility;
    private int cardsDealt = 0;

    private BlackJack(DeckUtility deckUtility, Dealer dealer, User user, PlayerUtility playerUtility) {
        setDeckUtility(deckUtility);
        setDealer(dealer);
        setUser(user);
        setPlayerUtility(playerUtility);
    }

    public static BlackJack createBlackJackGame() {
        if (blackJackInstance == null) {
            blackJackInstance = new BlackJack(new DeckUtility(), new Dealer(),
                    new User(), new PlayerUtility());
        }
        return blackJackInstance;
    }

    public void setUpGame() {
        deckUtility.fillDeckWithCards();
        deckUtility.shuffleCards(deckUtility.getDeckOfCardsAsAList());
        deckUtility.placeCardsIntoAStack(deckUtility.getDeckOfCardsAsAList());
        initialDealOfCards();
        List<Card> copyOfDealerHand = playerUtility.checkForAcesAndChangeCardRankIfNecessary(dealer.getDealerHand());
        dealer.setDealerHand(copyOfDealerHand);
        List<Card> copyOfUserHand = playerUtility.checkForAcesAndChangeCardRankIfNecessary(user.getUserHand());
        user.setUserHand(copyOfUserHand);
    }

    public void initialDealOfCards() {
        while (cardsDealt < STARTING_NUMBER_OF_CARDS) {
            playerUtility.drawCardFromDeck(dealer.getDealerHand());
            playerUtility.drawCardFromDeck(user.getUserHand());
            cardsDealt++;
        }
    }

    public void finalInformationOfUser(final User theUser) {
        playerUtility.displayCardsInHand(theUser.getUserHand());
        System.out.println("The final value of your hand is: " + playerUtility.currentValueOfHand(user.getUserHand()));
    }

    public void finalInformationOfDealer(final Dealer theDealer) {
        theDealer.checkForDealerMinimumHandValue();
        theDealer.displayCurrentDealerHandAsCards();
        System.out.println("The dealer's hand is worth: " + theDealer.displayCurrentDealerHandAsValues());
    }

    public void userInstantWin() {
        int valueOfUserHand = playerUtility.currentValueOfHand(user.getUserHand());
        if (valueOfUserHand == MAX_VALUE_ALLOWED_IN_HAND) {
            System.out.println("How lucky are you?! You started with 21. You win!");
        }
    }

    public boolean checkIfPlayerWantsToStartANewRound(final Scanner scanner) {
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
            setBlackJackInstance(null);
        }
        return doesPlayerWantToPlayAgain;
    }

    public void decideTheWinner() {
        int valueOfUserHand = playerUtility.currentValueOfHand(user.getUserHand());
        int valueOfDealerHand = playerUtility.currentValueOfHand(dealer.getDealerHand());
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

    public void setDeckUtility(final DeckUtility deckUtility) {
        this.deckUtility = deckUtility;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(final Dealer dealer) {
        this.dealer = dealer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public PlayerUtility getPlayerUtility() {
        return playerUtility;
    }

    public void setPlayerUtility(final PlayerUtility playerUtility) {
        this.playerUtility = playerUtility;
    }

    public static BlackJack getBlackJackInstance() {
        return blackJackInstance;
    }

    public static void setBlackJackInstance(final BlackJack blackJackInstance) {
        BlackJack.blackJackInstance = blackJackInstance;
    }

    public int getCardsDealt() {
        return cardsDealt;
    }

    public void setCardsDealt(final int cardsDealt) {
        this.cardsDealt = cardsDealt;
    }
}
