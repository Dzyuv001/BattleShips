package com.BattleShips;

public class Ship {
    private int x,y,rotation,length;
    private boolean shipDestroyed;

    public Ship(int x, int y, int rotation, int length, boolean shipDestroyed) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.length = length;
        this.shipDestroyed = shipDestroyed;
    }
}
