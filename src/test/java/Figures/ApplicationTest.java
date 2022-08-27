package Figures;

import Figures.MethodsForInput.FiguresFromScanner;
import Figures.TypesOfFigures.Figure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    Application app;

    @BeforeEach
    void input() {
        app = new Application();
    }

    @Test
    void testListFiguresForSize0() {
        assertThrows(IllegalArgumentException.class,
                () -> app.listFigures());
    }

    @Test
    void testDeleteFigure() {
        try {
            File file = new File("data");
            Scanner myReader = new Scanner(file);
            FiguresFromScanner.create(myReader, app.getFigures());
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int before = app.getFigures().size();
        app.deleteFigure(0);
        app.deleteFigure(app.getFigures().size() - 1);

        assertEquals(app.getFigures().size(), before - 2, "It`s not deleted figures");
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        try {
            File file = new File("data");
            Scanner myReader = new Scanner(file);
            FiguresFromScanner.create(myReader, app.getFigures());
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Figure first = app.getFigures().get(0);
        Figure last = app.getFigures().get(app.getFigures().size() - 1);

        app.cloneFigure(app.getFigures().size() - 1);
        assertEquals(last.toString(), app.getFigures().get(app.getFigures().size() - 1).toString(),
                "It`s not the same figure");
        app.cloneFigure(0);
        assertEquals(first.toString(), app.getFigures().get(app.getFigures().size() - 1).toString(),
                "It`s not the same figure");
    }

    @Test
    void testStoreInFile() {
        try {
            File file = new File("data");
            Scanner myReader = new Scanner(file);
            FiguresFromScanner.create(myReader, app.getFigures());
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        app.storeInFile("actual.txt");

        File actualFile = new File("actual.txt");
        File expectedFile = new File("expected.txt");
        assertThat(actualFile).hasSameTextualContentAs(expectedFile);
    }


}