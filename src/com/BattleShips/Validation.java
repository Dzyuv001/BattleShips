package com.BattleShips;

public class Validation { // class will be used to validate inputs
    private String shipArea[][];
    private int minX=0,maxX=0,minY=0,maxY=0;

    boolean isPlaceable(int rota,int shipLength, String[][] shipGrid, int y, int x){// false is unplaceable , true is placeable
        shipArea = shipGrid;
        switch (rota){
            case 0:
                minX = x -1;
                minY = y-(shipLength+1);
                maxX = x+1;
                maxY = y+1;
                break;
            case 1:
                minX = x-1;
                minY = y-1;
                maxX = x+(shipLength+1);
                maxY = y+1;
                break;
            case 2:
                minX = x-1;
                minY = y-1;
                maxX = x+1;
                maxY = y+(shipLength+1);
                break;
            case 3:
                minX = x-(shipLength+1);
                minY = y-1;
                maxX = x+1;
                maxY = y+1;
                break;
            default:
                break;
        }
        if ((minX < -1) || (minY < -1) || (maxX > 10) || (maxY > 10)){
            return false;
        }
        cleaner();
        if (!isClear()){
            return false;
        }
        return true;
    }

    private void cleaner(){ //removes coordinates that don't need to to be check or will crash the program
       if(minX==-1)minX=0;
        if(minY==-1)minY=0;
        if(maxX==10)maxX=9;
        if(maxY==10)maxY=9;
    }

    public boolean isClear(){// loop though every coordiate and check if its taken
        for (int i = minY; i < maxY; i++) {
            for (int j = minX; j < maxX; j++) {
                if(shipArea[i][j] != "n"){
                    return false;
                }
            }
        }
        return true;
    }
}
