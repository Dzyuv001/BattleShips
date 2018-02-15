package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerBoard extends ShipBoard implements KeyListener,MouseListener {
    private int rotation=0; // stores the rotation of the ship
    private ArrayList<Coordinate> currentShips = new ArrayList<>();

    public PlayerBoard(MainScreen ms) {
        super(ms);
    }

    @Override
    public String titleText() { return "Player area"; }

    @Override
    public void mouseClicked(MouseEvent e) {
        ((JButton)e.getSource()).setBackground(Color.GREEN);
        System.out.println("the button was clicked");
    }
    private void preview(int length ,int x , int y){
        int min=0,max=0;
        switch (rotation){
            case 0:
                for (int i = x; i < length+x ; i++) {
                    currentShips.add(coord[y][x]);
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
        for (Coordinate co :currentShips) co.setBackground(Color.BLUE);
    }

    private  void undoPreview(){
        int min=0,max=0;
        switch (rotation){
            case 0:
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
        for (Coordinate co :currentShips) {
            co.setBackground(Color.LIGHT_GRAY);
        System.out.println("The coorids are " + co.getCoordY() + " and " + co.getCoordX());
        }
        currentShips.removeAll(currentShips);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ((JButton)e.getSource()).setBackground(Color.red);
        System.out.println("mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int gameState = 0;
        boolean shipSelected = false;
        switch (gameState) {
            case 0: // game is being set up
                String testin[][] = new String[10][10];
                testin[0][0] = "hello";
                if (super.mainScreen.shipPlacement.isShipSelected()) {
                    if (valid.isPlaceable(rotation, super.mainScreen.shipPlacement.getSelectedShipLength(),getBoard(), ((Coordinate) e.getSource()).getCoordY(), ((Coordinate) e.getSource()).getCoordX())) {
                        preview(super.mainScreen.shipPlacement.getSelectedShipLength(),((Coordinate) e.getSource()).getCoordY(),((Coordinate) e.getSource()).getCoordX());
                       // ((Coordinate) e.getSource()).setBackground(Color.blue);
                    } else {
                        ((Coordinate) e.getSource()).setBackground(Color.red);
                    }
                }
                break;
            case 1:
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((JButton)e.getSource()).setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public Coordinate initBattleShipCoord(int y, int x){ // sets up buttons
        Coordinate coord = new Coordinate(x,y,"n");
        coord.setBackground(Color.LIGHT_GRAY);
        coord.setPreferredSize(new Dimension(22,22));
        coord.setBorder(BorderFactory.createLineBorder(Color.black));
        coord.addMouseListener(this);
        coord.setVisible(true);
        return coord;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }
}
