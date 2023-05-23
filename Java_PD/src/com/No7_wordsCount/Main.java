package com.No7_wordsCount;

import com.No7_wordsCount.WordsCounters.ConsoleWordsCounter;
import com.No7_wordsCount.WordsCounters.FileWordsCounter;

public class Main {
    public static void main(String[] args) {
        var counter = new FileWordsCounter("text.txt");
        counter.printAllWords();

    }
}
