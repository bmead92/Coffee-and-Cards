package com.coffeeandcards;

public class BlackJack {
    private static BlackJack blackJackInstance = null;
    private DeckUtility deckUtility;
    private Dealer dealer;
    private User user;
    private boolean gameStatus;

    private BlackJack(DeckUtility deckUtility, Dealer dealer, User user, boolean gameStatus) {
        setDeckUtility(deckUtility);
        setDealer(dealer);
        setUser(user);
        setGameStatus(gameStatus);
    }

    public static BlackJack createBlackJackGame() {
        if (blackJackInstance == null) {
            blackJackInstance = new BlackJack(new DeckUtility(), new Dealer(blackJackInstance), new User(blackJackInstance), true);
        }
        return blackJackInstance;
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
}
