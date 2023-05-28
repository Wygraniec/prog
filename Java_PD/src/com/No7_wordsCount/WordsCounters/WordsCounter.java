package com.No7_wordsCount.WordsCounters;
import java.security.InvalidKeyException;

/** Interface for classes being able to determine the number of appearances
 * of each word in a given text
 */
public interface WordsCounter {
    /**
     * Method getting count of a specific word in a given text
     * @param word Word for which the count should be returned, always converted to Lower-Case
     * @throws InvalidKeyException Exception is thrown if the provided String has not occurred in the text and
     *                                  thus if it isn't in the Map
     * @return Count of the word in a given phrase
     * */
    int getCountFor(String word) throws InvalidKeyException;
    /** Prints all the words and number of their occurrences to the console */
    void printAllWordCounts();
    /** Checks whether a text is set ( and prepared for counting) */
    Boolean hasValues();
}