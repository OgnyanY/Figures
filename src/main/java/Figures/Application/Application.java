package Figures.Application;

import Figures.MethodsForInput.FiguresFromScanner;
import Figures.MethodsForInput.RandomFigures;
import Figures.TypesOfFigures.Figure;
import lombok.Getter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private final @Getter
    List<Figure> figures = new ArrayList<>();


    public void createFigures(String method) {
        switch (method) {
            case "random":
                RandomFigures.create(figures);
                break;
            case "input":
                FiguresFromScanner.createFromIn(figures);
                break;
            case "file":
                FiguresFromScanner.createFromFile(figures);
                break;
            default:
                throw new IllegalArgumentException("Incorrect method.");
        }
    }

    public void listFigures() {
        if (figures.size() <= 0) {
            throw new IllegalArgumentException("There is no figures");
        }
        for (Figure figure : figures) {
            System.out.println(figure.toString());
        }
    }

    public void deleteFigure(int index) {
        figures.remove(index);
    }

    public void cloneFigure(int index) throws CloneNotSupportedException {
        Figure newFigure = figures.get(index).clone();
        figures.add(newFigure);
    }

    public void storeInFile(String file) {
        try {
            File myFile = new File(file);
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(file);
            for (Figure figure : figures) {
                writer.write(figure.toString());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
