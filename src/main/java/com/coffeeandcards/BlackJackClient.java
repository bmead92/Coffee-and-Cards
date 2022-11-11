package com.coffeeandcards;

import java.util.Scanner;

public class BlackJackClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(BlackJackUtility.welcomeMessage());
//        String inputSelection = scanner.next();
//        if (inputSelection.equalsIgnoreCase("Stay")) {
//            //TODO: if the user selects 'Stay', their turn ends and the game proceeds
//        }
        scanner.close();
        System.out.println(BlackJackUtility.exitMessage());
    }
}
