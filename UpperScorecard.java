/**
 * This program defines an object UpperScorecard
 * CPSC 224-02, Spring 2018
 * Programming Assignment5
 *
 * @author Andrew Zenoni
 * @version 1.0 3/23/18
 */

import java.util.ArrayList;

/**
 * Class that defines the upper scorecard
 */
public class UpperScorecard {
    private ScoreLine goodGuys;
    private ScoreLine princesses;
    private ScoreLine animals;
    private ScoreLine badGuys;
    private int upperSum;
    private boolean hasBonus;
    private int upperTotal;

    /**
     * Explicit value constructor
     * @param numSides Number of sides on a dice
     */
    public UpperScorecard(int numSides) {
        this.goodGuys = new ScoreLine("Good Guys");
        this.princesses = new ScoreLine("Princesses");
        this.animals = new ScoreLine("Animals");
        this.badGuys = new ScoreLine("Bad Guys");

        this.upperSum = 0;
        this.hasBonus = false;
        this.upperTotal = 0;
    }


    /**
     * Display the possible values for the upper score card
     */
    public void displayPossibleValues() {
        if(!goodGuys.isUsed()) {
            System.out.println(goodGuys);
        }
        if(!princesses.isUsed()) {
            System.out.println(princesses);
        }
        if(!animals.isUsed()) {
            System.out.println(animals);
        }
        if(!badGuys.isUsed()) {
            System.out.println(badGuys);
        }
    }

    public void resetUnusedValues() {
        if(!goodGuys.isUsed()) {
            goodGuys.setCurValue(0);
        }
        if(!princesses.isUsed()) {
            princesses.setCurValue(0);
        }
        if(!animals.isUsed()) {
            animals.setCurValue(0);
        }
        if(!badGuys.isUsed()) {
            badGuys.setCurValue(0);
        }
    }

    /**
     * If the upper portion has fields remaining
     * @return If there are fields remaining
     */
    public boolean hasFieldsRemaining() {
        if(!animals.isUsed() || !goodGuys.isUsed() || !princesses.isUsed() || !badGuys.isUsed()) {
            return true;
        }
        return false;
    }

    /**
     * Display the used fields of the score card
     */
    public void displayUsedFields() {
        if(goodGuys.isUsed()) {
            System.out.println(goodGuys);
        }
        if(princesses.isUsed()) {
            System.out.println(princesses);
        }
        if(animals.isUsed()) {
            System.out.println(animals);
        }
        if(badGuys.isUsed()) {
            System.out.println(badGuys);
        }
    }

    public void calculateScoreTotal() {
        upperSum = goodGuys.getCurValue() + princesses.getCurValue() + animals.getCurValue() + badGuys.getCurValue();
        if(upperSum >= 200) {
            hasBonus = true;
            upperSum += 45;
        }
        upperTotal = upperSum;

    }

    public ScoreLine getGoodGuys() {
        return goodGuys;
    }

    public void setGoodGuys(ScoreLine goodGuys) {
        this.goodGuys = goodGuys;
    }

    public ScoreLine getPrincesses() {
        return princesses;
    }

    public void setPrincesses(ScoreLine princesses) {
        this.princesses = princesses;
    }

    public ScoreLine getAnimals() {
        return animals;
    }

    public void setAnimals(ScoreLine animals) {
        this.animals = animals;
    }

    public ScoreLine getBadGuys() {
        return badGuys;
    }

    public void setBadGuys(ScoreLine badGuys) {
        this.badGuys = badGuys;
    }

    public int getUpperTotal() {
        return upperTotal;
    }

    public int getUpperSum() {
        return upperSum;
    }

    public void setUpperSum(int upperSum) {
        this.upperSum = upperSum;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public void setHasBonus(boolean hasBonus) {
        this.hasBonus = hasBonus;
    }
}