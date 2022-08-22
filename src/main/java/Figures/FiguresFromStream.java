package Figures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class FiguresFromStream {
    protected static void createFromIn(List<Figure> figures) {
        System.out.println("How many figures to create: ");
        Scanner scanAmount = new Scanner(System.in);
        int amount = scanAmount.nextInt();

        for (int i = 0; i < amount; i++) {
            System.out.println("Input figure: ");
            Scanner scanFigure = new Scanner(System.in);
            String figure = scanFigure.nextLine();

            addFigure(figures, figure);

            scanFigure.close();
        }
    }

    protected static void createFromFile(List<Figure> figures) throws FileNotFoundException {
        System.out.println("Input file name: ");
        Scanner scanIn = new Scanner(System.in);
        String fileName = scanIn.nextLine();
        File file = new File(fileName);
        Scanner readFile = new Scanner(file);

        while (readFile.hasNextLine()) {
            String figure = readFile.nextLine();
            addFigure(figures, figure);
        }
        scanIn.close();
        readFile.close();
    }

    private static void addFigure(List<Figure> figures, String data) {
        Scanner scanData = new Scanner(data).useDelimiter("\\s");
        String name = scanData.next();
        name = name.toLowerCase();

        switch (name) {
            case "circle":
                Circle circle = FromStringCircleFactory.create(data);
                figures.add(circle);
                break;
            case "rectangle":
                Rectangle rectangle = FromStringRectangleFactory.create(data);
                figures.add(rectangle);
                break;
            case "triangle":
                Triangle triangle = FromStringTriangleFactory.create(data);
                figures.add(triangle);
                break;
            default:
                throw new IllegalArgumentException("Incorrect figure.");
        }
    }
}
