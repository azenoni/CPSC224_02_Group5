import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestRunner implements ActionListener{

    public static void main(String[] args) {
        TitleScreenFrame frame1 = new TitleScreenFrame();
        frame1.setTitle("ButtonTest");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(false);

        InstructionsPageFrame frame2 = new InstructionsPageFrame();
        frame2.setTitle("Instructions");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(false);

        ScoringPageFrame frame3 = new ScoringPageFrame();
        frame3.setTitle("Scoring");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);

        DiceRollFrame frame4 = new DiceRollFrame();
        frame4.setTitle("Game");
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
