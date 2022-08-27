package Figures.FromStringFactories;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FromStringRectangleFactoryTest {
    @ParameterizedTest
    @CsvSource(value = {"rectangle 2,2 3,6|rectangle 2.2 3.6",
            "rectangle 200,2 356,6|rectangle 200.2 356.6",
            "rectangle 0,2 0,6|rectangle 0.2 0.6"}, delimiter = '|')
    void testCreatingCorrectFigure(String data, String expected) {
        assertEquals(expected + '\n', FromStringRectangleFactory.create(data).toString());

    }

    @ParameterizedTest
    @CsvSource(value = {"circle 2,2 3,6", "circle -100,25 -23,66", "rectangle 20,3 -563,32"}, delimiter = '|')
    void testCreatingIncorrectFigure(String data) {
        assertThrows(IllegalArgumentException.class,
                () -> FromStringRectangleFactory.create(data));
    }

}