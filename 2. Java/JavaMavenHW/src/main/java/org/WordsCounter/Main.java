package org.WordsCounter;

public class Main {
    public static void main(String[] args) {
            WordsCounter counter = new WordsCounter(FileStringReader.getStringFromFile("CounterText.txt"));
            counter.printAllWordCounts();
    }
}
