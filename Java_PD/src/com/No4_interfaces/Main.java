package com.No4_interfaces;

import java.util.Scanner;

public class Main {
    private static void printShapesData(ResizeableShape[] shapes) {
        for(ResizeableShape shape : shapes) {
            if(shape == null) continue;

            System.out.println(shape.toString());
            System.out.printf("The shape's field is equal to %f %n", shape.calculateField());
            System.out.printf("The shape's circumference is equal to %f %n", shape.calculateCircumference());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Logger log = new ConsoleLogger();
        Scanner stdin = new Scanner(System.in);
        ResizeableShape[] shapes = new ResizeableShape[2];

        System.out.print("Enter the circle's radius: ");
        try {
            shapes[0] = new Circle(stdin.nextDouble());
            log.information("Successfully instantiated a circle object");
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            stdin.nextLine();
        }

        System.out.print("Enter the rectangle's sides' length: ");
        try {
            shapes[1] = new Rectangle(stdin.nextDouble(), stdin.nextDouble());
            log.information("Successfully instantiated a rectangle object");
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            stdin.nextLine();
        }

        printShapesData(shapes);

        System.out.println("By what scale would you like to scale the figures?");
        float scale = stdin.nextFloat();
        try {
            for (ResizeableShape shape : shapes)
                shape.resize(scale);
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            log.error(e.getMessage());
        }

        printShapesData(shapes);

    }
}
