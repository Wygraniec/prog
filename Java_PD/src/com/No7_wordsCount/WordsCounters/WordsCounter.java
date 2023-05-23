package com.No7_wordsCount.WordsCounters;

/** Interface for classes being able to determine the number of appearances
 * of each word in a given text
 */
public interface WordsCounter {
    /**
     * Method getting count of a specific word in a given text
     * @param word Word for which the count should be returned, always converted to Lower-Case
     * @return Count of the word in a given phrase
     * */
    int getCountFor(String word);
    /** Prints all the words and their counts to the console */
    void printAllWords();
    /** Checks whether there is a value in the appropriate
     * and thus checks if the Map contains any values */
    Boolean hasValues();
}