import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MultiPlayerFrame extends JFrame implements ActionListener{
    private JPanel buttonPanel;
    private static int PLAYER_COUNT = 0;
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1200;

    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton playButton = new JButton("PLAY");
    private JButton mainMenuButton = new JButton("Main Menu");

    private JLabel title = new JLabel("<html><strong>How Many Players?</strong></html>");

    public MultiPlayerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        button1.setBackground(Color.WHITE);
        button2.setBackground(Color.WHITE);
        button3.setBackground(Color.WHITE);
        button4.setBackground(Color.WHITE);
        playButton.setBackground(Color.WHITE);
        mainMenuButton.setBackground(Color.WHITE);

        button1.setBounds(300, 350, 350, 120);
        button2.setBounds(1000, 350, 350, 120);
        button3.setBounds(300, 750, 350, 120);
        button4.setBounds(1000, 750, 350, 120);
        title.setBounds(30,30,DEFAULT_WIDTH,225);
        playButton.setBounds(45,980, 200,120);
        mainMenuButton.setBounds(1735,980, 350,120);

        Font titleFont = new Font("Arial", Font.BOLD, 175);
        Font buttonFont = new Font("Arial", Font.BOLD, 50);

        button1.setOpaque(true);
        button1.setBorderPainted(true);
        button1.setContentAreaFilled(true);
        button1.setFont(buttonFont);
        button1.setForeground(Color.BLACK);

        button2.setOpaque(true);
        button2.setBorderPainted(true);
        button2.setContentAreaFilled(true);
        button2.setFont(buttonFont);
        button2.setForeground(Color.BLACK);

        button3.setOpaque(true);
        button3.setBorderPainted(true);
        button3.setContentAreaFilled(true);
        button3.setFont(buttonFont);
        button3.setForeground(Color.BLACK);

        button4.setOpaque(true);
        button4.setBorderPainted(true);
        button4.setContentAreaFilled(true);
        button4.setFont(buttonFont);
        button4.setForeground(Color.BLACK);

        playButton.setVisible(false);
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

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        playButton.addActionListener(this);
        mainMenuButton.addActionListener(this);

        buttonPanel.add(title);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(playButton);
        buttonPanel.add(mainMenuButton);

        buttonPanel.setLocation(10,100);
        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1) {
            System.out.println("Player Count 1");
            button1.setBackground(Color.LIGHT_GRAY);
            button2.setBackground(Color.WHITE);
            button3.setBackground(Color.WHITE);
            button4.setBackground(Color.WHITE);
            PLAYER_COUNT = 1;
            playButton.setVisible(true);
        } else if(e.getSource() == button2) {
            System.out.println("Player Count 2");
            button1.setBackground(Color.WHITE);
            button2.setBackground(Color.LIGHT_GRAY);
            button3.setBackground(Color.WHITE);
            button4.setBackground(Color.WHITE);
            PLAYER_COUNT = 2;
            playButton.setVisible(true);
        } else if(e.getSource() == button3) {
            System.out.println("Player Count 3");
            button1.setBackground(Color.WHITE);
            button2.setBackground(Color.WHITE);
            button3.setBackground(Color.LIGHT_GRAY);
            button4.setBackground(Color.WHITE);
            PLAYER_COUNT = 3;
            playButton.setVisible(true);
        } else if(e.getSource() == button4) {
            System.out.println("Player Count 4");
            button1.setBackground(Color.WHITE);
            button2.setBackground(Color.WHITE);
            button3.setBackground(Color.WHITE);
            button4.setBackground(Color.LIGHT_GRAY);
            PLAYER_COUNT = 4;
            playButton.setVisible(true);
        } else if(e.getSource() == playButton) {
            System.out.println("Play button clicked");
            DiceRollFrame diceRollFrame = null;
            try {
                diceRollFrame = new DiceRollFrame(PLAYER_COUNT);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            diceRollFrame.setVisible(true);
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

            Graphics2D g2 = (Graphics2D) g;
            int w = DEFAULT_WIDTH;// real width of canvas
            int h = DEFAULT_HEIGHT;// real height of canvas
// Translate used to make sure scale is centered
            g2.translate(w/4, h/4);
            g2.scale(0.5, 0.5);
            g2.translate(-w/2, -h/2);

            g.drawImage(image.getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image. SCALE_SMOOTH), 0, 0, this);
        }
    }
}
