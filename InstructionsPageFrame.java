import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InstructionsPageFrame extends JFrame implements ActionListener{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1200;

    private JButton nextButton = new JButton("Next");
    private JButton mainMenuButton = new JButton("Main Menu");
    private JLabel title = new JLabel("<html><strong>INSTRUCTIONS</strong></html>");
    private JLabel howToWinText = new JLabel("<html><strong><u>How to Win:</u></strong> " +
            "<br><br> The highest score after all twelve rounds, wins the game </html>");
    private JLabel howToPlayText = new JLabel("<html><strong><u>How To Play:</u></strong> <br>" +
            "<br>To begin playing, each player will roll twelve, <strong>twelve-sided</strong> dice. The player who rolled the most ‘Mario’ dice, will begin the game. Play will " +
            "continue in a clockwise. For each hand, you get three roles: <br>" +
            "<strong>Roll 1:</strong><blockquote>On roll one, the player picks up all the dice and <br>" +
            "rolls them. After this roll, you can keep none of the dice " +
            "you rolled, some of the dice, or all of the dice. If you did " +
            "not keep all of the dice. Proceed to your second roll. <br></blockquote>" +
            "<strong>Roll 2:</strong><blockquote> Much like after the first roll, you may choose to keep " +
            "none of the dice, some of the dice, or all of the dice. " +
            "Dice kept last hand are not required to be kept again. If " +
            "you did not keep all of the dice, proceed to your last roll. <br></blockquote>" +
            "<strong>Roll 3:</strong><blockquote> Now that you have completed your final roll, you will <br>" +
            "need to score the current dice shown and choose a " +
            "section on the scorecard to fill in.</blockquote><br></html>");



    public InstructionsPageFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        nextButton.setBackground(Color.WHITE);
        mainMenuButton.setBackground(Color.WHITE);

        title.setBounds(30,30,1000,100);
        howToWinText.setBounds(75, 250, 600, 250);
        howToPlayText.setBounds(750, 250, 900, 800);
        nextButton.setBounds(45,980, 200,120);
        mainMenuButton.setBounds(1735,980, 350,120);

        Font titleFont = new Font("Arial", Font.BOLD, 125);
        Font instructionFont = new Font("Arial", Font.PLAIN, 30);
        Font buttonFont = new Font("Arial", Font.BOLD, 50);

        nextButton.setOpaque(true);
        nextButton.setBorderPainted(true);
        nextButton.setContentAreaFilled(true);
        nextButton.setFont(buttonFont);
        nextButton.setForeground(Color.BLACK);

        mainMenuButton.setOpaque(true);
        mainMenuButton.setBorderPainted(true);
        mainMenuButton.setContentAreaFilled(true);
        mainMenuButton.setFont(buttonFont);
        mainMenuButton.setForeground(Color.BLACK);

        title.setFont(titleFont);

        howToWinText.setFont(instructionFont);
        howToPlayText.setFont(instructionFont);

        nextButton.addActionListener(this);
        mainMenuButton.addActionListener(this);

        buttonPanel.add(mainMenuButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(howToWinText);
        buttonPanel.add(title);
        buttonPanel.add(howToPlayText);

        buttonPanel.setLocation(10,100);
        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton) {
            System.out.println("Next button clicked");
            DiceInstructionFrame diceInstructionFrame = null;
            try {
                diceInstructionFrame = new DiceInstructionFrame();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (FontFormatException e1) {
                e1.printStackTrace();
            }
            diceInstructionFrame.setVisible(true);
            this.dispose();
        } else if(e.getSource() == mainMenuButton) {
            System.out.println("Main menu button clicked");
            TitleScreenFrame titleScreenFrame = new TitleScreenFrame();
            titleScreenFrame.setVisible(true);
            this.dispose();
        }
    }

    public class ImagePanel extends JPanel{

        private BufferedImage image;

        public ImagePanel(BorderLayout bl) {
            super(bl);
            try {
                image = ImageIO.read(new File("img/flowerInstructions.png"));
            } catch (IOException ex) {
                System.out.println("Image not found INSTRUCTIONS");
                System.exit(1);
            }
        }

        public ImagePanel() {
            super();
            try {
                image = ImageIO.read(new File("img/flowerInstructions.png"));
            } catch (IOException ex) {
                System.out.println("Image not found INSTRUCTIONS 2");
                System.exit(1);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image.getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image. SCALE_SMOOTH), 0, 0, this);
        }
    }
}
