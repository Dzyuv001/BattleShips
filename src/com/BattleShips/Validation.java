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
                            if(!isClearAround(x,y-shipLength)){
                                return false;
                            }
                        }
                    }
                }
                break;
            case 1:
                if (isClearAround(x,y)){
                    if (shipLength == 1){
                        return true;
                    }else {
                        for (int i = 1; i < shipLength-1; i++) {
                            if(!isClearAround(x+shipLength,y)){
                                return false;
                            }
                        }
                    }
                }
                break;
            case 2:
                if (isClearAround(x,y+shipLength)){
                    if (shipLength == 1){
                        return true;
                    }else {
                        for (int i = 1; i < shipLength-1; i++) {
                            if(!isClearAround(x,y-shipLength)){
                                return false;
                            }
                        }
                    }
                }
                break;
            case 3:
                if (isClearAround(x+shipLength,y)){
                    if (shipLength == 1){
                        return true;
                    }else {
                        for (int i = 1; i < shipLength-1; i++) {
                            if(!isClearAround(x,y-shipLength)){
                                return false;
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }
        return true;
    }


    boolean isClearAround( int x, int y){
        int coords[][];
        if (shipArea[y][x] == null){
            if ((y==0 && x==0)){
                coords = new int[][]{{0, 1}, {1, 1}, {1, 0}};
            }
            if (y==10 && x==0) {
                coords = new int[][]{{9, 0}, {9, 1}, {10, 1}};
            }
            if(y==10 && x==10){
                coords = new int[][]{{9, 9}, {9, 10}, {10, 9}};
            }
            if(y==0 && x==10){
                coords = new int[][]{{0, 9}, {1,9}, {1, 10}};
            }
            if(x==10){
                coords = new int[][]{{0, 9}, {1,9}, {1, 10}};
            }
            if(x==0){
                coords = new int[][]{{0, 9}, {1,9}, {1, 10}};
            }
            if(y==10){
                coords = new int[][]{{0, 9}, {1,9}, {1, 10}};
            }
            if(y==0){
                coords = new int[][]{{0, 9}, {1,9}, {1, 10}};
            }
            if(){
                coords = new int[][]{{y,x-1}, {y-1,x-1}, {y-1, x}, {y-1,x+1},{y,x+1},{y+1,x+1},{y+1,x},{y+1,x-1}};
            }
            for (int i = 0; i < coords.length-1; i++) {

            }

        }
        return false;
    }


}
