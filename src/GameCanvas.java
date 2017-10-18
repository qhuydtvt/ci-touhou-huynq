import touhou.Player;
import touhou.PlayerSpell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

/**
 * Created by huynq on 10/11/17.
 */
public class GameCanvas extends JPanel {

    BufferedImage background;

    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player();
    ArrayList<PlayerSpell> spells = new ArrayList<>();

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
    }

    public void render() {
        //1. Draw everything on back buffer
        backGraphics.drawImage(background, 0, 0, null);
        player.render(backGraphics);

        for (PlayerSpell spell: spells) {
            spell.render(backGraphics);
        }

        //2. Call repaint
        repaint();
    }

    //2. Draw background

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }


    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }


    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }

    public void run() {
        player.run();
        player.shoot(spells);

        for(PlayerSpell spell: spells) {
            spell.run();
        }
    }
}
