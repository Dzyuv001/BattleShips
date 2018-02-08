package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {

    JPanel mainScreen;
    EnemyBoard enemySide;
    PlayerBoard playerSide;
    ShipPlacement shipPlacement;

    public MainScreen(){
        super("Battle Ships");
        setLayout(new BorderLayout());
        this.mainScreen = new JPanel();
        this.mainScreen.setLayout(new GridLayout(2,0));
        add(mainScreen, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        setSize(500, 500);
        setVisible(true);
        initSide();
    }

    private void initSide(){
        playerSide = new PlayerBoard(mainScreen);
        enemySide = new EnemyBoard(mainScreen);
        shipPlacement = new ShipPlacement(mainScreen);
    }

    public static void main(String args[]){
        MainScreen mainScreen  = new MainScreen();
    }
}
