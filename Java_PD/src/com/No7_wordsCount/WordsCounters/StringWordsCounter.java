package com.No7_wordsCount.WordsCounters;

/** Class enabling the user to count the number of appearances of each word in a given String */
public final class StringWordsCounter extends BaseWordsCounter {
    /** @param text String to be considered in counting the words */
    public StringWordsCounter(String text) {
        changeText(text);
    }
    /** @param text String to be considered in counting the words */
    public void changeText(String text) { super.setText(text); }
}