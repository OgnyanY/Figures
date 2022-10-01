package Figures;

import Figures.Application.Application;
import Figures.MethodsForInput.FiguresFromScanner;
import Figures.MethodsForInput.RandomFigures;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Application app = new Application();

        System.out.println("Choose (random, input or file) for method to insert figures: ");
        Scanner insert = new Scanner(System.in);
        String method = insert.next();
        method = method.toLowerCase();

        app.createFigures(method);

        boolean exit = false;
        do{
            System.out.println("Choose operation (list, delete, store, clone or exit) : ");
            String operation = insert.next();
            switch (operation){
                case "list":
                    app.listFigures();
                    break;
                case "delete":
                    System.out.println("Insert index : ");
                    int deleteIndex = insert.nextInt();
                    app.deleteFigure(deleteIndex);
                    break;
                case "store":
                    System.out.println("Insert file path : ");
                    String filePath = insert.next();
                    app.storeInFile(filePath);
                    break;
                case "clone":
                    System.out.println("Insert index : ");
                    int cloneIndex = insert.nextInt();
                    app.cloneFigure(cloneIndex);
                    break;
                case "exit":
                    System.out.println("Have a nice day.");
                    exit = true;
                    break;
                default:
                    throw new IllegalArgumentException("Incorrect method.");
            }
        }
        while(!exit);
        insert.close();
    }
}
