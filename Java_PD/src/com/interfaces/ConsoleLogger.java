package com.interfaces;

import java.time.LocalDateTime;

public class ConsoleLogger implements Logger {
    @Override
    public void information() {
        System.out.println("\n|=====================================================================================|");
        System.out.printf(" Timestamp: %s %n [Information] -> System logged an information with no description %n",
                LocalDateTime.now());
        System.out.println("|=====================================================================================|\n");
    }

    @Override
    public void information(String text) {
        System.out.println("\n|=====================================================================================|");
        System.out.printf(" Timestamp: %s %n [Information] -> %s %n",
                LocalDateTime.now(), text);
        System.out.println("|=====================================================================================|\n");
    }

    @Override
    public void warning() {
        System.out.println("\n|=====================================================================================|");
        System.out.printf(" Timestamp: %s %n [Warning] -> System logged a warning with no description %n",
                LocalDateTime.now());
        System.out.println("|=====================================================================================|\n");
    }

    @Override
    public void warning(String text) {
        System.out.println("\n|=====================================================================================|");
        System.out.printf(" Timestamp: %s %n [Warning] -> %s %n",
                LocalDateTime.now(), text);
        System.out.println("|=====================================================================================|\n");
    }

    @Override
    public void error() {
        System.out.println("\n|=====================================================================================|");
        System.out.printf(" Timestamp: %s %n [Error] -> System logged an error with no description %n",
                LocalDateTime.now());
        System.out.println("|=====================================================================================|\n");
    }

    @Override
    public void error(String text) {
        System.out.println("\n|=====================================================================================|");
        System.out.printf(" Timestamp: %s %n [Error] -> %s %n",
                LocalDateTime.now(), text);
        System.out.println("|=====================================================================================|\n");
    }
}
