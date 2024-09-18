public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел");
        int even = 0;
        int odd = 0;
        int a = -10;
        int b = 21;
        int c = a;
        do {
            if (c % 2 == 0) {
                even += c;
            } else {
                odd += c;
            }
            c++;
        } while (c < b);
        System.out.println("В отрезке [" + a + ", " + b + "] сумма четных чисел = " +
                even + ", а нечетных = " + odd);

        System.out.println("\n2. Вывод чисел между min и max в порядке убывания");
        int d = 10;
        int e = 5;
        int f = -1;
        int min = 0;
        int max = 0;
        if (d < e && d < f) {
            min = d;
        } else if (e < d && e < f) {
            min = e;
        } else if (f < d && f < e) {
            min = f;
        }
        if (d > e && d > f) {
            max = d;
        } else if (e > d && e > f) {
            max = e;
        } else if (f > d && f > e) {
            max = f;
        }
        for (int g = max; g >= min; g--) {
            System.out.print(g + "  ");
        }

        System.out.println("\n\n3.Вывод реверсивного числа и суммы его цифр");
        String num = "1234";
        int sum = 0;
        int h = 3;
        while (h >= 0) {
            System.out.print(num.charAt(h) + " ");
            sum += (h + 1);
            h--;
        }
        System.out.println("\nСумма выделенных цифр = " + sum);

        System.out.println("\n4.Вывод чисел в несколько строк");
        int j = 0;
        for (int i = 1; i <= 24; i++) {
            if (i % 2 != 0) {
                System.out.printf("%5d", i);
                j++;
                if (j % 5 == 0) {
                    System.out.println();
                }
            }
        }
        while (j % 5 != 0) {
            System.out.printf("%5d", 0);
            j++;
        }

        System.out.println("\n\n5.Проверка количества двоек числа на четность/нечетность");
        String numWithTwos = "3242592";
        int numTwos = 0;
        int count = 0;
        while (count < 7) {
            if (numWithTwos.charAt(count) == '2') {
                numTwos++;
            }
            count++;
        }
        String evenOdd;
        if (numTwos % 2 == 0) {
            evenOdd = "четное";
        } else {
            evenOdd = "нечетное";
        }
        System.out.printf("В %s %s (%d) количество двоек", numWithTwos, evenOdd, numTwos);

        System.out.println("\n\n6.Вывод геометрических фигур\n");
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 10; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        int n = 0;
        while (n < 5) {
            int m = n + 1;
            while (m < 6) {
                System.out.print("#");
                m++;
            }
            System.out.println();
            n++;
        }
        System.out.println();

        int o = 0;
        int p = 0;
        int newRow = 1;
        do {
            if (newRow == p) {
                System.out.println();
                newRow++;
                p = 0;
            }
            System.out.print("$");
            o++;
            p++;
        } while (o < 6);
        System.out.println();
        int q = 0;
        int r = 0;
        int newRow1 = 2;
        do {
            if (newRow1 == r) {
                System.out.println();
                newRow1--;
                r = 0;
            }
            System.out.print("$");
            q++;
            r++;
        } while (q < 3);

        System.out.println("\n\n7.Вывод ASCII-символов");
        System.out.println("DECIMAL   CHARACTER   DESCRIPTION");
        for (int s = 33; s <= 47; s++) {
            if (s % 2 != 0) {
                System.out.printf("%4d %10c %10s %-1s %n", s, s, " ", Character.getName(s));
            }
        }
        for (int t = 97; t <= 122; t++) {
            if (t % 2 == 0) {
                System.out.printf("%4d %10c %10s %-10s %n", t, t, " ", Character.getName(t));
            }
        }

        System.out.println("\n\n8.Проверка, является ли число палиндромом");
        String numPalindrome = "1234321";
        int u = 0;
        int v = 6;
        boolean isPalindrome = true;
        while (u <= v) {
            if (numPalindrome.charAt(u) != numPalindrome.charAt(v)) {
                isPalindrome = false;
                break;
            }
            u++;
            v--;
        }
        if (isPalindrome) {
            System.out.printf("Число %s - палиндром", numPalindrome);
        } else {
            System.out.printf("Число %s - не палиндром", numPalindrome);
        }

        System.out.println("\n\n9.Проверка, является ли число счастливым");
        int luckyNum = 789987;
        int firstNum = luckyNum / 100000;
        int secondNum = luckyNum % 100000 / 10000;
        int thirdNum = luckyNum % 10000 / 1000;
        int fourthNum = luckyNum % 1000 / 100;
        int fifthNum = luckyNum % 100 / 10;
        int sixthNum = luckyNum % 10;
        int leftHalf = firstNum + secondNum + thirdNum;
        int rightHalf = fourthNum + fifthNum + sixthNum;
        if (leftHalf == rightHalf) {
            System.out.printf("Число %d - счастливое %n", luckyNum);
            System.out.printf("Сумма цифр %d%d%d = %d%n", firstNum, secondNum, thirdNum, leftHalf);
            System.out.printf("Сумма цифр %d%d%d = %d%n", fourthNum, fifthNum, sixthNum, rightHalf);
        }

        System.out.println("\n\n10.Вывод таблицы умножения Пифагора");
        System.out.printf("%n%28S%n%n", "таблица   пифагора");
        for (int y = 1; y <= 9; y++) {
            if (y == 2) {
                for (int x1 = 0; x1 < 39; x1++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            for (int x = 1; x <= 9; x++) {
                if (x == 1 && y == 1) {
                    System.out.printf("%4s", " ");
                } else {
                    if (x == 2) {
                        System.out.printf("%2s", "|");
                    }
                    System.out.printf("%4d", y * x);
                }
            }
            System.out.println();
        }
    }
}