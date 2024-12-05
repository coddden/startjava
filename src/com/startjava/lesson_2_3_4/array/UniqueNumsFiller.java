package com.startjava.lesson_2_3_4.array;

public class UniqueNumsFiller {
    public static void main(String[] args) {
        fillAndDisplay(-30, -10, 23);
        fillAndDisplay(10, 50, 10);
        fillAndDisplay(-34, -34, 0);
        fillAndDisplay(-1, 2, -3);
        fillAndDisplay(5, -8, 2);
    }

    private static void fillAndDisplay(int start, int end, int rowLen) {
        double arrayLen = (end - start + 1) * 0.75;
        if (hasError(start, end, rowLen, (int) arrayLen)) return;
        int[] uniqueNums = new int[(int) arrayLen];
        int index = 0;
        while (index < uniqueNums.length) {
            int generatedNum = start + (int) (Math.random() * (end - start + 1));
            if (!hasSameNum(generatedNum, uniqueNums, index)) {
                uniqueNums[index] = generatedNum;
                index++;
            }
        }
        display(uniqueNums, rowLen);
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

    private static void display(int[] uniqueNums, int rowLen) {
        int len = uniqueNums.length;
        System.out.println();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (uniqueNums[i] > uniqueNums[j]) {
                    int temp = uniqueNums[i];
                    uniqueNums[i] = uniqueNums[j];
                    uniqueNums[j] = temp;
                }
            }
            System.out.printf("%d%s", uniqueNums[i], (i + 1) % rowLen == 0 ? '\n' : " ");
        }
        System.out.println();
    }
}
