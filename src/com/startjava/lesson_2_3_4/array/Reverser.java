package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverser {
    public static void main(String[] args) {
        int[] emptyArray = {};
        display("До", emptyArray);
        display("После", reverse(emptyArray));
        System.out.println();

        int[] nonExistArray = null;
        display("До", nonExistArray);
        display("После", reverse(nonExistArray));
        System.out.println();

        int[] nums1 = {6, 8, 9, 1};
        display("До", nums1);
        display("После", reverse(nums1));
        System.out.println();

        int[] nums2 = {13, 8, 5, 3, 2, 1, 1};
        display("До", nums2);
        display("После", reverse(nums2));
    }

    private static void display(String msg, int[] array) {
        String result = Arrays.toString(array);
        if (msg.equals("После")) {
            if (array == null || array.length == 0) {
                result = array == null ? "Массив не существует" : "Массив пуст";
            }
        }
        System.out.printf("%5s реверса: %s%n", msg, result);
    }

    private static int[] reverse(int[] array) {
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
