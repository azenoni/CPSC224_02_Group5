import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestRunner {

    public static void main(String[] args) throws IOException {
        Player firstPlayer = new Player(10,12);
        Player secondPlayer = new Player(10,12);
        Player thirdPlayer = new Player(10,12);
        Player fourthPlayer = new Player(10,12);
        ArrayList<Player> arrayList = new ArrayList<>();
        arrayList.add(firstPlayer);
        arrayList.add(secondPlayer);
        arrayList.add(thirdPlayer);
        arrayList.add(fourthPlayer);

        TitleScreenFrame frame = new TitleScreenFrame();
        frame.setTitle("ButtonTest");
        frame.setVisible(true);

        InstructionsPageFrame frame2 = new InstructionsPageFrame();
        frame2.setTitle("Instructions");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(false);

        ScoringInstructionFrame frame3 = new ScoringInstructionFrame();
        frame3.setTitle("Scoring");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(false);
        
        DiceRollFrame frame4 = new DiceRollFrame();
        frame4.setTitle("Game");
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(false);


        ArrayList<Dice> diceHand = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Dice dice = new Dice(12);
            dice.rollDice();
            diceHand.add(dice);
        }

        for(Dice tmp : diceHand) {
            System.out.println(tmp.getCurValue());
        }
        ScoreCardFrame frame5 = new ScoreCardFrame(arrayList,0, diceHand);
        frame5.setTitle("Scorecard");
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setVisible(false);
        
    }
}
