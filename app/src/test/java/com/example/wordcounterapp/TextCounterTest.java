package com.example.wordcounterapp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TextCounterTest {

    @Test
    public void testCountWords() {
        assertEquals(2, TextCounter.countWords("Labas pasauli"));
        assertEquals(0, TextCounter.countWords("123 456"));
        assertEquals(0, TextCounter.countWords("   "));
    }

    @Test
    public void testCountSentences() {
        assertEquals(2, TextCounter.countSentences("Pirmas sakinys. Antras sakinys!"));
        assertEquals(0, TextCounter.countSentences("12345. 6789."));
    }

    @Test
    public void testCountPunctuation() {
        assertEquals(3, TextCounter.countPunctuation("Labas, pasauli."));
    }

    @Test
    public void testCountNumbers() {
        assertEquals(4, TextCounter.countNumbers("Labas 1234 pasauli"));
    }
}
