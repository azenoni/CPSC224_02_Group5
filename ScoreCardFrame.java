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
    private ArrayList<Dice> diceHand;

    private final Font buttonFont = new Font("Arial", Font.BOLD, 45);
    private final Font titleFont = new Font("Arial", Font.BOLD, 120);
    private final Font instructionFont = new Font("Arial", Font.PLAIN, 28);

    private final int buttonWidth = 225;
    private final int buttonHeight = 60;
    private final int buttonDiff = 120;

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 2400;
    private static final int DEFAULT_HEIGHT = 1350;

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

    private JLabel title = new JLabel("<html><strong>PLAYER 1</strong></html>");
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
    private JLabel badGuysSuckDescription = new JLabel("-20 points");
    private JLabel superMarioDescription = new JLabel("100 points");
    private JLabel evilBowserDescription = new JLabel("<html>-50 points from every <br>other player</html>");
    private JLabel animalKingdomDescription = new JLabel("50 points");
    private JLabel marioPartyDescription = new JLabel("Sum of all dice");
    private JLabel firstArrow = new JLabel("------------------>");
    private JLabel secondArrow = new JLabel("------------------>");
    private JLabel upperSectionArrow = new JLabel("------------------>");
    private JLabel lowerSectionArrow = new JLabel("------------------>");
    private JLabel grandTotalArrow = new JLabel("------------------>");
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
        this.diceHand = diceHand;

        resetUnusedValues();
        arrayList.get(activePlayer).getScoreCard().setDiceHand(this.diceHand);
        arrayList.get(activePlayer).getScoreCard().calculatePossibleValues();

        initializeTitleAndSaveButton();
        initializeUpperScorecardGraphics();
        initializeLowerScorecardGraphics();
        if(activePlayer == 1) {
            title.setText("<html><strong>PLAYER 2</strong></html>");
        } else if(activePlayer == 2) {
            title.setText("<html><strong>PLAYER 3</strong></html>");
        } else if(activePlayer == 3) {
            title.setText("<html><strong>PLAYER 4</strong></html>");
        }
        displayPlayerUpperValues();
        displayPlayerLowerValues();

        updateTextColors();

        buttonPanel.setLocation(10,100);
        add(buttonPanel);
    }


    private void initializeTitleAndSaveButton() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new ImagePanel();
        buttonPanel.setLayout(null);

        saveButton.setBackground(Color.WHITE);

        title.setBounds(38,0,1200,150);
        saveButton.setBounds(30,975, 200,100);

        saveButton.setOpaque(true);
        saveButton.setBorderPainted(true);
        saveButton.setContentAreaFilled(true);
        saveButton.setFont(buttonFont);
        saveButton.setForeground(Color.BLACK);
        saveButton.addActionListener(this);

        title.setForeground(Color.WHITE);
        title.setFont(titleFont);

        buttonPanel.add(title);
        buttonPanel.add(saveButton);
    }


    private void resetUnusedValues() {
        for(Player player : arrayList) {
            ScoreCard scoreCard = player.getScoreCard();
            scoreCard.getUpperScorecard().resetUnusedValues();
            scoreCard.getLowerScorecard().resetUnusedValues();
        }
    }
    private void revertBackToOriginal() {
        ScoreCard scoreCard = arrayList.get(activePlayer).getScoreCard();
        scoreCard.getUpperScorecard().getGoodGuys().setUsed(false);
        scoreCard.getUpperScorecard().getPrincesses().setUsed(false);
        scoreCard.getUpperScorecard().getAnimals().setUsed(false);
        scoreCard.getUpperScorecard().getBadGuys().setUsed(false);
        scoreCard.getLowerScorecard().getFiveOfAKind().setUsed(false);
        scoreCard.getLowerScorecard().getSevenOfAKind().setUsed(false);
        scoreCard.getLowerScorecard().getGoodGuysRule().setUsed(false);
        scoreCard.getLowerScorecard().getBadGuysSuck().setUsed(false);
        scoreCard.getLowerScorecard().getSuperMario().setUsed(false);
        scoreCard.getLowerScorecard().getEvilBowser().setUsed(false);
        scoreCard.getLowerScorecard().getAnimalKingdom().setUsed(false);
        scoreCard.getLowerScorecard().getMarioParty().setUsed(false);

        goodGuys.setForeground(Color.WHITE);
        princesses.setForeground(Color.WHITE);
        animals.setForeground(Color.WHITE);
        badGuys.setForeground(Color.WHITE);
        fiveOfAKind.setForeground(Color.WHITE);
        sevenOfAKind.setForeground(Color.WHITE);
        superMario.setForeground(Color.WHITE);
        evilBowser.setForeground(Color.WHITE);
        animalKingdom.setForeground(Color.WHITE);
        marioParty.setForeground(Color.WHITE);
        goodGuysRule.setForeground(Color.WHITE);
        badGuysSuck.setForeground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ScoreCard scoreCard = arrayList.get(activePlayer).getScoreCard();
        if(e.getSource() == saveButton) {
            if((activePlayer == (arrayList.size() - 1)) && !arrayList.get(arrayList.size() - 1).getScoreCard().hasFieldsRemaining()) {
                //push to new frame
            } else {
                DiceRollFrame diceRollFrame = null;
                try {
                    diceRollFrame = new DiceRollFrame(arrayList, (activePlayer+1) % arrayList.size());
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.exit(1);
                }
                diceRollFrame.setVisible(true);
                this.dispose();
            }
            System.out.println("save button clicked");
        } else if(e.getSource() == goodGuys) {
            revertBackToOriginal();
            if(scoreCard.getUpperScorecard().getGoodGuys().isUsed()) {
                goodGuys.setForeground(Color.WHITE);
                scoreCard.getUpperScorecard().getGoodGuys().setUsed(false);
            } else {
                goodGuys.setForeground(Color.GREEN);
                scoreCard.getUpperScorecard().getGoodGuys().setUsed(true);
            }
            System.out.println("goodguys button clicked");
        } else if(e.getSource() == princesses) {
            revertBackToOriginal();
            if(scoreCard.getUpperScorecard().getPrincesses().isUsed()) {
                princesses.setForeground(Color.WHITE);
                scoreCard.getUpperScorecard().getPrincesses().setUsed(false);
            } else {
                princesses.setForeground(Color.GREEN);
                scoreCard.getUpperScorecard().getPrincesses().setUsed(true);
            }
            System.out.println("princesses clicked");
        } else if(e.getSource() == animals) {
            revertBackToOriginal();
            if(scoreCard.getUpperScorecard().getAnimals().isUsed()) {
                scoreCard.getUpperScorecard().getAnimals().setUsed(false);
                animals.setForeground(Color.WHITE);
            } else {
                scoreCard.getUpperScorecard().getAnimals().setUsed(true);
                animals.setForeground(Color.GREEN);
            }
            System.out.println("animals clicked");
        } else if(e.getSource() == badGuys) {
            revertBackToOriginal();
            if(scoreCard.getUpperScorecard().getBadGuys().isUsed()) {
                scoreCard.getUpperScorecard().getBadGuys().setUsed(false);
                badGuys.setForeground(Color.WHITE);
            } else {
                scoreCard.getUpperScorecard().getBadGuys().setUsed(true);
                badGuys.setForeground(Color.GREEN);
            }
            System.out.println("badguys clicked");
        } else if(e.getSource() == fiveOfAKind) {
            revertBackToOriginal();
            if(scoreCard.getLowerScorecard().getFiveOfAKind().isUsed()) {
                scoreCard.getLowerScorecard().getFiveOfAKind().setUsed(false);
                fiveOfAKind.setForeground(Color.WHITE);
            } else {
                scoreCard.getLowerScorecard().getFiveOfAKind().setUsed(true);
                fiveOfAKind.setForeground(Color.GREEN);
            }
            System.out.println("fiveofakind clicked");
        } else if(e.getSource() == sevenOfAKind) {
            revertBackToOriginal();
            if(scoreCard.getLowerScorecard().getSevenOfAKind().isUsed()) {
                scoreCard.getLowerScorecard().getSevenOfAKind().setUsed(false);
                sevenOfAKind.setForeground(Color.WHITE);
            } else {
                scoreCard.getLowerScorecard().getSevenOfAKind().setUsed(true);
                sevenOfAKind.setForeground(Color.GREEN);
            }
            System.out.println("sevenofakind clicked");
        } else if(e.getSource() == goodGuysRule) {
            revertBackToOriginal();
            if(scoreCard.getLowerScorecard().getGoodGuysRule().isUsed()) {
                goodGuysRule.setForeground(Color.WHITE);
                scoreCard.getLowerScorecard().getGoodGuysRule().setUsed(false);
            } else {
                scoreCard.getLowerScorecard().getGoodGuysRule().setUsed(true);
                goodGuysRule.setForeground(Color.GREEN);
            }
            System.out.println("goodguysrule clicked");
        } else if(e.getSource() == badGuysSuck) {
            revertBackToOriginal();
            if(scoreCard.getLowerScorecard().getBadGuysSuck().isUsed()) {
                scoreCard.getLowerScorecard().getBadGuysSuck().setUsed(false);
                badGuysSuck.setForeground(Color.WHITE);
            } else {
                scoreCard.getLowerScorecard().getBadGuysSuck().setUsed(true);
                badGuysSuck.setForeground(Color.GREEN);
            }
            System.out.println("badguyssuck clicked");
        } else if(e.getSource() == superMario) {
            revertBackToOriginal();
            if(scoreCard.getLowerScorecard().getSuperMario().isUsed()) {
                scoreCard.getLowerScorecard().getSuperMario().setUsed(false);
                superMario.setForeground(Color.WHITE);
            } else {
                scoreCard.getLowerScorecard().getSuperMario().setUsed(true);
                superMario.setForeground(Color.GREEN);
            }
            System.out.println("supermario clicked");
        } else if(e.getSource() == evilBowser) {
            revertBackToOriginal();
            if(scoreCard.getLowerScorecard().getEvilBowser().isUsed()) {
                scoreCard.getLowerScorecard().getEvilBowser().setUsed(false);
                for(Player player : arrayList) {
                    player.getScoreCard().getLowerScorecard().getEvilBowser().setUsed(false);
                }
                evilBowser.setForeground(Color.WHITE);
            } else {
                for(Player player : arrayList) {
                    player.getScoreCard().getLowerScorecard().getEvilBowser().setUsed(true);
                }
                scoreCard.getLowerScorecard().getEvilBowser().setUsed(true);
                evilBowser.setForeground(Color.GREEN);
            }
            System.out.println("evilbowser clicked");
        } else if(e.getSource() == animalKingdom) {
            revertBackToOriginal();
            if(scoreCard.getLowerScorecard().getAnimalKingdom().isUsed()) {
                scoreCard.getLowerScorecard().getAnimalKingdom().setUsed(false);
                animalKingdom.setForeground(Color.WHITE);
            } else {
                scoreCard.getLowerScorecard().getAnimalKingdom().setUsed(true);
                animalKingdom.setForeground(Color.GREEN);
            }
            System.out.println("animalkingdom clicked");
        } else if(e.getSource() == marioParty) {
            revertBackToOriginal();
            if(scoreCard.getLowerScorecard().getMarioParty().isUsed()) {
                scoreCard.getLowerScorecard().getMarioParty().setUsed(true);
                marioParty.setForeground(Color.WHITE);
            } else {
                scoreCard.getLowerScorecard().getMarioParty().setUsed(false);
                marioParty.setForeground(Color.GREEN);
            }
            System.out.println("marioparty clicked");
        }
    }


    private void displayPlayerUpperValues() {
        //for the upper values
        for(int i = 0; i < arrayList.size(); i++) {
            String curVal = "" + arrayList.get(i).getScoreCard().getUpperScorecard().getGoodGuys().getCurValue();
            JLabel goodGuys = new JLabel(curVal);
            goodGuys.setBounds(488+(150*i),225,150,75);
            goodGuys.setForeground(Color.WHITE);
            goodGuys.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getUpperScorecard().getGoodGuys().isUsed()) {
                goodGuys.setForeground(Color.GREEN);
            }
            buttonPanel.add(goodGuys);

            curVal = "" + arrayList.get(i).getScoreCard().getUpperScorecard().getPrincesses().getCurValue();
            JLabel princesses = new JLabel(curVal);
            princesses.setBounds(488+(150*i),345,150,75);
            princesses.setForeground(Color.WHITE);
            princesses.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getUpperScorecard().getPrincesses().isUsed()) {
                princesses.setForeground(Color.GREEN);
            }
            buttonPanel.add(princesses);

            curVal = "" + arrayList.get(i).getScoreCard().getUpperScorecard().getAnimals().getCurValue();
            JLabel animals = new JLabel(curVal);
            animals.setBounds(488+(150*i),465,150,75);
            animals.setForeground(Color.WHITE);
            animals.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getUpperScorecard().getAnimals().isUsed()) {
                animals.setForeground(Color.GREEN);
            }
            buttonPanel.add(animals);

            curVal = "" + arrayList.get(i).getScoreCard().getUpperScorecard().getBadGuys().getCurValue();
            JLabel badGuys = new JLabel(curVal);
            badGuys.setBounds(488+(150*i),600,150,75);
            badGuys.setForeground(Color.WHITE);
            badGuys.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getUpperScorecard().getBadGuys().isUsed()) {
                badGuys.setForeground(Color.GREEN);
            }
            buttonPanel.add(badGuys);

            curVal = "" + arrayList.get(i).getScoreCard().getUpperScorecard().getUpperSum();
            JLabel firstTotal = new JLabel(curVal);
            firstTotal.setBounds(488+(150*i),675,150,75);
            firstTotal.setForeground(Color.WHITE);
            firstTotal.setFont(instructionFont);
            buttonPanel.add(firstTotal);

            int bonusVal = 0;
            if(arrayList.get(i).getScoreCard().getUpperScorecard().isHasBonus()) {
                bonusVal = 45;
            }

            curVal = "" + bonusVal;
            JLabel bonus = new JLabel(curVal);
            bonus.setBounds(488+(150*i),750,150,75);
            bonus.setForeground(Color.WHITE);
            bonus.setFont(instructionFont);
            buttonPanel.add(bonus);

            curVal = "" + arrayList.get(i).getScoreCard().getUpperScorecard().getUpperTotal();
            JLabel secondTotal = new JLabel(curVal);
            secondTotal.setBounds(488+(150*i),810,150,75);
            secondTotal.setForeground(Color.WHITE);
            secondTotal.setFont(instructionFont);
            buttonPanel.add(secondTotal);
        }
    }

    private void displayPlayerLowerValues() {
        for(int i = 0; i < arrayList.size(); i++) {
            JLabel fiveOfAKind = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getFiveOfAKind().getCurValue());
            fiveOfAKind.setBounds(1590+(150*i),188,150,75);
            fiveOfAKind.setForeground(Color.WHITE);
            fiveOfAKind.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getFiveOfAKind().isUsed()) {
                fiveOfAKind.setForeground(Color.GREEN);
            }
            buttonPanel.add(fiveOfAKind);

            JLabel sevenOfAKind = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getSevenOfAKind().getCurValue());
            sevenOfAKind.setBounds(1590+(150*i),345,150,75);
            sevenOfAKind.setForeground(Color.WHITE);
            sevenOfAKind.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getSevenOfAKind().isUsed()) {
                sevenOfAKind.setForeground(Color.GREEN);
            }
            buttonPanel.add(sevenOfAKind);

            JLabel goodGuysRule = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getGoodGuysRule().getCurValue());
            goodGuysRule.setBounds(1590+(150*i),465,150,75);
            goodGuysRule.setForeground(Color.WHITE);
            goodGuysRule.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getGoodGuysRule().isUsed()) {
                goodGuysRule.setForeground(Color.GREEN);
            }
            buttonPanel.add(goodGuysRule);

            JLabel badGuysSuck = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getBadGuysSuck().getCurValue());
            badGuysSuck.setBounds(1590+(150*i),525,150,75);
            badGuysSuck.setForeground(Color.WHITE);
            badGuysSuck.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getBadGuysSuck().isUsed()) {
                badGuysSuck.setForeground(Color.GREEN);
            }
            buttonPanel.add(badGuysSuck);

            JLabel superMario = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getSuperMario().getCurValue());
            superMario.setBounds(1590+(150*i),600,150,75);
            superMario.setForeground(Color.WHITE);
            superMario.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getSuperMario().isUsed()) {
                superMario.setForeground(Color.GREEN);
            }
            buttonPanel.add(superMario);

            JLabel evilBowser = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getEvilBowser().getCurValue());
            evilBowser.setBounds(1590+(150*i),675,150,75);
            evilBowser.setForeground(Color.WHITE);
            evilBowser.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getEvilBowser().isUsed()) {
                evilBowser.setForeground(Color.GREEN);
            }
            buttonPanel.add(evilBowser);

            JLabel animalKingdom = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getAnimalKingdom().getCurValue());
            animalKingdom.setBounds(1590+(150*i),750,150,75);
            animalKingdom.setForeground(Color.WHITE);
            animalKingdom.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getAnimalKingdom().isUsed()) {
                animalKingdom.setForeground(Color.GREEN);
            }
            buttonPanel.add(animalKingdom);

            JLabel marioParty = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getMarioParty().getCurValue());
            marioParty.setBounds(1590+(150*i),825,150,75);
            marioParty.setForeground(Color.WHITE);
            marioParty.setFont(instructionFont);
            if(arrayList.get(i).getScoreCard().getLowerScorecard().getMarioParty().isUsed()) {
                marioParty.setForeground(Color.GREEN);
            }
            buttonPanel.add(marioParty);


            JLabel upperTotal = new JLabel("" + arrayList.get(i).getScoreCard().getUpperScorecard().getUpperTotal());
            upperTotal.setBounds(1590+(150*i),900,150,75);
            upperTotal.setForeground(Color.WHITE);
            upperTotal.setFont(instructionFont);
            buttonPanel.add(upperTotal);

            JLabel lowerTotal = new JLabel("" + arrayList.get(i).getScoreCard().getLowerScorecard().getLowerTotal());
            lowerTotal.setBounds(1590+(150*i),975,150,75);
            lowerTotal.setForeground(Color.WHITE);
            lowerTotal.setFont(instructionFont);
            buttonPanel.add(lowerTotal);

            int total = arrayList.get(i).getScoreCard().getLowerScorecard().getLowerTotal() + arrayList.get(i).getScoreCard().getUpperScorecard().getUpperTotal();
            JLabel grandTotal = new JLabel("" + total);
            grandTotal.setBounds(1590+(150*i),1050,150,75);
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
        int upperButtonStart = 225;
        upperSection.setBounds(38, 150, 225, 75);
        goodGuys.setBounds(38,upperButtonStart,buttonWidth,buttonHeight);
        princesses.setBounds(38,upperButtonStart+(buttonDiff*1),buttonWidth,buttonHeight);
        animals.setBounds(38,upperButtonStart+(buttonDiff*2),buttonWidth,buttonHeight);
        badGuys.setBounds(38,upperButtonStart+(buttonDiff*3),buttonWidth,buttonHeight);
        total.setBounds(38,645,150,150);
        bonus.setBounds(38,705,150,150);
        secondTotal.setBounds(38,765,150,150);

        goodGuyDescription.setBounds(263,upperButtonStart,225,120);
        princessesDescription.setBounds(263,upperButtonStart+(buttonDiff*1),225,120);
        animalsDescription.setBounds(263,upperButtonStart+(buttonDiff*2),225,120);
        badGuysDescription.setBounds(263,upperButtonStart+(buttonDiff*3),225,120);
        firstArrow.setBounds(263,690,225,75);
        bonusDescription.setBounds(263,750,100,75);
        secondArrow.setBounds(263,795,225,75);

        howToScoreFirst.setBounds(263, 150, 150, 75);
        player1Upper.setBounds(488,150,150,75);
        player2Upper.setBounds(638,150,150,75);
        player3Upper.setBounds(788,150,150,75);
        player4Upper.setBounds(938,150,150,75);

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
        lowerSection.setBounds(1125,75,150,75);
        howToScoreSecond.setBounds(1350,75,150,75);

        fiveOfAKind.setBounds(1125,150,225,150);
        sevenOfAKind.setBounds(1125,300,225,150);
        goodGuysRule.setBounds(1125,450,225,75);
        badGuysSuck.setBounds(1125,525,225,75);
        superMario.setBounds(1125,600,225,75);
        evilBowser.setBounds(1125,675,225,75);
        animalKingdom.setBounds(1125,750,225,75);
        marioParty.setBounds(1125,825,225,75);
        upperSectionTotal.setBounds(1125,900,225,75);
        lowerSectionTotal.setBounds(1125,975,225,75);
        grandTotal.setBounds(1125,1050,225,75);

        fiveOfAKindDescription.setBounds(1350,150,225,150);
        sevenOfAKindDescription.setBounds(1350,300,225,150);
        goodGuysRuleDescription.setBounds(1350,450,225,75);
        badGuysSuckDescription.setBounds(1350,525,225,75);
        superMarioDescription.setBounds(1350,600,225,75);
        evilBowserDescription.setBounds(1350,675,225,75);
        animalKingdomDescription.setBounds(1350,750,225,75);
        marioPartyDescription.setBounds(1350,825,225,75);
        upperSectionArrow.setBounds(1350,900,225,75);
        lowerSectionArrow.setBounds(1350,975,225,75);
        grandTotalArrow.setBounds(1350,1050,225,75);

        player1Lower.setBounds(1590,75,150,75);
        player2Lower.setBounds(1740,75,150,75);
        player3Lower.setBounds(1890,75,150,75);
        player4Lower.setBounds(2040,75,150,75);

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
                image = ImageIO.read(new File("img/scorecardBackground.png"));
            } catch (IOException ex) {
                System.out.println("Image not found");
                System.exit(1);
            }
        }

        public ImagePanel() {
            try {
                image = ImageIO.read(new File("img/scorecardBackground.png"));
            } catch (IOException ex) {
                System.out.println("Image not found");
                System.exit(1);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image.getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image. SCALE_SMOOTH), 0, 0, this);
            g.setColor(Color.RED);
            drawGridUpper(g);
            drawGridLower(g);
        }

        private void drawGridUpper(Graphics g) {
            //vertical lines
            for(int i = 480; i <= 1080; i+=150) {
                g.drawLine(i,150,i,870);
            }
            g.drawLine(30,150,30,870);
            g.drawLine(255,150,255,870);

            //hoizontal lines
            for(int i = 215; i <= 695; i+=120) {
                g.drawLine(30,i,1080,i);
            }
            g.drawLine(30,150,1080,150);
            for(int i = 750; i < 930; i+= 60) {
                g.drawLine(30,i,1080,i);
            }
        }

        private void drawGridLower(Graphics g) {
            g.drawLine(1110,75,2175,75);
            for(int i = 150; i <= 450; i+=150) {
                g.drawLine(1110,i,2175,i);

            }
            for(int i = 525; i <= 1125; i+=75) {
                g.drawLine(1110,i,2175,i);
            }
            g.drawLine(1110,75,1110,1125);
            for(int i = 1335; i <= 1575; i+= 225) {
                g.drawLine(i,75,i,1125);
                i+=10;
            }

            for(int i = 1725; i <= 2175; i+=150) {
                g.drawLine(i,75,i,1125);
            }
        }

    }
}