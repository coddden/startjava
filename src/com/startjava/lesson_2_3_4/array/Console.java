package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private Console() {}

    public static void displayFactorialsExpr(long[] factorials, int... nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int currentNum = nums[i];
            if (currentNum < 0) {
                displayMsg("\nОшибка: факториал " + currentNum + "! не определен.");
                continue;
            }
            StringBuilder factorialExp = new StringBuilder();
            factorialExp.append(currentNum).append("! = ");
            for (int j = 1; j <= currentNum; j++) {
                String sign = j == currentNum ? " = " : " * ";
                factorialExp.append(currentNum == 1 ? "" : j + sign);
            }
            factorialExp.append(factorials[i]).append(currentNum == len - 1 ? "" : "\n");
            System.out.print(factorialExp);
        }
    }

    public static void displayMsg(String msg) {
        System.out.println(msg);
    }

    public static void displayReversedArray(String msg, int[] array) {
        String result = Arrays.toString(array);
        if (msg.equals("После")) {
            if (array == null || array.length == 0) {
                result = array == null ? "Массив не существует." : "Массив пуст.";
            }
        }
        System.out.printf("%5s реверса: %s%n", msg, result);
    }

    public static void displayUniqueNums(int[] array, int rowLen) {
        if (array == null) return;
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print((i + 1) % rowLen == 0 ? "\n" : " ");
        }
        System.out.println();
    }

    public static void displayZeroedArray(String msg, float[] array) {
        System.out.printf("%s массив%n", msg);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f%s", array[i], i == 7 ? "\n" : " ");
        }
    }

    public static void typeText(String resultText) throws InterruptedException {
        for (char letter : resultText.toCharArray()) {
            System.out.print(letter);
            Thread.sleep(200);
        }
    }
}