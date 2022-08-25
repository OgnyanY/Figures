package Figures;

import Figures.TypesOfFigures.Rectangle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testGetter() {
        Rectangle rectangle = new Rectangle();
        rectangle.fromString("rectangle 2,2 3,3");
        assertEquals(2.2, rectangle.getSideA());
        assertEquals(3.3, rectangle.getSideB());
    }

    @ParameterizedTest
    @CsvSource(value = {"-2.2, 23.2", "-100.25, -25.2", "0.2,-56.23"})
    void testConstructor(double sideA, double sideB) {
        assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(sideA, sideB));
    }

    @ParameterizedTest
    @CsvSource({"2.2,13.823,32.046", "5.0,31.4159,72.8318", "15.3,96.132,222.864"})
    void testPerimeter(double sideA, double sideB, double expected) {
        Rectangle rectangle = new Rectangle(sideA, sideB);
        assertEquals(expected, rectangle.perimeter(), 0.001);
    }

    @ParameterizedTest
    @CsvSource(value = {"rectangle 2,2 3,6|2.2|3.6", "rectangle 200,2 356,6|200.2|356.6", "rectangle 0,2 0,6|0.2|0.6"}, delimiter = '|')
    void testFromString(String data, double expectedA, double expectedB) {
        Rectangle rectangle = new Rectangle();
        rectangle.fromString(data);
        assertEquals(expectedA, rectangle.getSideA());
        assertEquals(expectedB, rectangle.getSideB());
    }

    @ParameterizedTest
    @CsvSource(value = {"circle 2,2 3,6", "circle -100,25 -23,66", "rectangle 20,3 -563,32"}, delimiter = '|')
    void testFromStringIncorrect(String data) {
        Rectangle rectangle = new Rectangle();
        assertThrows(IllegalArgumentException.class,
                () -> rectangle.fromString(data));
    }

    @Test
    void testToString() {
        Rectangle rectangle = new Rectangle(2.2,3.6);
        assertEquals("rectangle 2.2 3.6\n", rectangle.toString());
    }

}