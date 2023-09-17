package org.WordsCounter;

import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterTest {
    @Test
    public void shouldCountWordsInProperText() {
        // Provided
        WordsCounter counter = new WordsCounter("Ala ma kota lub ala nie ma kota");

        // When
        int countForWord1, countForWord2, countForWord3, countForWord4 ,countForWord5;
        try {
            countForWord1 = counter.getCountFor("Ala");
            countForWord2 = counter.getCountFor("ma");
            countForWord3 = counter.getCountFor("kota");
            countForWord4 = counter.getCountFor("lub");
            countForWord5 = counter.getCountFor("nie");
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        assertEquals(2, countForWord1);
        assertEquals(2, countForWord2);
        assertEquals(2, countForWord3);
        assertEquals(1, countForWord4);
        assertEquals(1, countForWord5);

    }

    @Test
    public void shouldCountWordsInTextWithSpecialCharacters() {
        // Provided
        WordsCounter counter = new WordsCounter("A$$la ma    k$$$ota lub a!@la nie m&a ko!!ta.   ");

        // When
        int countForWord1, countForWord2, countForWord3, countForWord4 ,countForWord5;
        try {
            countForWord1 = counter.getCountFor("Ala");
            countForWord2 = counter.getCountFor("ma");
            countForWord3 = counter.getCountFor("kota");
            countForWord4 = counter.getCountFor("lub");
            countForWord5 = counter.getCountFor("nie");
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        // Then
        assertEquals(2, countForWord1);
        assertEquals(2, countForWord2);
        assertEquals(2, countForWord3);
        assertEquals(1, countForWord4);
        assertEquals(1, countForWord5);
    }


    @Test
    public void shouldThrowKeyException() {
        // Provided
        WordsCounter counter = new WordsCounter("Ala ma kota lub ala nie ma kota");

        // Then
        assertThrows(InvalidKeyException.class, () -> counter.getCountFor("i"));
    }

}