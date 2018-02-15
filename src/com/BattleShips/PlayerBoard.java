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

    private void preview(int length ,int y , int x){
        int min=0,max=0;
        switch (rotation){
            case 0:
                for (int i = y-length; i <= y ; i++) {
                    System.out.println(i);
                    currentShips.add(coord[i][x]);
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
        System.out.println(currentShips.size());
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
        int shipLength =  super.mainScreen.shipPlacement.getSelectedShipLength();
        int x=((Coordinate)e.getSource()).getCoordX(),y=((Coordinate)e.getSource()).getCoordY();
        switch (gameState) {
            case 0: // game is being set up
                if (super.mainScreen.shipPlacement.isShipSelected()) {
                    if (valid.isPlaceable(rotation,shipLength,getBoard(),y,x)) {
                        preview(shipLength,y,x);
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
        for (Coordinate co :currentShips) co.setBackground(Color.lightGray);
        currentShips.removeAll(currentShips);
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
