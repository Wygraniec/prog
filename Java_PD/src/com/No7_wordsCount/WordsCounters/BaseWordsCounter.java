package com.No7_wordsCount.WordsCounters;

import java.security.InvalidKeyException;
import java.util.Map;
import java.util.TreeMap;

/** An abstract class providing implementation of basic functions required for a class
 * calculating the number of occurrences of each word which is saved in the given text variable */
abstract class BaseWordsCounter implements WordsCounter {
    private Map<String, Integer> wordFrequencyMap = new TreeMap<>();
    private String[] preparedText;

    /** Calculates the number of occurrences of a word in a given text and saving it in the frequency map */
    private void calculateCount() {
        if( !this.hasValues() ) return; // If there's no text, the function may be returned early

        wordFrequencyMap = new TreeMap<>(); // Emptying the map

        for(String word : preparedText)
            wordFrequencyMap.put( word,
                    wordFrequencyMap.getOrDefault(word, 0) + 1
            );
    }

    /**
     * Converts a given text to a prepared one -> in lower case, only with letters and split by " "
     * @param text original text
     * @return prepared text
     * */
    private String[] prepareText(String text) {
        return text.strip()                                         // Deleting unnecessary whitespace characters
                .toLowerCase()                                      // Converting the text to Lower-Case to prevent counting the same word as two different
                .replaceAll("[^a-z\\s]", "")        // Deleting all characters not being letters (or " " characters)
                .replaceAll("\\s+"," ")             // Replace additional whitespace characters (if there's more than one in one place) with single space character
                .split(" ");                                  // Splitting the text by " " characters in order to extract every word
    }

    /**
     * Changes the text being considered in counting and performs the operation
     * @param text New text to be processed
     * @throws IllegalArgumentException Throws such an exception if the text passed in as an argument
     *                                  is null or is an empty string
     * */
    protected void setText(String text) throws IllegalArgumentException {
        if( text == null || text.isBlank() )
            throw new IllegalArgumentException("Provided text must be neither empty nor a null");

        this.preparedText = prepareText(text);
        calculateCount();
    }

    @Override
    public void printAllWordCounts() {
        for ( Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet() )
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
    }

    @Override
    public int getCountFor(String word) throws InvalidKeyException {
        if( !wordFrequencyMap.containsKey( word.toLowerCase().strip() ) )
            throw new InvalidKeyException("Provided word has not occurred in the text");

        return wordFrequencyMap.get( word.toLowerCase().strip() );
    }

    @Override
    public Boolean hasValues() {
        return preparedText != null;
    }
}
