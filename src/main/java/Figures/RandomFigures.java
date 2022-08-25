package Figures;

import Figures.MainFactories.RandomFigureFactory;
import Figures.TypesOfFigures.Figure;

import java.util.List;
import java.util.Scanner;

public class RandomFigures {
    protected static void create(List<Figure> figures) {
        System.out.println("How many figures to create: ");
        Scanner scanAmount = new Scanner(System.in);
        int amount = scanAmount.nextInt();
        for (int i = 0; i < amount; i++) {
            RandomFigureFactory factory = new RandomFigureFactory();
            figures.add(factory.createFigure());
        }
    }
}
