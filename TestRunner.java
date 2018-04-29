import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestRunner {

    public static void main(String[] args) {
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

        ScoreCardFrame frame5 = new ScoreCardFrame(arrayList,0, null);
        frame4.setTitle("Scorecard");
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);
        
    }
}
