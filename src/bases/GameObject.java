package bases;

import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;

import java.awt.*;
import java.util.Vector;

/**
 * Created by huynq on 10/18/17.
 */
public class GameObject {
    public Vector2D position;

    public Renderer renderer;

    public boolean isActive;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObjects = new Vector<>();

    public static void runAll() {
        for (GameObject gameObject: gameObjects) {
            if (gameObject.isActive)
                gameObject.run();
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics g) {
        for (GameObject gameObject: gameObjects) {
            if (gameObject.isActive)
                gameObject.render(g);
        }
    }

    public void render(Graphics g) {
        if (renderer != null) {
            renderer.render(g, position);
        }
    }

    public static void add(GameObject gameObject) {
        newGameObjects.add(gameObject);
    }

    public static <T extends GameObject> T recycle(Class<T> cls) {
        for (GameObject gameObject: gameObjects) {
            if (gameObject.getClass().equals(cls)) {
                if (!gameObject.isActive) {
                    (gameObject).isActive = true;
                    return (T) gameObject;
                }
            }
        }

        try {
            T newGameObject = cls.newInstance();
            add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T extends PhysicsBody> T collideWith(BoxCollider boxCollider, Class<T> cls) {

        for (GameObject gameObject: gameObjects) {
            if (!gameObject.isActive) continue;
            if (!(gameObject instanceof PhysicsBody)) continue;
            if (!(gameObject.getClass().equals(cls))) continue;

            BoxCollider otherBoxCollider = ((PhysicsBody) gameObject).getBoxCollider();
            if (otherBoxCollider.collideWith(boxCollider)) {
                return (T)gameObject;
            }
        }

        return null;
    }


    public GameObject() {
        position = new Vector2D();
        isActive = true;
    }

    public void run() {

    }


}
