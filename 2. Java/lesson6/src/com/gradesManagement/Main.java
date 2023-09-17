package com.gradesManagement;

import com.loggers.FileLogger;

public class Main {
    public static void main(String[] args) {
        Grades grades = new Grades( new FileLogger() );

        grades.add(5, 3);
        grades.add( new Grade(2, 2) );
        grades.add(6, 3, "Sprawdzian");

        grades.remove(2);
        grades.remove(1);

        System.out.println(grades);
        System.out.println(grades.calculateAverage());

    }
}