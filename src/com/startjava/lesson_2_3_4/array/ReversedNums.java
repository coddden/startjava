package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ReversedNums {
    public static void main(String[] args) {
        int[] emptyArray = {};
        display("До", emptyArray);
        display("После", reverse(emptyArray));
        System.out.println();

        int[] nonExistArray = null;
        display("До", nonExistArray);
        display("После", reverse(nonExistArray));
        System.out.println();

        int[] fewNums = {6, 8, 9, 1};
        display("До", fewNums);
        display("После", reverse(fewNums));
        System.out.println();

        int[] lotsNums = {13, 8, 5, 3, 2, 1, 1};
        display("До", lotsNums);
        display("После", reverse(lotsNums));
    }

    public static void display(String msg, int[] array) {
        String result = Arrays.toString(array);
        if (msg.equals("После")) {
            if (array == null || array.length == 0) {
                result = array == null ? "Массив не существует" : "Массив пуст";
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
