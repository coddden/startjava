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
        displayMsg("\n1. Ревёрс значений массива.\n\n");
        int[][] numArrays = {{}, null, {6, 8, 9, 1}, {13, 8, 5, 3, 2, 1, 1}};
        for (int[] numArray : numArrays) {
            if (numArray == null || numArray.length == 0) {
                displayMsg(numArray == null ? "Массив не существует.\n\n" : "Массив пуст.\n\n");
                continue;
            }
            displayMsg("   До ревёрса: " + java.util.Arrays.toString(numArray) + "\n");
            displayMsg("После ревёрса: " + java.util.Arrays.toString(reverseArray(numArray)) + "\n\n");
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
        int srcArrayLength = 15;
        for (int index : indexes) {
            System.out.println();
            float[] srcArray = generateArray(index, srcArrayLength);
            if (srcArray == null) {
                displayMsg("Ошибка! Индекса " + index + " в массиве не существует!\n" +
                        "Доступные индексы 0-" + (srcArrayLength - 1) + "\n");
                continue;
            }
            displayArrayBySevenNums("Исходный массив.\n", srcArray);
            int zeroedCells = removeExceedElements(index, srcArray);
            displayArrayBySevenNums("\n\nИзменённый массив.\n", srcArray);
            displayMsg("\nИндекс " + index + " | Обнулённых ячеек " + zeroedCells + "\n");
        }
    }

    private static void launchCharTriangleCreation() {
        displayMsg("\n4. Вывод отсортированных символов в виде треугольника.\n\n");
        StringBuilder[] charTriangles = new StringBuilder[3];
        charTriangles[0] = createCharTriangle('0', '9', true);
        charTriangles[1] = createCharTriangle('/', '!', false);
        charTriangles[2] = createCharTriangle('A', 'J', false);
        for (StringBuilder charTriangle : charTriangles) {
            displayMsg(charTriangle.toString());
        }
    }

    private static void launchUniqueNumsFilling() {
        displayMsg("\n5.Заполнение массива уникальными числами.\n");
        displayArrayByLines(fillArrayAsc(-30, -10, 23), 23);
        displayArrayByLines(fillArrayAsc(10, 50, 10), 10);
        displayArrayByLines(fillArrayAsc(-34, -34, 0), 0);
        displayArrayByLines(fillArrayAsc(-1, 2, -3), -3);
        displayArrayByLines(fillArrayAsc(5, -8, 2), 2);
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
            String resultText = makeTextFragmentInCaps(originalText);
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