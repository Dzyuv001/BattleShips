package com.BattleShips;

import javax.swing.*;
import java.awt.*;

public class EnemyBoard extends ShipBoard {

    public EnemyBoard(JPanel ms) {
        super(ms);
    }

    @Override
    public String titleText() {
        return "Enemy area";
    }

    @Override
    public JButton initBattleShipCoord(){ // sets up buttons
        JButton button = new JButton();
        button.setBackground(Color.LIGHT_GRAY);
        button.setPreferredSize(new Dimension(22,22));
        button.setBorder(BorderFactory.createLineBorder(Color.black));
        button.setVisible(true);
        return button;
    }

}
