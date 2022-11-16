package com.coffeeandcards.players;

import com.coffeeandcards.blackjack.BlackJack;
import com.coffeeandcards.deck.Card;
import com.coffeeandcards.deck.CardRank;
import com.coffeeandcards.deck.DeckUtility;
import com.coffeeandcards.players.User;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    public static final int MINIMUM_DEALER_HAND_VALUE = 17;
    public static final int STARTING_NUMBER_OF_CARDS = 2;
    private int intValueOfDealerHand = 0;
    private List<Card> dealerHand = new ArrayList<>();

    /**
     * The dealer has to have a hand value of at least 17, getCard() is run until that minimum is met.
     * getCard() is also run if the dealer wishes to 'Hit' and get a new card.
     */
    public void dealerDrawFromDeck() {
        DeckUtility theDeckUtility = BlackJack.getBlackJackInstance().getDeckUtility();
        int intValueOfDealerHand = getIntValueOfDealerHand();

        Card drawnCard = theDeckUtility.drawCardFromDeck();
        intValueOfDealerHand += drawnCard.
                getCardRank().
                getValue();
        dealerHand.add(drawnCard);
        setDealerHand(dealerHand);
        setIntValueOfDealerHand(intValueOfDealerHand);
        checkForAcesAndUpdateValueIfNecessary();
    }
    public void checkForAcesAndUpdateValueIfNecessary() {
        for (Card card : dealerHand) {
            if (currentValueOfDealerHand() > BlackJack.MAX_VALUE_ALLOWED_IN_HAND &&
                    card.getCardRank().equals(CardRank.ACE)) {
                card.getCardRank().setValue(1);
            }
        }
    }
    public void displayDealerHand() {
        final User theUser = BlackJack.getBlackJackInstance().getUser();
        List<Card> listToDisplay = new ArrayList<>();
        boolean userTurnCompleted = theUser.isTurnCompleted();
        if (!userTurnCompleted) {
            System.out.println("Dealer's face-up card");
            listToDisplay.add(dealerHand.get(0));
            displayDealerCards(listToDisplay);
        } else {
            System.out.println("Dealer's final hand");
            displayDealerCards(dealerHand);
        }
    }

    private void displayDealerCards(List<Card> listOfCards) {
        StringBuilder display = new StringBuilder();
        for (Card card : listOfCards) {
            CardRank cardRank = card.getCardRank();
            String cardIcon = card.getCardSuit()
                    .getIcon();
            boolean cardIsAFaceCard = cardRank.equals(CardRank.ACE) ||
                    cardRank.equals(CardRank.KING) ||
                    cardRank.equals(CardRank.QUEEN) ||
                    cardRank.equals(CardRank.JACK);
            if (cardIsAFaceCard) {
                char firstCharInCardRank = cardRank.name().charAt(0);
                display.append(firstCharInCardRank).append("  ")
                        .append(firstCharInCardRank).append("\n");
                display.append(" ").append(cardIcon).append("\n");
                display.append(firstCharInCardRank).append("  ")
                        .append(firstCharInCardRank).append("\n");
            } else {
                int cardValue = cardRank
                        .getValue();
                display.append(cardValue).append("  ").append(cardValue).append("\n");
                display.append(" ").append(cardIcon).append("\n");
                display.append(cardValue).append("  ").append(cardValue).append("\n");
            }
        }
        System.out.println(display);
    }

    /**
     * Because the dealer is dealt a face-down and a face-up card,displayCards will show one card
     * to the user at the start. When the user ends their turn, the dealer will reveal the rest of their cards.
     *
     * @return int currentVisibleValueOfDealerHand
     */
    public int showDealerCardValues() {
        final User theUser = BlackJack.getBlackJackInstance().getUser();
        int currentVisibleValueOfDealerHand = 0;
        boolean isUserTurnCompleted = theUser.isTurnCompleted();

        if (isUserTurnCompleted) {
            currentVisibleValueOfDealerHand = currentValueOfDealerHand();
        } else {
            currentVisibleValueOfDealerHand = dealerHand.get(0).
                    getCardRank().
                    getValue();
        }
        return currentVisibleValueOfDealerHand;
    }

    public int currentValueOfDealerHand() {
        int totalValueOfDealerHand = 0;
        for (Card card : dealerHand) {
            totalValueOfDealerHand += card.
                    getCardRank().
                    getValue();
        }
        setIntValueOfDealerHand(totalValueOfDealerHand);
        return totalValueOfDealerHand;
    }

    public void dealCardsToDealer() {
        while (dealerHand.size() < STARTING_NUMBER_OF_CARDS) {
            dealerDrawFromDeck();
        }
    }

    public void dealCardsToUser(){
        final User theUser = BlackJack.getBlackJackInstance().getUser();
        while (theUser.getUserHand().size() < STARTING_NUMBER_OF_CARDS) {
            theUser.userDrawCardFromDeck();
        }
    }

    public void checkForDealerMinimumHandValue() {
        while (intValueOfDealerHand < MINIMUM_DEALER_HAND_VALUE) {
            dealerDrawFromDeck();
        }
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(List<Card> dealerHand) {
        this.dealerHand = dealerHand;
    }

    public int getIntValueOfDealerHand() {
        return intValueOfDealerHand;
    }

    public void setIntValueOfDealerHand(int intValueOfDealerHand) {
        this.intValueOfDealerHand = intValueOfDealerHand;
    }
}
