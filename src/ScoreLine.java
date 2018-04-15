/**
 * This program defines an object ScoreLine
 * CPSC 224-02, Spring 2018
 * Programming Assignment5
 *
 * @author Andrew Zenoni
 * @version 1.0 3/23/18
 */

/**
 * Class the defines a score line object
 */
public class ScoreLine {
    private String name;
    private boolean isUsed;
    private int curValue;
    private int possibleValue;

    /**
     * One of the explicit value constructors
     * @param name Name of the line
     * @param possibleValue Possible value of the line
     */
    public ScoreLine(String name, int possibleValue) {
        this.name = name;
        this.isUsed = false;
        this.curValue = 0;
        this.possibleValue = possibleValue;
    }

    /**
     * One of the explicit value constructors
     * @param name The name of the line
     */
    public ScoreLine(String name) {
        this.name = name;
        this.isUsed = false;
        this.curValue = 0;
        this.possibleValue = -1;
    }

    /**
     * Overrides the toString method of the object
     * @return The output to the screen
     */
    @Override
    public String toString() {
        String output = name + " can be scored at: " + curValue;
        return output;
    }

    /**
     * Gets whether the line has been used or not
     * @return if the line is used
     */
    public boolean isUsed() {
        return isUsed;
    }

    /**
     * Set if the line has been used
     * @param used the state of the line
     */
    public void setUsed(boolean used) {
        isUsed = used;
    }

    /**
     * Sets the current value of the line
     * @param curValue
     */
    public void setCurValue(int curValue) {
        this.curValue = curValue;
    }

    public int getCurValue() {
        return curValue;
    }
}
