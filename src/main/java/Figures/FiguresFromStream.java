package Figures;

import Figures.MainFactories.FromStringFigureFactory;
import Figures.TypesOfFigures.Figure;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FiguresFromStream {
    protected static void createFromIn(List<Figure> figures) {
        System.out.println("How many figures to create: ");
        Scanner scanAmount = new Scanner(System.in);
        int amount = scanAmount.nextInt();

        Scanner scanFigure = new Scanner(System.in);
        for (int i = 0; i < amount; i++) {
            System.out.println("Input figure: ");
            String figure = scanFigure.nextLine();

            FromStringFigureFactory factory = new FromStringFigureFactory();
            figures.add(factory.createFigure(figure));
        }
        scanFigure.close();
    }

    protected static void createFromFile(List<Figure> figures){
        System.out.println("Input file name: ");
        Scanner scanIn = new Scanner(System.in);
        String fileName = scanIn.nextLine();

        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                FromStringFigureFactory factory = new FromStringFigureFactory();
                figures.add(factory.createFigure(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        scanIn.close();
    }
}
