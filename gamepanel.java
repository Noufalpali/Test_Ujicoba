package game2d;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class gamepanel extends JPanel implements Runnable {
    
    //screen setting
    final int originalTilesize = 16;
    final int scale = 3;

    final int tileSize = originalTilesize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int Screenwidth = tileSize * maxScreenCol;
    final int Screenheight = tileSize * maxScreenRow;

    int fps = 60;

    keyhandlers keyit = new keyhandlers();
    Thread gameThread;

    int playerx = 100;
    int playery = 100;
    int playerspeed = 4;

    public gamepanel() {
        this.setPreferredSize(new Dimension(Screenwidth, Screenheight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyit);
        this.setFocusable(true);
    }

    public void startgameThread () {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
    double drawInterval = 1000000000/fps;
     
       while (gameThread != null) {
        update();

        repaint();

       }
    }
    public void update() {
        if (keyit.upPreased == true) {
            playery -= playerspeed;
        } else if(keyit.downPreased == true) {
            playery += playerspeed;
        } else if(keyit.leftPreased == true) {
            playerx -= playerspeed;
        } else if(keyit.rightPreased == true) {
            playerx += playerspeed;
        }
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(playerx, playery, tileSize, tileSize);
        g2.dispose();
    }
}
