package com.interfaces;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileLogger implements Logger{
    private PrintWriter writer;
    private File file;
    /** Creates a new PrintWriter object and assigns it to the "writer" field and <br>
     * creates a new File object and assigns it to the file field
     * @param path path to the file to which data will be printed*/
    private void openFileWriter(final String path) {
        file = new File(path);
        try {
            writer = new PrintWriter(
                    new FileWriter(file)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logCreation() {
        writer.println("\n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [Information] -> Created a log object %n",
                LocalDateTime.now());
        writer.println("|=====================================================================================|\n");
    }
    public FileLogger() {
        this.openFileWriter("log.txt");
        this.logCreation();
    }

    public FileLogger(String path) {
        this.openFileWriter(path);
        this.logCreation();
    }

    private void log(String level) {
        writer.println("\n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [%s] -> System logged an information with no description %n",
                LocalDateTime.now(), level);
        writer.println("|=====================================================================================|\n");
    }

    private void log(String level, String text) {
        writer.println("\n|=====================================================================================|");
        writer.printf(" Timestamp: %s %n [%s] -> %s %n",
                LocalDateTime.now(), level, text);
        writer.println("|=====================================================================================|\n");
    }

    @Override
    public void information() {
        log("Information");
    }

    @Override
    public void information(String text) {
        log("Information", text);
    }

    @Override
    public void warning() {
        log("Warning");
    }

    @Override
    public void warning(String text) {
        log("Warning", text);
    }

    @Override
    public void error() {
        log("Error");
    }

    @Override
    public void error(String text) {
        log("Error", text);
    }

}
