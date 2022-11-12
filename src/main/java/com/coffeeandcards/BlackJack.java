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
    }

    public void decideTheWinner() {
        if ((user.valueOfUserHand() == MAX_VALUE_ALLOWED_IN_HAND) &&
                (dealer.valueOfDealerHand() != MAX_VALUE_ALLOWED_IN_HAND)) {
            System.out.println("How lucky! You started with 21 and the dealer did not, you win!");
        } else if((user.valueOfUserHand() > MAX_VALUE_ALLOWED_IN_HAND) &&
                (dealer.valueOfDealerHand() > MAX_VALUE_ALLOWED_IN_HAND)) {
            System.out.println("You both busted, it's a draw!");
        } else if ((user.valueOfUserHand() <= MAX_VALUE_ALLOWED_IN_HAND) &&
                (user.valueOfUserHand() > dealer.valueOfDealerHand())) {
            System.out.println("Congrulations, you win!");
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
