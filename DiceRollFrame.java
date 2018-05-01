import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class DiceRollFrame extends JFrame implements ActionListener {
    private Random random = new Random();
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1200;
    private static int turnCount = 0;
    private int activePlayer;
    private static ArrayList<Image> diceImages = new ArrayList<>();
    private static ArrayList<Player> players;
    private ArrayList<Dice> diceHand = new ArrayList<>();

    private JButton keepButton1 = new JButton("KEEP");
    private JButton keepButton2 = new JButton("KEEP");
    private JButton keepButton3 = new JButton("KEEP");
    private JButton keepButton4 = new JButton("KEEP");
    private JButton keepButton5 = new JButton("KEEP");
    private JButton keepButton6 = new JButton("KEEP");
    private JButton keepButton7 = new JButton("KEEP");
    private JButton keepButton8 = new JButton("KEEP");
    private JButton keepButton9 = new JButton("KEEP");
    private JButton keepButton10 = new JButton("KEEP");
    private JButton keepButton11 = new JButton("KEEP");
    private JButton keepButton12 = new JButton("KEEP");

    private JButton diceButton1 = new JButton();
    private JButton diceButton2 = new JButton();
    private JButton diceButton3 = new JButton();
    private JButton diceButton4 = new JButton();
    private JButton diceButton5 = new JButton();
    private JButton diceButton6 = new JButton();
    private JButton diceButton7 = new JButton();
    private JButton diceButton8 = new JButton();
    private JButton diceButton9 = new JButton();
    private JButton diceButton10 = new JButton();
    private JButton diceButton11 = new JButton();
    private JButton diceButton12 = new JButton();

    private JButton rollButton = new JButton("ROLL");
    private JButton scoreButton = new JButton("SCORE");
    private JButton mainMenuButton = new JButton("Main Menu");

    private boolean keepBool1, keepBool2, keepBool3, keepBool4, keepBool5, keepBool6, keepBool7, keepBool8, keepBool9, keepBool10, keepBool11, keepBool12 = false;

    public DiceRollFrame() throws IOException {
        initializeButtons();
        initializeDiceImages();
        initializeDiceButtons();
        players = new ArrayList<>();
        scoreButton.setVisible(false);
        buttonPanel.setLocation(10, 100);
        add(buttonPanel);
    }

    public DiceRollFrame(int players) throws IOException {
        this.players = new ArrayList<>();
        initializeButtons();
        initializeDiceImages();
        initializeDiceButtons();

        for(int i = 0; i < players; i++)
        {
            this.players.add(new Player(12, 12));
        }

        scoreButton.setVisible(false);
        buttonPanel.setLocation(10, 100);
        add(buttonPanel);
    }

    public DiceRollFrame(ArrayList<Player> players, int currentPlayer) throws IOException {
        initializeButtons();
        initializeDiceImages();
        initializeDiceButtons();
        this.players = players;
        activePlayer = currentPlayer;

        scoreButton.setVisible(false);
        buttonPanel.setLocation(10, 100);
        add(buttonPanel);
    }

    private void initializeButtons(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        Font buttonFont = new Font("Arial", Font.BOLD, 35);

        keepButton1.setBackground(Color.WHITE);
        keepButton2.setBackground(Color.WHITE);
        keepButton3.setBackground(Color.WHITE);
        keepButton4.setBackground(Color.WHITE);
        keepButton5.setBackground(Color.WHITE);
        keepButton6.setBackground(Color.WHITE);
        keepButton7.setBackground(Color.WHITE);
        keepButton8.setBackground(Color.WHITE);
        keepButton9.setBackground(Color.WHITE);
        keepButton10.setBackground(Color.WHITE);
        keepButton11.setBackground(Color.WHITE);
        keepButton12.setBackground(Color.WHITE);

        rollButton.setBackground(Color.WHITE);
        scoreButton.setBackground(Color.WHITE);
        mainMenuButton.setBackground(Color.WHITE);

        keepButton1.setForeground(Color.BLACK);
        keepButton2.setForeground(Color.BLACK);
        keepButton3.setForeground(Color.BLACK);
        keepButton4.setForeground(Color.BLACK);
        keepButton5.setForeground(Color.BLACK);
        keepButton6.setForeground(Color.BLACK);
        keepButton7.setForeground(Color.BLACK);
        keepButton8.setForeground(Color.BLACK);
        keepButton9.setForeground(Color.BLACK);
        keepButton10.setForeground(Color.BLACK);
        keepButton11.setForeground(Color.BLACK);
        keepButton12.setForeground(Color.BLACK);

        rollButton.setForeground(Color.BLACK);
        scoreButton.setForeground(Color.BLACK);
        mainMenuButton.setForeground(Color.BLACK);

        keepButton1.setBounds(200, 300, 200, 100);
        keepButton2.setBounds(600, 300, 200, 100);
        keepButton3.setBounds(950, 300, 200, 100);
        keepButton4.setBounds(1300, 300, 200, 100);
        keepButton5.setBounds(1650, 300, 200, 100);
        keepButton6.setBounds(2000, 300, 200, 100);
        keepButton7.setBounds(200, 750, 200, 100);
        keepButton8.setBounds(600, 750, 200, 100);
        keepButton9.setBounds(950, 750, 200, 100);
        keepButton10.setBounds(1300, 750, 200, 100);
        keepButton11.setBounds(1650, 750, 200, 100);
        keepButton12.setBounds(2000, 750, 200, 100);

        mainMenuButton.setBounds(400,1000, 270,100);
        rollButton.setBounds(1735, 1000, 200, 100);
        scoreButton.setBounds(1145, 960, 200, 100);

        keepButton1.setFont(buttonFont);
        keepButton2.setFont(buttonFont);
        keepButton3.setFont(buttonFont);
        keepButton4.setFont(buttonFont);
        keepButton5.setFont(buttonFont);
        keepButton6.setFont(buttonFont);
        keepButton7.setFont(buttonFont);
        keepButton8.setFont(buttonFont);
        keepButton9.setFont(buttonFont);
        keepButton10.setFont(buttonFont);
        keepButton11.setFont(buttonFont);
        keepButton12.setFont(buttonFont);

        mainMenuButton.setFont(buttonFont);
        rollButton.setFont(buttonFont);
        scoreButton.setFont(buttonFont);

        keepButton1.addActionListener(this);
        keepButton2.addActionListener(this);
        keepButton3.addActionListener(this);
        keepButton4.addActionListener(this);
        keepButton5.addActionListener(this);
        keepButton6.addActionListener(this);
        keepButton7.addActionListener(this);
        keepButton8.addActionListener(this);
        keepButton9.addActionListener(this);
        keepButton10.addActionListener(this);
        keepButton11.addActionListener(this);
        keepButton12.addActionListener(this);

        mainMenuButton.addActionListener(this);
        rollButton.addActionListener(this);
        scoreButton.addActionListener(this);

        buttonPanel.add(keepButton1);
        buttonPanel.add(keepButton2);
        buttonPanel.add(keepButton3);
        buttonPanel.add(keepButton4);
        buttonPanel.add(keepButton5);
        buttonPanel.add(keepButton6);
        buttonPanel.add(keepButton7);
        buttonPanel.add(keepButton8);
        buttonPanel.add(keepButton9);
        buttonPanel.add(keepButton10);
        buttonPanel.add(keepButton11);
        buttonPanel.add(keepButton12);

        buttonPanel.add(mainMenuButton);
        buttonPanel.add(rollButton);
        buttonPanel.add(scoreButton);
    }

    private void initializeDiceImages() throws  IOException{
        Image mario = ImageIO.read(new File("img/mario.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image luigi = ImageIO.read(new File("img/luigi.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image toad = ImageIO.read(new File("img/toad.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image princessPeach = ImageIO.read(new File("img/princessPeach.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image daisy = ImageIO.read(new File("img/daisy.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image rosalina = ImageIO.read(new File("img/rosalina.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image yoshi = ImageIO.read(new File("img/yoshi.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image donkeyKong = ImageIO.read(new File("img/donkeyKong.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image diddyKong = ImageIO.read(new File("img/diddyKong.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image wario = ImageIO.read(new File("img/wario.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image waluigi = ImageIO.read(new File("img/waluigi.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        Image bowser = ImageIO.read(new File("img/bowser.png")).getScaledInstance(200, 250, Image.SCALE_SMOOTH);

        diceImages.add(mario);
        diceImages.add(luigi);
        diceImages.add(toad);
        diceImages.add(princessPeach);
        diceImages.add(daisy);
        diceImages.add(rosalina);
        diceImages.add(yoshi);
        diceImages.add(donkeyKong);
        diceImages.add(diddyKong);
        diceImages.add(wario);
        diceImages.add(waluigi);
        diceImages.add(bowser);
    }

    private void initializeDiceButtons(){
        diceButton1.setBackground(Color.WHITE);
        diceButton2.setBackground(Color.WHITE);
        diceButton3.setBackground(Color.WHITE);
        diceButton4.setBackground(Color.WHITE);
        diceButton5.setBackground(Color.WHITE);
        diceButton6.setBackground(Color.WHITE);
        diceButton7.setBackground(Color.WHITE);
        diceButton8.setBackground(Color.WHITE);
        diceButton9.setBackground(Color.WHITE);
        diceButton10.setBackground(Color.WHITE);
        diceButton11.setBackground(Color.WHITE);
        diceButton12.setBackground(Color.WHITE);

        diceButton1.setBounds(200, 25, 200, 250);
        diceButton2.setBounds(600, 25, 200, 250);
        diceButton3.setBounds(950, 25, 200, 250);
        diceButton4.setBounds(1300, 25, 200, 250);
        diceButton5.setBounds(1650, 25, 200, 250);
        diceButton6.setBounds(2000, 25, 200, 250);
        diceButton7.setBounds(200, 475, 200, 250);
        diceButton8.setBounds(600, 475, 200, 250);
        diceButton9.setBounds(950, 475, 200, 250);
        diceButton10.setBounds(1300, 475, 200, 250);
        diceButton11.setBounds(1650, 475, 200, 250);
        diceButton12.setBounds(2000, 475, 200, 250);

        diceButton1.addActionListener(this);
        diceButton2.addActionListener(this);
        diceButton3.addActionListener(this);
        diceButton4.addActionListener(this);
        diceButton5.addActionListener(this);
        diceButton6.addActionListener(this);
        diceButton7.addActionListener(this);
        diceButton8.addActionListener(this);
        diceButton9.addActionListener(this);
        diceButton10.addActionListener(this);
        diceButton11.addActionListener(this);
        diceButton12.addActionListener(this);

        setDiceFace(diceButton1);
        setDiceFace(diceButton2);
        setDiceFace(diceButton3);
        setDiceFace(diceButton4);
        setDiceFace(diceButton5);
        setDiceFace(diceButton6);
        setDiceFace(diceButton7);
        setDiceFace(diceButton8);
        setDiceFace(diceButton9);
        setDiceFace(diceButton10);
        setDiceFace(diceButton11);
        setDiceFace(diceButton12);

        buttonPanel.add(diceButton1);
        buttonPanel.add(diceButton2);
        buttonPanel.add(diceButton3);
        buttonPanel.add(diceButton4);
        buttonPanel.add(diceButton5);
        buttonPanel.add(diceButton6);
        buttonPanel.add(diceButton7);
        buttonPanel.add(diceButton8);
        buttonPanel.add(diceButton9);
        buttonPanel.add(diceButton10);
        buttonPanel.add(diceButton11);
        buttonPanel.add(diceButton12);
    }

    private void setDiceFace(JButton button){
        Dice dice = new Dice(12);
        dice.rollDice();
        Image face = diceImages.get(dice.getCurValue() - 1);
        button.setIcon(new ImageIcon(face));

        diceHand.add(dice);
    }

    private void rollDice(){
        if(keepBool1 == false)
            setDiceFace(diceButton1);
        if(keepBool2 == false)
            setDiceFace(diceButton2);
        if(keepBool3 == false)
            setDiceFace(diceButton3);
        if(keepBool4 == false)
            setDiceFace(diceButton4);
        if(keepBool5 == false)
            setDiceFace(diceButton5);
        if(keepBool6 == false)
            setDiceFace(diceButton6);
        if(keepBool7 == false)
            setDiceFace(diceButton7);
        if(keepBool8 == false)
            setDiceFace(diceButton8);
        if(keepBool9 == false)
            setDiceFace(diceButton9);
        if(keepBool10 == false)
            setDiceFace(diceButton10);
        if(keepBool11 == false)
            setDiceFace(diceButton11);
        if(keepBool12 == false)
            setDiceFace(diceButton12);
    }

    public void runTurn(){
        if((turnCount == 2) || (keepBool1 && keepBool2 && keepBool3 && keepBool4 && keepBool5 && keepBool6
                && keepBool7 && keepBool8 && keepBool9 && keepBool10 && keepBool11 && keepBool12)){
            rollButton.setVisible(false);
            scoreButton.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if(button == mainMenuButton) {
            System.out.println("Main menu button clicked");
            TitleScreenFrame titleScreenFrame = new TitleScreenFrame();
            titleScreenFrame.setVisible(true);
            this.dispose();
        } else if (button == keepButton1){
            keepBool1 = !keepBool1;
            if(keepBool1 == true){
                diceButton1.setBackground(Color.DARK_GRAY);
            } else {
                diceButton1.setBackground(Color.WHITE);
            }
        } else if (button == keepButton2){
            keepBool2 = !keepBool2;
            if(keepBool2 == true){
                diceButton2.setBackground(Color.DARK_GRAY);
            } else{
                diceButton2.setBackground(Color.WHITE);
            }
        } else if (button == keepButton3){
            keepBool3 = !keepBool3;
            if(keepBool3 == true){
                diceButton3.setBackground(Color.DARK_GRAY);
            } else{
                diceButton3.setBackground(Color.WHITE);
            }
        } else if (button == keepButton4){
            keepBool4 = !keepBool4;
            if(keepBool4 == true){
                diceButton4.setBackground(Color.DARK_GRAY);
            } else{
                diceButton4.setBackground(Color.WHITE);
            }
        } else if (button == keepButton5){
            keepBool5 = !keepBool5;
            if(keepBool5 == true){
                diceButton5.setBackground(Color.DARK_GRAY);
            } else{
                diceButton5.setBackground(Color.WHITE);
            }
        } else if (button == keepButton6){
            keepBool6 = !keepBool6;
            if(keepBool6 == true){
                diceButton6.setBackground(Color.DARK_GRAY);
            } else{
                diceButton6.setBackground(Color.WHITE);
            }
        } else if (button == keepButton7){
            keepBool7 = !keepBool7;
            if(keepBool7 == true){
                diceButton7.setBackground(Color.DARK_GRAY);
            } else{
                diceButton7.setBackground(Color.WHITE);
            }
        } else if (button == keepButton8){
            keepBool8 = !keepBool8;
            if(keepBool8 == true){
                diceButton8.setBackground(Color.DARK_GRAY);
            } else{
                diceButton8.setBackground(Color.WHITE);
            }
        } else if (button == keepButton9){
            keepBool9 = !keepBool9;
            if(keepBool9 == true){
                diceButton9.setBackground(Color.DARK_GRAY);
            } else{
                diceButton9.setBackground(Color.WHITE);
            }
        } else if (button == keepButton10){
            keepBool10 = !keepBool10;
            if(keepBool10 == true){
                diceButton10.setBackground(Color.DARK_GRAY);
            } else{
                diceButton10.setBackground(Color.WHITE);
            }
        } else if (button == keepButton11){
            keepBool11 = !keepBool11;
            if(keepBool11 == true){
                diceButton11.setBackground(Color.DARK_GRAY);
            } else{
                diceButton11.setBackground(Color.WHITE);
            }
        } else if (button == keepButton12){
            keepBool12 = !keepBool12;
            if(keepBool12 == true){
                diceButton12.setBackground(Color.DARK_GRAY);
            } else{
                diceButton12.setBackground(Color.WHITE);
            }
        } else if(button == rollButton){
            System.out.println("Roll button clicked");
            turnCount++;
            rollDice();
            runTurn();
        } else if(button == scoreButton){
            System.out.println("Score button clicked");
            turnCount = 0;
            ScoreCardFrame scoreCardFrame = new ScoreCardFrame(players, activePlayer, diceHand);
            scoreCardFrame.setVisible(true);
            this.dispose();
        }
    }

    public class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel(BorderLayout b1) {
            super(b1);
            try{
                image = ImageIO.read(new File("img/diceRollBackground.png"));
            } catch (IOException ex) {
                System.out.println("Image not found DICE ROLL ");
                System.exit(1);
            }
        }

        public ImagePanel() {
            super();
            try {
                image = ImageIO.read(new File("img/diceRollBackground.png"));
            } catch (IOException ex) {
                System.out.println("Image not found DICE ROLL 2");
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