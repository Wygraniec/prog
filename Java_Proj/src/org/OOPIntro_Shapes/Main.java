package org.OOPIntro_Shapes;
import java.util.Scanner;
public class Main {
    /** Prints the actions that can be performed on the shapes */
    private static void printOptions() {

    }
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        System.out.print("Enter the square's side's length: ");
        Square square = new Square(stdin.nextDouble());

        System.out.print("Enter the circle's radius: ");
        Circle circle = new Circle(stdin.nextDouble());

        System.out.print("Enter the rectangle's first side's length: ");
        double tempLength = stdin.nextDouble();
        System.out.print("Enter the rectangle's second side's length: ");
        Rectangle rectangle = new Rectangle(tempLength, stdin.nextDouble());

        int selectedMenuOption = 0;
        do {
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Circle");
            System.out.println("Select the shape to be used (enter the number): ");

            printOptions();

        } while(selectedMenuOption != 0);


    }
}
