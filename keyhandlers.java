package game2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyhandlers implements KeyListener{

    public boolean upPreased, downPreased, leftPreased, rightPreased;

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPreased = true;
        } if (code == KeyEvent.VK_A) {
            leftPreased = true;
        } if (code == KeyEvent.VK_S) {
            downPreased = true;
        } if (code == KeyEvent.VK_D) {
            rightPreased = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPreased = false;
        } if (code == KeyEvent.VK_A) {
            leftPreased = false;
        } if (code == KeyEvent.VK_S) {
            downPreased = false;
        } if (code == KeyEvent.VK_D) {
            rightPreased = false;
        }
    }
    
}
