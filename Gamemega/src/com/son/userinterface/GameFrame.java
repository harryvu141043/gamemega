package com.son.userinterface;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 400;
    GamePanel GamePanel;

    public GameFrame()  {
        Toolkit toolkit = this.getToolkit();
        Dimension Dimension = toolkit.getScreenSize();
        this.setBounds((Dimension.width - SCREEN_WIDTH) / 2, (Dimension.height - SCREEN_HEIGHT) / 2, SCREEN_WIDTH, SCREEN_HEIGHT);
        GamePanel=new GamePanel();
        this.add(GamePanel);
        this.addKeyListener(GamePanel);
    }
    public void  Startgame(){
        GamePanel.Startgame();
    }

    public static void main(String[] args) {
        GameFrame gameFrame=new GameFrame();
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.Startgame();


    }


}
