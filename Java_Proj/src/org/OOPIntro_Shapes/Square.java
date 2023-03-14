package org.OOPIntro_Shapes;

public class Square {
    private double side;
    public double getSide() { return this.side; }
    public void setSide(final double side) throws ArithmeticException {
        if(side <= 0) throw new ArithmeticException("Side's length must be a positive number");
        this.side = side;
    }

    public Square(final double side) { setSide(side); }

    public double calculateField() { return this.side * this.side; }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
