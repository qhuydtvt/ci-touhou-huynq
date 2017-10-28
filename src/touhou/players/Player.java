package touhou.players;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.inputs.InputManager;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_X;

/**
 * Created by huynq on 10/14/17.
 */
public class Player extends GameObject implements PhysicsBody {

    final int SPEED = 5;

    final int LEFT = 0;
    final int RIGHT = 384;
    final int TOP = 0;
    final int BOTTOM = 500;

    private BoxCollider boxCollider;
    PlayerCastSpell castSpell;

    public Player() {
        position.set(182, 500);

        this.renderer = new ImageRenderer("assets/images/players/straight/0.png");

        boxCollider = new BoxCollider(8, 8);

        castSpell = new PlayerCastSpell();
    }

    public void run() {
        move();

        castSpell.run(this);
    }

    Vector2D velocity = new Vector2D();

    private void move() {
        velocity.set(0, 0);

        InputManager inputManager = InputManager.instance;

        if (inputManager.rightPressed) {
            velocity.x += SPEED;
        }

        if (inputManager.leftPressed) {
            velocity.x -= SPEED;
        }

        if(inputManager.downPressed) {
            velocity.y += SPEED;
        }

        if(inputManager.upPressed) {
            velocity.y -= SPEED;
        }

        position.addUp(velocity);

        position.x = (int)clamp(position.x, LEFT, RIGHT);
        position.y = (int)clamp(position.y, TOP, BOTTOM);

        boxCollider.position.set(this.position);
    }

    private float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }

        if (value > max) {
            return max;
        }

        return value;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    public void getHit() {
        System.out.println("Player get hit");
        // TODO: Change to game over scene
    }
}
