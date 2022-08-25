package Figures.MainFactories;

import Figures.RandomFactories.RandomCircleFactory;
import Figures.RandomFactories.RandomRectangleFactory;
import Figures.RandomFactories.RandomTriangleFactory;
import Figures.TypesOfFigures.Figure;

import java.util.concurrent.ThreadLocalRandom;


public class RandomFigureFactory {
    public Figure createFigure() {
        int max = 3;
        int min = 1;
        int random = randomGenerator(min, max);
        switch (random) {
            case 1:
                return RandomCircleFactory.create();
            case 2:
                return RandomRectangleFactory.create();
            case 3:
                return RandomTriangleFactory.create();
            default:
                throw new IllegalArgumentException("Incorrect figure.");
        }
    }

    private int randomGenerator(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
