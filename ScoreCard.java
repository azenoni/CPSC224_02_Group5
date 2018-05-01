/**
 * This program defines an object ScoreCard
 * CPSC 224-02, Spring 2018
 * Programming Assignment5
 *
 * @author Andrew Zenoni
 * @version 1.0 3/23/18
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for the ScoreCard object
 */
public class ScoreCard {
    private UpperScorecard upperScorecard;
    private LowerScorecard lowerScorecard;
    private int scoreCardTotal;
    private ArrayList<Dice> diceHand;

    /**
     * Explicit value constructor
     * @param numDice The number of dice
     * @param numSideDice Sides on each dice
     */
    public ScoreCard(int numDice, int numSideDice) {
        this.upperScorecard = new UpperScorecard(numSideDice);
        this.lowerScorecard = new LowerScorecard();
        this.scoreCardTotal = 0;
        diceHand = null;
    }

    /**
     * Display the used values on the card
     */
    public void displayUsedValues() {
        upperScorecard.displayUsedFields();
        lowerScorecard.displayUsedFields();
    }

    /**
     * Whether or not the scorecard has unused fields
     * @return If there are fields remaining
     */
    public boolean hasFieldsRemaining() {
        if(upperScorecard.hasFieldsRemaining() || lowerScorecard.hasFieldsRemaining()) {
            return true;
        }
        return false;
    }

    /**
     * Sets the dice hand
     * @param diceHand new dice hand
     */
    public void setDiceHand(ArrayList<Dice> diceHand) {
        this.diceHand = diceHand;
    }

    /**
     * Displays the score card
     */
    public void displayScoreCard() {
        calculatePossibleValues();
        upperScorecard.displayPossibleValues();
        lowerScorecard.displayPossibleValues();
    }

    /**
     * Calculate the possible values for the score card
     */
    public void calculatePossibleValues() {
        performSumDiceCalculations();
        performLikeDiceCalculations();
//        if(!hasFieldsRemaining()) {
            upperScorecard.calculateScoreTotal();
            lowerScorecard.calculateTotalValue();
//        }
        lowerScorecard.getMarioParty().setCurValue(getCurrDiceValue());
    }

    public void performLikeDiceCalculations() {
        int numMarios = 0;
        int numBowsers = 0;
        int numGoodGuys = 0;
        int numAnimals = 0;
        int numPrincesses = 0;
        int numBadBuys = 0;
        for(Dice dice : diceHand) {
            if(dice.getCurValue() < 4) {
                if(dice.getCurValue() == 1) {
                    numMarios += 1;
                }
                numGoodGuys += 1;
            } else if(dice.getCurValue() < 7) {
                numPrincesses += 1;
            } else if(dice.getCurValue() < 10) {
                numAnimals += 1;
            } else {
                if(dice.getCurValue() == 12) {
                    numBowsers += 1;
                }
                numBadBuys += 1;
            }
        }
        if(numGoodGuys >= 6) {
            if(!lowerScorecard.getGoodGuysRule().isUsed())
                lowerScorecard.getGoodGuysRule().setCurValue(35);
        } else {
            if(!lowerScorecard.getGoodGuysRule().isUsed())
                lowerScorecard.getGoodGuysRule().setCurValue(0);
        }
        if(numBadBuys >= 6) {
            if(!lowerScorecard.getBadGuysSuck().isUsed())
                lowerScorecard.getBadGuysSuck().setCurValue(-20);
        } else {
            if(!lowerScorecard.getBadGuysSuck().isUsed())
                lowerScorecard.getBadGuysSuck().setCurValue(0);
        }
        if(numMarios >= 8) {
            if(!lowerScorecard.getSuperMario().isUsed())
                lowerScorecard.getSuperMario().setCurValue(100);
        } else {
            if(!lowerScorecard.getSuperMario().isUsed())
                lowerScorecard.getSuperMario().setCurValue(0);
        }
        if(numBowsers >= 8) {
            // choose player to deduct points from
        }
        if(numAnimals > 10) {
            if(!lowerScorecard.getAnimalKingdom().isUsed()) {
                lowerScorecard.getAnimalKingdom().setCurValue(50);
            }
        } else {
            if(!lowerScorecard.getAnimalKingdom().isUsed()) {
                lowerScorecard.getAnimalKingdom().setCurValue(0);
            }
        }
    }

    /**
     * Analyze which rows to keep
     * @param str The desired row to keep
     * @return Whether or not the row was accepted
     */
    public boolean analyzeRowKeep(String str) {
        switch(str) {
            case "Good Guys":
                upperScorecard.getGoodGuys().setUsed(true);
                return false;
            case "Princesses":
                upperScorecard.getPrincesses().setUsed(true);
                return false;
            case "Animals":
                upperScorecard.getAnimals().setUsed(true);
                return false;
            case "Bad Guys":
                upperScorecard.getBadGuys().setUsed(true);
                return false;
            case "Five of a kind":
                lowerScorecard.getFiveOfAKind().setUsed(true);
                return false;
            case "Seven of a kind":
                lowerScorecard.getSevenOfAKind().setUsed(true);
                return false;
            case "Good Guys Rule":
                lowerScorecard.getGoodGuysRule().setUsed(true);
                return false;
            case "Bad Guys Suck":
                lowerScorecard.getBadGuysSuck().setUsed(true);
                return false;
            case "Super Mario":
                lowerScorecard.getSuperMario().setUsed(true);
                return false;
            case "Evil Bowser":
                lowerScorecard.getEvilBowser().setUsed(true);
                return false;
            case "Animal Kingdom":
                lowerScorecard.getAnimalKingdom().setUsed(true);
                return false;
            case "Mario Party":
                lowerScorecard.getMarioParty().setUsed(true);
                return false;
            default:
                System.out.println("Please input a proper token");
                return true;
        }

    }

    /**
     * Gets the sum of the current dice
     * @return the sum of the dice
     */
    private int getCurrDiceValue() {
        int sumDice = 0;
        for(Dice dice : diceHand) {
            sumDice+= dice.getCurValue();
        }
        return sumDice;
    }

    private void performSumDiceCalculations() {
        int goodGuysTotal = 0;
        int princessesTotal = 0;
        int animalsTotal = 0;
        int badGuysTotal = 0;
        for(Dice dice : diceHand) {
            if(dice.getCurValue() < 4) {
                goodGuysTotal += 20;
            } else if(dice.getCurValue() < 7) {
                princessesTotal += 15;
            } else if(dice.getCurValue() < 10) {
                animalsTotal += 10;
            } else {
                badGuysTotal += 5;
            }
        }
        if(!upperScorecard.getGoodGuys().isUsed()) {
            upperScorecard.getGoodGuys().setCurValue(goodGuysTotal);
        }
        if(!upperScorecard.getPrincesses().isUsed()) {
            upperScorecard.getPrincesses().setCurValue(princessesTotal);
        }
        if(!upperScorecard.getAnimals().isUsed()) {
            upperScorecard.getAnimals().setCurValue(animalsTotal);
        }
        if(!upperScorecard.getBadGuys().isUsed()) {
            upperScorecard.getBadGuys().setCurValue(badGuysTotal);
        }

        if(goodGuysTotal > princessesTotal && goodGuysTotal > animalsTotal && goodGuysTotal > badGuysTotal) {
            if(goodGuysTotal / 20 >= 7) {
                if(!lowerScorecard.getSevenOfAKind().isUsed()) {
                    lowerScorecard.getSevenOfAKind().setCurValue(goodGuysTotal * 7);
                }
                if(!lowerScorecard.getFiveOfAKind().isUsed()) {
                    lowerScorecard.getFiveOfAKind().setCurValue(goodGuysTotal * 5);
                }
            } else if(goodGuysTotal / 20 >= 5){
                if(!lowerScorecard.getSevenOfAKind().isUsed()) {
                    lowerScorecard.getSevenOfAKind().setCurValue(0);
                }
                if(!lowerScorecard.getFiveOfAKind().isUsed()) {
                    lowerScorecard.getFiveOfAKind().setCurValue(goodGuysTotal * 5);
                }
            } else {
                if(!lowerScorecard.getSevenOfAKind().isUsed()) {
                    lowerScorecard.getSevenOfAKind().setCurValue(0);
                }
                if(!lowerScorecard.getFiveOfAKind().isUsed()) {
                    lowerScorecard.getFiveOfAKind().setCurValue(0);
                }
            }
        } else if(princessesTotal > goodGuysTotal && princessesTotal > animalsTotal && princessesTotal > badGuysTotal) {
            if(princessesTotal / 15 >= 7) {
                if(!lowerScorecard.getSevenOfAKind().isUsed()) {
                    lowerScorecard.getSevenOfAKind().setCurValue(princessesTotal * 7);
                }
                if(!lowerScorecard.getFiveOfAKind().isUsed()) {
                    lowerScorecard.getFiveOfAKind().setCurValue(princessesTotal * 5);
                }
            } else if(princessesTotal / 15 >= 5){
                if(!lowerScorecard.getSevenOfAKind().isUsed()) {
                    lowerScorecard.getSevenOfAKind().setCurValue(0);
                }
                if(!lowerScorecard.getFiveOfAKind().isUsed()) {
                    lowerScorecard.getFiveOfAKind().setCurValue(princessesTotal * 5);
                }
            } else {
                if(!lowerScorecard.getSevenOfAKind().isUsed()) {
                    lowerScorecard.getSevenOfAKind().setCurValue(0);
                }
                if(!lowerScorecard.getFiveOfAKind().isUsed()) {
                    lowerScorecard.getFiveOfAKind().setCurValue(0);
                }
            }
        } else if(animalsTotal > goodGuysTotal && animalsTotal > princessesTotal && animalsTotal > badGuysTotal) {
            if(animalsTotal / 10 >= 7) {
                if(!lowerScorecard.getSevenOfAKind().isUsed()) {
                    lowerScorecard.getSevenOfAKind().setCurValue(animalsTotal * 7);
                }
                if(!lowerScorecard.getFiveOfAKind().isUsed()) {
                    lowerScorecard.getFiveOfAKind().setCurValue(animalsTotal * 5);
                }
            } else if(animalsTotal / 10 >= 5){
                if(!lowerScorecard.getSevenOfAKind().isUsed()) {
                    lowerScorecard.getSevenOfAKind().setCurValue(0);
                }
                if(!lowerScorecard.getFiveOfAKind().isUsed()) {
                    lowerScorecard.getFiveOfAKind().setCurValue(animalsTotal * 5);
                }
            } else {
                if(!lowerScorecard.getSevenOfAKind().isUsed()) {
                    lowerScorecard.getSevenOfAKind().setCurValue(0);
                }
                if(!lowerScorecard.getFiveOfAKind().isUsed()) {
                    lowerScorecard.getFiveOfAKind().setCurValue(0);
                }
            }
        } else {
            if(badGuysTotal / 5 >= 7) {
                if(!lowerScorecard.getSevenOfAKind().isUsed()) {
                    lowerScorecard.getSevenOfAKind().setCurValue(badGuysTotal * 7);
                }
                if(!lowerScorecard.getFiveOfAKind().isUsed()) {
                    lowerScorecard.getFiveOfAKind().setCurValue(badGuysTotal * 5);
                }
            } else if(badGuysTotal / 5 >= 5){
                lowerScorecard.getSevenOfAKind().setCurValue(0);
                lowerScorecard.getFiveOfAKind().setCurValue(badGuysTotal * 5);
            } else {
                lowerScorecard.getFiveOfAKind().setCurValue(0);
                lowerScorecard.getSevenOfAKind().setCurValue(0);
            }
        }

    }

    public UpperScorecard getUpperScorecard() {
        return upperScorecard;
    }

    public void setUpperScorecard(UpperScorecard upperScorecard) {
        this.upperScorecard = upperScorecard;
    }

    public LowerScorecard getLowerScorecard() {
        return lowerScorecard;
    }

    public void setLowerScorecard(LowerScorecard lowerScorecard) {
        this.lowerScorecard = lowerScorecard;
    }

    public void determineFinalScore() {
//        upperScorecard.calculateScoreTotal();
//        lowerScorecard.calculateTotalValue();
        scoreCardTotal = upperScorecard.getUpperTotal() + lowerScorecard.getLowerTotal();
    }

    public int getScoreCardTotal() {
        scoreCardTotal = upperScorecard.getUpperTotal() + lowerScorecard.getLowerTotal();
        return scoreCardTotal;
    }

    public void setScoreCardTotal(int scoreCardTotal) {
        this.scoreCardTotal = scoreCardTotal;
    }
}