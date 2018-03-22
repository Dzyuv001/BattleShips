package com.BattleShips;

import java.util.LinkedList;

public class Ship {
    private int x,y,rotation,length,xInc=0,yInc=0;
    private LinkedList<ShipPart> shipParts = new LinkedList<>();
    private boolean shipDestroyed= false;

    public boolean isShipDestroyed() {// returns the states of he ship
        checkShipDestroyed();
        return shipDestroyed;
    }

    public Ship(int x, int y, int rotation, int length) { //constructor
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.length = length;
    }

    private void setIncrements(){// this function will work out the increment of coordinates based on rotation
        switch(rotation){
            case 0:yInc--;
                break;
            case 1:
                xInc++;
                break;
            case 2:
                yInc++;
                break;
            case 3:
                xInc--;
                break;
            default:
                break;
        }
    }

    private void checkShipDestroyed(){// will check each coord of ship and see if all of them have been
        int shipLenght=0;
        for (ShipPart sp  : shipParts){
            if (sp.isHit()){
                shipLenght++;
            }
        }
        shipDestroyed = (shipParts.size() == shipLenght);
    }

    private void calcShip(){ // used to work out the coordiantes of the ship
        setIncrements();
        for (int i = 0; i < length ; i++) { shipParts.add(new ShipPart(x+(i*xInc),y+(i*yInc),i)); }
    }
}
