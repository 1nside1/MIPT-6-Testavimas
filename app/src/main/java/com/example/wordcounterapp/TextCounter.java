package com.example.wordcounterapp;

public class TextCounter {
    // Zodziu skaiciavimas
    public static int countWords(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }

    // Sakiniu skaiciavimas
    public static int countSentences(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }
        return text.split("[.!?]+").length;
    }

    // Zenklu skaiciavimas
    public static int countPunctuation(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ' || c == ',' || c == '.') {
                count++;
            }
        }
        return count;
    }

    // Skaiciu skaiciaivimas
    public static int countNumbers(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }
}
