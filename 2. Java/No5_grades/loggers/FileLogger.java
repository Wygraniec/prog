package com.No5_grades.loggers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileLogger implements Logger{
    private PrintWriter writer;
    public FileLogger() {
        this("log.txt");
    }
    public FileLogger(String path) {
        try {
            writer = new PrintWriter(
                    new FileWriter(path, true),
                    true
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        log("Information", "Created log file");
    }
    @Override
    public void log(String level) {
        writer.println("\n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [%s] -> System logged %s with no description %n",
                LocalDateTime.now(), level, level.toLowerCase());
        writer.println("|=====================================================================================|\n");
    }
    @Override
    public void log(String level, String text) {
        writer.println("\n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [%s] -> %s %n",
                LocalDateTime.now(), level, text);
        writer.println("|=====================================================================================|\n");
    }
}
