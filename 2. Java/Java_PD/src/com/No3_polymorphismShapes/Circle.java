package com.No3_polymorphismShapes;

public class Circle extends Shape{
    private final double radius;

    public Circle(double radius) throws  IllegalArgumentException{
        if(radius <= 0) throw new IllegalArgumentException("Circle's radius must be a positive number");
        this.radius = radius;
    }

    @Override
    public double calculateCircumference() { return 2 * Math.PI * radius; }

    @Override
    public double calculateField() { return Math.PI * radius * radius; }

    @Override
    public String toString() { return String.format("Circle { %n radius = %f %n}", radius); }
}
