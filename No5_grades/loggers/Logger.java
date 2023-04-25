package com.No5_grades.loggers;

public interface Logger {
    /** Logs a message as one of a selected level
     * @param level level of message (for instance Message or Warning)
     * */
    void log(String level);
    /** Logs a message as one of a selected level
     * @param level level of message (for instance Message or Warning)
     * @param text description of event to be logged
     * */
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
