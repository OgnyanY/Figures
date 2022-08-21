package Figures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RandomFactoryTest {
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