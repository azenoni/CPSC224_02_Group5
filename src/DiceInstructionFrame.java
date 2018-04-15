import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DiceInstructionFrame extends JFrame implements ActionListener{
    private JPanel buttonPanel;
    private BufferedImage diceImages[][];
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1200;

    private JButton backButton = new JButton("Back");
    private JButton nextButton = new JButton("Next");
    private JButton mainMenuButton = new JButton("Main Menu");
    private JLabel title = new JLabel("<html><strong>DICE</strong></html>");
    private JLabel diceDescription = new JLabel("<html>This game is played with twelve, <strong>twelve-sided</strong> dice.</html>");

    public DiceInstructionFrame () throws IOException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ImagePanel();
        diceImages = new BufferedImage[3][4];
        buttonPanel.setLayout(null);

        diceImages[0][0] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\mario.png"));
        diceImages[0][1] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\princessPeach.png"));
        diceImages[0][2] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\yoshi.png"));
        diceImages[0][3] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\wario.png"));
        diceImages[1][0] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\luigi.png"));
        diceImages[1][1] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\daisy.png"));
        diceImages[1][2] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\donkeyKong.png"));
        diceImages[1][3] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\waluigi.png"));
        diceImages[2][0] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\toad.png"));
        diceImages[2][1] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\rosalina.png"));
        diceImages[2][2] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\diddyKong.png"));
        diceImages[2][3] = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\bowser.png"));

        backButton.setBackground(Color.WHITE);
        nextButton.setBackground(Color.WHITE);
        mainMenuButton.setBackground(Color.WHITE);

        title.setBounds(30,30,1000,100);
        diceDescription.setBounds(75, 100, 1000, 250);
        backButton.setBounds(45,980, 200,120);
        nextButton.setBounds(300, 980, 200, 120);
        mainMenuButton.setBounds(1735,980, 350,120);

        Font titleFont = new Font("Arial", Font.BOLD, 125);
        Font textFont = new Font("Arial", Font.PLAIN, 30);
        Font buttonFont = new Font("Arial", Font.BOLD, 50);

        backButton.setOpaque(true);
        backButton.setBorderPainted(true);
        backButton.setContentAreaFilled(true);
        backButton.setFont(buttonFont);
        backButton.setForeground(Color.BLACK);

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

        diceDescription.setFont(textFont);

        backButton.addActionListener(this);
        nextButton.addActionListener(this);
        mainMenuButton.addActionListener(this);

        buttonPanel.add(title);
        buttonPanel.add(mainMenuButton);
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(diceDescription);
        //buttonPanel.add(diceImages);

        buttonPanel.setLocation(10,100);
        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            System.out.println("Back button clicked");
            InstructionsPageFrame instructionsPageFrame = new InstructionsPageFrame();
            instructionsPageFrame.setVisible(true);
            this.dispose();
        } else if (e.getSource() == nextButton) {
            System.out.println("Next button clicked");
            // edit scoring pages
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
                image = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\flowerInstructions.png"));
            } catch (IOException ex) {
                System.out.println("Image not found DICE INSTRUCTIONS");
                System.exit(1);
            }
        }

        public ImagePanel() {
            super();
            try {
                image = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\flowerInstructions.png"));
            } catch (IOException ex) {
                System.out.println("Image not found DICE INSTRUCTIONS 2");
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
