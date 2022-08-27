package Figures.RandomFactories;

import Figures.RandomFactories.RandomCircleFactory;
import Figures.RandomFactories.RandomRectangleFactory;
import Figures.RandomFactories.RandomTriangleFactory;
import Figures.TypesOfFigures.Circle;
import Figures.TypesOfFigures.Rectangle;
import Figures.TypesOfFigures.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomFactoriesTest {
    @Test
    void testRandomFigureFactories() {
        Circle circle = RandomCircleFactory.create();
        Rectangle rectangle = RandomRectangleFactory.create();
        Triangle triangle = RandomTriangleFactory.create();
        String strC = circle.toString();
        String strR = rectangle.toString();
        String strT = triangle.toString();

        assertFalse(strC.isEmpty());
        assertFalse(strR.isEmpty());
        assertFalse(strT.isEmpty());
    }
}