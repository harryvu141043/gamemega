package com.son.userinterface;

import com.son.effect.Animation;
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
    BufferedImage Image;
    BufferedImage SubImage;
    FrameImage frame1;
    FrameImage frame2;
    FrameImage frame3;
    Animation anim;


    public GamePanel() {
        InputManager = new InputManager ();
        try {
            BufferedImage image = ImageIO.read ( new File ( "data/megasprite.png" ) );
            BufferedImage image1=image.getSubimage(529,38,90,100);
            frame1=new FrameImage("frame1",image1);
            BufferedImage image2=image.getSubimage(616,38,80,100);
            frame2=new FrameImage("frame2",image2);
            BufferedImage image3=image.getSubimage(704,38,80,100);
            frame3=new FrameImage("frame3",image3);

            anim=new Animation();
            anim.add(frame1,500*1000000);
            anim.add(frame2,500*1000000);
            anim.add(frame3,500*1000000);
        } catch (IOException ex) {
            ex.printStackTrace ();
        }





    }

    @Override
    public void paint(Graphics g) {
        super.paint ( g );
        Graphics2D g2=(Graphics2D) g;

        anim.Update ( System.nanoTime());
        anim.draw (100,130,g2);

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
            repaint ();
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
