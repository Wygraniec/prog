package com.interfaces;

public interface Logger {
    void information();
    void information(String text);

    void warning();
    void warning(String text);

    void error();
    void error(String text);
}
