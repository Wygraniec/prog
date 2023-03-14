package org.OOPIntro_Shapes;
import java.util.Scanner;
public class Main {
    /** Prints the actions that can be performed on rectangle and square */
    private static void printOptionsForRectangles() {
        System.out.println("1. Get the side's length");
        System.out.println("2. Calculate field");
        System.out.println("3. Change the figure's measurements");
        System.out.println("4. Calculate the diagonal");
    }
    /** Prints the actions that can be performed on circle */
    private static void printOptionsForCircle() {
        System.out.println("1. Get the radius");
        System.out.println("2. Calculate field");
        System.out.println("3. Change the figure's radius");
        System.out.println("4. Calculate circumference");
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
        
        while(true) {
            System.out.println("0. Close the programme");
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Circle");
            System.out.println("Select the shape to be used (enter the number): ");

            int selectedShape = stdin.nextInt();

            if(selectedShape == 0) System.exit(0);

            if(selectedShape == 1 || selectedShape == 2) printOptionsForRectangles();
            else if(selectedShape == 3) printOptionsForCircle();
            else {
                System.out.println("Invalid option selected");
                continue;
            }

            System.out.println("Select an option: ");
            int selectedMenuOption = stdin.nextInt();

            switch(selectedMenuOption) {
                case 1 -> {
                    switch (selectedShape) {
                        case 1 -> System.out.printf("The side is %f units long%n", square.getSide());
                        case 2 -> System.out.printf("The sides are %f and %f units long%n",
                                rectangle.getSide1(), rectangle.getSide2());
                        case 3 -> System.out.printf("The circle's radius is %f units %n", circle.getRadius());
                    }
                }

                case 2 -> {
                    switch (selectedShape) {
                        case 1 -> System.out.printf("The square's field is %f square units %n", square.calculateField());
                        case 2 -> System.out.printf("The rectangle's field is %f square units %n", rectangle.calculateField());
                        case 3 -> System.out.printf("The circle's field is %f square units %n", circle.calculateField());
                    }
                }

                case 3 -> {
                    switch (selectedShape) {
                        case 1 -> {
                            System.out.println("Enter the square's side's length: ");
                            square.setSide(stdin.nextDouble());
                        }

                        case 2 -> {
                            System.out.print("Enter the first rectangle's side's length: ");
                            double temp = stdin.nextDouble();
                            System.out.print("Enter the second rectangle's side's length: ");
                            rectangle.setSides(temp, stdin.nextDouble());
                        }

                        case 3 -> {
                            System.out.println("Enter the circle's radius length: ");
                            circle.setRadius(stdin.nextDouble());
                        }
                    }

                }

                case 4 -> {
                    switch(selectedShape) {
                        case 1 -> System.out.printf("The diagonal of the square is %f %n", square.calculateDiagonal());
                        case 2 -> System.out.printf("The diagonal of the rectangle is %f %n", rectangle.calculateDiagonal());
                        case 3 -> System.out.printf("The circumference of the circle is %f %n", circle.calculateCircumference());
                    }
                }

                default -> System.out.println("Invalid option selected");
            }
        }

    }
}
