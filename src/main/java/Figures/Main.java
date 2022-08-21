package Figures;

public class Main {
    public static void main() {

        double sumOfAreas = 0.0;
        double sumOfPerimeters = 0.0;

        for(int i = 0; i < 10; ++i) {
            try {
                //Figure f = StdinFigureFactory.create();
                //sumOfAreas += f.area();
                //sumOfPerimters += f.perimeter();
            } catch(Exception e) {
                System.out.println("Invalid input! Try again.");
                --i;
            }
        }

        System.out.println("Total area: " + sumOfAreas);
        //System.out.println("Total perimeter: " + sumOfPerimteters);

    }
}
