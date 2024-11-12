package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ReversedNums {
    public static void main(String[] args) {
        int[] emptyArray = {};
        displayArray("До", emptyArray);
        displayArray("После", reverse(emptyArray));
        System.out.println();

        int[] nonExistArray = null;
        displayArray("До", nonExistArray);
        displayArray("После", reverse(nonExistArray));
        System.out.println();

        int[] nums1 = {6, 8, 9, 1};
        displayArray("До", nums1);
        displayArray("После", reverse(nums1));
        System.out.println();

        int[] nums2 = {13, 8, 5, 3, 2, 1, 1};
        displayArray("До", nums2);
        displayArray("После", reverse(nums2));
    }

    public static void displayArray(String msg, int[] array) {
        String result = Arrays.toString(array);
        if (array == null && msg.equals("После")) {
            result = "Массив не существует";
        }
        if (array != null) {
            if (array.length == 0 && msg.equals("После")) {
                result = "Массив пуст";
            }
        }
        System.out.printf("%5s реверса: %s%n", msg, result);
    }

    public static int[] reverse(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int len = array.length;
        int[] reversed = new int[len];
        int index = 0;
        for (int i = len - 1; i >= 0; i--) {
            reversed[index++] = array[i];
        }
        return reversed;
    }
}
