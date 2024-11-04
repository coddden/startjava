package com.startjava.lesson_1.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("\n\n1.Вывод характеристик компьютера");
        byte numCores = 12;
        short amountRam = 16;
        int amountSsd = 512;
        long frequencyRam = 3200L;
        float frequencyCpu = 2.5F;
        double screenSize = 15.6;
        char genProcessor = 'X';
        boolean hasTouchScreen = false;
        System.out.println("Количество ядер - " + numCores);
        System.out.println("Объем оперативной памяти - " + amountRam);
        System.out.println("Объем физической памяти - " + amountSsd);
        System.out.println("Частота оперативной памяти - " + frequencyRam);
        System.out.println("Частота процессора - " + frequencyCpu);
        System.out.println("Диагональ экрана - " + screenSize);
        System.out.println("Поколение - " + genProcessor);
        System.out.println("Сенсорный экран - " + hasTouchScreen);

        System.out.println("\n\n2.Расчет стоимости товара со скидкой");
        double penPrice = 105.50;
        double bookPrice = 235.83;
        double discountPercent = 0.11;
        double basePrice = penPrice + bookPrice;
        double discountSum = basePrice * discountPercent;
        double discountPrice = basePrice - discountSum;
        System.out.println("Стоимость товаров без скидки = " + basePrice);
        System.out.println("Сумма скидки = " + discountSum);
        System.out.println("Стоимость товаров со скидкой = " + discountPrice);

        System.out.println("\n\n3.Вывод слова JAVA\n");
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        System.out.println("\n\n4.Вывод min и max значений целых числовых типов");
        byte byteMax = 127;
        short shortMax = 32_767;
        int intMax = 2_147_483_647;
        long longMax = 9_223_372_036_854_775_807L;
        char charMax = 65_535;
        System.out.println("byte " + byteMax++); // 127
        System.out.println("byte++ " + byteMax--); // -128
        System.out.println("byte-- " + byteMax + "\n"); // 127
        System.out.println("short " + shortMax++);
        System.out.println("short++ " + shortMax--);
        System.out.println("short-- " + shortMax + "\n");
        System.out.println("int " + intMax++);
        System.out.println("int++ " + intMax--);
        System.out.println("int-- " + intMax + "\n");
        System.out.println("long " + longMax++);
        System.out.println("long++ " + longMax--);
        System.out.println("long-- " + longMax + "\n");
        System.out.println("char " + (int) charMax++);
        System.out.println("char++ " + (int) charMax--);
        System.out.println("char-- " + (int) charMax);

        System.out.println("\n\n5.Перестановка значений переменных");
        int a = 2;
        int b = 5;
        System.out.println("Исходные значения:\n" + "a " + a + "\nb " + b);
        int swap = a;
        a = b;
        b = swap;
        System.out.println("\nС помощью третьей переменной:\n" + "a " + a + "\nb " + b);
        a += b;
        b = a - b;
        a -= b;
        System.out.println("\nС помощью арифметических операций:\n" +
                "a " + a + "\nb " + b);
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("\nС помощью побитовой операции ^:\n" + "a " + a + "\nb " + b);

        System.out.println("\n\n6.Вывод символов и их кодов");
        char dollar = '$';
        char asterisk = '*';
        char atSign = '@';
        char verticalBar = '|';
        char tilde = '~';
        System.out.println((int) dollar + " " + dollar);
        System.out.println((int) asterisk + " " + asterisk);
        System.out.println((int) atSign + " " + atSign);
        System.out.println((int) verticalBar + " " + verticalBar);
        System.out.println((int) tilde + " " + tilde);

        System.out.println("\n\n7.Вывод в консоль ASCII-арт Дюка");
        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char openBracket = '(';
        char closeBracket = ')';
        System.out.println("    " + slash + backslash);
        System.out.println("   " + slash + "  " + backslash);
        System.out.println("  " + slash + underscore + openBracket + " " + closeBracket + backslash);
        System.out.println(" " + slash + "      " + backslash);
        System.out.println("" + slash + underscore + underscore + underscore + underscore + slash +
                backslash + underscore + underscore + backslash);

        System.out.println("\n\n8.Манипуляции с сотнями, десятками и единицами числа");
        int num = 123;
        int hundreds = num / num;
        int tens = (num % 100) / 10;
        int ones = num % 10;
        int sumDigits = hundreds + tens + ones;
        int productDigits = hundreds * tens * ones;
        System.out.println("Число " + num + " содержит:");
        System.out.println("\tсотен - " + hundreds);
        System.out.println("\tдесятков - " + tens);
        System.out.println("\tединиц - " + ones);
        System.out.println("Сумма разрядов = " + sumDigits);
        System.out.println("Произведение разрядов = " + productDigits);

        System.out.println("\n\n9.Перевод секунд в часы, минуты и секунды");
        int allSeconds = 86399;
        int hh = allSeconds / 3600;
        int mm = (allSeconds % 3600) / 60;
        int ss = allSeconds % 60;
        System.out.println(hh + ":" + mm + ":" + ss);

        System.out.println("\n\n10.*Расчет стоимости товара со скидкой");
        var penPrice1 = new BigDecimal("105.50");
        var bookPrice1 = new BigDecimal("235.83");
        var discountPercent1 = new BigDecimal("0.11");
        var basePrice1 = penPrice1.add(bookPrice1);
        var discountSum1 = basePrice1.multiply(discountPercent1).setScale(2, RoundingMode.HALF_UP);
        var discountPrice1 = basePrice1.subtract(discountSum1);
        System.out.println("Стоимость товаров без скидки = " + basePrice1);
        System.out.println("Сумма скидки = " + discountSum1);
        System.out.println("Стоимость товаров со скидкой = " + discountPrice1);
    }
}