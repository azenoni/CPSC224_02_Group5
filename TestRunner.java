import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestRunner implements ActionListener{

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);

        InstructionsPageFrame frame2 = new InstructionsPageFrame();
        frame2.setTitle("Instructions");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(false);

        ScoringPageFrame frame3 = new ScoringPageFrame();
        frame3.setTitle("Scoring");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(false);

        ScoreCardFrame frame4 = new ScoreCardFrame(arrayList,0, null);
        frame4.setTitle("Scorecard");
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
