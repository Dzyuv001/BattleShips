package com.BattleShips;

import javax.swing.*;

public class Coordinate extends JButton{
    int x,y;
    JButton btn;
    String state;

   public Coordinate(int x, int y,JButton btn, String state){
       this.x = x;
       this.y = y;
       this.btn = btn;
       this.state = state;
    }
    public int getCoordX(){ return x; }
    public int getCoordY(){ return y; }
}
