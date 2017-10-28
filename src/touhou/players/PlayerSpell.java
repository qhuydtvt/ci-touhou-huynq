package touhou.players;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.enemies.Enemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by huynq on 10/14/17.
 */
public class PlayerSpell extends GameObject {

    final int SPEED = 10;
    public BoxCollider boxCollider;

    public PlayerSpell() {
        this.renderer = new ImageRenderer("assets/images/player-bullets/a/0.png");
        this.boxCollider = new BoxCollider(20, 20);
    }

    public void run() {
        this.position.subtractBy(0, SPEED);
        this.boxCollider.position.set(this.position);

        Enemy enemy = GameObject.collideWith(this.boxCollider, Enemy.class);
        if (enemy != null) {
            enemy.getHit();
            this.isActive = false;
        }

        deactiveIfNeded();
    }

    private void deactiveIfNeded() {
        if (position.y < 0) {
            this.isActive = false;
        }
    }
}
