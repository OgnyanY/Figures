package Figures.TypesOfFigures;

import Figures.TypesOfFigures.Circle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @ParameterizedTest
    @CsvSource(value = {"-2.2", "-100.25", "-0.2"})
    void testConstructor(double radius){
        assertThrows(IllegalArgumentException.class,
                () -> new Circle(radius));
    }

    @Test
    void testGetter(){
        Circle circle = new Circle();
        circle.fromString("circle 2,2");
        assertEquals(2.2,circle.getRadius());
    }

    @ParameterizedTest
    @CsvSource({"2.2,13.823", "5.0,31.4159", "15.3,96.132"})
    void testPerimeter(double radius, double expected) {
        Circle circle = new Circle(radius);
        assertEquals(expected, circle.perimeter(),0.001);
    }

    @ParameterizedTest
    @CsvSource(value = {"circle 2,2|2.2",
                        "circle 100,25|100.25",
                        "circle 20,233|20.233"},delimiter = '|')
    void testFromString(String data, double expected){
        Circle circle = new Circle();
        circle.fromString(data);
        assertEquals(expected,circle.getRadius());
    }

    @ParameterizedTest
    @CsvSource(value = {"rectangle 2,2", "circle -100,25", "triangle 0"},delimiter = '|')
    void testFromStringIncorrect(String data){
        Circle circle = new Circle();
        assertThrows(IllegalArgumentException.class,
                () -> circle.fromString(data));
    }

    @Test
    void testToString(){
        Circle circle = new Circle(2.2);
        assertEquals("circle 2.2\n",circle.toString());
    }

}