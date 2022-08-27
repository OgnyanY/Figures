package Figures.MethodsForInput;

import Figures.TypesOfFigures.Figure;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class FiguresFromScannerTest {
    @Test
    void testCreatingCorrectFiguresFromFile() {
        List<Figure> figures = new ArrayList<>();
        try {
            File file = new File("data");
            Scanner myReader = new Scanner(file);
            FiguresFromScanner.create(myReader, figures);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myFile = new File("actual.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("actual.txt");
            for (Figure figure : figures) {
                writer.write(figure.toString());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        File actualFile = new File("actual.txt");
        File expectedFile = new File("expected.txt");
        assertThat(actualFile).hasSameTextualContentAs(expectedFile);
    }

}