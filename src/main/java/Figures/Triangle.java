package Figures;

import java.util.Scanner;

public class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
        this.sideA = 0;
        this.sideB = 0;
        this.sideC = 0;
    }

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA >= 0 && sideB >= 0 && sideC >= 0) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        } else {
            throw new IllegalArgumentException("Incorrect data.");
        }
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        return (Triangle) super.clone();
    }

    public void fromString(String data) {
        Scanner scanner = new Scanner(data).useDelimiter("\\s");
        String name = scanner.next();
        name = name.toLowerCase();
        double tempA = scanner.nextDouble();
        double tempB = scanner.nextDouble();
        double tempC = scanner.nextDouble();
        if (name.equals("triangle") && tempA >= 0 && tempB >= 0 && tempC >= 0) {
            this.sideA = tempA;
            this.sideB = tempB;
            this.sideC = tempC;
        } else {
            throw new IllegalArgumentException("Incorrect data.");
        }
    }

    @Override
    public String toString() {
        return "triangle " + sideA + " " + sideB + " " + sideC + "\n";
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}
