package com.startjava.lesson_2_3_4.array;

import static com.startjava.lesson_2_3_4.array.Arrays.*;
import static com.startjava.lesson_2_3_4.array.Console.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        displayHeader(1);
        int[] emptyArray = {};
        launchReverser(emptyArray);
        int[] nonExistArray = null;
        launchReverser(nonExistArray);
        int[] nums1 = {6, 8, 9, 1};
        launchReverser(nums1);
        int[] nums2 = {13, 8, 5, 3, 2, 1, 1};
        launchReverser(nums2);

        displayHeader(2);
        displayFactorial(calcFactorial());
        displayFactorial(calcFactorial(null));
        displayFactorial(calcFactorial(8, 0, 9), 8, 0, 9);
        displayFactorial(calcFactorial(-3, 1, 7, 13), -3, 1, 7, 13);
        displayFactorial(calcFactorial(-22, -0), -22, -0);

        displayHeader(3);
        int[] indexes = {-1, 15, 0, 14};
        int srcArrayLength = 15;
        for (int index : indexes) {
            int zeroedCells = removeExceedElements(index, srcArrayLength);
            if (zeroedCells < 0) continue;
            displayZeroedCellsMsg(index, zeroedCells);
        }

        displayHeader(4);
        launchTriangle(createTriangle('0', '9', true));
        launchTriangle(createTriangle('/', '!', false));
        launchTriangle(createTriangle('A', 'J', false));

        displayHeader(5);
        displayUniqueNums(fillAsc(-30, -10, 23), 23);
        displayUniqueNums(fillAsc(10, 50, 10), 10);
        displayUniqueNums(fillAsc(-34, -34, 0), 0);
        displayUniqueNums(fillAsc(-1, 2, -3), -3);
        displayUniqueNums(fillAsc(5, -8, 2), 2);

        displayHeader(6);
        launchTypewriter("Java - это C++, из которого убрали все пистолеты, " +
                "ножи и дубинки.\n- James Gosling\n");
        launchTypewriter("Чтобы написать чистый код, мы сначала пишем грязный код, " +
                "затем рефакторим его.\n- Robert Martin\n");
        launchTypewriter(null);
        launchTypewriter("");
    }

    private static void launchReverser(int[] array) {
        displayBeforeOrAfterReverse("До", array);
        displayBeforeOrAfterReverse("После", reverseArray(array));
        System.out.println();
    }

    private static void launchTriangle(StringBuilder triangleOfChars) {
        if (triangleOfChars != null) displayTriangle(triangleOfChars);
    }

    private static void launchTypewriter(String originalText) throws InterruptedException {
        String resultText = typeText(originalText);
        if (resultText != null) displayPrintText(resultText);
    }
}
