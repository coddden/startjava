package com.startjava.lesson_2_3_4.array;

import java.util.Comparator;
import java.util.Random;

public class Arrays {
    private Arrays() {}

    public static long[] calcFactorial(long... nums) {
        if (nums == null || nums.length == 0) return nums;
        int len = nums.length;
        long[] factorials = new long[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) continue;
            factorials[i] = 1;
            for (int j = 2; j <= nums[i]; j++) {
                factorials[i] *= j;
            }
        }
        return factorials;
    }

    public static StringBuilder createTriangleOfChars(char start, char end, boolean asc) {
        if (start > end) return null;
        int len = end - start + 1;
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = asc ? start++ : end--;
        }
        int charAmount = 1;
        int offset = len;
        StringBuilder triangleOfChars = new StringBuilder();
        for (char character : chars) {
            String character1 = String.valueOf(character);
            triangleOfChars.append(" ".repeat(offset--));
            triangleOfChars.append((character1).repeat(charAmount)).append("\n");
            charAmount += 2;
        }
        return triangleOfChars;
    }

    public static int[] fillWithAscUniqueNums(int start, int end, int rowLen) {
        int range = end - start + 1;
        int arrayLen = (int) (range * 0.75);
        if (arrayLen <= 0) {
            Console.displayMsg("Ошибка: длина массива должна быть больше 0 (" + arrayLen + ")\n\n");
            return null;
        }
        if (start > end) {
            Console.displayMsg("Ошибка: левая граница (" + start + ") > правой (" + end + ")\n\n");
            return null;
        }
        if (rowLen < 1) {
            Console.displayMsg("Ошибка: количество чисел в строке не может быть меньше 1 (" +
                    rowLen + ")\n\n");
            return null;
        }
        int[] uniqueNums = new int[arrayLen];
        Random random = new Random();
        for (int i = 0; i < arrayLen; i++) {
            int generatedNum;
            boolean isUnique;
            do {
                generatedNum = random.nextInt(start, end + 1);
                isUnique = true;
                for (int j = 0; j < i; j++) {
                    if (generatedNum == uniqueNums[j]) {
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique);
            uniqueNums[i] = generatedNum;
        }
        java.util.Arrays.sort(uniqueNums);
        return uniqueNums;
    }

    public static float[] generateArray(int index, int arrayLen) {
        if (index < 0 || index >= arrayLen) return null;
        float[] array = new float[arrayLen];
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) Math.random();
        }
        return array;
    }

    public static int removeExceedElements(float[] array, int index) {
        int zeroedCells = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[index]) {
                array[i] = 0;
                zeroedCells++;
            }
        }
        return zeroedCells;
    }

    public static int[] reverse(int[] array) {
        int len = array.length - 1;
        int[] reversed = new int[len + 1];
        for (int item : array) {
            reversed[len--] = item;
        }
        return reversed;
    }

    public static String toUpperCaseRange(String originalText) {
        if (originalText == null || originalText.isBlank()) return null;
        String cleanText = originalText.replaceAll("[\\p{Punct}&&[^+]]", "");
        String[] words = cleanText.split("\\s+");
        java.util.Arrays.sort(words, Comparator.comparingInt(String::length));
        words[0] = words[0].length() == 1 ? ' ' + words[0] + ' ' : words[0];
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
}