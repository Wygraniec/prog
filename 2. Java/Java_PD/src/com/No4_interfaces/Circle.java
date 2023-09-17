package com.No4_interfaces;

public class Circle implements ResizeableShape {
    private double radius;

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

    @Override
    public void resize(float scale) throws IllegalArgumentException {
        if(scale < 0) throw new IllegalArgumentException("Scale must be a positive number");
        radius *= scale;
    }
}
