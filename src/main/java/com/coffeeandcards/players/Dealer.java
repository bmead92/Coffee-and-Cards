package com.coffeeandcards.players;

import com.coffeeandcards.blackjack.BlackJack;
import com.coffeeandcards.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    public static final int MINIMUM_DEALER_HAND_VALUE = 17;
    private List<Card> dealerHand = new ArrayList<>();

    public void displayCurrentDealerHandAsCards() {
        PlayerUtility playerUtility = BlackJack.getBlackJackInstance().getPlayerUtility();
        BlackJack blackJackInstance = BlackJack.getBlackJackInstance();
        final User theUser = blackJackInstance.getUser();
        List<Card> listToDisplay = new ArrayList<>();
        boolean userTurnCompleted = theUser.isTurnCompleted();
        if (!userTurnCompleted) {
            System.out.println("Dealer's face-up card");
            listToDisplay.add(dealerHand.get(0));
            playerUtility.displayCardsInHand(listToDisplay);
        } else {
            System.out.println("Dealer's final hand");
            playerUtility.displayCardsInHand(dealerHand);
        }
    }

    /**
     * Because the dealer is dealt a face-down and a face-up card,displayCards will show one card
     * to the user at the start. When the user ends their turn, the dealer will reveal the rest of their cards.
     *
     * @return int currentVisibleValueOfDealerHand
     */
    public int displayCurrentDealerHandAsValues() {
        BlackJack blackJackInstance = BlackJack.getBlackJackInstance();
        PlayerUtility playerUtility = BlackJack.getBlackJackInstance().getPlayerUtility();
        final User theUser = blackJackInstance.getUser();
        int currentVisibleValueOfDealerHand = 0;
        boolean isUserTurnCompleted = theUser.isTurnCompleted();
        if (isUserTurnCompleted) {
            currentVisibleValueOfDealerHand = playerUtility.currentValueOfHand(dealerHand);
        } else {
            currentVisibleValueOfDealerHand = dealerHand.get(0).
                    getCardRank().
                    getCardValue();
        }
        return currentVisibleValueOfDealerHand;
    }

    public void checkForDealerMinimumHandValue() {
        PlayerUtility playerUtility = BlackJack.getBlackJackInstance().getPlayerUtility();
        int currentValueOfDealerHand = playerUtility.currentValueOfHand(dealerHand);
        while (currentValueOfDealerHand < MINIMUM_DEALER_HAND_VALUE) {
            playerUtility.drawCardFromDeck(dealerHand);
            currentValueOfDealerHand = playerUtility.currentValueOfHand(dealerHand);
        }
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(List<Card> dealerHand) {
        this.dealerHand = dealerHand;
    }
}

