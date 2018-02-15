package com.BattleShips;

import javax.swing.*;
import java.awt.*;

public class EnemyBoard extends ShipBoard {

    public EnemyBoard(MainScreen ms) {
        super(ms);
    }

    @Override
    public String titleText() {
        return "Enemy area";
    }

    @Override
    public Coordinate initBattleShipCoord(int x,int y){ // sets up buttons
        Coordinate coord = new Coordinate(x,y,"n");
        coord.setBackground(Color.LIGHT_GRAY);
        coord.setPreferredSize(new Dimension(22,22));
        coord.setBorder(BorderFactory.createLineBorder(Color.black));
        coord.setVisible(true);
        return coord;
    }

}
