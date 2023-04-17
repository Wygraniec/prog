package com.No4_interfaces;

public interface Logger {
    void log(String level);
    void log(String level, String text);

    default void information() {
        log("Information");
    }
    default void information(String text) {
        log("Information", text);
    }

    default void warning(){
        log("Warning");
    }
    default void warning(String text) {
        log("Warning", text);
    }

    default void error() {
        log("Error");
    }
    default void error(String text) {
        log("Error", text);
    }
}
