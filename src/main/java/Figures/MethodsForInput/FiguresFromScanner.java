package Figures.MethodsForInput;

import Figures.MainFactories.FromStringFigureFactory;
import Figures.TypesOfFigures.Figure;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FiguresFromScanner {
    protected static void create(Scanner scanner, List<Figure> figures) {
        boolean exit = false;
        do {
            String figure = scanner.nextLine();
            if (!figure.equals("exit")) {
                FromStringFigureFactory factory = new FromStringFigureFactory();
                figures.add(factory.createFigure(figure));
            } else {
                exit = true;
            }
        } while (!exit);
    }

    public static void createFromIn(List<Figure> figures) {
        System.out.println("Input figures or write exit to end: ");
        Scanner scanFigure = new Scanner(System.in);
        create(scanFigure, figures);
        scanFigure.close();
    }

    public static void createFromFile(List<Figure> figures) {
        System.out.println("Input file name: ");
        Scanner scanIn = new Scanner(System.in);
        String fileName = scanIn.nextLine();
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            create(myReader, figures);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        scanIn.close();
    }
}
