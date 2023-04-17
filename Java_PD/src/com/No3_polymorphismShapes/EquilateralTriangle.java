package com.No3_polymorphismShapes;

public class EquilateralTriangle extends Shape {
    private final double side;

    public EquilateralTriangle(double side) throws IllegalArgumentException {
        if(side <= 0) throw new IllegalArgumentException("Sides must be positive numbers");

        this.side = side;
    }
    @Override
    public double calculateField() { return (side * side * Math.sqrt(3)) / 4; }

    @Override
    public double calculateCircumference() { return 3 * side; }

    @Override
    public String toString() { return String.format("Circle { %n base = %f %n}", side); }
}
