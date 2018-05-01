import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EndGameFrame extends JFrame implements ActionListener{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1200;

    private JButton playAgainButton = new JButton("PLAY AGAIN");
    private JButton exitButton = new JButton("EXIT");

    private JLabel title = new JLabel("<html><strong>Congratulations!</strong></html>");
    private JLabel player1 = new JLabel();
    private JLabel player2 = new JLabel();
    private JLabel player3 = new JLabel();
    private JLabel player4 = new JLabel();


    public EndGameFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        playAgainButton.setBackground(Color.WHITE);
        exitButton.setBackground(Color.WHITE);

        title.setBounds(30,30,DEFAULT_WIDTH,225);
        player1.setBounds(/*set bounds*/);
        player2.setBounds(/*set bounds*/);
        player3.setBounds(/*set bounds*/);
        player4.setBounds(/*set bounds*/);

        player1.setText("Player 1's score is: " + String.valueOf(TestRunner.getValueAt(1).getFinalScore()));
        player2.setText("Player 2's score is: " + String.valueOf(TestRunner.getValueAt(2).getFinalScore()));
        player3.setText("Player 3's score is: " + String.valueOf(TestRunner.getValueAt(3).getFinalScore()));
        player4.setText("Player 4's score is: " + String.valueOf(TestRunner.getValueAt(4).getFinalScore()));



        playAgainButton.setBounds(45,980, 200,120);
        exitButton.setBounds(1735,980, 350,120);

        Font titleFont = new Font("Arial", Font.BOLD, 175);
        Font buttonFont = new Font("Arial", Font.BOLD, 50);

        playAgainButton.setVisible(false);
        playAgainButton.setOpaque(true);
        playAgainButton.setBorderPainted(true);
        playAgainButton.setContentAreaFilled(true);
        playAgainButton.setFont(buttonFont);
        playAgainButton.setForeground(Color.BLACK);

        exitButton.setOpaque(true);
        exitButton.setBorderPainted(true);
        exitButton.setContentAreaFilled(true);
        exitButton.setFont(buttonFont);
        exitButton.setForeground(Color.BLACK);

        title.setFont(titleFont);

        playAgainButton.addActionListener(this);
        exitButton.addActionListener(this);

        buttonPanel.add(title);
        buttonPanel.add(playAgainButton);
        buttonPanel.add(exitButton);

        buttonPanel.setLocation(10,100);
        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == playAgainButton) {
            System.out.println("Play Again button clicked");
             TitleScreenFrame titleScreenFrame = new TitleScreenFrame();
             titleScreenFrame.setVisible(true);
             this.dispose();
        }if else(e.getSource() == exitButton) {
            this.dispose();
        }
    }

    public class ImagePanel extends JPanel{

        private BufferedImage image;

        public ImagePanel(BorderLayout bl) {
            super(bl);
            try {
                image = ImageIO.read(new File("img/endScreen.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found INSTRUCTIONS");
                System.exit(1);
            }
        }

        public ImagePanel() {
            super();
            try {
                image = ImageIO.read(new File("img/endScreen.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found INSTRUCTIONS 2");
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
