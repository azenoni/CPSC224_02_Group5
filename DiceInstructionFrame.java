import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.*;

public class DiceInstructionFrame extends JFrame implements ActionListener{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1200;

    private JButton backButton = new JButton("Back");
    private JButton nextButton = new JButton("Next");
    private JButton mainMenuButton = new JButton("Main Menu");
    private JLabel title = new JLabel("<html><strong>DICE</strong></html>");
    private JLabel diceDescription = new JLabel("<html><font color=\"white\">Good Guys " +
            "&emsp;&emsp;&emsp;&emsp;Princesses " +
            "&emsp;&emsp;&emsp;&emsp;Animals " +
            "&emsp;&emsp;&emsp;&emsp;Bad Guys</font></html>");

    public DiceInstructionFrame () throws IOException, FontFormatException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        backButton.setBackground(Color.WHITE);
        nextButton.setBackground(Color.WHITE);
        mainMenuButton.setBackground(Color.WHITE);

        title.setBounds(30,30,1000,100);
        diceDescription.setBounds(225, 75, 1600, 250);
        backButton.setBounds(45,980, 200,120);
        nextButton.setBounds(300, 980, 200, 120);
        mainMenuButton.setBounds(1735,980, 350,120);

        Font titleFont = new Font("Arial", Font.BOLD, 125);
        Font textFont = new Font("Arial", Font.ITALIC, 40);
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
            ScoringInstructionFrame scoringInstructionFrame = new ScoringInstructionFrame();
            scoringInstructionFrame.setVisible(true);
            this.dispose();
        } else if(e.getSource() == mainMenuButton) {
            System.out.println("Main menu button clicked");
            TitleScreenFrame titleScreenFrame = new TitleScreenFrame();
            titleScreenFrame.setVisible(true);
            this.dispose();
        }
    }

    // Sets up Background Image on Panel
    // Add buttons to background
    public class ImagePanel extends JPanel{
        private BufferedImage image;
        // Good Guys
        private BufferedImage mario;
        private BufferedImage luigi;
        private BufferedImage toad;
        // Princesses
        private BufferedImage princessPeach;
        private BufferedImage daisy;
        private BufferedImage rosalina;
        // Animals
        private BufferedImage yoshi;
        private BufferedImage donkeyKong;
        private BufferedImage diddyKong;
        // Bad Guys
        private BufferedImage wario;
        private BufferedImage waluigi;
        private BufferedImage bowser;
        private final int IMAGE_SIZE = 200;

        public ImagePanel() throws IOException {
            super();

            try {
                image = read(new File("img/flowerInstructions.png"));
                // Good Guys
                mario = read(new File("img/mario.png"));
                luigi = read(new File("img/luigi.png"));
                toad = read(new File("img/toad.png"));
                // Princesses
                princessPeach = read(new File("img/princessPeach.png"));
                daisy = read(new File("img/daisy.png"));
                rosalina = read(new File("img/rosalina.png"));
                // Animals
                yoshi = read(new File("img/yoshi.png"));
                donkeyKong = read(new File("img/donkeyKong.png"));
                diddyKong = read(new File("img/diddyKong.png"));
                // Bad Guys
                wario = read(new File("img/wario.png"));
                waluigi = read(new File("img/waluigi.png"));
                bowser = read(new File("img/bowser.png"));
            } catch (IOException ex) {
                System.out.println("Image not found DICE INSTRUCTIONS 2");
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

            g.drawImage(image.getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH), 0, 0, this);
            // Good Guys
            g.drawImage(mario.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 200, 250, this);
            g.drawImage(luigi.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 200, 500, this);
            g.drawImage(toad.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 200, 750, this);
            // Princesses
            g.drawImage(princessPeach.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 550, 250, this);
            g.drawImage(daisy.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 550, 500, this);
            g.drawImage(rosalina.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 550, 750, this);
            // Animals
            g.drawImage(yoshi.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 900, 250, this);
            g.drawImage(donkeyKong.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 900, 500, this);
            g.drawImage(diddyKong.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 900, 750, this);
            // Bad Guys
            g.drawImage(wario.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 1250, 250, this);
            g.drawImage(waluigi.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 1250, 500, this);
            g.drawImage(bowser.getScaledInstance(IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH), 1250, 750, this);
        }
    }
}
