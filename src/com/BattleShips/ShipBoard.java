package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public abstract class ShipBoard extends JPanel {
    MainScreen mainScreen;
    private int elemHight, elemWidth;
    private JLabel lblAreaTitle= new JLabel("",SwingConstants.CENTER);

    public Coordinate[][] coord = new Coordinate[10][10];
    public Validation valid = new Validation();
    public Ship ships[] = new Ship[10];

    public ShipBoard(MainScreen ms){
        mainScreen = ms;
        initBA();
    }

    private void initTitle(){
        lblAreaTitle.setPreferredSize(new Dimension((int)(elemWidth*0.6),20));
        lblAreaTitle.setText(titleText());
        lblAreaTitle.doLayout();
        this.add(lblAreaTitle);
    }

    public abstract String titleText();

    private void setXY(){ // Gets main JFrame's height and width
        elemHight = mainScreen.getHeight();
        elemWidth = mainScreen.getWidth();
    }

    public String[][] getBoard(){
        String stringArray[][] = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                stringArray[i][j] = coord[i][j].getState();
            }
        }
        return stringArray;
    }

    private void initBA(){ // sets up the battle ship area
        setXY();
        this.setVisible(true);
        mainScreen.getMS().add(this);
        initTitle();
        placeElements();
    }

    private JLabel initLblLocation(String name){ // sets up labels
        JLabel label = new JLabel(name,SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(22,22));
        label.setVisible(true);
        return label;
    }

    public abstract Coordinate initBattleShipCoord(int x,int y);

    private void placeElements(){// used to place elements on the jframe
        String leters[] = {" ", "A","B","C","D","E","F","G","H","I","J"};
        for (int i = 0; i < leters.length; i++) {
            this.add(initLblLocation(leters[i]));
        }
        for (int i = 0; i < 10; i++) {
            this.add(initLblLocation((i + 1) + ""));
            for (int j = 0; j < 10; j++) {
                coord[i][j] = initBattleShipCoord(i, j);
                this.add(coord[i][j]);
            }
        }
    }
}