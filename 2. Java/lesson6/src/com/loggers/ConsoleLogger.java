package com.loggers;

import java.time.LocalDateTime;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String level) {
        System.out.println("\n|=====================================================================================|");
        System.out.printf(" Timestamp: %s %n [%s] -> System logged %s with no description %n",
                LocalDateTime.now(), level, level.toLowerCase());
        System.out.println("|=====================================================================================|\n");
    }
    @Override
    public void log(String level, String text) {
        System.out.println("\n|=====================================================================================|");
        System.out.printf(" Timestamp: %s %n [%s] -> %s %n",
                LocalDateTime.now(), level, text);
        System.out.println("|=====================================================================================|\n");
    }


}
