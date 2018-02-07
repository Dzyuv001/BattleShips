package com.BattleShips;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ShipBoard {
    private JPanel mainScreen;
    private JFrame battleArea = new JFrame();
    private JButton btnShipCoord[][] = new JButton[10][10];
    private JLabel lblLocation[] = new JLabel[21];
    private int elemHight, elemWidth;

    public ShipBoard(JPanel ms){
        ms = mainScreen;
        initBA();
    }

    private void setXY(){ // Gets main JFrame's height and width
        elemHight = mainScreen.getHeight();
        elemWidth = mainScreen.getWidth();
    }



    private void initBA(){ // sets up the battle ship area
        // setXY();
        battleArea.setBackground(Color.BLACK);
        battleArea.setVisible(true);
        mainScreen.add(battleArea);
        placeElements();
    }

    private JLabel initLblLocation(String name){ // sets up labels
        JLabel label = new JLabel(name,SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(battleArea.getWidth()/12,battleArea.getHeight()/12));
        label.setVisible(true);
        return label;
    }

    private JButton initBattleShipCoord(){ // sets up buttons
        JButton button = new JButton();
        button.setBackground(Color.BLUE);
        button.setPreferredSize(new Dimension(battleArea.getWidth()/12,battleArea.getHeight()/12));
        button.setBorder(BorderFactory.createLineBorder(Color.black));
        button.setVisible(true);

        return button;
    }

    private void placeElements(){// used to place elements on the jframe
        String Leters[] = {" ", "A","B","C","D","E","F","G","H","I","J"};
        for (int i = 0; i < Leters.length; i++) {
            battleArea.add(initLblLocation(Leters[i]));
        }

        for (int i = 0; i < 10; i++) {
            if(i == 0 || (i % 10 == 0)){
                battleArea.add(initLblLocation(i+""));
            }
            for (int j = 0; j < 10; j++) {
                battleArea.add(initBattleShipCoord());
            }
        }
    }

}