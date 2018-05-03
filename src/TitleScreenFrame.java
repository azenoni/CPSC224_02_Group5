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
    private static int DEFAULT_WIDTH = 2400;
    private static int DEFAULT_HEIGHT = 1200;

    private JButton playButton = new JButton("Play");
    private JButton instructionButton = new JButton("Instructions");



    public TitleScreenFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        DEFAULT_HEIGHT = (int)screenSize.getHeight();
        DEFAULT_WIDTH = (int)screenSize.getWidth();
        System.out.println(DEFAULT_HEIGHT);
        System.out.println(DEFAULT_WIDTH);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        playButton.setBackground(Color.WHITE);
        instructionButton.setBackground(Color.WHITE);

        playButton.setBounds(DEFAULT_WIDTH/5,DEFAULT_HEIGHT*3/4, 300,180);
        instructionButton.setBounds(DEFAULT_WIDTH*3/5,DEFAULT_HEIGHT*3/4, 500,180);

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
            multiPlayerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        } else if(e.getSource() == instructionButton) {
            System.out.println("Instruction button clicked");
            InstructionsPageFrame instructionsPageFrame = new InstructionsPageFrame();
            instructionsPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            g.drawImage(image.getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH), 0, 0, this);
        }
    }
}