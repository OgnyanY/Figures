package Figures.FromStringFactories;

import Figures.TypesOfFigures.Triangle;

public class FromStringTriangleFactory {
    public static Triangle create(String data) {
        Triangle triangle = new Triangle();
        triangle.fromString(data);
        return triangle;
    }
}
