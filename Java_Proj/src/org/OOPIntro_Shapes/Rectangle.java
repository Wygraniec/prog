package org.OOPIntro_Shapes;
public class Rectangle {
    private double side1, side2;
    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public void setSides(final double side1, final double side2) throws ArithmeticException {
        if(side1 <= 0 || side2 <= 0)
            throw new ArithmeticException("Side's length must be a positive number");

        this.side1 = side1;
        this.side2 = side2;
    }
    public Rectangle(final double side1, final double side2) {
        setSides(side1, side2);
    }
    public double calculateField() { return side1 * side2; }

    @Override
    public String toString() {
        return "Rectangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                '}';
    }
}
