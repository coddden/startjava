package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private Console() {}

    public static void displayAmountNumsInRowError(int rowLen) {
        System.out.printf("Ошибка: количество чисел в строке не может быть меньше 1 (%d)%n%n", rowLen);
    }

    public static void displayBeforeOrAfterReverse(String msg, int[] array) {
        String result = Arrays.toString(array);
        if (msg.equals("После")) {
            if (array == null || array.length == 0) {
                result = array == null ? "Массив не существует." : "Массив пуст.";
            }
        }
        System.out.printf("%5s реверса: %s%n", msg, result);
    }

    public static void displayEmptyArrayMsg(long[] array) {
        System.out.printf("Массив %s%n%n", array == null ? "не существует." : "пуст.");
    }

    public static void displayEmptyRowError(String msg) {
        System.out.printf("%nОшибка! Строка %s%n", msg);
    }

    public static void displayExceedArrayLenError(int arrayLen) {
        System.out.printf("Ошибка: длина массива должна быть больше 0 (%d)%n%n", arrayLen);
    }

    public static void displayExceedRightBorderError(int start, int end) {
        System.out.printf("%nОшибка: левая граница (%d) > правой (%d)%n%n", start, end);
    }

    public static void displayFactorial(long[] factorials, int... nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int currentNum = nums[i];
            if (currentNum < 0) {
                System.out.printf("Ошибка: факториал %d! не определен.%n", currentNum);
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
        System.out.println();
    }

    public static void displayHeader(int headerNumber) {
        switch (headerNumber) {
            case 1:
                System.out.printf("%n1.Ревёрс значений массива.%n%n");
                break;
            case 2:
                System.out.printf("%n2.Вычисление факториала.%n%n");
                break;
            case 3:
                System.out.printf("%n3.Удаление элементов массива, превышающих заданное значение.%n");
                break;
            case 4:
                System.out.printf("%n4.Вывод отсортированных символов в виде треугольника.%n%n");
                break;
            case 5:
                System.out.printf("%n5.Заполнение массива уникальными числами.%n");
                break;
            case 6:
                System.out.printf("%n6.Вывод текста с эффектом пишущей машинки.%n");
                break;
            default:
                System.out.printf("%nОшибка! Заголовок отсутствует.%n");
                break;
        }
    }

    public static void displayMissingIndexError(int index, int srcArrayLength) {
        System.out.printf("%nОшибка! Индекса %d в массиве не существует!%nДоступные индексы 0-%d%n",
                index, srcArrayLength - 1);
    }

    public static void displayPrintText(String resultText) throws InterruptedException {
        for (char letter : resultText.toCharArray()) {
            System.out.print(letter);
            Thread.sleep(200);
        }
    }

    public static void displaySrcOrChangedArray(String msg, float[] array) {
        System.out.printf("%n%s массив%n", msg);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f%s", array[i], i == 7 ? "\n" : " ");
        }
        System.out.println();
    }

    public static void displayTriangle(StringBuilder triangleOfChars) {
        System.out.print(triangleOfChars);
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

    public static void displayZeroedCellsMsg(int index, int zeroedCells) {
        System.out.printf("Индекс %d | Обнулённых ячеек %d%n", index, zeroedCells);
    }
}
