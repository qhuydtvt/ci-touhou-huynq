import bases.GameObject;
import touhou.enemies.EnemySpawner;
import touhou.players.Player;

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

    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player();

    public GameCanvas() {

        //1. Create back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        // 2. Load Background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameObject.add(player);
        GameObject.add(new EnemySpawner());
    }

    public void render() {
        //1. Draw everything on back buffer
        backGraphics.drawImage(background, 0, 0, null);

        GameObject.renderAll(backGraphics);

        //2. Call repaint
        repaint();
    }

    //2. Draw background

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }


    public void run() {
        GameObject.runAll();
    }
}
