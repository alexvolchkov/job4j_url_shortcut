package ru.job4j.shortcut.utilite;

import java.util.Random;

public class RandomGeneration {
    private static final String SYMBOL_PASSWORD = "0123456789-+%ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String SYMBOL_URL = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final int LENGTH_PASSWORD = 7;
    private static final int LENGTH_URL = 7;

    private static String randomGenerate(int length, String source) {
        Random rnd = new Random();
        char[] text = new char[length];
        for (int i = 0; i < text.length; i++) {
            text[i] = source.charAt(rnd.nextInt(source.length()));
        }
        return String.valueOf(text);
    }

    public static String generatePassword() {
        return randomGenerate(LENGTH_PASSWORD, SYMBOL_PASSWORD);
    }

    public static String convertUrl() {
        return randomGenerate(LENGTH_URL, SYMBOL_URL);
    }
}
