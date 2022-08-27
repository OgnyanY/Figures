package Figures.MainFactories;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FromStringFigureFactoryTest {
    @ParameterizedTest
    @CsvSource(value = {"triangle 2,2 3,6 5,5|triangle 2.2 3.6 5.5",
            "circle 2,2|circle 2.2",
            "rectangle 200,2 356,6|rectangle 200.2 356.6"}, delimiter = '|')
    void testCreatingCorrectFigure(String data, String expected) {
        assertEquals(expected + '\n', FromStringFigureFactory.createFigure(data).toString());

    }

    @ParameterizedTest
    @CsvSource(value = {"rectangle -2,2 3,6 2,56",
            "circle -100,25 -23,66 -59,66",
            "triangle 20,3 -563,32 123,22"}, delimiter = '|')
    void testCreatingIncorrectFigure(String data) {
        assertThrows(IllegalArgumentException.class,
                () -> FromStringFigureFactory.createFigure(data));
    }

}