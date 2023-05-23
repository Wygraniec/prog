package com.No7_wordsCount.WordsCounters;

import java.util.Map;
import java.util.TreeMap;

/** An abstract class providing implementation of basic functions required for a class
 * calculating the number of occurrences of each word which is saved in the given text variable */
public abstract class BaseWordsCounter implements WordsCounter {
    protected Map<String, Integer> wordFrequencyMap = new TreeMap<>();
    protected String text; // The text that will be processed by the calculating method

    /** Calculates the number of occurrences of a word in a given text and saving it in the frequency map */
    protected void calculateCount() {
        wordFrequencyMap = new TreeMap<>(); // Clearing the map

        if( !this.hasValues() ) return; // If there's no text, the function may be returned early

        String[] preparedText = text.strip() // Deleting unnecessary whitespace characters
                .toLowerCase() // Converting the text to Lower-Case to prevent counting the same word as two different
                .replaceAll("[^a-z\\s]", "") // Deleting all characters which are not letters
                .replaceAll("\\s+"," ") // Replace additional whitespace characters (if there's more than one in one place)
                .split(" "); // Splitting the text by space characters in order to extract every word

        for ( String word : preparedText ) {
            if ( wordFrequencyMap.containsKey(word) )
                wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
            else
                wordFrequencyMap.put(word, 1);
        }

    }

    @Override
    public void printAllWords() {
        for ( Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet() )
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
    }

    @Override
    public int getCountFor(String word) {
        if( !wordFrequencyMap.containsKey(word) )
            throw new IllegalArgumentException("Provided word has not occurred in the text");

        return wordFrequencyMap.get(word.toLowerCase());
    }

    @Override
    public Boolean hasValues() {
        return !(text == null);
    }
}
