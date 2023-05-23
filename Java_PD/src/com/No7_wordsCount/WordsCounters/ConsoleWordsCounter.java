package com.No7_wordsCount.WordsCounters;

import java.util.TreeMap;

public class ConsoleWordsCounter extends BaseWordsCounter {
    public ConsoleWordsCounter(){ super(); }
    public ConsoleWordsCounter(String text) {
        this();
        super.text = text;
        super.calculateCount();
    }
    /**
     * Changes the text being considered in counting
     * @param text New text to be processed
     * */
    public void setText(String text) {
        super.text = text;
        super.wordFrequencyMap = new TreeMap<>();
        super.calculateCount();
    }
}
