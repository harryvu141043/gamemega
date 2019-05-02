package com.son.userinterface;

import java.awt.event.KeyEvent;

public class InputManager {
    public void processKeyPressed(int keycode) {
        switch (keycode){
            case KeyEvent.VK_UP:
                System.out.println("you press up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("you press down");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("you press left");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("you press right");
                break;
            case KeyEvent.VK_ENTER:
                System.out.println("you press enter");
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("you press space");
                break;
            case KeyEvent.VK_A:
                System.out.println("you press a");
                break;
        }

    }
    public void processKeyReleased(int keycode) {
        switch (keycode){
            case KeyEvent.VK_UP:
                System.out.println("you released up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("you released down");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("you released  left");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("you released  right");
                break;
            case KeyEvent.VK_ENTER:
                System.out.println("you released  enter");
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("you released space");
                break;
            case KeyEvent.VK_A:
                System.out.println("you released a");
                break;
        }

    }
}
