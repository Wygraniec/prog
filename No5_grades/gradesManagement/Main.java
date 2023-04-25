package com.No5_grades.gradesManagement;

import com.No5_grades.loggers.FileLogger;

public class Main {
    public static void main(String[] args) {
        Subject grades = new Subject( "Podstawy Przedsiębiorczości", "Jacek Poławski",
                new FileLogger() );

        grades.add(5, 3);
        grades.add( new Grade(2, 2) );
        grades.add(6, 3, "Sprawdzian1");

        try {
            grades.update(4, 6, 3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index");
//            e.printStackTrace();
        }

        System.out.println(grades);
        System.out.println(grades.calculateAverage());

    }
}