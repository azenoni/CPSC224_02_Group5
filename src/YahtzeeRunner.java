/**
 * This program is the runner for yahtzee
 * CPSC 224-02, Spring 2018
 * Programming Assignment5
 *
 * @author Andrew Zenoni
 * @version 1.0 3/23/18
 */

import java.io.*;
import java.util.Scanner;

/**
 * The runner for lizard spock yahtzee
 */
public class YahtzeeRunner {
    /**
     * Main method
     * @param args Optional command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Super Mario Yahtzee");
        System.out.println("The dice are as follows: \n 1 : Mario \n 2 : Luigi \n 3 : Toad \n 4 : Peach \n 5 : Daisy \n 6 : Rosalina \n 7 : Yoshi \n 8 : Donky Kong \n 9 : Diddy Kong \n 10 : Wario \n 11 : Waluigi \n 12 : Bowser");
        System.out.println("Numbers are categorized as follows: \n 1-3 : Good Guys \n 4-6 : Princesses \n 7-9 : Animals \n 10-12 : Bad Guys");
        System.out.println("Have fun!");
        Scanner reader = new Scanner(System.in);
        int numSides = 12;
        int numDie = 10;
        int numRolls = 3;

        boolean playAgain = true;
        Player player = new Player(numDie, numSides);
        while (playAgain && player.hasFieldsRemaining()) {
            String hand = "";
            String checker = "";
            for(int i = 0; i < numDie; i++) {
                hand += "n";
                checker += "y";
            }
            int turn = 1;
            while (turn < (numRolls+1) && !hand.equals(checker)) {
                player.analyzeDice(hand);
                player.rollDice();
                if (turn < (numRolls+1)) {
                    System.out.println("enter dice to keep (y or n) ");
                    hand = reader.nextLine();
                }
                turn++;
            }
            player.displayScoreCard();
            System.out.println("Which line would you like to keep? (Input the name left of 'can')");
            boolean contRunning = true;
            while (contRunning) {
                String input = reader.nextLine();
                contRunning = player.analyzeRowKeep(input);
            }
            System.out.println("\nSubmission received\n");
            if(player.hasFieldsRemaining()) {
                System.out.println("Would you like to play again? (y or n)");
                String input = reader.nextLine();
                while (!input.equals("n") && !input.equals("y")) {
                    System.out.println("Please input appropriate character");
                    input = reader.nextLine();
                }
                if (input.equals("n")) {
                    playAgain = false;
                    System.out.println();
                    System.out.println("Displaying your scorecard fields that you used: ");
                    System.out.println();
                    player.displayUsedFields();
                } else {
                    System.out.println("Playing again");
//                    player.analyzeDice("nnnnn");
                }
            } else {
                System.out.println("Good game. Here is your scorecard");
                player.displayUsedFields();
            }

        }
    }

}