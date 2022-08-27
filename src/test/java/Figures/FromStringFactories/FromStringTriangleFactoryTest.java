package Figures.FromStringFactories;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FromStringTriangleFactoryTest {
    @ParameterizedTest
    @CsvSource(value = {"triangle 2,2 3,6 5,5|triangle 2.2 3.6 5.5",
            "triangle 200,2 356,6 123,56|triangle 200.2 356.6 123.56",
            "triangle 0,2 0,6 0,5|triangle 0.2 0.6 0.5"}, delimiter = '|')
    void testCreatingCorrectFigure(String data, String expected) {
        assertEquals(expected + '\n', FromStringTriangleFactory.create(data).toString());

    }

    @ParameterizedTest
    @CsvSource(value = {"circle 2,2 3,6 2,56",
            "circle -100,25 -23,66 -59,66",
            "triangle 20,3 -563,32 123,22"}, delimiter = '|')
    void testCreatingIncorrectFigure(String data) {
        assertThrows(IllegalArgumentException.class,
                () -> FromStringTriangleFactory.create(data));
    }

}