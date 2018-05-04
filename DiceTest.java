import static org.junit.jupiter.api.Assertions.*;

import junit.framework.TestCase;

 public class DiceTest extends TestCase{


     public void testCreateDice() throws Exception {
         Dice dice = new Dice(6);
         assertEquals(dice.getNumSides(), 6);
         assertTrue (dice.isActive());
     }


 }
