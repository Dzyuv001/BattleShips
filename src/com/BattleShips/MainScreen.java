package com.BattleShips;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {
    private JPanel ms;
    EnemyBoard enemySide;
    PlayerBoard playerSide;
    ShipPlacement shipPlacement;

    public MainScreen(){
        super("Battle Ships");
        setLayout(new BorderLayout());
        this.ms = new JPanel();
        this.ms.setLayout(new GridLayout(2,0));
        add(ms, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
       // setFocusable(true);
        setSize(700, 700);
        initSide();
        setVisible(true);
        setFocusable(true);
    }

    public JPanel getMS(){ return ms; }

    public ShipPlacement getShipPlacement() { return shipPlacement; }

    private void initSide(){
        playerSide = new PlayerBoard(this);
        enemySide = new EnemyBoard(this);
        shipPlacement = new ShipPlacement(this);
    }

    public static void main(String args[]){ MainScreen mainScreen  = new MainScreen(); }
}
