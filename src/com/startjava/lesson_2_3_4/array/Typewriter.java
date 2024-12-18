package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Comparator;

public class Typewriter {
    public static void main(String[] args) throws InterruptedException {
        type("Java - это C++, из которого убрали все пистолеты, " +
                "ножи и дубинки.\n- James Gosling\n");
        type("Чтобы написать чистый код, мы сначала пишем грязный код, " +
                "затем рефакторим его.\n- Robert Martin\n");
        type(null);
        type("");
    }

    private static void type(String originalText) throws InterruptedException {
        if (!isExist(originalText)) return;
        String cleanText = originalText.replaceAll("[\\p{Punct}&&[^+]]", "");
        String[] words = cleanText.split("\\s+");
        Arrays.sort(words, Comparator.comparingInt(String::length));
        addSpaces(words);
        System.out.println();
        display(findSelection(originalText, words));
    }

    private static boolean isExist(String originalText) {
        if (originalText != null && !originalText.isBlank()) return true;
        String msg = originalText == null ? "не существует." : "пуста.";
        System.out.printf("%nОшибка! Строка %s%n", msg);
        return false;
    }

    private static void addSpaces(String[] words) {
        words[0] = words[0].length() == 1 ? ' ' + words[0] + ' ' : words[0];
    }

    private static String findSelection(String originalText, String[] words) {
        int len = words.length;
        int start = originalText.indexOf(words[0]);
        int end = originalText.indexOf(words[len - 1]);
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
            end += words[0].length();
        } else {
            end += words[len - 1].length();
        }
        return originalText.substring(0, start) +
                originalText.substring(start, end).toUpperCase() +
                originalText.substring(end);
    }

    private static void display(String resultText) throws InterruptedException {
        for (char letter : resultText.toCharArray()) {
            System.out.print(letter);
            Thread.sleep(200);
        }
    }
}