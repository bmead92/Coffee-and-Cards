# COFFEE & CARDS

#### Created By: Bryce Meadors, Kiaya Anderson, Lok Tamang

![image](https://cdn.pixabay.com/photo/2020/11/16/23/12/poker-5750834__340.jpg)

#### Project Presentation: 

## Project Description
**“Coffee & Cards”** is a Java Blackjack experience. The game is
a console-based application where a user will attempt to
beat the dealer by getting their card values to 21, or as close
as possible without going over. At the beginning of the
game, the user will be dealt two cards and will have the
opportunity to ‘Hit’ or receive another card to increase the
overall total of their hand or ‘Stay’. Once the user decides to stay,
the dealer will reveal the value of their cards and the player with the
card values closest to 21 wins!

### Card Values
**Ace Card** - It can hold a value of 1 or 11 points; value is based on the other cards
in hand.<br>
**Number Cards (2 - 10)** - These cards hold face value; i.e. a 2 card is counted
as 2 points. <br>
**Face Cards (King, Queen, Jack)** - Each of these cards is valued at 10 points.

*The suit of the card has no effect on the value.*

### Objectives
**How do you beat the dealer?**
- By drawing a hand value that is higher than the dealer’s hand value.
- By the dealer drawing a hand value that goes over 21.
- By drawing a hand value of 21 on your first two cards,
when the dealer does not.

**How do you lose to the dealer?**
- Your hand value exceeds 21.
- The dealers hand has a greater value than yours at the end of the round

## How to play?

### Console Instructions
- At the start of the game, both the player and the dealer will be dealt 2 cards;
the player will have 2 face-up cards and the dealer will have 1 face-up and 1 face-down. 
- The console will prompt the user to enter 'Hit' to get another card, 
or enter 'Stay' to keep their current cards.
- When the user enters 'Stay' or busts (goes over 21), the dealer reveals their cards.
- If the player has a higher value than the dealer without going over 21, they win. 

### Possible Edge Cases
- Both the user and the dealer start with 21. This is a draw - no one wins or loses.
- Both the user and the dealer have the same hand value at the end of the game. This is a draw - no one wins or loses.
- The user starts with 21 and the dealer does not. The user wins.

## Project UML Diagram
Initial Conception of Game -
![image](https://res.cloudinary.com/kacloud20/image/upload/v1668621505/TLGFinalProject/Screen_Shot_2022-11-16_at_12.55.25_PM_cxwnut.png)

Final Model of Game -
![image](https://res.cloudinary.com/kacloud20/image/upload/v1668711685/TLGFinalProject/Screen_Shot_2022-11-17_at_2.00.14_PM_rvlqug.png)