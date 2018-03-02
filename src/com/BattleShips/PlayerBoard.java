package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PlayerBoard extends ShipBoard implements MouseListener {
    private int rotation=0; // stores the rotation of the ship
    private ArrayList<Coordinate> currentShips = new ArrayList<>();
    private MouseEvent mouse;

    private int currentX , currentY;

    public PlayerBoard(MainScreen ms) {
        super(ms);
        setFocusable(true);
        addKeyBinding(this,KeyEvent.VK_E,"clockwise", (eve) -> {
            roation(1);
        });
        addKeyBinding(this,KeyEvent.VK_Q,"anticlockwise", (eve) -> {
            roation(-1);
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

    private void preview(int length ){
        Color shipCol = Color.BLUE;
        clearPreview();
        int min=0,max=0;
        switch (rotation){
            case 0:
                shipCol=shipFits(0,currentY-length);
                max = currentY;
                if (shipCol == Color.BLUE){
                    min = currentY-length;
                }else {
                    min= 0;
                }
                for (int i = min; i <= max ; i++) {
                    currentShips.add(coord[i][currentX]);
                }
                break;
            case 1:
                shipCol=shipFits(currentX+length,9);
                min = currentX;
                if (shipCol == Color.BLUE){
                    max = currentX+length;
                }else {
                    max = 9;
                }
                for (int i = min; i <= max ; i++) {
                    currentShips.add(coord[currentY][i]);
                }
                break;
            case 2:
                shipCol=shipFits(currentY+length,9);
                min = currentY;
                if (shipCol == Color.BLUE){
                    max = currentY+length;
                }else {
                    max = 9;
                }
                for (int i = min; i <= max ; i++) {
                    currentShips.add(coord[i][currentX]);
                }
                break;
            case 3:
                shipCol=shipFits(0,currentX-length);
                max = currentX;
                if (shipCol == Color.BLUE){
                    min = currentX-length;
                }else {
                    min= 0;
                }
                for (int i = min; i <= max; i++) {
                    currentShips.add(coord[currentY][i]);
                }
                break;
            default:
                break;
        }
        for (Coordinate co :currentShips) co.setBackground(shipCol);
    }

    private Color shipFits(int val1 ,int val2){
        Color col = Color.red;
        if(val1<=val2){
            col = Color.BLUE;
        }
        System.out.println("this ran" + col);
        return col;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ((JButton)e.getSource()).setBackground(Color.red);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    private void placeable(){
        int shipLength =  super.mainScreen.shipPlacement.getSelectedShipLength();
        currentX=((Coordinate)mouse.getSource()).getCoordX();
        currentY=((Coordinate)mouse.getSource()).getCoordY();
        if (super.mainScreen.shipPlacement.isShipSelected()) {
            preview(shipLength);
//            if (valid.isPlaceable(rotation,shipLength,getBoard(),currentY,currentX)) {
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
    public void mouseExited(MouseEvent e) { }

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
