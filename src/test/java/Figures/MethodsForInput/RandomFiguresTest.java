package Figures.MethodsForInput;

import Figures.TypesOfFigures.Figure;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class RandomFiguresTest {

    @Test
    void testFiguresCreation() {
        List<Figure> figures = new ArrayList<>();
        Scanner scanner = new Scanner("100");
        RandomFigures.createFigures(figures, scanner);
        for (Figure figure : figures) {
            Scanner scanName = new Scanner(figure.toString());
            String name = scanName.next();

            assertThat(name).isIn("circle", "rectangle", "triangle");

            scanner.close();
        }

    }

}