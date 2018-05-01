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
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1200;

    private JButton playButton = new JButton("Play");
    private JButton mainMenuButton = new JButton("Main Menu");
    private JLabel title = new JLabel("<html><strong>SCORING</strong></html>");
    private JLabel upperSectionText = new JLabel("<html><strong><u>UPPER SECTION:</u></strong> <br>The upper section scores dice that are in the same character category.  " +
            "The number of points awarded for each dice rolled depends on the <br> character’s category. " +
            "<br> <blockquote> <strong> Good Guy: </strong> 20 points <br><strong> Princess: </strong> 15 points <br> <strong> Animal: </strong> 10 points <br> " +
            "<strong> Bad Guy: </strong> 5 points <br><blockquote><em> Mushroom Bonus: </em> Additional 45 points added to the total of the Upper Section score if score is 200 or greater </blockquote></blockquote> </html>");
    private JLabel lowerSectionText = new JLabel("<html><strong><u>LOWER SECTION:</u></strong> <br>The lower section scores the following dice combinations:<blockquote> " +
            "<strong>5 of a kind: </strong><ul><li>5 characters from the same category are rolled <li><u>Score:</u> Points of selected character category, multiplied by 5</ul>" +
            "<strong>7 of a kind: </strong><ul><li>7 characters from the same category are rolled <li><u>Score:</u> Points of selected character category, multiplied by 7</ul>" +
            "<strong>Good Guys Rule: </strong><ul><li>6 characters from the \"Good Guy\" category are rolled <li><u>Score:</u> 35 points</ul>" +
            "<strong>Bad Guys Suck: </strong><ul><li>6 characters from the \"Bad Guy\" category are rolled <li><u>Score:</u> -20 points <i>(given to another player)</i></ul>" +
            "<br><br><strong>Super Mario: </strong><ul><li>8 dice present \"Mario\" <li><u>Score:</u> 100 points</ul>" +
            "<strong>Evil Bowser: </strong><ul><li>8 dice present \"Bowser\" <li><u>Score:</u> -50 <i> (given to another player)</i></ul>" +
            "<strong>Animal Kingdom: </strong><ul><li>10 dice present characters from the \"Animal\" category<li><u>Score:</u> 50 points</ul>" +
            "<strong>Mario Party: </strong><ul><li>equivalent to \"Chance\" of normal yahtzee <li><u>Score:</u> Sum of all dice shown</ul></blockquote></html>");

    public ScoringPageFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        playButton.setBackground(Color.WHITE);
        mainMenuButton.setBackground(Color.WHITE);

        playButton.setBounds(10,600, 150,90);
        mainMenuButton.setBounds(200,600, 275,90);

        title.setBounds(25,0,800,100);
        upperSectionText.setBounds(25, 125, 600, 400);
        lowerSectionText.setBounds(700, 50, 800, 1100);

        Font buttonFont = new Font("Arial", Font.BOLD, 30);
        Font titleFont = new Font("Arial", Font.BOLD, 100);
        Font instructionFont = new Font("Arial", Font.PLAIN, 20);

        playButton.setOpaque(true);
        playButton.setBorderPainted(true);
        playButton.setContentAreaFilled(true);
        playButton.setFont(buttonFont);

        mainMenuButton.setOpaque(true);
        mainMenuButton.setBorderPainted(true);
        mainMenuButton.setContentAreaFilled(true);
        mainMenuButton.setFont(buttonFont);

        title.setFont(titleFont);

        upperSectionText.setFont(instructionFont);
        lowerSectionText.setFont(instructionFont);

        playButton.addActionListener(this);
        mainMenuButton.addActionListener(this);

        buttonPanel.add(mainMenuButton);
        buttonPanel.add(playButton);
        buttonPanel.add(title);
        buttonPanel.add(upperSectionText);
        buttonPanel.add(lowerSectionText);

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
                image = ImageIO.read(new File("img/desertScoring.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found SCORING");
                System.exit(1);
            }
        }

        public ImagePanel() {
            super();
            try {
                image = ImageIO.read(new File("img/desertScoring.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found SCORING 2");
                System.exit(1);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

//            Graphics2D g2 = (Graphics2D) g;
//            int w = DEFAULT_WIDTH;// real width of canvas
//            int h = DEFAULT_HEIGHT;// real height of canvas
//// Translate used to make sure scale is centered
//            g2.translate(w/4, h/4);
//            g2.scale(0.5, 0.5);
//            g2.translate(-w/2, -h/2);

            g.drawImage(image.getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image. SCALE_SMOOTH), 0, 0, this);
        }
    }
}
