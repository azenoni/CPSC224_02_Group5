/**
 * This program defines an object Player
 * CPSC 224-02, Spring 2018
 * Programming Assignment5
 *
 * @author Andrew Zenoni
 * @version 1.0 3/23/18
 */

/**
 * Class that defines a Player object
 */
public class Player {
    private ScoreCard scoreCard;
    private Hand playerHand;

    /**
     * Explicit Value Constructor
     * @param numDice The number of dice to be used
     * @param numSides The number of sides on each dice
     */
    public Player(int numDice, int numSides) {
        playerHand = new Hand(numDice, numSides);
        scoreCard = new ScoreCard(numDice, numSides);
        scoreCard.setDiceHand(playerHand.getDiceHand());
    }

    /**
     * Roll the dice for the player
     */
    public void rollDice() {
        playerHand.rollDice();
    }

    /**
     * Analyze the dice the player wants to keep
     * @param str The dice the player wants to keep
     */
    public void analyzeDice(String str) {
        playerHand.analyzeDice(str);
    }

    /**
     * Display the score card
     */
    public void displayScoreCard() {
        scoreCard.setDiceHand(playerHand.getDiceHand());
        scoreCard.displayScoreCard();
    }

    /**
     * Analyze which rows to keep
     * @param str The desired row to keep
     * @return Whether or not the row was accepted
     */
    public boolean analyzeRowKeep(String str) {
        return scoreCard.analyzeRowKeep(str);
    }

    /**
     * If the player has fields they can still input
     * @return If the user can keep playing
     */
    public boolean hasFieldsRemaining() {
        return scoreCard.hasFieldsRemaining();
    }

    /**
     * Display all fields the user has used
     */
    public void displayUsedFields() {
        scoreCard.displayUsedValues();
    }

    public ScoreCard getScoreCard() {
        return scoreCard;
    }

    public void setScoreCard(ScoreCard scoreCard) {
        this.scoreCard = scoreCard;
    }
}