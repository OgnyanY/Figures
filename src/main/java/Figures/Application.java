package Figures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Application {
    private List<Figure> figures;

    public void start() throws FileNotFoundException {
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

    /*public void StoreInFile(String file) {
        return;
    }*/

    public List<Figure> getFigures() {
        return figures;
    }
}
