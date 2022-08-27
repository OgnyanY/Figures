package Figures.TypesOfFigures;

import Figures.TypesOfFigures.Triangle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void testGetter() {
        Triangle triangle = new Triangle();
        triangle.fromString("triangle 2,2 3,3 6,5");
        assertEquals(2.2, triangle.getSideA());
        assertEquals(3.3, triangle.getSideB());
        assertEquals(6.5, triangle.getSideC());
    }

    @ParameterizedTest
    @CsvSource(value = {"-2.2, 23.2, 65.22", "-100.25, -25.2, 65.88", "0.2,-56.23,52.22"})
    void testConstructor(double sideA, double sideB, double sideC) {
        assertThrows(IllegalArgumentException.class,
                () -> new Triangle(sideA, sideB,sideC));
    }

    @ParameterizedTest
    @CsvSource({"2.2,13.823,32.046,48.069", "5.0,31.4159,72.8318,109.2477", "15.3,96.132,222.864,334.296"})
    void testPerimeter(double sideA, double sideB, double sideC, double expected) {
        Triangle triangle = new Triangle(sideA, sideB,sideC);
        assertEquals(expected, triangle.perimeter(), 0.001);
    }

    @ParameterizedTest
    @CsvSource(value = {"triangle 2,2 3,6 5,5|2.2|3.6|5.5", "triangle 200,2 356,6 123,56|200.2|356.6|123.56", "triangle 0,2 0,6 0,5|0.2|0.6|0.5"}, delimiter = '|')
    void testFromString(String data, double expectedA, double expectedB, double expectedC) {
        Triangle triangle = new Triangle();
        triangle.fromString(data);
        assertEquals(expectedA, triangle.getSideA());
        assertEquals(expectedB, triangle.getSideB());
        assertEquals(expectedC, triangle.getSideC());
    }

    @ParameterizedTest
    @CsvSource(value = {"circle 2,2 3,6 2,56", "circle -100,25 -23,66 -59,66", "triangle 20,3 -563,32 123,22"}, delimiter = '|')
    void testFromStringIncorrect(String data) {
        Triangle triangle = new Triangle();
        assertThrows(IllegalArgumentException.class,
                () -> triangle.fromString(data));
    }

    @Test
    void testToString() {
        Triangle triangle = new Triangle(2.2,3.5,7.2);
        assertEquals("triangle 2.2 3.5 7.2\n", triangle.toString());
    }

}