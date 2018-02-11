package com.BattleShips;

import javax.swing.*;

public class Coordinate {
    int x,y;
    JButton button;
    String state;

   public Coordinate(int x, int y, JButton button, String state){
       this.x = x;
       this.y = y;
       this.button = button;
       this.state = state;
    }

    public int getX(){ return x; }

    public int getY(){ return y; }
}
