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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
            MultiPlayerFrame multiPlayerFrame = new MultiPlayerFrame();
            multiPlayerFrame.setVisible(true);
            this.dispose();
        } else if(e.getSource() == instructionButton) {
            System.out.println("Instruction button clicked");
            InstructionsPageFrame instructionsPageFrame = new InstructionsPageFrame();
            instructionsPageFrame.setVisible(true);
            this.dispose();

        }
    }

    public class ImagePanel extends JPanel{

        private BufferedImage image;

        public ImagePanel(BorderLayout bl) {
            super(bl);
            try {
                image = ImageIO.read(new File("img/titleScreen.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found TITLE");
                System.exit(1);
            }
        }

        public ImagePanel() {
            super();
            try {
                image = ImageIO.read(new File("img/titleScreen.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found TITLE 2");
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
        }
    }
}