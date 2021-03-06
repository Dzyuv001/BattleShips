package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ShipPlacement implements MouseListener {
    private JLabel lblAreaTitle= new JLabel("",SwingConstants.CENTER);
    private JButton ships[] = new JButton[10];
    private MainScreen mainScreen;
    private JButton selectedShip;
    private boolean isShipSelected = false;
    private JPanel shipArea = new JPanel();

    public ShipPlacement(MainScreen ms){
        mainScreen = ms;
        mainScreen.getMS().add(shipArea);
        initTitle();
        initShips();
    }

    private void initTitle(){
        lblAreaTitle.setPreferredSize(new Dimension((int)(mainScreen.getWidth()*0.6),20));
        lblAreaTitle.setText("Place your ships");
        lblAreaTitle.doLayout();
        shipArea.add(lblAreaTitle);
    }

    private void initShips(){
        int lengths[] = {4,3,3,2,2,2,1,1,1,1};
        for (int i = 0; i < lengths.length; i++) {
            ships[i] = new JButton(lengths[i] + " Long");
            ships[i].setPreferredSize(new Dimension(60*lengths[i],20));
            shipArea.add(ships[i]);
            ships[i].addMouseListener(this);
            ships[i].putClientProperty("int", i);
        }
    }

    public  boolean isShipSelected(){ return isShipSelected; }

    public int getSelectedShipLength() {
        return (selectedShip.getWidth()/60)-1;
    }
public int getShipIndex(){
        return (int)selectedShip.getClientProperty("int");
}



    @Override
    public void mouseClicked(MouseEvent e) {
        selectedShip = ((JButton)e.getSource());
        System.out.println(((JButton) e.getSource()).getClientProperty("int"));
        isShipSelected = true;
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
