package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] nonExistArray = null;
        int[] positiveNums = {8, 0, 9};
        int[] diffNums = {-3, 1, 7, 13};
        int[] negativeNums = {-22, -0};
        getArray(emptyArray, nonExistArray, positiveNums, diffNums, negativeNums);
    }

    private static void getArray(int[]... numArrays) {
        for (int[] numArray : numArrays) {
            System.out.println();
            if (isEmpty(numArray)) {
                displayFactorial(numArray, calcFactorial(numArray));
            }
        }
    }

    private static boolean isEmpty(int[] numArray) {
        if (numArray != null && numArray.length > 0) return true;
        String emptyOrNotExist = numArray == null ? "не существует" : "пуст";
        System.out.printf("Массив %s%n", emptyOrNotExist);
        return false;
    }

    private static void displayFactorial(int[] numArray, long[] factorials) {
        int len = numArray.length;
        for (int i = 0; i < len; i++) {
            int currentNum = numArray[i];
            if (currentNum < 0) {
                System.out.printf("Ошибка: факториал %d! не определен%n", currentNum);
                continue;
            }
            System.out.printf("%d! = ", currentNum);
            for (int j = 1; j <= currentNum; j++) {
                String sign = j == currentNum ? " = " : " * ";
                System.out.print(currentNum == 1 ? "" : j + sign);
            }
            System.out.printf("%d %s", factorials[i], currentNum == len - 1 ? "" : "\n");
        }
    }

    private static long[] calcFactorial(int[] numArray) {
        int len = numArray.length;
        long[] factorials = new long[len];
        for (int i = 0; i < len; i++) {
            if (numArray[i] < 0) continue;
            factorials[i] = 1;
            for (int j = 1; j <= numArray[i]; j++) {
                factorials[i] *= j;
            }
        }
        return factorials;
    }
}