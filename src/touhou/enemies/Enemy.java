package touhou.enemies;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;

/**
 * Created by huynq on 10/21/17.
 */
public class Enemy extends GameObject implements PhysicsBody {

    public BoxCollider boxCollider;
    PlayerDamage playerDamage;

    public Enemy() {
//        this.image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
        this.renderer = new ImageRenderer("assets/images/enemies/level0/blue/0.png");
        boxCollider = new BoxCollider(30, 30);
        this.playerDamage = new PlayerDamage();
    }

    @Override
    public void run() {
        position.addUp(0, 2);
        boxCollider.position.set(this.position);
        this.playerDamage.run(this);
    }

    public void getHit() {
        isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
