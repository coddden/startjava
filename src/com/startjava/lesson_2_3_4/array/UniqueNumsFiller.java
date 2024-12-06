package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumsFiller {
    public static void main(String[] args) {
        ascDisplay(fill(-30, -10, 23), 23);
        ascDisplay(fill(10, 50, 10), 10);
        ascDisplay(fill(-34, -34, 0), 0);
        ascDisplay(fill(-1, 2, -3), -3);
        ascDisplay(fill(5, -8, 2), 2);
    }

    private static int[] fill(int start, int end, int rowLen) {
        int range = end - start + 1;
        int arrayLen = (int) (range * 0.75);
        if (hasError(start, end, rowLen, arrayLen)) return null;
        int[] uniqueNums = new int[arrayLen];
        Random random = new Random();
        int index = 0;
        while (index < uniqueNums.length) {
            int generatedNum = random.nextInt(range) + start;
            if (!hasSameNum(generatedNum, uniqueNums, index)) {
                uniqueNums[index] = generatedNum;
                index++;
            }
        }
        return uniqueNums;
    }

    private static boolean hasError(int start, int end, int rowLen, int arrayLen) {
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", start, end);
            return true;
        }
        if (arrayLen < 0) {
            System.out.printf("Ошибка: длина массива должна быть больше 0 (%d)%n%n", arrayLen);
            return true;
        }
        if (rowLen < 1) {
            System.out.printf("Ошибка: количество чисел в строке не может быть меньше 1 (%d)%n%n", rowLen);
            return true;
        }
        return false;
    }

    private static boolean hasSameNum(int generatedNum, int[] uniqueNums, int index) {
        for (int i = 0; i < index; i++) {
            if (generatedNum == uniqueNums[i]) {
                return true;
            }
        }
        return false;
    }

    private static void ascDisplay(int[] array, int rowLen) {
        if (array == null) return;
        System.out.println();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print((i + 1) % rowLen == 0 ? "\n" : " ");
        }
        System.out.println();
    }
}
