package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;


public class ShipPlacement implements MouseListener {
    private JLabel lblAreaTitle= new JLabel("",SwingConstants.CENTER);
    private JButton ships[] = new JButton[10];
    private MainScreen mainScreen;
    private JButton selectedShip;
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

    private void initLabel(){

    }

    private void initShips(){
        int lengths[] = {4,3,3,2,2,2,1,1,1,1};
        for (int i = 0; i < lengths.length; i++) {
            ships[i] = new JButton(lengths[i] + " Long");
            ships[i].setPreferredSize(new Dimension(60*lengths[i],20));
            shipArea.add(ships[i]);
            ships[i].addMouseListener(this);
        }
    }

    public  boolean isShipSelected(){
        return selectedShip != null;
    }

     public int getSelectedShipLength() {
        return (selectedShip.getWidth()/60)-1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selectedShip = ((JButton)e.getSource());
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
