package Figures;

public class FromStringTriangleFactory {
    public static Triangle create(String data) {
        Triangle triangle = new Triangle();
        triangle.fromString(data);
        return triangle;
    }
}
