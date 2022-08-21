package Figures;

import java.util.Scanner;

public class Circle extends Figure {
    private double radius;

    public Circle() {
        this.radius = 0;
    }

    public Circle(double radius) {
        if(radius >= 0){
            this.radius = radius;
        }else{
            throw new IllegalArgumentException("Incorrect radius.");
        }

    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    public void fromString(String data) {
        Scanner scanner = new Scanner(data).useDelimiter("\\s");
        String name = scanner.next();
        name = name.toLowerCase();
        double tempRadius = scanner.nextDouble();
        if (name.equals("circle") && tempRadius >= 0) {
            this.radius = tempRadius;
        } else {
            throw new IllegalArgumentException("Incorrect data.");
        }
    }

    @Override
    public String toString() {
        return "circle " + radius + "\n";
    }

    public double getRadius() {
        return radius;
    }
}
