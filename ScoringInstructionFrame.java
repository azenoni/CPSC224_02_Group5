import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScoringInstructionFrame extends JFrame implements ActionListener{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1200;

    private JButton backButton = new JButton("Back");
    private JButton playButton = new JButton("PLAY");
    private JButton mainMenuButton = new JButton("Main Menu");
    private JLabel title = new JLabel("<html><strong>SCORING</strong></html>");
    private JLabel upperSectionText = new JLabel("<html><strong><u>UPPER SECTION:</u></strong><br><br> The upper section scores dice that are in the same <i>character category.</i>" +
            "<blockquote><u><i>Good Guys:</i></u> 20 points<br><u><i>Princesses:</i></u> 15 points<br><u><i>Animals:</i></u> 10 points<br><u><i>Bad Guys:</i></u> 5 points" +
            "<blockquote><u><i>Mushroom Bonus:</u></i> additional 45 points added to the total of the upper section score if score or greater</blockquote></blockquote></html>");
    private JLabel lowerSectionText = new JLabel("<html><strong><u>LOWER SECTION:</u></strong> <br>" +
            "<br>The lower section scores the following dice combinations <br>" +
            "<strong>5 of a Kind:</strong><ul><li>5 characters from the same category are rolled</li><li><u>Score:</u> points of the character category multiplied by 5</li></ul>" +
            "<strong>7 of a Kind:</strong><ul><li>7 characters from the same category are rolled</li><li><u>Score:</u> points of the character category multiplied by 7</li></ul>" +
            "<strong>Good Guys Rule:</strong><ul><li>6 characters from the \"Good Guy\" category are rolled</li><li><u>Score:</u> 35 points</li></ul>" +
            "<strong>Bad Guys Suck:</strong><ul><li>6 characters from the \"Bad Guys\" category are rolled</li><li><u>Score:</u> -20 points (from all other players)</li></ul>" +
            "<strong>Super Mario:</strong><ul><li>8 of the dice are showing 'Mario'</li><li><u>Score:</u> 100 points</li></ul>" +
            "<strong>Evil Bowser:</strong><ul><li>8 of the dice are showing 'Bowser'</li><li><u>Score:</u> -50 points (from all other players)</li></ul>" +
            "<strong>Animal Kingdom:</strong><ul><li>10 of the dice are showing Animal category characters</li><li><u>Score:</u> 50 points</li></ul>" +
            "<strong>Mario Pary:</strong><ul><li>Equivalent to the chance of normal Yahtzee</li><li><u>Score:</u> sum up point value of all dice shown</li></ul></html>");


    public ScoringInstructionFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        backButton.setBackground(Color.WHITE);
        playButton.setBackground(Color.WHITE);
        mainMenuButton.setBackground(Color.WHITE);

        title.setBounds(30,30,1000,100);
        upperSectionText.setBounds(75, 150, 600, 500);
        lowerSectionText.setBounds(850, 125, 900, 1000);
        backButton.setBounds(45,980, 200,120);
        playButton.setBounds(300, 980, 200, 120);
        mainMenuButton.setBounds(1735,980, 350,120);

        Font titleFont = new Font("Arial", Font.BOLD, 125);
        Font upperTextFont = new Font("Arial", Font.PLAIN, 27);
        Font lowerTextFont = new Font("Arial", Font.PLAIN, 25);
        Font buttonFont = new Font("Arial", Font.BOLD, 50);

        backButton.setOpaque(true);
        backButton.setBorderPainted(true);
        backButton.setContentAreaFilled(true);
        backButton.setFont(buttonFont);
        backButton.setForeground(Color.BLACK);

        playButton.setOpaque(true);
        playButton.setBorderPainted(true);
        playButton.setContentAreaFilled(true);
        playButton.setFont(buttonFont);
        playButton.setForeground(Color.BLACK);

        mainMenuButton.setOpaque(true);
        mainMenuButton.setBorderPainted(true);
        mainMenuButton.setContentAreaFilled(true);
        mainMenuButton.setFont(buttonFont);
        mainMenuButton.setForeground(Color.BLACK);

        title.setFont(titleFont);
        upperSectionText.setFont(upperTextFont);
        lowerSectionText.setFont(lowerTextFont);

        backButton.addActionListener(this);
        playButton.addActionListener(this);
        mainMenuButton.addActionListener(this);

        buttonPanel.add(title);
        buttonPanel.add(upperSectionText);
        buttonPanel.add(lowerSectionText);
        buttonPanel.add(mainMenuButton);
        buttonPanel.add(backButton);
        buttonPanel.add(playButton);

        buttonPanel.setLocation(10,100);
        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            System.out.println("Back button clicked");
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
        } else if(e.getSource() == playButton) {
            System.out.println("Play button clicked");
            MultiPlayerFrame multiPlayerFrame = new MultiPlayerFrame();
            multiPlayerFrame.setVisible(true);
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
