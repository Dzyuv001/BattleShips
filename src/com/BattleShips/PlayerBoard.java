package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerBoard extends ShipBoard implements KeyListener,MouseListener {
    private int GameState=0;

    public PlayerBoard(JPanel ms) {
        super(ms);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ((JButton)e.getSource()).setBackground(Color.GREEN);
        System.out.println("the button was clicked");
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
        ((JButton)e.getSource()).setBackground(Color.blue);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((JButton)e.getSource()).setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public JButton initBattleShipCoord(){ // sets up buttons
        JButton button = new JButton();
        button.setBackground(Color.LIGHT_GRAY);
        button.setPreferredSize(new Dimension(22,22));
        button.setBorder(BorderFactory.createLineBorder(Color.black));
        //button.addActionListener((ActionListener) button);
        button.addMouseListener(this);
//        button.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent e) {
//                ((JButton)e.getSource()).setBackground(Color.GREEN);
//            }
//        });


        // button.addKeyListener((KeyListener) button);
        button.setVisible(true);
        return button;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
