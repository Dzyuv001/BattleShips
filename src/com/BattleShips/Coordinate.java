package com.BattleShips;

import javax.swing.*;

public class Coordinate extends JButton{
   private int x,y;
   public String state;

   public Coordinate(int x, int y, String state){
       this.x = x;
       this.y = y;
     this.state = state;
    }

//    public JButton getBtn() {
//        return btn;
//    }
//public void setCoordsXY(int)

    public String getState() { return state; }
    public int getCoordX(){ return x; }
    public int getCoordY(){ return y; }
}
