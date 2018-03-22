package com.BattleShips;

import javax.swing.*;

public class Coordinate extends JButton{
   private int x,y,shipId,shipPartId;
   private String state;
   private ShipPart sp;

// write ship index and ship part index



   public Coordinate(int x, int y, String state){
       this.x = x;
       this.y = y;
     this.state = state;
    }

    public void navalSetUp(int shipId,int  shipPartId){
       this.shipId = shipId;
       this.shipPartId = shipPartId;
    }

    public void setSp(ShipPart sp) { this.sp = sp; }
    public String getState() { return state; }
    public int getCoordX(){ return x; }
    public int getCoordY(){ return y; }
}
