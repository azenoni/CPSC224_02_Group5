import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScoringPageFrame extends JFrame implements ActionListener{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 1600;
    private static final int DEFAULT_HEIGHT = 800;

    private JButton playButton = new JButton("Play");
    private JButton mainMenuButton = new JButton("Main Menu");
    private JLabel title = new JLabel("<html><strong>SCORING</strong></html>");
    private JLabel howToWinText = new JLabel("<html><strong>How to Win:</strong> <br> The highest score after all twelve <br> rounds, wins the game </html>");
    private JLabel howToPlayText = new JLabel("<html><strong>How To Play:</strong> <br>" +
            "To begin playing, each player will roll all 10 dice. The player <br> " +
            "who rolled the most ‘Mario’ dice, will begin the game. Play will <br>" +
            "continue in a clockwise. For each hand, you get three roles:<br>" +
            "<strong>Roll 1:</strong> On roll one, the player picks up all the dice and <br>" +
            "rolls them. After this roll, you can keep none of the dice <br>" +
            "you rolled, some of the dice, or all of the dice. If you did <br>" +
            "not keep all of the dice. Proceed to your second roll<br>" +
            "<strong>Roll 2:</strong> Much like after the first roll, you may choose to keep <br>" +
            "none of the dice, some of the dice, or all of the dice. <br>" +
            "Dice kept last hand are not required to be kept again. If <br>" +
            "you did not keep all of the dice, proceed to your last roll.<br>" +
            "<strong>Roll 3:</strong> Now that you have completed your final roll, you will <br>" +
            "need to score the current dice shown and choose a <br>" +
            "section on the scorecard to fill in.<br></html>");



    public ScoringPageFrame() {
//        setLayout(null);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);
        playButton.setBackground(Color.WHITE);
        mainMenuButton.setBackground(Color.WHITE);
        playButton.setBounds(0,650, 150,100);
        mainMenuButton.setBounds(150,650, 400,100);
        howToWinText.setBounds(25, 200, 600, 100);
        title.setBounds(25,0,800,100);
        howToPlayText.setBounds(700, 175, 800, 450);

        Font buttonFont = new Font("Arial", Font.BOLD, 30);
        Font titleFont = new Font("Arial", Font.BOLD, 100);
        Font instructionFont = new Font("Arial", Font.PLAIN, 20);

        playButton.setOpaque(false);
        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.setFont(buttonFont);

        mainMenuButton.setOpaque(false);
        mainMenuButton.setBorderPainted(false);
        mainMenuButton.setContentAreaFilled(false);
        mainMenuButton.setFont(buttonFont);

        title.setFont(titleFont);

        howToWinText.setFont(instructionFont);
        howToPlayText.setFont(instructionFont);

        playButton.addActionListener(this);
        mainMenuButton.addActionListener(this);

        buttonPanel.add(mainMenuButton);
        buttonPanel.add(playButton);
        buttonPanel.add(howToWinText);
        buttonPanel.add(title);
        buttonPanel.add(howToPlayText);



        buttonPanel.setLocation(10,100);
        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playButton) {
            System.out.println("Play button clicked");
        } else if(e.getSource() == mainMenuButton) {
            System.out.println("Main menu button clicked");
        }
    }

    public class ImagePanel extends JPanel{

        private BufferedImage image;

        public ImagePanel(BorderLayout bl) {
            super(bl);
            try {
                image = ImageIO.read(new File("img/desert.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found");
                System.exit(1);
            }
        }

        public ImagePanel() {
            try {
                image = ImageIO.read(new File("img/desert.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found");
                System.exit(1);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image.getScaledInstance(1600, 800, Image. SCALE_SMOOTH), 0, 0, this);
        }

    }
}
