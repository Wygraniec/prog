package com.interfaces;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileLogger implements Logger{
    private PrintWriter writer;
    public FileLogger() {
        try {
            writer = new PrintWriter(
                    new FileWriter("log.txt", true)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileLogger(String path) {
        try {
            writer = new PrintWriter(
                    new FileWriter(path, true)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void information() {
        writer.println("\n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [Information] -> System logged an information with no description %n",
                LocalDateTime.now());
        writer.println("|=====================================================================================|\n");
    }

    @Override
    public void information(String text) {
        writer.println("\n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [Information] -> %s %n",
                LocalDateTime.now(), text);
        writer.println("|=====================================================================================|\n");
    }

    @Override
    public void warning() {
        writer.println("\n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [Warning] -> System logged a warning with no description %n",
                LocalDateTime.now());
        writer.println("|=====================================================================================|\n");
    }

    @Override
    public void warning(String text) {
        writer.println("\n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [Warning] -> %s %n",
                LocalDateTime.now(), text);
        writer.println("|=====================================================================================|\n");
    }

    @Override
    public void error() {
        writer.println("\n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [Error] -> System logged an error with no description %n",
                LocalDateTime.now());
        writer.println("|=====================================================================================|\n");
    }

    @Override
    public void error(String text) {
        writer.println("/n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [Error] -> %s %n",
                LocalDateTime.now(), text);
        writer.println("|=====================================================================================|/n");
    }

}
