package com.example.wordcounterapp;

public class TextCounter {

    // Zodziu skaiciavimas
    public static int countWords(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }

        String[] tokens = text.trim().split("\\s+");
        int count = 0;

        for (String token : tokens) {
            boolean hasLetter = false;
            for (char c : token.toCharArray()) {
                if (Character.isLetter(c)) {
                    hasLetter = true;
                    break;
                }
            }
            if (hasLetter) {
                count++;
            }
        }

        return count;
    }

    // Sakiniu skaiciavimas
    public static int countSentences(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }

        // Išskaidome tekstą pagal taškus, klaustukus ar šauktukus
        String[] tokens = text.split("[.!?]+");
        int count = 0;

        // Tikriname kiekvieną atskirtą dalį (galimą sakinį)
        for (String token : tokens) {
            boolean hasLetter = false;
            // Tikriname, ar šioje dalyje yra bent viena raidė
            for (char c : token.toCharArray()) {
                if (Character.isLetter(c)) {
                    hasLetter = true;
                    break; // Radome raidę, toliau šios dalies tikrinti nebereikia
                }
            }
            // Jei rado raidę, pridedame prie sakinių skaičiaus
            if (hasLetter) {
                count++;
            }
        }

        return count;
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

    // Skaiciu skaiciavimas
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