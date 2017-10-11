import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by huynq on 10/11/17.
 */
public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;

    int playerX = 182;
    int playerY = 500;

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    BufferedImage backBuffer;
    Graphics backGraphics;

    public GameCanvas() {
        //1. Create back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        // 2. Load Background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render() {
        //1. Draw everything on back buffer
        backGraphics.drawImage(background, 0, 0, null);
        backGraphics.drawImage(player, playerX, playerY, null);

        //2. Call repaint
        repaint();
    }

    //2. Draw background
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
    }

    public void run() {
        int vx = 0;
        int vy = 0;

        if (rightPressed) {
            vx += 5;
        }

        if (leftPressed) {
            vx -= 5;
        }

        playerX = playerX + vx;
    }
}
