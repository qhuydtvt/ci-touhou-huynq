import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by huynq on 10/11/17.
 */
public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;

    public GameCanvas() {
        // 1. Load Background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2. Draw background
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(player, 182, 500, null);
    }

}
