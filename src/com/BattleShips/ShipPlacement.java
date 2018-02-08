package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ShipPlacement implements MouseListener {
    private JLabel lblAreaTitle= new JLabel("",SwingConstants.CENTER);
    private JButton ships[] = new JButton[10];
    private JPanel mainScreen;
    private JButton selected;
    private JPanel shipArea = new JPanel();

    public ShipPlacement(JPanel ms){
        mainScreen = ms;
        mainScreen.add(shipArea);
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
            // ships[i].setText(lengths[i] + " Long");
            ships[i].setPreferredSize(new Dimension(60*lengths[i],20));
            shipArea.add(ships[i]);
            ships[i].addMouseListener(this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selected = ((JButton)e.getSource());
        System.out.println("dis works " + selected.getWidth()/60);
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
