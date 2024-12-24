package com.startjava.lesson_2_3_4.array;

import static com.startjava.lesson_2_3_4.array.Arrays.*;
import static com.startjava.lesson_2_3_4.array.Console.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        displayMsg("\n1. Ревёрс значений массива.\n");
        int[] emptyArray = {};
        launchReverser(emptyArray);
        int[] nonExistArray = null;
        launchReverser(nonExistArray);
        int[] nums1 = {6, 8, 9, 1};
        launchReverser(nums1);
        int[] nums2 = {13, 8, 5, 3, 2, 1, 1};
        launchReverser(nums2);

        displayMsg("2. Вычисление факториала.\n");
        displayFactorialsExpr(calcFactorial());
        displayFactorialsExpr(calcFactorial(null));
        displayFactorialsExpr(calcFactorial(8, 0, 9), 8, 0, 9);
        displayFactorialsExpr(calcFactorial(-3, 1, 7, 13), -3, 1, 7, 13);
        displayFactorialsExpr(calcFactorial(-22, -0), -22, -0);

        displayMsg("\n3. Удаление элементов массива, превышающих заданное значение.");
        int[] indexes = {-1, 15, 0, 14};
        int srcArrayLength = 15;
        for (int index : indexes) {
            System.out.println();
            if (index < 0 || index >= srcArrayLength) {
                displayMsg("Ошибка! Индекса " + index + " в массиве не существует!\n" +
                        "Доступные индексы 0-" + (srcArrayLength - 1));
                continue;
            }
            float[] srcArray = new float[srcArrayLength];
            for (int i = 0; i < srcArrayLength; i++) {
                srcArray[i] = (float) Math.random();
            }
            displayZeroedArray("Исходный", srcArray);
            int zeroedCells = removeExceedElements(index, srcArray);
            displayZeroedArray("\n\nИзменённый", srcArray);
            displayMsg("\nИндекс " + index + " | Обнулённых ячеек " + zeroedCells);
        }

        displayMsg("\n4. Вывод отсортированных символов в виде треугольника.\n");
        launchTriangle(createTriangle('0', '9', true));
        launchTriangle(createTriangle('/', '!', false));
        launchTriangle(createTriangle('A', 'J', false));

        displayMsg("5.Заполнение массива уникальными числами.");
        displayUniqueNums(fillArrayAsc(-30, -10, 23), 23);
        displayUniqueNums(fillArrayAsc(10, 50, 10), 10);
        displayUniqueNums(fillArrayAsc(-34, -34, 0), 0);
        displayUniqueNums(fillArrayAsc(-1, 2, -3), -3);
        displayUniqueNums(fillArrayAsc(5, -8, 2), 2);

        displayMsg("6.Вывод текста с эффектом пишущей машинки.");
        launchTypewriter("Java - это C++, из которого убрали все пистолеты, " +
                "ножи и дубинки.\n- James Gosling\n");
        launchTypewriter("Чтобы написать чистый код, мы сначала пишем грязный код, " +
                "затем рефакторим его.\n- Robert Martin\n");
        launchTypewriter(null);
        launchTypewriter("");
    }

    private static void launchReverser(int[] array) {
        displayReversedArray("До", array);
        displayReversedArray("После", reverseArray(array));
        System.out.println();
    }

    private static void launchTriangle(StringBuilder triangleOfChars) {
        if (triangleOfChars != null) displayMsg(triangleOfChars.toString());
    }

    private static void launchTypewriter(String originalText) throws InterruptedException {
        String resultText = prepareTypeText(originalText);
        if (resultText != null) typeText(resultText);
    }
}