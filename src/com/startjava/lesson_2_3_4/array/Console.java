package com.startjava.lesson_2_3_4.array;

public class Console {
    private Console() {}

    public static void displayFactorialsExpr(long[] factorials, int... nums) {
        if (factorials == null || factorials.length == 0) {
            displayMsg(factorials == null ? "Массив не существует.\n\n" : "Массив пуст.\n\n");
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int currentNum = nums[i];
            if (currentNum < 0) {
                displayMsg("\nОшибка: факториал " + currentNum + "! не определен.\n");
                continue;
            }
            StringBuilder factorialExpr = new StringBuilder();
            factorialExpr.append(currentNum).append("! = ");
            for (int j = 1; j <= currentNum; j++) {
                String sign = j == currentNum ? " = " : " * ";
                factorialExpr.append(currentNum == 1 ? "" : j + sign);
            }
            factorialExpr.append(factorials[i]).append(currentNum == len - 1 ? "" : "\n");
            displayMsg(factorialExpr.toString());
        }
    }

    public static void displayLines(int[] array, int rowLen) {
        if (array == null) return;
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print((i + 1) % rowLen == 0 ? "\n" : " ");
        }
        System.out.println();
    }

    public static void displayMsg(String msg) {
        System.out.printf(msg);
    }

    public static void typeText(String text) throws InterruptedException {
        for (char letter : text.toCharArray()) {
            System.out.print(letter);
            Thread.sleep(200);
        }
    }

    public static void displayTwoLines(float[] array, String msg) {
        displayMsg(msg);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f%s", array[i], i == 7 ? "\n" : " ");
        }
    }
}