import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DiceRollFrame extends JFrame implements ActionListener {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1200;

    private JButton keepButton1 = new JButton("KEEP");
    private JButton keepButton2 = new JButton("KEEP");
    private JButton keepButton3 = new JButton("KEEP");
    private JButton keepButton4 = new JButton("KEEP");
    private JButton keepButton5 = new JButton("KEEP");
    private JButton keepButton6 = new JButton("KEEP");
    private JButton keepButton7 = new JButton("KEEP");
    private JButton keepButton8 = new JButton("KEEP");
    private JButton keepButton9 = new JButton("KEEP");
    private JButton keepButton10 = new JButton("KEEP");
    private JButton keepButton11 = new JButton("KEEP");
    private JButton keepButton12 = new JButton("KEEP");

    private JButton rollButton = new JButton("ROLL");
    private JButton scoreButton = new JButton("SCORE");

    public DiceRollFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        keepButton1.setBackground(Color.WHITE);
        keepButton2.setBackground(Color.WHITE);
        keepButton3.setBackground(Color.WHITE);
        keepButton4.setBackground(Color.WHITE);
        keepButton5.setBackground(Color.WHITE);
        keepButton6.setBackground(Color.WHITE);
        keepButton7.setBackground(Color.WHITE);
        keepButton8.setBackground(Color.WHITE);
        keepButton9.setBackground(Color.WHITE);
        keepButton10.setBackground(Color.WHITE);
        keepButton11.setBackground(Color.WHITE);
        keepButton12.setBackground(Color.WHITE);

        keepButton1.setBounds(50, 200, 200, 100);
        keepButton2.setBounds(300, 200, 200, 100);
        keepButton3.setBounds(550, 200, 200, 100);
        keepButton4.setBounds(800, 200, 200, 100);
        keepButton5.setBounds(1050, 200, 200, 100);
        keepButton6.setBounds(1300, 200, 200, 100);
        keepButton7.setBounds(50, 600, 200, 100);
        keepButton8.setBounds(300, 600, 200, 100);
        keepButton9.setBounds(550, 600, 200, 100);
        keepButton10.setBounds(800, 600, 200, 100);
        keepButton11.setBounds(1050, 600, 200, 100);
        keepButton12.setBounds(1300, 600, 200, 100);

        Font buttonFont = new Font("Arial", Font.BOLD, 35);

        keepButton1.setFont(buttonFont);
        keepButton2.setFont(buttonFont);
        keepButton3.setFont(buttonFont);
        keepButton4.setFont(buttonFont);
        keepButton5.setFont(buttonFont);
        keepButton6.setFont(buttonFont);
        keepButton7.setFont(buttonFont);
        keepButton8.setFont(buttonFont);
        keepButton9.setFont(buttonFont);
        keepButton10.setFont(buttonFont);
        keepButton11.setFont(buttonFont);
        keepButton12.setFont(buttonFont);

        keepButton1.addActionListener(this);
        keepButton2.addActionListener(this);
        keepButton3.addActionListener(this);
        keepButton4.addActionListener(this);
        keepButton5.addActionListener(this);
        keepButton6.addActionListener(this);
        keepButton7.addActionListener(this);
        keepButton8.addActionListener(this);
        keepButton9.addActionListener(this);
        keepButton10.addActionListener(this);
        keepButton11.addActionListener(this);
        keepButton12.addActionListener(this);

        buttonPanel.add(keepButton1);
        buttonPanel.add(keepButton2);
        buttonPanel.add(keepButton3);
        buttonPanel.add(keepButton4);
        buttonPanel.add(keepButton5);
        buttonPanel.add(keepButton6);
        buttonPanel.add(keepButton7);
        buttonPanel.add(keepButton8);
        buttonPanel.add(keepButton9);
        buttonPanel.add(keepButton10);
        buttonPanel.add(keepButton11);
        buttonPanel.add(keepButton12);

        buttonPanel.setLocation(10, 100);
        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*switch(e.getSource()){
            case keepButton1:
                System.out.println("Keep Dice 1");
                break;
            case keepButton2:
                System.out.println("Keep Dice 2");
                break;
            default:
                break;
        }*/
    }


    public class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel(BorderLayout b1) {
            super(b1);
            try{
                image = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\diceRollBackground.png"));
            } catch (IOException ex) {
                System.out.println("Image not found DICE ROLL ");
                System.exit(1);
            }
        }

        public ImagePanel() {
            super();
            try {
                image = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\diceRollBackground.png"));
            } catch (IOException ex) {
                System.out.println("Image not found DICE ROLL 2");
                System.exit(1);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image.getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH), 0, 0, this);
        }
    }
}