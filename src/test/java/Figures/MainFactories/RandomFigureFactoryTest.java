package Figures.MainFactories;

import Figures.TypesOfFigures.Figure;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class RandomFigureFactoryTest {

    @Test
    void testCorrectRandomGeneration() {
        for (int i = 0; i < 100; i++) {
            Figure figure = RandomFigureFactory.createFigure();
            Scanner scanner = new Scanner(figure.toString());
            String name = scanner.next();

            assertThat(name).isIn("circle", "rectangle", "triangle");

            scanner.close();
        }
    }

}