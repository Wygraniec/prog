package org.WordsCounter;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileStringReaderTest {

    @Test
    public void shouldReadFile() {
        // When
        String text = FileStringReader.getStringFromFile("StringFileExtractorTest.txt");

        // Then
        assertEquals(text, "Ala ma kota, Ala ma psa, Ala moze ma kota. ");
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        // Then
        assertThrows(IllegalArgumentException.class, () -> FileStringReader.getStringFromFile("NonExistentFile"));
    }
}