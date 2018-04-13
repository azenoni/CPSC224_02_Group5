import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TitleScreenFrame extends JFrame implements ActionListener{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1200;

    private JButton playButton = new JButton("Play");
    private JButton instructionButton = new JButton("Instructions");



    public TitleScreenFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        playButton.setBackground(Color.WHITE);
        instructionButton.setBackground(Color.WHITE);

        playButton.setBounds(425,850, 300,180);
        instructionButton.setBounds(1500,850, 500,180);

        Font buttonFont = new Font("Ariel", Font.BOLD, 70);

        playButton.setFont(buttonFont);
        instructionButton.setFont(buttonFont);

        playButton.addActionListener(this);
        instructionButton.addActionListener(this);

        buttonPanel.add(playButton);
        buttonPanel.add(instructionButton);

        buttonPanel.setLocation(10,100);
        add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playButton) {
            System.out.println("Play button clicked");
        } else if(e.getSource() == instructionButton) {
            System.out.println("Instruction button clicked");
        }
    }

    public class ImagePanel extends JPanel{

        private BufferedImage image;

        public ImagePanel(BorderLayout bl) {
            super(bl);
            try {
                image = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\titleScreen.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found TITLE");
                System.exit(1);
            }
        }

        public ImagePanel() {
            super();
            try {
                image = ImageIO.read(new File("C:\\Users\\krist\\OneDrive - Gonzaga University\\Spring 2018\\CPSC 224\\FinalProject\\img\\titleScreen.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found TITLE 2");
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