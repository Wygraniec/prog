package com.interfaces;

public class Main {
    public static void main(String[] args) {
        Logger log = new FileLogger();

        log.information();
        log.information("File opened");

        log.warning();
        log.warning("Unused import statement");

        log.error();
        log.error("Stack overflow on line 39");

    }
}
