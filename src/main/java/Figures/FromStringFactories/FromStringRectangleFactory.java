package Figures.FromStringFactories;

import Figures.TypesOfFigures.Rectangle;

public class FromStringRectangleFactory {
    public static Rectangle create(String data) {
        Rectangle rectangle = new Rectangle();
        rectangle.fromString(data);
        return rectangle;
    }
}
