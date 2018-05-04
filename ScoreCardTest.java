import static org.junit.jupiter.api.Assertions.*;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ScoreCardTest extends TestCase{

    public void testHasFieldsRemaining() throws Exception {
        ScoreCard scoreCard = new ScoreCard(12,12);
        scoreCard.getUpperScorecard().getGoodGuys().setUsed(true);
        scoreCard.getUpperScorecard().getPrincesses().setUsed(true);
        scoreCard.getUpperScorecard().getAnimals().setUsed(true);
        scoreCard.getUpperScorecard().getBadGuys().setUsed(true);

        scoreCard.getLowerScorecard().getFiveOfAKind().setUsed(true);
        scoreCard.getLowerScorecard().getSevenOfAKind().setUsed(true);
        scoreCard.getLowerScorecard().getGoodGuysRule().setUsed(true);
        scoreCard.getLowerScorecard().getBadGuysSuck().setUsed(true);
        scoreCard.getLowerScorecard().getSuperMario().setUsed(true);
        scoreCard.getLowerScorecard().getEvilBowser().setUsed(true);
        scoreCard.getLowerScorecard().getAnimalKingdom().setUsed(true);
        scoreCard.getLowerScorecard().getMarioParty().setUsed(true);

        assertFalse(scoreCard.hasFieldsRemaining());
    }


    public void testHasFieldsRemainingTrue() throws Exception {
        ScoreCard scoreCard = new ScoreCard(12,12);
        assertTrue(scoreCard.hasFieldsRemaining());
    }

    public void testCalculateLikeDice() throws Exception {
        ScoreCard scoreCard = new ScoreCard(12,12);
        Hand hand = new Hand(12,12);
        hand.rollDice();
        int[] diceValues = new int[12];
        for(int i = 0; i < diceValues.length; i++) {
            diceValues[i] = 0;
        }
        ArrayList<Dice> arrayList = new ArrayList<>();
        for(Dice dice : hand.getDiceHand()) {
            diceValues[dice.getCurValue()-1] += 1;
            arrayList.add(dice);
        }
        scoreCard.setDiceHand(arrayList);
        scoreCard.performLikeDiceCalculations();
        if(diceValues[0] + diceValues[1] + diceValues[2] >= 6) {
            assertEquals(scoreCard.getLowerScorecard().getGoodGuysRule().getCurValue(), 35);
        } else {
            assertEquals(scoreCard.getLowerScorecard().getGoodGuysRule().getCurValue(), 0);
        }

        if(diceValues[9] + diceValues[10] + diceValues[11] >= 6) {
            assertEquals(scoreCard.getLowerScorecard().getBadGuysSuck().getCurValue(), -20);
        } else {
            assertEquals(scoreCard.getLowerScorecard().getBadGuysSuck().getCurValue(), 0);
        }

        if(diceValues[0] >= 8) {
            assertEquals(scoreCard.getLowerScorecard().getSuperMario().getCurValue(), 100);
        } else {
            assertEquals(scoreCard.getLowerScorecard().getSuperMario().getCurValue(), 0);
        }

        if(diceValues[6] + diceValues[7] + diceValues[8] > 10) {
            assertEquals(scoreCard.getLowerScorecard().getAnimalKingdom().getCurValue(), 50);
        } else {
            assertEquals(scoreCard.getLowerScorecard().getAnimalKingdom().getCurValue(), 0);
        }

    }


}
