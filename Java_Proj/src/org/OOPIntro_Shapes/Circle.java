package org.OOPIntro_Shapes;

public class Circle {
    private double radius;
    public double getRadius() { return radius; }
    public void setRadius(final double radius) throws ArithmeticException {
        if(radius <= 0) throw new ArithmeticException("Radius must be a positive number");
        this.radius = radius;
    }
    public Circle(final double radius) { setRadius(radius); }
    public double calculateCircumference() { return 2 * Math.PI * radius; }
    public double calculateField() { return Math.PI * radius * radius; }
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
