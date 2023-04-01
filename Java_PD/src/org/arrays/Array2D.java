package org.arrays;

import java.util.Arrays;

public class Array2D<Type extends Number> {
    private final int sizeX;
    private final int sizeY;
    private Number[][] array;

    public Array2D(int sizeX, int sizeY) {
        if(sizeX <= 0 || sizeY <= 0) {
            System.out.println("Podano niepoprawny rozmiar tablicy");
            System.exit(1);
        }

        this.sizeX = sizeX;
        this.sizeY = sizeY;

        array = new Number[sizeX][sizeY];
    }

    // Getters
    public int getSizeX() { return sizeX; }
    public int getSizeY() { return sizeY; }
    public Type get(int indexX, int indexY) {
        return (Type) array[indexX][indexY];
    }


    // Value setter
    public void setValue(int indexX, int indexY, Type val) {
        array[indexX][indexY] = val;
    }


    // Prints visualization of the array
    public void print() {
        System.out.println();
        for(int colID = 0; colID < sizeX; colID++) {
            for (int rowID = 0; rowID < sizeY; rowID++)
                System.out.print(array[colID][rowID] + "  ");
            System.out.println();
        }
        System.out.println();
    }


    // Numeric functions
    public Type maxVal() {
        Number max = array[0][0];

        for(Number[] row : array)
            for(Number num : row)
                if(max.floatValue() < num.floatValue())
                    max = num;

       return (Type)max;
    }
    public Type minVal() {
        Number min = array[0][0];

        for(Number[] row : array)
            for(Number num : row)
                if(min.floatValue() > num.floatValue())
                    min = num;

        return (Type)min;
    }


    private float sum() {
        float sum = 0;

        for(Number[] row : array)
            for(Number num : row)
                sum += num.floatValue();

        return sum;
    }
    public float average() { return sum()/(sizeX * sizeY); }


    private float numAverage(Number num1, Number num2) { return (num1.floatValue() + num2.floatValue()) / 2; }
    public float median() {
        Type[] arr1D = (Type[])new Number[sizeX * sizeY];

        for(int i = 0, l = 0; i < sizeX; i++)
            for (int j = 0; j < sizeY; j++) {
                arr1D[l] = (Type)array[i][j];
                l++;
            }

        Arrays.sort(arr1D);

        // If number of elements is odd, median is the middle value in the array
        // else median is an average of two middle numbers
        if(arr1D.length % 2 != 0)
            return arr1D[(arr1D.length - 1) / 2].floatValue();
        else
            return numAverage(arr1D[arr1D.length / 2 - 1], arr1D[arr1D.length / 2]);

    }
}
