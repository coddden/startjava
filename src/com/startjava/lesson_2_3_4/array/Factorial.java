package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        display(calc());
        display(calc(null));
        display(calc(8, 0, 9), 8, 0, 9);
        display(calc(-3, 1, 7, 13), -3, 1, 7, 13);
        display(calc(-22, -0), -22, -0);
    }

    private static long[] calc(long... nums) {
        if (isEmpty(nums)) return nums;
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

    private static boolean isEmpty(long[] numArray) {
        if (numArray != null && numArray.length > 0) return false;
        System.out.printf("Массив %s%n%n", numArray == null ? "не существует" : "пуст");
        return true;
    }

    private static void display(long[] factorials, int... nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int currentNum = nums[i];
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
        System.out.println();
    }
}