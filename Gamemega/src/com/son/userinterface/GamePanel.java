package com.son.userinterface;

import com.son.effect.Animation;
import com.son.effect.CacheDataloader;
import com.son.effect.FrameImage;

import javax.imageio.IIOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    private Thread thread;
    private boolean isRunning;
    private InputManager InputManager;
    FrameImage frame1;



    public GamePanel() {
        InputManager = new InputManager ();
        frame1= CacheDataloader.getInstance ().getFrameImage ( "idle2" );
    }

    @Override
    public void paint(Graphics g) {
        super.paint ( g );
        Graphics2D g2=(Graphics2D) g;
        frame1.draw (g2,30,30  );


    }
    public void Startgame() {
        if (thread == null) {
            isRunning = true;
            thread = new Thread ( this );
            thread.start ();
        }
    }


    @Override
    public void run() {
        long FPS = 80;
        long period = 1000 * 1000000 / FPS;
        long begintime = System.nanoTime ();
        long sleeptime;
        int a = 1;

        while (isRunning) {

            long deltatime = System.nanoTime () - begintime;
            sleeptime = period - deltatime;
            try {
                if (sleeptime > 0)
                    Thread.sleep ( sleeptime / 1000000 );
                else Thread.sleep ( period / 2000000 );
            } catch (InterruptedException ex) {}
            begintime = System.nanoTime ();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        InputManager.processKeyPressed ( e.getKeyCode () );
    }

    @Override
    public void keyReleased(KeyEvent e) {
        InputManager.processKeyReleased ( e.getKeyCode () );
    }
}
