package Figures;

import java.util.List;
import java.util.Scanner;

public class RandomFigures {
    protected static void create(List<Figure> figures) {
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
}
