package com.startjava.lesson_2_3_4.array;

public class Typewriter {
    public static void main(String[] args) throws InterruptedException {
        type("Java - это C++, из которого убрали все пистолеты, " +
                "ножи и дубинки.\n- James Gosling\n");
        type("Чтобы написать чистый код, мы сначала пишем грязный код, " +
                "затем рефакторим его.\n- Robert Martin\n");
        type(null);
        type("");
    }

    private static void type(String row) throws InterruptedException {
        if (isExist(row)) return;
        String cleanRow = removeSigns(row);
        String[] words = cleanRow.split("\\s+");
        sort(words);
        System.out.println();
        display(row, words);
    }

    private static boolean isExist(String row) {
        if (row == null || row.isBlank()) {
            System.out.printf("%nОшибка! Строка ");
            System.out.printf(row == null ? "не существует%n" : "пуста%n");
            return true;
        }
        return false;
    }

    private static String removeSigns(String row) {
        StringBuilder cleanRow = new StringBuilder();
        for (int i = 0; i < row.length(); i++) {
            if (row.charAt(i) == '.' || row.charAt(i) == ',' || row.charAt(i) == '?' ||
                    row.charAt(i) == '!' || row.charAt(i) == ';' || row.charAt(i) == ':' ||
                    row.charAt(i) == '-' || row.charAt(i) == '(' || row.charAt(i) == ')' ||
                    row.charAt(i) == '\"' || row.charAt(i) == '\n') continue;
            cleanRow.append(row.charAt(i));
        }
        return cleanRow + "";
    }

    private static void sort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i].length() < array[j].length()) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static void display(String row, String[] array) throws InterruptedException {
        int len = array.length;
        String shortWord = array[0];
        String longWord = array[len - 1];
        int start = row.indexOf(shortWord);
        int end = row.indexOf(longWord);
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
            end += shortWord.length();
        } else {
            end += longWord.length();
        }
        String resultRow = row.substring(0, start) +
                row.substring(start, end).toUpperCase() +
                row.substring(end);
        for (int i = 0; i < resultRow.length(); i++) {
            System.out.print(resultRow.charAt(i));
            Thread.sleep(200);
        }
    }
}
