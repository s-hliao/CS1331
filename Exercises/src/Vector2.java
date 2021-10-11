/**
 * Represents a 2D Vector in the x y plane.
 * 
 * @author henry
 * @version 1.0
 */
public class Vector2 {
    public final double x;
    public final double y;

    /**
     * Creates a Vector2 with given parameters.
     * 
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    /**
     * @return the vector in coordinate form
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Adds two vectors together and returns the result.
     * 
     * @param other The other vector to add this one to
     * @return sum of two vectors
     */
    public Vector2 plus(Vector2 other) {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    /**
     * Subtracts another vector from this vector and returns the result.
     * 
     * @param other the other vector to subtract from this one
     * @return difference between the two vectors
     */
    public Vector2 minus(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    /**
     * Performs a dot product on two vectors and returns the result.
     * 
     * @param other the other vector to perform a dot product on
     * @return dot product of the two vectors
     */
    public Vector2 dot(Vector2 other) {
        return new Vector2(this.x * other.x, this.y * other.y);
    }
}
