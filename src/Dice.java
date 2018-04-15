/**
 * This program defines an object Dice
 * CPSC 224-02, Spring 2018
 * Programming Assignment5
 *
 * @author Andrew Zenoni
 * @version 1.0 3/23/18
 */
import java.util.Random;

/**
 * Dice object that is comparable to another dice
 */
public class Dice implements Comparable<Dice>{
    private int curValue;
    private Random randomGenerator;
    private boolean active;
    private int numSides;

    /**
     * Explicit value constructor
     *
     * @param numSides The number of sides on the dice
     */
    public Dice(int numSides) {
        randomGenerator = new Random();
        this.active = true;
        this.numSides = numSides;
    }

    /**
     * Rolls the dice assigning it a random value
     */
    public void rollDice() {
        this.curValue = Math.abs(randomGenerator.nextInt() % numSides) + 1;
    }

    /**
     * Compares a dice to itself
     * @param o The dice being compared to
     * @return Whether the other dice is larger or not
     */
    @Override
    public int compareTo(Dice o) {
        if(this.curValue > o.getCurValue())
            return 1;
        else if(this.curValue < o.getCurValue())
            return -1;
        return 0;
    }

    /**
     * Determines what to print when the dice is printed
     * @return The desired output
     */
    @Override
    public String toString() {
        String tmp = "Current Value of Dice is: " + curValue;
        return tmp;
    }

    /**
     * Gets the current value of the dice
     * @return The current value of the dice
     */
    public int getCurValue() {
        return curValue;
    }

    /**
     * Sets the value of the dice
     * @param curValue new value for dice
     */
    public void setCurValue(int curValue) {
        this.curValue = curValue;
    }

    /**
     * Determines if the dice is active
     * @return whether or not the dice is active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets whether the dice is active
     * @param active new state of the dice
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    public int getNumSides() {
        return numSides;
    }

}
