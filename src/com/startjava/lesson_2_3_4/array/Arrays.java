package com.startjava.lesson_2_3_4.array;

import static com.startjava.lesson_2_3_4.array.Console.displayMsg;

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
            for (int j = 1; j <= nums[i]; j++) {
                factorials[i] *= j;
            }
        }
        return factorials;
    }

    public static StringBuilder createCharTriangle(int start, int end, boolean asc) {
        if (start > end) {
            StringBuilder msg = new StringBuilder();
            return msg.append("\nОшибка: левая граница (")
                    .append(start)
                    .append(") > правой (")
                    .append(end).append(")\n\n");
        }
        int len = end - start + 1;
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = asc ? (char) start++ : (char) end--;
        }
        int charAmount = 1;
        int offset = len;
        StringBuilder triangle = new StringBuilder();
        for (char character : chars) {
            triangle.append(" ".repeat(offset--));
            triangle.append((character + "").repeat(charAmount)).append("\n");
            charAmount += 2;
        }
        return triangle;
    }

    public static int[] fillArrayAsc(int start, int end, int rowLen) {
        int range = end - start + 1;
        int arrayLen = (int) (range * 0.75);
        if (start > end) {
            displayMsg("Ошибка: левая граница (" + start + ") > правой (" + end + ")\n\n");
            return null;
        }
        if (arrayLen <= 0) {
            displayMsg("Ошибка: длина массива должна быть больше 0 (" + arrayLen + ")\n\n");
            return null;
        }
        if (rowLen < 1) {
            displayMsg("Ошибка: количество чисел в строке не может быть меньше 1 (" + rowLen + ")\n\n");
            return null;
        }
        int[] uniqueNums = new int[arrayLen];
        Random random = new Random();
        for (int i = 0; i < arrayLen; i++) {
            int generatedNum;
            boolean isUnique;
            do {
                generatedNum = random.nextInt(range) + start;
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

    public static float[] generateArray(int index, int srcArrayLength) {
        if (index < 0 || index >= srcArrayLength) return null;
        float[] srcArray = new float[srcArrayLength];
        for (int i = 0; i < srcArray.length; i++) {
            srcArray[i] = (float) Math.random();
        }
        return srcArray;
    }

    public static String makeTextFragmentInCaps(String originalText) {
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

    public static int removeExceedElements(int index, float[] array) {
        int zeroedCells = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[index]) {
                array[i] = 0;
                zeroedCells++;
            }
        }
        return zeroedCells;
    }

    public static int[] reverseArray(int[] array) {
        int len = array.length;
        int[] reversed = new int[len];
        int index = 0;
        for (int i = len - 1; i >= 0; i--) {
            reversed[index++] = array[i];
        }
        return reversed;
    }
}