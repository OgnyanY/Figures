package Figures.FromStringFactories;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FromStringCircleFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"circle 266,2|circle 266.2",
            "circle 100,2555|circle 100.2555",
            "circle 200,233|circle 200.233"}, delimiter = '|')
    void testCreatingCorrectFigure(String data, String expected) {

        assertEquals(expected + '\n', FromStringCircleFactory.create(data).toString());
    }

    @ParameterizedTest
    @CsvSource(value = {"rectangle 2,2", "circle -100,25", "triangle 0"}, delimiter = '|')
    void testCreatingIncorrectFigure(String data) {
        assertThrows(IllegalArgumentException.class,
                () -> FromStringCircleFactory.create(data));
    }

}