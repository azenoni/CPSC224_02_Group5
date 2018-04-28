import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreCardFrame extends JFrame implements ActionListener{

    private ArrayList<Player> arrayList;
    private int activePlayer;

    private final Font buttonFont = new Font("Arial", Font.BOLD, 30);
    private final Font titleFont = new Font("Arial", Font.BOLD, 80);
    private final Font instructionFont = new Font("Arial", Font.PLAIN, 18);

    private final int buttonWidth = 150;
    private final int buttonHeight = 40;
    private final int buttonDiff = 80;

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 1600;
    private static final int DEFAULT_HEIGHT = 800;

    private JButton saveButton = new JButton("SAVE");
    private JButton goodGuys = new JButton("Good Guys");
    private JButton princesses = new JButton("Princesses");
    private JButton animals = new JButton("Animals");
    private JButton badGuys = new JButton("Bad Guys");
    private JButton fiveOfAKind = new JButton("5 of a Kind");
    private JButton sevenOfAKind = new JButton("7 of a Kind");
    private JButton goodGuysRule = new JButton("<html>Good Guys <br>Rule</html>");
    private JButton badGuysSuck = new JButton("<html>Bad Guys <br>Suck</html>");
    private JButton superMario = new JButton("Super Mario");
    private JButton evilBowser = new JButton("Evil Bowser");
    private JButton animalKingdom = new JButton("<html>Animal <br>Kingdom</html>");
    private JButton marioParty = new JButton("Mario Party");


    private JLabel title = new JLabel("<html><strong>SCORECARD</strong></html>");
    private JLabel upperSection = new JLabel("<html><strong>Upper Section:</strong></html>");
    private JLabel lowerSection = new JLabel("<html><strong>Lower Section:</strong></html>");
    private JLabel howToScoreFirst = new JLabel("<html><strong>How to score:</strong></html>");
    private JLabel howToScoreSecond = new JLabel("<html><strong>How to score:</strong></html>");
    private JLabel player1Upper = new JLabel("<html><strong>Player 1:</strong></html>");
    private JLabel player2Upper = new JLabel("<html><strong>Player 2:</strong></html>");
    private JLabel player3Upper = new JLabel("<html><strong>Player 3:</strong></html>");
    private JLabel player4Upper = new JLabel("<html><strong>Player 4:</strong></html>");
    private JLabel player1Lower = new JLabel("<html><strong>Player 1:</strong></html>");
    private JLabel player2Lower = new JLabel("<html><strong>Player 2:</strong></html>");
    private JLabel player3Lower = new JLabel("<html><strong>Player 3:</strong></html>");
    private JLabel player4Lower = new JLabel("<html><strong>Player 4:</strong></html>");
    private JLabel goodGuyDescription = new JLabel("<html>20 points for each <br>good guy character</html>");
    private JLabel princessesDescription = new JLabel("<html>15 points for each <br>princess character</html>");
    private JLabel animalsDescription = new JLabel("<html>10 points for each <br>animal character</html>");
    private JLabel badGuysDescription = new JLabel("<html>5 points for each <br>bad guy character</html>");
    private JLabel fiveOfAKindDescription = new JLabel("<html>Points of \"like\" characters multiplied by 5</html>");
    private JLabel sevenOfAKindDescription = new JLabel("<html>Points of \"like\" characters multiplied by 7</html>");
    private JLabel goodGuysRuleDescription = new JLabel("35 points");
    private JLabel badGuysSuckDescription = new JLabel("-10 points");
    private JLabel superMarioDescription = new JLabel("100 points");
    private JLabel evilBowserDescription = new JLabel("-50 points");
    private JLabel animalKingdomDescription = new JLabel("50 points");
    private JLabel marioPartyDescription = new JLabel("Sum of all dice");
    private JLabel firstArrow = new JLabel("--------------------->");
    private JLabel secondArrow = new JLabel("--------------------->");
    private JLabel upperSectionArrow = new JLabel("--------------------->");
    private JLabel lowerSectionArrow = new JLabel("--------------------->");
    private JLabel grandTotalArrow = new JLabel("--------------------->");
    private JLabel bonusDescription = new JLabel("45 points");
    private JLabel total = new JLabel("Total");
    private JLabel secondTotal = new JLabel("Total");
    private JLabel bonus = new JLabel("Bonus");
    private JLabel upperSectionTotal = new JLabel("<html>Upper Section <br>Total</html>");
    private JLabel lowerSectionTotal = new JLabel("<html>Lower Section <br>Total</html>");
    private JLabel grandTotal = new JLabel("GRAND TOTAL");




    public ScoreCardFrame(ArrayList<Player> arrayList, int activePlayer, ArrayList<Dice> diceHand) {
        this.arrayList = arrayList;
        this.activePlayer = activePlayer;
        initializeTitleAndSaveButton();
        initializeUpperScorecardGraphics();
        initializeLowerScorecardGraphics();
        displayPlayerUpperValues();
        displayPlayerLowerValues();
        updateTextColors();
//        for(int i = 0; i < arrayList.size(); i++) {
//            if(i == activePlayer) {
//                arrayList.get(i).getScoreCard().setDiceHand(diceHand);
//            } else {
//                arrayList.get(i).getScoreCard().setDiceHand(new ArrayList<>());
//            }
//            arrayList.get(i).getScoreCard().calculatePossibleValues();
//        }

        buttonPanel.setLocation(10,100);
        add(buttonPanel);
    }


    private void initializeTitleAndSaveButton() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        saveButton.setBackground(Color.WHITE);

        title.setBounds(25,0,800,100);
        saveButton.setBounds(0,650, 150,50);

        saveButton.setOpaque(false);
        saveButton.setBorderPainted(false);
        saveButton.setContentAreaFilled(false);
        saveButton.setFont(buttonFont);
        saveButton.setForeground(Color.WHITE);
        saveButton.addActionListener(this);

        title.setForeground(Color.WHITE);
        title.setFont(titleFont);

        buttonPanel.add(title);
        buttonPanel.add(saveButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ScoreCard scoreCard = arrayList.get(activePlayer).getScoreCard();
        if(e.getSource() == saveButton) {
            System.out.println("save button clicked");
        } else if(e.getSource() == goodGuys) {
            scoreCard.getUpperScorecard().getGoodGuys().setUsed(true);
            System.out.println("goodguys button clicked");
        } else if(e.getSource() == princesses) {
            scoreCard.getUpperScorecard().getPrincesses().setUsed(true);
            System.out.println("princesses clicked");
        } else if(e.getSource() == animals) {
            scoreCard.getUpperScorecard().getAnimals().setUsed(true);
            System.out.println("animals clicked");
        } else if(e.getSource() == badGuys) {
            scoreCard.getUpperScorecard().getBadGuys().setUsed(true);
            System.out.println("badguys clicked");
        } else if(e.getSource() == fiveOfAKind) {
            scoreCard.getLowerScorecard().getFiveOfAKind().setUsed(true);
            System.out.println("fiveofakind clicked");
        } else if(e.getSource() == sevenOfAKind) {
            scoreCard.getLowerScorecard().getSevenOfAKind().setUsed(true);
            System.out.println("sevenofakind clicked");
        } else if(e.getSource() == goodGuysRule) {
            scoreCard.getLowerScorecard().getGoodGuysRule().setUsed(true);
            System.out.println("goodguysrule clicked");
        } else if(e.getSource() == badGuysSuck) {
            scoreCard.getLowerScorecard().getBadGuysSuck().setUsed(true);
            System.out.println("badguyssuck clicked");
        } else if(e.getSource() == superMario) {
            scoreCard.getLowerScorecard().getSuperMario().setUsed(true);
            System.out.println("supermario clicked");
        } else if(e.getSource() == evilBowser) {
            scoreCard.getLowerScorecard().getEvilBowser().setUsed(true);
            System.out.println("evilbowser clicked");
        } else if(e.getSource() == animalKingdom) {
            scoreCard.getLowerScorecard().getAnimalKingdom().setUsed(true);
            System.out.println("animalkingdom clicked");
        } else if(e.getSource() == marioParty) {
            scoreCard.getLowerScorecard().getMarioParty().setUsed(true);
            System.out.println("marioparty clicked");
        }
    }

    private void displayPlayerUpperValues() {
        //for the upper values
        for(int i = 0; i < arrayList.size(); i++) {
            JLabel goodGuys = new JLabel("" + arrayList.get(i).getScoreCard().getUpperScorecard().getGoodGuys().getCurValue());
            goodGuys.setBounds(325+(100*i),150,100,50);
            goodGuys.setForeground(Color.WHITE);
            goodGuys.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getUpperScorecard().getGoodGuys().isUsed()) {
                goodGuys.setForeground(Color.GREEN);
            }
            buttonPanel.add(goodGuys);

            JLabel princesses = new JLabel("" + arrayList.get(i).getScoreCard().getUpperScorecard().getPrincesses().getCurValue());
            princesses.setBounds(325+(100*i),230,100,50);
            princesses.setForeground(Color.WHITE);
            princesses.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getUpperScorecard().getPrincesses().isUsed()) {
                princesses.setForeground(Color.GREEN);
            }
            buttonPanel.add(princesses);

            JLabel animals = new JLabel("" + arrayList.get(i).getScoreCard().getUpperScorecard().getAnimals().getCurValue());
            animals.setBounds(325+(100*i),310,100,50);
            animals.setForeground(Color.WHITE);
            animals.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getUpperScorecard().getAnimals().isUsed()) {
                animals.setForeground(Color.GREEN);
            }
            buttonPanel.add(animals);

            JLabel badGuys = new JLabel("" + arrayList.get(i).getScoreCard().getUpperScorecard().getBadGuys().getCurValue());
            badGuys.setBounds(325+(100*i),400,100,50);
            badGuys.setForeground(Color.WHITE);
            badGuys.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getUpperScorecard().getBadGuys().isUsed()) {
                badGuys.setForeground(Color.GREEN);
            }
            buttonPanel.add(badGuys);

            JLabel firstTotal = new JLabel("" + arrayList.get(i).getScoreCard().getUpperScorecard().getUpperSum());
            firstTotal.setBounds(325+(100*i),450,100,50);
            firstTotal.setForeground(Color.WHITE);
            firstTotal.setFont(instructionFont);
            buttonPanel.add(firstTotal);

            int bonusVal = 0;
            if(arrayList.get(i).getScoreCard().getUpperScorecard().isHasBonus()) {
                bonusVal = 45;
            }
            JLabel bonus = new JLabel("" + bonusVal);
            bonus.setBounds(325+(100*i),500,100,50);
            bonus.setForeground(Color.WHITE);
            bonus.setFont(instructionFont);
            buttonPanel.add(bonus);

            JLabel secondTotal = new JLabel("" + arrayList.get(i).getScoreCard().getUpperScorecard().getUpperTotal());
            secondTotal.setBounds(325+(100*i),540,100,50);
            secondTotal.setForeground(Color.WHITE);
            secondTotal.setFont(instructionFont);
            buttonPanel.add(secondTotal);
        }
    }

    private void displayPlayerLowerValues() {
        for(int i = 0; i < arrayList.size(); i++) {
            JLabel fiveOfAKind = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getFiveOfAKind().getCurValue());
            fiveOfAKind.setBounds(1060+(100*i),125,100,50);
            fiveOfAKind.setForeground(Color.WHITE);
            fiveOfAKind.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getFiveOfAKind().isUsed()) {
                fiveOfAKind.setForeground(Color.GREEN);
            }
            buttonPanel.add(fiveOfAKind);

            JLabel sevenOfAKind = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getSevenOfAKind().getCurValue());
            sevenOfAKind.setBounds(1060+(100*i),230,100,50);
            sevenOfAKind.setForeground(Color.WHITE);
            sevenOfAKind.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getSevenOfAKind().isUsed()) {
                sevenOfAKind.setForeground(Color.GREEN);
            }
            buttonPanel.add(sevenOfAKind);

            JLabel goodGuysRule = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getGoodGuysRule().getCurValue());
            goodGuysRule.setBounds(1060+(100*i),310,100,50);
            goodGuysRule.setForeground(Color.WHITE);
            goodGuysRule.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getGoodGuysRule().isUsed()) {
                goodGuysRule.setForeground(Color.GREEN);
            }
            buttonPanel.add(goodGuysRule);

            JLabel badGuysSuck = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getBadGuysSuck().getCurValue());
            badGuysSuck.setBounds(1060+(100*i),350,100,50);
            badGuysSuck.setForeground(Color.WHITE);
            badGuysSuck.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getBadGuysSuck().isUsed()) {
                badGuysSuck.setForeground(Color.GREEN);
            }
            buttonPanel.add(badGuysSuck);

            JLabel superMario = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getSuperMario().getCurValue());
            superMario.setBounds(1060+(100*i),400,100,50);
            superMario.setForeground(Color.WHITE);
            superMario.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getSuperMario().isUsed()) {
                superMario.setForeground(Color.GREEN);
            }
            buttonPanel.add(superMario);

            JLabel evilBowser = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getEvilBowser().getCurValue());
            evilBowser.setBounds(1060+(100*i),450,100,50);
            evilBowser.setForeground(Color.WHITE);
            evilBowser.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getEvilBowser().isUsed()) {
                evilBowser.setForeground(Color.GREEN);
            }
            buttonPanel.add(evilBowser);

            JLabel animalKingdom = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getAnimalKingdom().getCurValue());
            animalKingdom.setBounds(1060+(100*i),500,100,50);
            animalKingdom.setForeground(Color.WHITE);
            animalKingdom.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getAnimalKingdom().isUsed()) {
                animalKingdom.setForeground(Color.GREEN);
            }
            buttonPanel.add(animalKingdom);

            JLabel marioParty = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getMarioParty().getCurValue());
            marioParty.setBounds(1060+(100*i),550,100,50);
            marioParty.setForeground(Color.WHITE);
            marioParty.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getMarioParty().isUsed()) {
                marioParty.setForeground(Color.GREEN);
            }
            buttonPanel.add(marioParty);


            JLabel upperTotal = new JLabel("" + arrayList.get(i).getScoreCard().getUpperScorecard().getUpperTotal());
            upperTotal.setBounds(1060+(100*i),600,100,50);
            upperTotal.setForeground(Color.WHITE);
            upperTotal.setFont(instructionFont);
            buttonPanel.add(upperTotal);

            JLabel lowerTotal = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getLowerTotal());
            lowerTotal.setBounds(1060+(100*i),650,100,50);
            lowerTotal.setForeground(Color.WHITE);
            lowerTotal.setFont(instructionFont);
            buttonPanel.add(lowerTotal);

            int total = arrayList.get(i).getScoreCard().getLowerScorecard().getLowerTotal() + arrayList.get(i).getScoreCard().getUpperScorecard().getUpperTotal();
            JLabel grandTotal = new JLabel("" + total);
            grandTotal.setBounds(1060+(100*i),700,100,50);
            grandTotal.setForeground(Color.WHITE);
            grandTotal.setFont(instructionFont);
            buttonPanel.add(grandTotal);
        }
    }

    private void updateTextColors() {
        ScoreCard scoreCard = arrayList.get(activePlayer).getScoreCard();
        if(scoreCard.getUpperScorecard().getGoodGuys().isUsed()) {
            goodGuys.setEnabled(false);
            goodGuys.setForeground(Color.GREEN);
        }
        if(scoreCard.getUpperScorecard().getPrincesses().isUsed()) {
            princesses.setEnabled(false);
            princesses.setForeground(Color.GREEN);
        }
        if(scoreCard.getUpperScorecard().getAnimals().isUsed()) {
            animals.setEnabled(false);
            animals.setForeground(Color.GREEN);
        }
        if(scoreCard.getUpperScorecard().getBadGuys().isUsed()) {
            badGuys.setEnabled(false);
            badGuys.setForeground(Color.GREEN);
        }
        if(scoreCard.getLowerScorecard().getFiveOfAKind().isUsed()) {
            fiveOfAKind.setEnabled(false);
            fiveOfAKind.setForeground(Color.GREEN);
        }
        if(scoreCard.getLowerScorecard().getSevenOfAKind().isUsed()) {
            sevenOfAKind.setEnabled(false);
            sevenOfAKind.setForeground(Color.GREEN);
        }
        if(scoreCard.getLowerScorecard().getGoodGuysRule().isUsed()) {
            goodGuysRule.setEnabled(false);
            goodGuysRule.setForeground(Color.GREEN);
        }
        if(scoreCard.getLowerScorecard().getBadGuysSuck().isUsed()) {
            badGuysSuck.setEnabled(false);
            badGuysSuck.setForeground(Color.GREEN);
        }
        if(scoreCard.getLowerScorecard().getSuperMario().isUsed()) {
            superMario.setEnabled(false);
            superMario.setForeground(Color.GREEN);
        }
        if(scoreCard.getLowerScorecard().getEvilBowser().isUsed()) {
            evilBowser.setEnabled(false);
            evilBowser.setForeground(Color.GREEN);
        }
        if(scoreCard.getLowerScorecard().getAnimalKingdom().isUsed()) {
            animalKingdom.setEnabled(false);
            animalKingdom.setForeground(Color.GREEN);
        }
        if(scoreCard.getLowerScorecard().getMarioParty().isUsed()) {
            marioParty.setEnabled(false);
            marioParty.setForeground(Color.GREEN);
        }
    }


    private void initializeUpperScorecardGraphics() {
        int upperButtonStart = 150;
        upperSection.setBounds(25, 100, 150, 50);
        goodGuys.setBounds(25,upperButtonStart,buttonWidth,buttonHeight);
        princesses.setBounds(25,upperButtonStart+(buttonDiff*1),buttonWidth,buttonHeight);
        animals.setBounds(25,upperButtonStart+(buttonDiff*2),buttonWidth,buttonHeight);
        badGuys.setBounds(25,upperButtonStart+(buttonDiff*3),buttonWidth,buttonHeight);
        total.setBounds(25,430,100,100);
        bonus.setBounds(25,470,100,100);
        secondTotal.setBounds(25,510,100,100);

        goodGuyDescription.setBounds(175,upperButtonStart,150,80);
        princessesDescription.setBounds(175,upperButtonStart+(buttonDiff*1),150,80);
        animalsDescription.setBounds(175,upperButtonStart+(buttonDiff*2),150,80);
        badGuysDescription.setBounds(175,upperButtonStart+(buttonDiff*3),150,80);
        firstArrow.setBounds(175,460,150,50);
        bonusDescription.setBounds(175,500,100,50);
        secondArrow.setBounds(175,530,150,50);

        howToScoreFirst.setBounds(175, 100, 150, 50);
        player1Upper.setBounds(325,100,100,50);
        player2Upper.setBounds(425,100,100,50);
        player3Upper.setBounds(525,100,100,50);
        player4Upper.setBounds(625,100,100,50);

        goodGuys.setOpaque(false);
        goodGuys.setBorderPainted(false);
        goodGuys.setContentAreaFilled(false);
        goodGuys.setFont(instructionFont);
        goodGuys.addActionListener(this);

        princesses.setOpaque(false);
        princesses.setBorderPainted(false);
        princesses.setContentAreaFilled(false);
        princesses.setFont(instructionFont);
        princesses.addActionListener(this);

        animals.setOpaque(false);
        animals.setBorderPainted(false);
        animals.setContentAreaFilled(false);
        animals.setFont(instructionFont);
        animals.addActionListener(this);

        badGuys.setOpaque(false);
        badGuys.setBorderPainted(false);
        badGuys.setContentAreaFilled(false);
        badGuys.setFont(instructionFont);
        badGuys.addActionListener(this);

        goodGuys.setForeground(Color.WHITE);
        princesses.setForeground(Color.WHITE);
        animals.setForeground(Color.WHITE);
        badGuys.setForeground(Color.WHITE);
        fiveOfAKind.setForeground(Color.WHITE);
        sevenOfAKind.setForeground(Color.WHITE);
        goodGuysRule.setForeground(Color.WHITE);
        badGuysSuck.setForeground(Color.WHITE);
        superMario.setForeground(Color.WHITE);
        evilBowser.setForeground(Color.WHITE);
        animalKingdom.setForeground(Color.WHITE);
        marioParty.setForeground(Color.WHITE);
        goodGuyDescription.setForeground(Color.WHITE);
        princessesDescription.setForeground(Color.WHITE);
        animalsDescription.setForeground(Color.WHITE);
        badGuysDescription.setForeground(Color.WHITE);
        fiveOfAKindDescription.setForeground(Color.WHITE);
        sevenOfAKindDescription.setForeground(Color.WHITE);
        goodGuysRuleDescription.setForeground(Color.WHITE);
        badGuysSuckDescription.setForeground(Color.WHITE);
        superMarioDescription.setForeground(Color.WHITE);
        evilBowserDescription.setForeground(Color.WHITE);
        animalKingdomDescription.setForeground(Color.WHITE);
        marioPartyDescription.setForeground(Color.WHITE);
        firstArrow.setForeground(Color.WHITE);
        secondArrow.setForeground(Color.WHITE);
        total.setForeground(Color.WHITE);
        secondTotal.setForeground(Color.WHITE);
        bonus.setForeground(Color.WHITE);
        bonusDescription.setForeground(Color.WHITE);
        upperSectionTotal.setForeground(Color.WHITE);
        lowerSectionTotal.setForeground(Color.WHITE);
        grandTotal.setForeground(Color.WHITE);
        upperSection.setForeground(Color.WHITE);
        howToScoreFirst.setForeground(Color.WHITE);
        player1Upper.setForeground(Color.WHITE);
        player2Upper.setForeground(Color.WHITE);
        player3Upper.setForeground(Color.WHITE);
        player4Upper.setForeground(Color.WHITE);

        upperSection.setFont(instructionFont);
        goodGuys.setFont(instructionFont);
        princesses.setFont(instructionFont);
        animals.setFont(instructionFont);
        badGuys.setFont(instructionFont);
        total.setFont(instructionFont);
        bonus.setFont(instructionFont);
        secondTotal.setFont(instructionFont);
        firstArrow.setFont(instructionFont);
        secondArrow.setFont(instructionFont);


        howToScoreFirst.setFont(instructionFont);
        player1Upper.setFont(instructionFont);
        player2Upper.setFont(instructionFont);
        player3Upper.setFont(instructionFont);
        player4Upper.setFont(instructionFont);

        buttonPanel.add(upperSection);
        buttonPanel.add(goodGuys);
        buttonPanel.add(princesses);
        buttonPanel.add(animals);
        buttonPanel.add(badGuys);
        buttonPanel.add(total);
        buttonPanel.add(bonus);
        buttonPanel.add(secondTotal);

        buttonPanel.add(goodGuyDescription);
        buttonPanel.add(princessesDescription);
        buttonPanel.add(animalsDescription);
        buttonPanel.add(badGuysDescription);
        buttonPanel.add(firstArrow);
        buttonPanel.add(bonusDescription);
        buttonPanel.add(secondArrow);

        buttonPanel.add(howToScoreFirst);
        buttonPanel.add(player1Upper);
        buttonPanel.add(player2Upper);
        buttonPanel.add(player3Upper);
        buttonPanel.add(player4Upper);
    }

    private void initializeLowerScorecardGraphics() {
        lowerSection.setBounds(750,50,100,50);
        howToScoreSecond.setBounds(900,50,100,50);

        fiveOfAKind.setBounds(750,100,150,100);
        sevenOfAKind.setBounds(750,200,150,100);
        goodGuysRule.setBounds(750,300,150,50);
        badGuysSuck.setBounds(750,350,150,50);
        superMario.setBounds(750,400,150,50);
        evilBowser.setBounds(750,450,150,50);
        animalKingdom.setBounds(750,500,150,50);
        marioParty.setBounds(750,550,150,50);
        upperSectionTotal.setBounds(750,600,150,50);
        lowerSectionTotal.setBounds(750,650,150,50);
        grandTotal.setBounds(750,700,150,50);

        fiveOfAKindDescription.setBounds(900,100,150,100);
        sevenOfAKindDescription.setBounds(900,200,150,100);
        goodGuysRuleDescription.setBounds(900,300,150,50);
        badGuysSuckDescription.setBounds(900,350,150,50);
        superMarioDescription.setBounds(900,400,150,50);
        evilBowserDescription.setBounds(900,450,150,50);
        animalKingdomDescription.setBounds(900,500,150,50);
        marioPartyDescription.setBounds(900,550,150,50);
        upperSectionArrow.setBounds(900,600,150,50);
        lowerSectionArrow.setBounds(900,650,150,50);
        grandTotalArrow.setBounds(900,700,150,50);

        player1Lower.setBounds(1060,50,100,50);
        player2Lower.setBounds(1160,50,100,50);
        player3Lower.setBounds(1260,50,100,50);
        player4Lower.setBounds(1360,50,100,50);

        fiveOfAKind.setOpaque(false);
        fiveOfAKind.setBorderPainted(false);
        fiveOfAKind.setContentAreaFilled(false);
        fiveOfAKind.setFont(instructionFont);
        fiveOfAKind.setHorizontalTextPosition(SwingConstants.LEFT);
        fiveOfAKind.addActionListener(this);

        sevenOfAKind.setOpaque(false);
        sevenOfAKind.setBorderPainted(false);
        sevenOfAKind.setContentAreaFilled(false);
        sevenOfAKind.setFont(instructionFont);
        sevenOfAKind.setHorizontalTextPosition(SwingConstants.LEFT);
        sevenOfAKind.addActionListener(this);

        goodGuysRule.setOpaque(false);
        goodGuysRule.setBorderPainted(false);
        goodGuysRule.setContentAreaFilled(false);
        goodGuysRule.setFont(instructionFont);
        goodGuysRule.setHorizontalTextPosition(SwingConstants.LEFT);
        goodGuysRule.addActionListener(this);

        badGuysSuck.setOpaque(false);
        badGuysSuck.setBorderPainted(false);
        badGuysSuck.setContentAreaFilled(false);
        badGuysSuck.setFont(instructionFont);
        badGuysSuck.setHorizontalTextPosition(SwingConstants.LEFT);
        badGuysSuck.addActionListener(this);

        superMario.setOpaque(false);
        superMario.setBorderPainted(false);
        superMario.setContentAreaFilled(false);
        superMario.setFont(instructionFont);
        superMario.setHorizontalTextPosition(SwingConstants.LEFT);
        superMario.addActionListener(this);

        evilBowser.setOpaque(false);
        evilBowser.setBorderPainted(false);
        evilBowser.setContentAreaFilled(false);
        evilBowser.setFont(instructionFont);
        evilBowser.setHorizontalTextPosition(SwingConstants.LEFT);
        evilBowser.addActionListener(this);

        animalKingdom.setOpaque(false);
        animalKingdom.setBorderPainted(false);
        animalKingdom.setContentAreaFilled(false);
        animalKingdom.setFont(instructionFont);
        animalKingdom.setHorizontalTextPosition(SwingConstants.LEFT);
        animalKingdom.addActionListener(this);

        marioParty.setOpaque(false);
        marioParty.setBorderPainted(false);
        marioParty.setContentAreaFilled(false);
        marioParty.setFont(instructionFont);
        marioParty.setHorizontalTextPosition(SwingConstants.LEFT);
        marioParty.addActionListener(this);

        howToScoreSecond.setFont(instructionFont);
        lowerSection.setFont(instructionFont);
        player1Lower.setFont(instructionFont);
        player2Lower.setFont(instructionFont);
        player3Lower.setFont(instructionFont);
        player4Lower.setFont(instructionFont);
        lowerSectionTotal.setFont(instructionFont);
        upperSectionTotal.setFont(instructionFont);
        grandTotal.setFont(instructionFont);
        upperSectionArrow.setFont(instructionFont);
        lowerSectionArrow.setFont(instructionFont);
        grandTotalArrow.setFont(instructionFont);

        howToScoreSecond.setForeground(Color.WHITE);
        player1Lower.setForeground(Color.WHITE);
        player2Lower.setForeground(Color.WHITE);
        player3Lower.setForeground(Color.WHITE);
        player4Lower.setForeground(Color.WHITE);
        fiveOfAKind.setForeground(Color.WHITE);
        fiveOfAKindDescription.setForeground(Color.WHITE);
        sevenOfAKind.setForeground(Color.WHITE);
        sevenOfAKindDescription.setForeground(Color.WHITE);
        goodGuysRule.setForeground(Color.WHITE);
        goodGuysRuleDescription.setForeground(Color.WHITE);
        badGuysSuck.setForeground(Color.WHITE);
        badGuysSuckDescription.setForeground(Color.WHITE);
        superMario.setForeground(Color.WHITE);
        superMarioDescription.setForeground(Color.WHITE);
        evilBowser.setForeground(Color.WHITE);
        evilBowserDescription.setForeground(Color.WHITE);
        animalKingdom.setForeground(Color.WHITE);
        animalKingdomDescription.setForeground(Color.WHITE);
        marioParty.setForeground(Color.WHITE);
        marioPartyDescription.setForeground(Color.WHITE);
        upperSectionTotal.setForeground(Color.WHITE);
        lowerSectionTotal.setForeground(Color.WHITE);
        grandTotal.setForeground(Color.WHITE);
        lowerSection.setForeground(Color.WHITE);
        upperSectionArrow.setForeground(Color.WHITE);
        lowerSectionArrow.setForeground(Color.WHITE);
        grandTotalArrow.setForeground(Color.WHITE);

        buttonPanel.add(howToScoreSecond);
        buttonPanel.add(lowerSection);
        buttonPanel.add(player1Lower);
        buttonPanel.add(player2Lower);
        buttonPanel.add(player3Lower);
        buttonPanel.add(player4Lower);
        buttonPanel.add(fiveOfAKind);
        buttonPanel.add(fiveOfAKindDescription);
        buttonPanel.add(sevenOfAKind);
        buttonPanel.add(sevenOfAKindDescription);
        buttonPanel.add(goodGuysRule);
        buttonPanel.add(goodGuysRuleDescription);
        buttonPanel.add(badGuysSuck);
        buttonPanel.add(badGuysSuckDescription);
        buttonPanel.add(superMario);
        buttonPanel.add(superMarioDescription);
        buttonPanel.add(evilBowser);
        buttonPanel.add(evilBowserDescription);
        buttonPanel.add(animalKingdom);
        buttonPanel.add(animalKingdomDescription);
        buttonPanel.add(marioParty);
        buttonPanel.add(marioPartyDescription);
        buttonPanel.add(upperSectionTotal);
        buttonPanel.add(lowerSectionTotal);
        buttonPanel.add(grandTotal);
        buttonPanel.add(upperSectionArrow);
        buttonPanel.add(lowerSectionArrow);
        buttonPanel.add(grandTotalArrow);
    }

    public class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel(BorderLayout bl) {
            super(bl);
            try {
                image = ImageIO.read(new File("img/underground_scorecard.png"));
            } catch (IOException ex) {
                System.out.println("Image not found");
                System.exit(1);
            }
        }

        public ImagePanel() {
            try {
                image = ImageIO.read(new File("img/underground_scorecard.png"));
            } catch (IOException ex) {
                System.out.println("Image not found");
                System.exit(1);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image.getScaledInstance(1600, 800, Image. SCALE_SMOOTH), 0, 0, this);
            g.setColor(Color.RED);
            drawGridUpper(g);
            drawGridLower(g);
        }

        private void drawGridUpper(Graphics g) {
            //vertical lines
            for(int i = 320; i <= 720; i+=100) {
                g.drawLine(i,100,i,580);
            }
            g.drawLine(20,100,20,580);
            g.drawLine(170,100,170,580);

            //hoizontal lines
            for(int i = 140; i <= 460; i+=80) {
                g.drawLine(20,i,720,i);
            }
            g.drawLine(20,100,720,100);
            for(int i = 500; i < 620; i+= 40) {
                g.drawLine(20,i,720,i);
            }
        }

        private void drawGridLower(Graphics g) {
            g.drawLine(740,50,1450,50);
            for(int i = 100; i <= 300; i+=100) {
                g.drawLine(740,i,1450,i);

            }
            for(int i = 350; i <= 750; i+=50) {
                g.drawLine(740,i,1450,i);
            }
            g.drawLine(740,50,740,750);
            for(int i = 890; i <= 1050; i+= 150) {
                g.drawLine(i,50,i,750);
                i+=10;
            }

            for(int i = 1150; i <= 1450; i+=100) {
                g.drawLine(i,50,i,750);
            }
        }

    }
}
