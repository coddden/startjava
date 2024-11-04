package com.startjava.lesson_1.base;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.printf("%n1.Подсчет суммы четных и нечетных чисел%n");
        int sumEvenNums = 0;
        int sumOddNums = 0;
        int startSegment = -10;
        int endSegment = 21;
        int counter = startSegment;
        do {
            if (counter % 2 == 0) {
                sumEvenNums += counter;
            } else {
                sumOddNums += counter;
            }
            counter++;
        } while (counter <= endSegment);
        System.out.printf("В отрезке [%d, %d] сумма четных чисел = %d, а нечетных = %d",
                startSegment, endSegment, sumEvenNums, sumOddNums);

        System.out.printf("%n%n2.Вывод чисел между min и max в порядке убывания%n");
        int a = 5;
        int b = 10;
        int c = -1;
        int minNum = a;
        if (minNum > b) {
            minNum = b;
        }
        if (minNum > c) {
            minNum = c;
        }
        int maxNum = a;
        if (maxNum < b) {
            maxNum = b;
        }
        if (maxNum < c) {
            maxNum = c;
        }
        for (int i = maxNum - 1; i > minNum; i--) {
            System.out.printf("%d ", i);
        }

        System.out.printf("%n%n3.Вывод реверсивного числа и суммы его цифр%n");
        int sourceNum = 1234;
        int sumDigits = 0;
        int digit = 0;
        while (sourceNum > 0) {
            digit = sourceNum % 10;
            sumDigits += digit;
            System.out.print(digit);
            sourceNum /= 10;
        }
        System.out.printf("%nСумма выделенных цифр = %d%n", sumDigits);

        System.out.printf("%n4.Вывод чисел в несколько строк%n");
        int rowSize = 0;
        for (int i = 1; i < 24; i++) {
            if (i % 2 != 0) {
                System.out.printf("%5d", i);
                rowSize++;
                if (rowSize % 5 == 0) {
                    System.out.println();
                }
            }
        }
        while (rowSize % 5 != 0) {
            System.out.printf("%5d", 0);
            rowSize++;
        }

        System.out.printf("%n%n5.Проверка количества двоек числа на четность/нечетность%n");
        int initNum = 3242592;
        int initNumCopy = initNum;
        int numTwos = 0;
        while (initNumCopy > 0) {
            if ((initNumCopy % 10) == 2) {
                numTwos++;
            }
            initNumCopy /= 10;
        }
        String evenOrOdd = "нечетное";
        if (numTwos % 2 == 0) {
            evenOrOdd = "четное";
        }
        System.out.printf("В %d %s (%d) количество двоек", initNum, evenOrOdd, numTwos);

        System.out.printf("%n%n6.Вывод геометрических фигур%n%n");

        // Прямоугольник
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // Прямоугольный треугольник
        int row = 0;
        while (row < 5) {
            int item = row + 1;
            while (item < 6) {
                System.out.print("#");
                item++;
            }
            System.out.println();
            row++;
        }
        System.out.println();

        // Равнобедренный треугольник
        row = 0;
        do {
            int item = 0;
            if (row == 3) {
                item = row - 1;
            } else if (row == 4) {
                item = row - 3;
            } else {
                item = row + 1;
            }
            do {
                System.out.print("$");
                item--;
            } while (item > 0);
            System.out.println();
            row++;
        } while (row < 5);

        System.out.printf("%n7.Вывод ASCII-символов%n");
        System.out.println("DECIMAL   CHARACTER   DESCRIPTION");
        for (int i = 33; i <= 47; i++) {
            if (i % 2 != 0) {
                System.out.printf("%4d %10c %10s %-1s %n", i, i, " ", Character.getName(i));
            }
        }
        for (int i = 97; i <= 122; i++) {
            if (i % 2 == 0) {
                System.out.printf("%4d %10c %10s %-10s %n", i, i, " ", Character.getName(i));
            }
        }

        System.out.printf("%n8.Проверка, является ли число палиндромом%n");
        int initPalindrome = 1234321;
        int palindrome = initPalindrome;
        int reversePalindrome = 0;
        while (palindrome > 0) {
            reversePalindrome += palindrome % 10;
            reversePalindrome *= 10;
            palindrome /= 10;
        }
        reversePalindrome /= 10;
        String palindromeOrNot = "не является палиндромом";
        if (initPalindrome == reversePalindrome) {
            palindromeOrNot = "палиндром";
        }
        System.out.printf("Число %d - %s", initPalindrome, palindromeOrNot);

        System.out.printf("%n%n9.Проверка, является ли число счастливым%n");
        int initLuckyNum = 316145;
        int luckyNum = initLuckyNum;
        int leftHalfSum = 0;
        int rightHalfSum = 0;
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                rightHalfSum += luckyNum % 10;
            } else {
                leftHalfSum += luckyNum % 10;
            }
            luckyNum /= 10;
        }
        String luckyOrNot = "несчастливое";
        if (leftHalfSum == rightHalfSum) {
            luckyOrNot = "счастливое";
        }
        int leftHalf = initLuckyNum / 1000;
        int rightHalf = initLuckyNum % 1000;
        System.out.printf("Число %d - %s%n", initLuckyNum, luckyOrNot);
        System.out.printf("Сумма цифр %d = %d%n", leftHalf, leftHalfSum);
        System.out.printf("Сумма цифр %d = %d%n", rightHalf, rightHalfSum);

        System.out.printf("%n10.Вывод таблицы умножения Пифагора%n%n");
        System.out.printf("%28S%n%n", "таблица   пифагора");
        for (int i = 1; i <= 9; i++) {
            if (i == 2) {
                for (int j = 0; j < 34; j++) {
                    if (j < 3) {
                        System.out.print(" ");
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println();
            }
            for (int j = 1; j <= 9; j++) {
                if (j == 1 && i == 1) {
                    System.out.printf("%4s", " ");
                } else if (j == 2) {
                    System.out.printf("%2s", "|");
                } else {
                    System.out.printf("%4d", i * j);
                }
            }
            System.out.println();
        }
    }
}