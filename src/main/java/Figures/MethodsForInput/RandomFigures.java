package Figures.MethodsForInput;

import Figures.MainFactories.RandomFigureFactory;
import Figures.TypesOfFigures.Figure;

import java.util.List;
import java.util.Scanner;

public class RandomFigures {
    public static void create(List<Figure> figures) {
        System.out.println("How many figures to create: ");
        Scanner scanAmount = new Scanner(System.in);
        createFigures(figures, scanAmount);
    }

    public static void createFigures(List<Figure> figures, Scanner scanAmount) {
        int amount = scanAmount.nextInt();
        for (int i = 0; i < amount; i++) {
            figures.add(RandomFigureFactory.createFigure());
        }
    }
}
