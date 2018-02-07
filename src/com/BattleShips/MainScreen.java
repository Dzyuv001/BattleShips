package com.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {

    JPanel mainScreen;
    ShipBoard playedSide,enemySide;


    public MainScreen(){
        super("Battle Ships");
        setLayout(new BorderLayout());
        this.mainScreen = new JPanel();
        this.mainScreen.setLayout(new FlowLayout());
        add(mainScreen, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        initSide();


    }

    private void initSide(){
        enemySide = new ShipBoard(mainScreen);
        playedSide = new ShipBoard(mainScreen);

    }


    public static void main(String args[]){
        MainScreen mainScreen  = new MainScreen();
    }
}
