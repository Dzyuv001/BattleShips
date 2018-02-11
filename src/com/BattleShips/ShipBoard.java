package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class ShipBoard {
    private JPanel mainScreen;
    private JPanel battleArea = new JPanel();
    private JButton btnShipCoord[][] = new JButton[10][10];
    String locations[][] = new String[10][10];
    private JLabel lblLocation[] = new JLabel[21];
    private int elemHight, elemWidth;
    private JLabel lblAreaTitle= new JLabel("",SwingConstants.CENTER);

    private Coordinate coord[][] = new Coordinate[10][10];
    Validation valid;
    private List<Ship> ship;

    public ShipBoard(JPanel ms){
        mainScreen = ms;
        initBA();
    }

    private void initTitle(){
        lblAreaTitle.setPreferredSize(new Dimension((int)(elemWidth*0.6),20));
        lblAreaTitle.setText(titleText());
        lblAreaTitle.doLayout();
        battleArea.add(lblAreaTitle);
    }

    public abstract String titleText();

    private void setXY(){ // Gets main JFrame's height and width
        elemHight = mainScreen.getHeight();
        elemWidth = mainScreen.getWidth();
    }

    private void initBA(){ // sets up the battle ship area
        setXY();
        battleArea.setVisible(true);
        mainScreen.add(battleArea);
        initTitle();
        placeElements();
    }

    private JLabel initLblLocation(String name){ // sets up labels
        JLabel label = new JLabel(name,SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(22,22));
        label.setVisible(true);
        return label;
    }

    public abstract JButton initBattleShipCoord();

    private void placeElements(){// used to place elements on the jframe
        String Leters[] = {" ", "A","B","C","D","E","F","G","H","I","J"};
        for (int i = 0; i < Leters.length; i++) {
            battleArea.add(initLblLocation(Leters[i]));
        }
        for (int i = 0; i < 10; i++) {
            battleArea.add(initLblLocation((i+1)+""));
            for (int j = 0; j < 10; j++) {
                coord[i][j] = new Coordinate(i,j,initBattleShipCoord(),"n");
                battleArea.add(coord[i][j].btn);
            }
        }
    }
}
