package com.BattleShips;

public class Validation { // class will be used to validate inputs
private String shipArea[][];

    boolean isplaceable(int rota,int shipLength, String[][] shipGrid, int x, int y){
        shipArea = shipGrid;
        switch (rota){
            case 0:
                if (isClearAround(x,y)){
                    if (shipLength == 1){
                        return true;
                    }else {
                        for (int i = 1; i < shipLength-1; i++) {

                        }
                    }
                }

                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
        return true;
    }

    boolean isUsable(){
        return false;
    }

    boolean isClearAround( int x, int y){
        if (){
            return true;
        }
        return false;
    }


}
