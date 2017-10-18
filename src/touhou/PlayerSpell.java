package touhou;

import bases.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by huynq on 10/14/17.
 */
public class PlayerSpell {
    public int x;
    public int y;

    BufferedImage image;
    final int SPEED = 10;

    public PlayerSpell() {
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
    }

    public void render(Graphics backGraphics) {
        backGraphics.drawImage(image, x, y,null);
    }

    public void run() {
        y -= SPEED;
    }
}
