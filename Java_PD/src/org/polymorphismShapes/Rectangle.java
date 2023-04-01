package org.polymorphismShapes;

public class Rectangle extends Shape{

    private final double side1, side2;

    public Rectangle(double side1, double side2) throws  IllegalArgumentException{

        if(side1 <= 0 || side2 <= 0) throw new IllegalArgumentException("Rectangle's sides must be positive numbers");

        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double calculateCircumference() { return 2 * side1 + 2 * side2; }

    @Override
    public double calculateField() { return side1 * side2; }

    @Override
    public String toString() { return String.format("Rectangle { %n side1 = %f %n side2 = %f %n}", side1, side2); }
}
