package org.OOPIntro_Shapes;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        System.out.print("Enter the square's side's length: ");
        Square square = new Square(stdin.nextDouble());

        System.out.println(square.calculateField());
        square.setSide(-5);
        System.out.println(square.toString());
    }
}
