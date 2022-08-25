package Figures.MainFactories;

import Figures.FromStringFactories.FromStringCircleFactory;
import Figures.FromStringFactories.FromStringRectangleFactory;
import Figures.FromStringFactories.FromStringTriangleFactory;
import Figures.TypesOfFigures.Figure;


import java.util.List;
import java.util.Scanner;

public class FromStringFigureFactory {
    public Figure createFigure(String data) {
        Scanner scanData = new Scanner(data).useDelimiter("\\s");
        String name = scanData.next();
        name = name.toLowerCase();

        switch (name) {
            case "circle":
                return FromStringCircleFactory.create(data);
            case "rectangle":
                return FromStringRectangleFactory.create(data);
            case "triangle":
                return FromStringTriangleFactory.create(data);
            default:
                throw new IllegalArgumentException("Incorrect figure.");
        }
    }
}
