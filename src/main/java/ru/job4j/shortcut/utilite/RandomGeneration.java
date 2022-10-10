package ru.job4j.shortcut.utilite;

import java.util.Random;

public class RandomGeneration {
    private static final String SYMBOL_PASSWORD = "0123456789-+%ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String SYMBOL_URL = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final int LENGTH_PASSWORD = 7;

    public static String generatePassword() {
        Random rnd = new Random();
        char[] text = new char[LENGTH_PASSWORD];
        for (int i = 0; i < text.length; i++) {
            text[i] = SYMBOL_PASSWORD.charAt(rnd.nextInt(SYMBOL_PASSWORD.length()));
        }
        return String.valueOf(text);
    }

    public static String convertUrl(int id) {
        int base = SYMBOL_URL.length();
        StringBuilder rsl = new StringBuilder();
        while (id > 0) {
            rsl.append(SYMBOL_URL.charAt(id % base));
            id /= base;
        }
        return rsl.reverse().toString();
    }
}
