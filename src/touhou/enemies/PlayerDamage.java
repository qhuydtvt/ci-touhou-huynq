package touhou.enemies;

import bases.GameObject;
import bases.physics.BoxCollider;
import touhou.players.Player;

/**
 * Created by huynq on 10/25/17.
 */
public class PlayerDamage {

    public void run(Enemy owner) {
        BoxCollider boxCollider = owner.getBoxCollider();
        Player player = GameObject.collideWith(boxCollider, Player.class);
        if (player != null) {
            owner.isActive = false;
            player.getHit();
        }
    }
}
