package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PlayerBoard extends ShipBoard implements MouseListener {
    private int rotation=3; // stores the rotation of the ship
    private ArrayList<Coordinate> currentShips = new ArrayList<>();
    private MouseEvent mouse;

    public PlayerBoard(MainScreen ms) {
        super(ms);
        setFocusable(true);
        addKeyBinding(this,KeyEvent.VK_E,"clockwise", (eve) -> {
            roation(1);
            System.out.print("turned turned right " + rotation);
        });
        addKeyBinding(this,KeyEvent.VK_Q,"anticlockwise", (eve) -> {

            roation(-1);
            System.out.print("turned left " + rotation);
        });
    }

    private void addKeyBinding(JComponent comp, int keyCode, String id, ActionListener act){
        InputMap im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap ap = this.getActionMap();
        im.put(KeyStroke.getKeyStroke(keyCode,0,true),id);
        ap.put(id, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                act.actionPerformed(e);
                System.out.println("hello world");
            }
        });
    }

    private void roation(int rot){// changes the rotation value
        System.out.println(rot);
        if (rot==1){
            if (rotation==3){
                rotation=0;
            }else {
                rotation+=rot;
            }
        }else {
            if (rotation==0){
                rotation=3;
            }else {
                rotation+=rot;
            }
        }
        placeable();
    }

    private void clearPreview(){
        for (Coordinate co :currentShips) co.setBackground(Color.lightGray);
        currentShips.removeAll(currentShips);
    }

    @Override
    public String titleText() { return "Player area"; }

    @Override
    public void mouseClicked(MouseEvent e) {
        ((JButton)e.getSource()).setBackground(Color.GREEN);
        System.out.println("the button was clicked");
    }

    private void preview(int length ,int y , int x){
        clearPreview();
        int min=0,max=0;
        switch (rotation){
            case 0:
                for (int i = y-length; i <= y ; i++) {
                    currentShips.add(coord[i][x]);
                }
                break;
            case 1:
                for (int i = x; i <= x+length ; i++) {
                    currentShips.add(coord[y][i]);
                }
                break;
            case 2:
                for (int i = y; i <= y+length ; i++) {
                    currentShips.add(coord[i][x]);
                }
                break;
            case 3:
                for (int i = x-length; i <= x; i++) {
                    currentShips.add(coord[y][i]);
                }
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

    private void placeable(){
        int shipLength =  super.mainScreen.shipPlacement.getSelectedShipLength();
        int x=((Coordinate)mouse.getSource()).getCoordX(),y=((Coordinate)mouse.getSource()).getCoordY();
        if (super.mainScreen.shipPlacement.isShipSelected()) {
            if (valid.isPlaceable(rotation,shipLength,getBoard(),y,x)) {
                preview(shipLength,y,x);
            } else {
                ((Coordinate) mouse.getSource()).setBackground(Color.red);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int gameState = 0;
        switch (gameState) {
            case 0: // game is being set up
                mouse = e;
                placeable();
                break;
            case 1:
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        clearPreview();
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
}
