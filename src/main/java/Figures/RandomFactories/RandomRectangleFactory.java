package Figures.RandomFactories;

import Figures.TypesOfFigures.Rectangle;

public class RandomRectangleFactory {
    public static Rectangle create(){
        return new Rectangle(Math.random() * 10.0,
                            Math.random() * 10.0);
    }
}
