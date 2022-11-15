package com.coffeeandcards;

import java.util.Collections;

public class BlackJack {
    private static BlackJack blackJackInstance = null;
    private DeckUtility deckUtility;
    private Dealer dealer;
    private User user;
    private boolean gameStatus;

    public static final int MAX_VALUE_ALLOWED_IN_HAND = 21;

    private BlackJack(DeckUtility deckUtility, Dealer dealer, User user, boolean gameStatus) {
        setDeckUtility(deckUtility);
        setDealer(dealer);
        setUser(user);
        setGameStatus(gameStatus);
    }

    public static BlackJack createBlackJackGame() {
        if (blackJackInstance == null) {
            blackJackInstance = new BlackJack(new DeckUtility(), new Dealer(), new User(), true);
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

    public void endGame() {
        System.out.println(BlackJackClientUtility.exitMessage());
        System.exit(0);
    }

    public void userInstantWin() {
        if (user.currentValueOfUserHand() == MAX_VALUE_ALLOWED_IN_HAND) {
            System.out.println("How lucky are you?! You started with 21. You win!");
        }
    }

    public void decideTheWinner() {
        if ((user.currentValueOfUserHand() == MAX_VALUE_ALLOWED_IN_HAND) &&
                (dealer.getIntValueOfDealerHand() != MAX_VALUE_ALLOWED_IN_HAND)) {
            System.out.println("You hit 21! You win!");
        } else if ((user.currentValueOfUserHand() > MAX_VALUE_ALLOWED_IN_HAND) &&
                (dealer.getIntValueOfDealerHand() > MAX_VALUE_ALLOWED_IN_HAND)) {
            System.out.println("You both busted - TOO BAD, SO SAD!");
        } else if ((user.currentValueOfUserHand() < MAX_VALUE_ALLOWED_IN_HAND) &&
                (user.currentValueOfUserHand() > dealer.getIntValueOfDealerHand())) {
            System.out.println("Congratulations, you win!");
        } else if ((dealer.getIntValueOfDealerHand() > user.currentValueOfUserHand()) &&
                (dealer.getIntValueOfDealerHand() <= MAX_VALUE_ALLOWED_IN_HAND)) {
            System.out.println("Better luck next time. Dealer wins.");
        } else if ((user.currentValueOfUserHand() <= MAX_VALUE_ALLOWED_IN_HAND) &&
                (dealer.getIntValueOfDealerHand() > MAX_VALUE_ALLOWED_IN_HAND)) {
            System.out.println("Dealer bust. You win!");
        } else if (user.currentValueOfUserHand() > MAX_VALUE_ALLOWED_IN_HAND) {
            System.out.println("Why didn't you stay? You lose!");
        } else if ((user.currentValueOfUserHand() == MAX_VALUE_ALLOWED_IN_HAND) &&
                (dealer.getIntValueOfDealerHand() == MAX_VALUE_ALLOWED_IN_HAND)) {
            System.out.println("What are the odds!? It's a draw!");
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

    public boolean isGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static BlackJack getBlackJackInstance() {
        return blackJackInstance;
    }

    public static void setBlackJackInstance(BlackJack blackJackInstance) {
        BlackJack.blackJackInstance = blackJackInstance;
    }
}
