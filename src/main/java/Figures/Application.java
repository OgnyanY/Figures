package Figures;

import Figures.TypesOfFigures.Figure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private final List<Figure> figures = new ArrayList<>();


    public void start(){
        System.out.println("Choose method to insert figures: ");
        Scanner insert = new Scanner(System.in);
        String method = insert.next();
        method = method.toLowerCase();

        switch (method) {
            case "random":
                RandomFigures.create(figures);
                break;
            case "input":
                FiguresFromStream.createFromIn(figures);
                break;
            case "file":
                FiguresFromStream.createFromFile(figures);
                break;
            default:
                throw new IllegalArgumentException("Incorrect method.");
        }
        insert.close();
    }

    public void ListFigures() {
        if (figures.size() <= 0) {
            throw new IllegalArgumentException("There is no figures");
        }
        for (Figure figure : figures) {
            System.out.println(figure.toString());
        }
    }

    public void DeleteFigure(int index) {
        figures.remove(index);
    }

    public void CloneFigure(int index) throws CloneNotSupportedException {
        Figure newFigure = figures.get(index).clone();
        figures.add(newFigure);
    }

    public void StoreInFile(String file) {
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

    public List<Figure> getFigures() {
        return figures;
    }
}
