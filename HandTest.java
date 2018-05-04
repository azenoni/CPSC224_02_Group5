 import junit.framework.TestCase;
 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.Test;

 public class HandTest extends TestCase{


     public void testAnalyzeHand() throws Exception {
         Hand hand = new Hand(12,6);
         hand.analyzeDice("yyyyyyyyyyyy");
         for(Dice dice : hand.getDiceHand()) {
             assertFalse(dice.isActive());
         }

         hand.analyzeDice("nnnnnnnnnnnn");
         for(Dice dice : hand.getDiceHand()) {
             assertTrue(dice.isActive());
         }
     }

     public void testRollDice() throws Exception {
         Hand hand = new Hand(12,12);
         Hand second = new Hand(12,12);
         for(int i = 0; i < second.getDiceHand().size(); i++) {
            second.getDiceHand().get(i).setCurValue(hand.getDiceHand().get(i).getCurValue());
         }

         second.rollDice();
         int sameNumCount = 0;
         for(int i = 0; i < second.getDiceHand().size(); i++) {
             if(second.getDiceHand().get(i).getCurValue() == hand.getDiceHand().get(i).getCurValue()) {
                 sameNumCount++;
             }
         }

         assertEquals(sameNumCount,0,4);
     }
 }
