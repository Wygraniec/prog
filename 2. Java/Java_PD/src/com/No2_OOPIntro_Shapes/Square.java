package com.No2_OOPIntro_Shapes;

public class Square {
    private double side;
    public double getSide() { return side; }
    /** Method setting both side's length and performing error-checking<br>
     *  Side's length must be positive numbers*/
    public void setSide(final double side) throws ArithmeticException {
        if(side <= 0) throw new ArithmeticException("Side's length must be a positive number");
        this.side = side;
    }
    public Square(final double side) { setSide(side); }
    public double calculateField() { return side * side; }
    public double calculateDiagonal() { return side * Math.sqrt(2); }
    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
