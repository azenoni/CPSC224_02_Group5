/**
 * This program defines an object LowerScorecard
 * CPSC 224-02, Spring 2018
 * Programming Assignment5
 *
 * @author Andrew Zenoni
 * @version 1.0 3/23/18
 */

import java.util.ArrayList;

/**
 * Class for the lower scorecard object
 */
public class LowerScorecard {
    private ScoreLine fiveOfAKind;
    private ScoreLine sevenOfAKind;
    private ScoreLine goodGuysRule;
    private ScoreLine badGuysSuck;
    private ScoreLine superMario;
    private ScoreLine evilBowser;
    private ScoreLine animalKingdom;
    private ScoreLine marioParty;
    private int lowerTotal;

    /**
     * Default value constructor
     */
    public LowerScorecard() {
        fiveOfAKind = new ScoreLine("Five of a kind");
        sevenOfAKind = new ScoreLine("Seven of a kind");
        goodGuysRule = new ScoreLine("Good Guys Rule", 35);
        badGuysSuck = new ScoreLine("Bad Guys Suck", -20);
        superMario = new ScoreLine("Super Mario", 100   );
        evilBowser = new ScoreLine("Evil Bowser", -50);
        animalKingdom = new ScoreLine("Animal Kingdom", 50);
        marioParty = new ScoreLine("Mario Party");
        lowerTotal = 0;
    }

    /**
     * Calculates the possible values for the lower scorecard
     */
    public void displayPossibleValues() {
        if(!fiveOfAKind.isUsed()) {
            System.out.println(fiveOfAKind);
        }
        if(!sevenOfAKind.isUsed()) {
            System.out.println(sevenOfAKind);
        }
        if(!goodGuysRule.isUsed()) {
            System.out.println(goodGuysRule);
        }
        if(!badGuysSuck.isUsed()) {
            System.out.println(badGuysSuck);
        }
        if(!superMario.isUsed()) {
            System.out.println(superMario);
        }
        if(!evilBowser.isUsed()) {
            System.out.println(evilBowser);
        }
        if(!animalKingdom.isUsed()) {
            System.out.println(animalKingdom);
        }
        if(!marioParty.isUsed()) {
            System.out.println(marioParty);
        }
        System.out.println("Lower total is: " + lowerTotal);
    }

    /**
     * Determines if there are fields remaining
     * @return If there are fields remaining
     */
    public boolean hasFieldsRemaining() {
        if(!fiveOfAKind.isUsed() || !sevenOfAKind.isUsed() || !goodGuysRule.isUsed() || !badGuysSuck.isUsed() || !superMario.isUsed() || !evilBowser.isUsed() || !animalKingdom.isUsed() || !marioParty.isUsed()) {
            return true;
        }
        return false;
    }

    public void calculateTotalValue() {
        lowerTotal += fiveOfAKind.getCurValue() + sevenOfAKind.getCurValue() + goodGuysRule.getCurValue() + badGuysSuck.getCurValue() + superMario.getCurValue() + evilBowser.getCurValue() + animalKingdom.getCurValue() + marioParty.getCurValue();
    }

    /**
     * Display the used fields in the score card
     */
    public void displayUsedFields() {
        if(fiveOfAKind.isUsed()) {
            System.out.println(fiveOfAKind);
        }
        if(sevenOfAKind.isUsed()) {
            System.out.println(sevenOfAKind);
        }
        if(badGuysSuck.isUsed()) {
            System.out.println(badGuysSuck);
        }
        if(superMario.isUsed()) {
            System.out.println(superMario);
        }
        if(evilBowser.isUsed()) {
            System.out.println(evilBowser);
        }
        if(animalKingdom.isUsed()) {
            System.out.println(animalKingdom);
        }
        if(goodGuysRule.isUsed()) {
            System.out.println(goodGuysRule);
        }
        if(superMario.isUsed()) {
            System.out.println(superMario);
        }
    }

    /**
     * Getter for three of a kind
     * @return three of a kind
     */
    public ScoreLine getFiveOfAKind() {
        return fiveOfAKind;
    }

    /**
     * Getter for four of a kind
     * @return four of a kind
     */
    public ScoreLine getSevenOfAKind() {
        return sevenOfAKind;
    }

    /**
     * Getter for a full house
     * @return full house
     */
    public ScoreLine getGoodGuysRule() {
        return goodGuysRule;
    }

    /**
     * Getter for small straight
     * @return small straight
     */
    public ScoreLine getBadGuysSuck() {
        return badGuysSuck;
    }

    /**
     * Getter for the large straight
     * @return large straight
     */
    public ScoreLine getSuperMario() {
        return superMario;
    }

    /**
     * Getter for a evilBowser
     * @return evilBowser
     */
    public ScoreLine getEvilBowser() {
        return evilBowser;
    }

    /**
     * Getter for the animalKingdom
     * @return animalKingdom
     */
    public ScoreLine getAnimalKingdom() {
        return animalKingdom;
    }

    public ScoreLine getMarioParty() {
        return marioParty;
    }

    public void setMarioParty(ScoreLine marioParty) {
        this.marioParty = marioParty;
    }

    public int getLowerTotal() {
        return lowerTotal;
    }
}
