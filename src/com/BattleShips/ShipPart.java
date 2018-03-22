package com.BattleShips;

public class ShipPart {
    private int x,y, partIdex;
    private boolean isHit = false;

    public boolean isHit(){ return isHit; }

    public void partHit() { isHit = true; }

    public ShipPart(int x, int y, int partIdex) {
        this.x = x;
        this.y = y;
        this.partIdex = partIdex;
    }
}
