/**
 * This program defines an object Hand
 * CPSC 224-02, Spring 2018
 * Programming Assignment5
 *
 * @author Andrew Zenoni
 * @version 1.0 3/23/18
 */
import java.util.ArrayList;

/**
 * Class that defines a Hand object
 */
public class Hand {
    private ArrayList<Dice> diceHand;

    /**
     * Explicit value constructor
     * @param numDice The number of dice
     * @param numSides The number of sides on the dice
     */
    public Hand(int numDice, int numSides) {
        diceHand = new ArrayList<>();
        initializeDiceHand(numDice, numSides);
    }

    /**
     * Initializes the hand of dice
     * @param numDice The number of dice being used
     * @param numSides The number of sides on the dice
     */
    private void initializeDiceHand(int numDice, int numSides) {
        for(int i = 0; i < numDice; i++) {
            diceHand.add(new Dice(numSides));
        }
    }

    /**
     * Roll the dice in the Hand
     */
    public void rollDice() {
        for(Dice dice : diceHand) {
            if(dice.isActive()) {
                dice.rollDice();
            }
        }
        displayRoll();
    }

    /**
     * Displays the users current role
     */
    private void displayRoll() {
        System.out.print("Your roll was: ");
        for(Dice tmp: diceHand) {
            System.out.print(tmp.getCurValue() + " ");
        }
        System.out.println();
    }

    /**
     * Analyzes the dice the user wants to keep
     * @param input The desired dice to keep
     */
    public void analyzeDice(String input) {
        char[] inputCharArray = input.toCharArray();
        for(int i = 0; i < diceHand.size(); i++) {
                if(inputCharArray[i] == 'y') {
                this.diceHand.get(i).setActive(false);
            } else {
                this.diceHand.get(i).setActive(true);
            }
        }
    }

    /**
     * Getter for the hand
     * @return returns the dice in the hand
     */
    public ArrayList<Dice> getDiceHand() {
        return diceHand;
    }
}
