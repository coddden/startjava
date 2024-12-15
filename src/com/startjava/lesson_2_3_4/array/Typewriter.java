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
        display(findHighlight(originalText, words));
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

    private static String findHighlight(String originalText, String[] array) {
        int len = array.length;
        int startHighlight = originalText.indexOf(array[0]);
        int endHighlight = originalText.indexOf(array[len - 1]);
        if (startHighlight > endHighlight) {
            int temp = startHighlight;
            startHighlight = endHighlight;
            endHighlight = temp;
            endHighlight += array[0].length();
        } else {
            endHighlight += array[len - 1].length();
        }
        return originalText.substring(0, startHighlight) +
                originalText.substring(startHighlight, endHighlight).toUpperCase() +
                originalText.substring(endHighlight);
    }

    private static void display(String resultText) throws InterruptedException {
        for (int i = 0; i < resultText.length(); i++) {
            System.out.print(resultText.charAt(i));
            Thread.sleep(200);
        }
    }
}