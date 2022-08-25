package Figures.RandomFactories;

import Figures.TypesOfFigures.Circle;

public class RandomCircleFactory {
    public static Circle create() {
        return new Circle(Math.random() * 10.0);
    }
}
