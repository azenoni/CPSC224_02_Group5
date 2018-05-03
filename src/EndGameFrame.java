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




    public EndGameFrame(ArrayList<Player> arrayList) {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        playAgainButton.setBackground(Color.WHITE);
        exitButton.setBackground(Color.WHITE);

        title.setBounds(30,30,DEFAULT_WIDTH,225);
        player1.setBounds(30,300,800,100);
        player2.setBounds(30,400,800,100);
        player3.setBounds(30,500,800,100);
        player4.setBounds(30,600,800,100);

        for(int i = 0; i < arrayList.size(); i++) {
            if(i == 0) {
                arrayList.get(i).getScoreCard().determineFinalScore();
                player1.setText("Player 1's score is: " + (String.valueOf(arrayList.get(i).getScoreCard().getScoreCardTotal())));
            }
            if(i == 1) {
                player2.setText("Player 2's score is: " + String.valueOf(arrayList.get(i).getScoreCard().getScoreCardTotal()));
            }
            if(i == 2) {
                player3.setText("Player 3's score is: " + String.valueOf(arrayList.get(i).getScoreCard().getScoreCardTotal()));
            }
            if(i == 3) {
                player4.setText("Player 4's score is: " + (String.valueOf(arrayList.get(i).getScoreCard().getScoreCardTotal())));

            }
        }

        playAgainButton.setBounds(45,980, 350,120);
        exitButton.setBounds(1735,980, 350,120);

        Font titleFont = new Font("Arial", Font.BOLD, 175);
        Font buttonFont = new Font("Arial", Font.BOLD, 50);

        playAgainButton.setVisible(true);
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

        player1.setFont(buttonFont);
        player2.setFont(buttonFont);
        player3.setFont(buttonFont);
        player4.setFont(buttonFont);

        buttonPanel.add(title);
        buttonPanel.add(player1);
        buttonPanel.add(player2);
        buttonPanel.add(player3);
        buttonPanel.add(player4);
        buttonPanel.add(playAgainButton);
        buttonPanel.add(exitButton);

        buttonPanel.setLocation(10,100);
        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == playAgainButton) {
            System.out.println("Play Again button clicked");
             MultiPlayerFrame multiPlayerFrame = new MultiPlayerFrame();
             multiPlayerFrame.setVisible(true);
             this.dispose();
        }else if(e.getSource() == exitButton) {
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
