package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] nonExistArray = null;
        int[] positiveNums = {8, 0, 9};
        int[] diffNums = {-3, 1, 7, 13};
        int[] negativeNums = {-22, -0};
        calcFactorial(emptyArray, nonExistArray, positiveNums, diffNums, negativeNums);
    }

    public static void calcFactorial(int[]... numArrays) {
        for (int[] numArray : numArrays) {
            if (numArray == null || numArray.length == 0) {
                String emptyOrNotExist = numArray == null ? "не существует" : "пуст";
                System.out.printf("Массив %s%n", emptyOrNotExist);
                continue;
            }
            System.out.println();
            int len = numArray.length;
            long[] resultArray = new long[len];
            for (int i = 0; i < len; i++) {
                if (numArray[i] < 0) {
                    System.out.printf("Ошибка: факториал %d! не определен%n", numArray[i]);
                    continue;
                }
                resultArray[i] = 1;
                System.out.printf("%d! = ", numArray[i]);
                for (int j = 1; j <= numArray[i]; j++) {
                    String sign = j == numArray[i] ? " = " : " * ";
                    System.out.print(numArray[i] == 1 ? "" : j + sign);
                    resultArray[i] *= j;
                }
                System.out.printf("%d%n", resultArray[i]);
            }
        }
    }
}