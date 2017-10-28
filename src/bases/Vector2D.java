package bases;


/**
 * Created by huynq on 10/18/17.
 */
public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D other) {
        set(other.x, other.y);
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    public void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D other) {
        this.addUp(other.x, other.y);
    }

    public Vector2D add(float x, float y) {
//        Vector2D newVector = new Vector2D();
//        newVector.x = this.x + x;
//        newVector.y = this.y + y;
//        return newVector;
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D other) {
        return add(other.x, other.y);
    }

    public void subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    public void subtractBy(Vector2D other) {
        subtractBy(other.x, other.y);
    }

    public Vector2D subtract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D subtract(Vector2D other) {
        return subtract(other.x, other.y);
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2D normalize() {
        float length = length();
        return new Vector2D(this.x / length, this.y / length);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
