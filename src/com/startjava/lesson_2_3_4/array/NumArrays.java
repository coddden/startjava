package com.startjava.lesson_2_3_4.array;

public class NumArrays {
    public static void main(String[] args) {
        int[] emptyArray = {};
        reverse(emptyArray);

        int[] nonExistArray = null;
        reverse(nonExistArray);

        int[] shortArray = {6, 8, 9, 1};
        reverse(shortArray);

        int[] longArray = {13, 8, 5, 3, 2, 1, 1};
        reverse(longArray);
    }

    public static void reverse(int[] array) {
        displayArray("До", array);
        if (array != null && array.length > 0) {
            int[] reverseArray = new int[array.length];
            int count = 0;
            for (int i = array.length - 1; i >= 0; i--) {
                reverseArray[count] = array[i];
                count++;
            }
            for (int i = 0; i < array.length; i++) {
                array[i] = reverseArray[i];
            }
        }
        displayArray("После", array);
        System.out.println();
    }

    public static void displayArray(String beforeOrAfter, int[] array) {
        System.out.printf("%5s реверса: [", beforeOrAfter);
        if (array != null && array.length > 0) {
            String separator = ", ";
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i == array.length - 1) {
                    separator = "";
                }
                System.out.printf(separator);
            }
        }
        System.out.printf("]%n");
    }
}
