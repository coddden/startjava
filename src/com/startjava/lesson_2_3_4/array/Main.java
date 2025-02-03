package com.startjava.lesson_2_3_4.array;

import static com.startjava.lesson_2_3_4.array.Arrays.*;
import static com.startjava.lesson_2_3_4.array.Console.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        launchReverse();
        launchFactorialCalc();
        launchExceedingElementsRemoval();
        launchCharTriangleCreation();
        launchUniqueNumsFilling();
        launchTextPrinting();
    }

    private static void launchReverse() {
        displayMsg("\n1. Реверс значений массива.\n\n");
        int[][] numArrays = {{}, null, {6, 8, 9, 1}, {13, 8, 5, 3, 2, 1, 1}};
        for (int[] numArray : numArrays) {
            if (numArray == null || numArray.length == 0) {
                displayMsg(numArray == null ? "Массив не существует.\n\n" : "Массив пуст.\n\n");
                continue;
            }
            displayMsg("   До реверса: " + java.util.Arrays.toString(numArray) + "\n");
            displayMsg("После реверса: " + java.util.Arrays.toString(reverse(numArray)) + "\n\n");
        }
    }

    private static void launchFactorialCalc() {
        displayMsg("2. Вычисление факториала.\n\n");
        displayFactorialsExpr(calcFactorial());
        displayFactorialsExpr(calcFactorial(null));
        displayFactorialsExpr(calcFactorial(8, 0, 9), 8, 0, 9);
        displayFactorialsExpr(calcFactorial(-3, 1, 7, 13), -3, 1, 7, 13);
        displayFactorialsExpr(calcFactorial(-22, -0), -22, -0);
    }

    private static void launchExceedingElementsRemoval() {
        displayMsg("\n3. Удаление элементов массива, превышающих заданное значение.\n");
        int[] indexes = {-1, 15, 0, 14};
        int srcArrayLen = 15;
        for (int index : indexes) {
            System.out.println();
            float[] srcArray = generateArray(index, srcArrayLen);
            if (srcArray == null) {
                displayMsg("Ошибка! Индекса " + index + " в массиве не существует!\n" +
                        "Доступные индексы 0-" + (srcArrayLen - 1) + "\n");
                continue;
            }
            displayTwoLines(srcArray, "Исходный массив.\n");
            int zeroedCells = removeExceedElements(srcArray, index);
            displayTwoLines(srcArray, "\n\nИзменённый массив.\n");
            displayMsg("\nИндекс " + index + " | Обнулённых ячеек " + zeroedCells + "\n");
        }
    }

    private static void launchCharTriangleCreation() {
        displayMsg("\n4. Вывод отсортированных символов в виде треугольника.\n\n");
        char[] chars = {'0', '9', '/', '!', 'A', 'J'};
        boolean[] dirs = {true, false, false};
        int index = 0;
        for (int i = 0; i < chars.length; i += 2) {
            StringBuilder triangleOfChars = createTriangleOfChars(chars[i], chars[i + 1], dirs[index++]);
            if (triangleOfChars == null) {
                displayMsg("\nОшибка: левая граница (" + (int) chars[i] +
                        ") > правой (" + (int) chars[i + 1] + ")\n\n");
                continue;
            }
            displayMsg(triangleOfChars.toString());
        }
    }

    private static void launchUniqueNumsFilling() {
        displayMsg("\n5.Заполнение массива уникальными числами.\n");
        displayLines(fillWithAscUniqueNums(-30, -10, 23), 23);
        displayLines(fillWithAscUniqueNums(10, 50, 10), 10);
        displayLines(fillWithAscUniqueNums(-34, -34, 0), 0);
        displayLines(fillWithAscUniqueNums(-1, 2, -3), -3);
        displayLines(fillWithAscUniqueNums(5, -8, 2), 2);
    }

    private static void launchTextPrinting() throws InterruptedException {
        displayMsg("6.Вывод текста с эффектом пишущей машинки.\n");
        String[] originalTexts = {
                "Java - это C++, из которого убрали все пистолеты, " +
                        "ножи и дубинки.\n- James Gosling\n",
                "Чтобы написать чистый код, мы сначала пишем грязный код, " +
                        "затем рефакторим его.\n- Robert Martin\n",
                null,
                ""
        };
        for (String originalText : originalTexts) {
            String resultText = toUpperCaseRange(originalText);
            if (resultText == null) {
                displayMsg(originalText == null ?
                        "\nОшибка! Строка не существует.\n" : "\nОшибка! Строка пуста.\n");
                continue;
            }
            System.out.println();
            typeText(resultText);
        }
    }
}