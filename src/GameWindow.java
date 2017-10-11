import javax.swing.*;
import java.awt.*;

/**
 * Created by huynq on 10/11/17.
 */
public class GameWindow extends JFrame {

    GameCanvas canvas;

    public GameWindow() {
        this.setSize(800, 600);
        this.setVisible(true);

        this.canvas = new GameCanvas();
        this.setContentPane(this.canvas);
    }
}
