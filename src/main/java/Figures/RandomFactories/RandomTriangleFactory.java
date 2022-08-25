package Figures.RandomFactories;

import Figures.TypesOfFigures.Triangle;

public class RandomTriangleFactory {
    public static Triangle create() {
        while (true) {
            double sideA = Math.random() * 10.0;
            double sideB = Math.random() * 10.0;
            double sideC = Math.random() * 10.0;
            if (sideA + sideB > sideC &&
                    sideA + sideC > sideB &&
                    sideB + sideC > sideA) {
                return new Triangle(sideA, sideB, sideC);
            }
        }
    }
}
