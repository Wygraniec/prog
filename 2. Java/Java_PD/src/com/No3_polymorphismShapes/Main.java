package com.No3_polymorphismShapes;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        final Shape[] shapes = new Shape[3];

        System.out.print("Podaj promień okręgu: ");
        shapes[0] = new Circle(stdin.nextDouble());
        stdin.nextLine();

        System.out.print("Podaj długości boków prostokąta: ");
        shapes[1] = new Rectangle(stdin.nextDouble(), stdin.nextDouble());
        stdin.nextLine();

        System.out.print("Podaj długość boku trójkąta równobocznego: ");
        shapes[2] = new EquilateralTriangle(stdin.nextDouble());
        stdin.nextLine();

        for(Shape shape : shapes)
            System.out.printf("Kształt: %s %nPole: %f %nObwód: %f %n %n", shape.getClass().getName(),
                    shape.calculateField(), shape.calculateCircumference());
    }
}