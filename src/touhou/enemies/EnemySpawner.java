package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

/**
 * Created by huynq on 10/21/17.
 */
public class EnemySpawner extends GameObject {

    FrameCounter frameCounter = new FrameCounter(200);
    Random random = new Random();

    @Override
    public void run() {
        if (frameCounter.run()) {
            frameCounter.reset();
            spawn();
        }
    }

    private void spawn() {
        Enemy enemy = new Enemy();
        enemy.position.set(random.nextInt(384), 0);
        GameObject.add(enemy);
    }
}
