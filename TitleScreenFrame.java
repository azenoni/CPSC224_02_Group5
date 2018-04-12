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
    private static final int DEFAULT_WIDTH = 1600;
    private static final int DEFAULT_HEIGHT = 800;

    private JButton playButton = new JButton("Play");
    private JButton instructionButton = new JButton("Instructions");



    public TitleScreenFrame() {
//        setLayout(null);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);
        playButton.setBackground(Color.WHITE);
        instructionButton.setBackground(Color.WHITE);
        playButton.setBounds(350,600, 150,100);
        instructionButton.setBounds(1000,600, 200,100);

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
                image = ImageIO.read(new File("img/Title_Screen.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found");
                System.exit(1);
            }
        }

        public ImagePanel() {
            try {
                image = ImageIO.read(new File("img/Title_Screen.jpg"));
            } catch (IOException ex) {
                System.out.println("Image not found");
                System.exit(1);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
        }

    }


}
