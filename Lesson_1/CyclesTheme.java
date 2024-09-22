public class CyclesTheme {
    public static void main(String[] args) {
        System.out.printf("%n1.Подсчет суммы четных и нечетных чисел%n");
        int sumEvenNums = 0;
        int sumOddNums = 0;
        int firstValue = -10;
        int secondValue = 21;
        int segmentSize = firstValue;
        do {
            if (segmentSize % 2 == 0) {
                sumEvenNums += segmentSize;
            } else {
                sumOddNums += segmentSize;
            }
            segmentSize++;
        } while (segmentSize <= secondValue);
        System.out.printf("В отрезке [%d, %d] сумма четных чисел = %d, а нечетных = %d",
                firstValue, secondValue, sumEvenNums, sumOddNums);

        System.out.printf("%n%n2.Вывод чисел между min и max в порядке убывания%n");
        int minNum = 10;
        int middleNum = 5;
        int maxNum = -1;
        for (int i = 0; i < 2; i++) {
            if (minNum > middleNum) {
                int swap = minNum;
                minNum = middleNum;
                middleNum = swap;
            }
            if (middleNum > maxNum) {
                int swap = middleNum;
                middleNum = maxNum;
                maxNum = swap;
            }
        }
        for (int i = maxNum - 1; i > minNum; i--) {
            System.out.printf("%d ", i);
        }

        System.out.printf("%n%n3.Вывод реверсивного числа и суммы его цифр%n");
        int reverseNum = 1234;
        int sumDigits = 0;
        while (reverseNum > 0) {
            System.out.print(reverseNum % 10);
            sumDigits += reverseNum % 10;
            reverseNum /= 10;
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
        int initNumWithTwos = 3242592;
        int numWithTwos = initNumWithTwos;
        int numTwos = 0;
        while (numWithTwos > 0) {
            if ((numWithTwos % 10) == 2) {
                numTwos++;
            }
            numWithTwos /= 10;
        }
        String evenOrOdd;
        if (numTwos % 2 == 0) {
            evenOrOdd = "четное";
        } else {
            evenOrOdd = "нечетное";
        }
        System.out.printf("В %d %s (%d) количество двоек", initNumWithTwos, evenOrOdd, numTwos);

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
        int triangleRow = 0;
        while (triangleRow < 5) {
            int triangleItem = triangleRow + 1;
            while (triangleItem < 6) {
                System.out.print("#");
                triangleItem++;
            }
            System.out.println();
            triangleRow++;
        }
        System.out.println();

        // Равнобедренный треугольник
        int triangleRow1 = 0;
        int itemCounter = 0;
        int triangleItem1 = 1;
        do {
            if (triangleItem1 == itemCounter) {
                System.out.println();
                triangleItem1++;
                itemCounter = 0;
            }
            System.out.print("$");
            triangleRow1++;
            itemCounter++;
        } while (triangleRow1 < 6);
        System.out.println();
        int triangleRow2 = 0;
        int itemCounter2 = 0;
        int triangleItem2 = 2;
        do {
            if (triangleItem2 == itemCounter2) {
                System.out.println();
                triangleItem2--;
                itemCounter2 = 0;
            }
            System.out.print("$");
            triangleRow2++;
            itemCounter2++;
        } while (triangleRow2 < 3);

        System.out.printf("%n%n7.Вывод ASCII-символов%n");
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

        System.out.printf("%n%n8.Проверка, является ли число палиндромом%n");
        int initPalindrome = 1234321;
        int palindrome = initPalindrome;
        int reversePalindrome = 0;
        int multiplier = 1000000;
        while (palindrome > 0) {
            reversePalindrome += (palindrome % 10) * multiplier;
            palindrome /= 10;
            multiplier /= 10;
        }
        if (initPalindrome == reversePalindrome) {
            System.out.printf("Число %d - палиндром", initPalindrome);
        }

        System.out.printf("%n%n9.Проверка, является ли число счастливым%n");
        int initLuckyNum = 316145;
        int luckyNum = initLuckyNum;
        int leftHalfSum = 0;
        int rightHalfSum = 0;
        int leftHalf = 0;
        int rightHalf = 0;
        int multiplier1 = 1;
        for (int i = 0; i < 6; i++) {
            if (multiplier1 == 1000) {
                multiplier1 = 1;
            }
            if (i < 3) {
                rightHalfSum += luckyNum % 10;
                rightHalf += (luckyNum % 10) * multiplier1;
                multiplier1 *= 10;
            } else {
                leftHalfSum += luckyNum % 10;
                leftHalf += (luckyNum % 10) * multiplier1;
                multiplier1 *= 10;
            }
            luckyNum /= 10;
        }
        if (leftHalfSum == rightHalfSum) {
            System.out.printf("Число %d - счастливое%n", initLuckyNum);
            System.out.printf("Сумма цифр %d = %d%n", leftHalf, leftHalfSum);
            System.out.printf("Сумма цифр %d = %d%n", rightHalf, rightHalfSum);
        }

        System.out.printf("%n%n10.Вывод таблицы умножения Пифагора%n%n");
        System.out.printf("%28S%n%n", "таблица   пифагора");
        for (int i = 1; i <= 9; i++) {
            if (i == 2) {
                for (int k = 0; k < 39; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            for (int j = 1; j <= 9; j++) {
                if (j == 1 && i == 1) {
                    System.out.printf("%4s", " ");
                } else {
                    if (j == 2) {
                        System.out.printf("%2s", "|");
                    }
                    System.out.printf("%4d", i * j);
                }
            }
            System.out.println();
        }
    }
}