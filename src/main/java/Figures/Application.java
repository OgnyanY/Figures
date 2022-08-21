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
                makeRandomFigures();
                break;
            case "input":
                makeFigureFromIn();
                break;
            case "file":
                makeFigureFromFile();
                break;
            default:
                throw new IllegalArgumentException("Incorrect method.");
        }
        insert.close();
    }

    public void makeRandomFigures() {
        int max = 3;
        int min = 1;

        System.out.println("How many figures to create: ");
        Scanner scanAmount = new Scanner(System.in);
        int amount = scanAmount.nextInt();
        for (int i = 0; i < amount; i++) {

            int random = (int) (Math.random() * (max - min)) + max;

            switch (random) {
                case 1:
                    Circle circle = RandomCircleFactory.create();
                    figures.add(circle);
                    break;
                case 2:
                    Rectangle rectangle = RandomRectangleFactory.create();
                    figures.add(rectangle);
                    break;
                case 3:
                    Triangle triangle = RandomTriangleFactory.create();
                    break;
                default:
                    throw new IllegalArgumentException("Incorrect figure.");
            }
        }
    }

    public void makeFigureFromIn() {
        System.out.println("How many figures to create: ");
        Scanner scanAmount = new Scanner(System.in);
        int amount = scanAmount.nextInt();

        for (int i = 0; i < amount; i++) {
            System.out.println("Input figure: ");
            Scanner scanFigure = new Scanner(System.in);
            String figure = scanFigure.nextLine();

            addFigure(figure);

            scanFigure.close();
        }
    }

    public void makeFigureFromFile() throws FileNotFoundException {
        System.out.println("Input file name: ");
        Scanner scanIn = new Scanner(System.in);
        String fileName = scanIn.nextLine();
        File file = new File(fileName);
        Scanner readFile = new Scanner(file);

        while (readFile.hasNextLine()) {
            String figure = readFile.nextLine();
            addFigure(figure);
        }
        scanIn.close();
        readFile.close();
    }

    private void addFigure(String data){
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
