import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("\n\n1.Вывод характеристик компьютера");
        byte cores = 12;
        short ram = 16;
        int ssd = 512;
        long ramFrequency = 3200L;
        float processorFrequency = 2.5F;
        double display = 15.6D;
        char gen = 'X';
        boolean touchScreen = false;
        System.out.println("Количество ядер - " + cores);
        System.out.println("Объем оперативной памяти - " + ram);
        System.out.println("Объем физической памяти - " + ssd);
        System.out.println("Частота оперативной памяти - " + ramFrequency);
        System.out.println("Частота процессора - " + processorFrequency);
        System.out.println("Диагональ экрана - " + display);
        System.out.println("Поколение - " + gen);
        System.out.println("Сенсорный экран - " + touchScreen);

        System.out.println("\n\n2.Расчет стоимости товара со скидкой");
        double penPrice = 105.50;
        double bookPrice = 235.83;
        double discountPercent = 0.11;
        double allGoodsPrice = penPrice + bookPrice;
        double discount = allGoodsPrice * discountPercent;
        double discountGoods = allGoodsPrice - discount;
        System.out.println("Стоимость товаров без скидки = " + allGoodsPrice);
        System.out.println("Сумма скидки = " + discount);
        System.out.println("Стоимость товаров со скидкой = " + discountGoods);

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
        System.out.println("byte " + byteMax++); // 127
        System.out.println("byte++ " + byteMax--); // -128
        System.out.println("byte-- " + --byteMax + "\n"); // 126
        System.out.println("short " + shortMax++);
        System.out.println("short++ " + shortMax--);
        System.out.println("short-- " + --shortMax + "\n");
        System.out.println("int " + intMax++);
        System.out.println("int++ " + intMax--);
        System.out.println("int-- " + --intMax + "\n");
        System.out.println("long " + longMax++);
        System.out.println("long++ " + longMax--);
        System.out.println("long-- " + --longMax);

        System.out.println("\n\n5.Перестановка значений переменных");
        int two = 2;
        int five = 5;
        System.out.println("Исходные значения:\n" + "Два " + two + "\nПять " + five);
        int change = two;
        two = five;
        five = change;
        System.out.println("\nС помощью третьей переменной:\n" + "Два " + two + "\nПять " + five);
        int difference = five - two;
        two += difference;
        five -= difference;
        System.out.println("\nС помощью арифметических операций:\n" +
                "Два " + two + "\nПять " + five);
        int seven = two ^ five;
        two = seven ^ two;
        five = seven ^ five;
        System.out.println("\nС помощью побитовой операции ^:\n" + "Два " + two + "\nПять " + five);

        System.out.println("\n\n6.Вывод символов и их кодов");
        int intDollar = 36;
        int intAsterisk = 42;
        int intAtSign = 64;
        int intVerticalBar = 124;
        int intTilde = 126;
        char charDollar = '$';
        char charAsterisk = '*';
        char charAtSign = '@';
        char charVerticalBar = '|';
        char charTilde = '~';
        System.out.println(intDollar + " " + charDollar);
        System.out.println(intAsterisk + " " + charAsterisk);
        System.out.println(intAtSign + " " + charAtSign);
        System.out.println(intVerticalBar + " " + charVerticalBar);
        System.out.println(intTilde + " " + charTilde);

        System.out.println("\n\n7.Вывод в консоль ASCII-арт Дюка");
        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        char openBracket = '(';
        char closeBracket = ')';
        System.out.println("    " + slash + backslash);
        System.out.println("   " + slash + " " + " " + backslash);
        System.out.println("  " + slash + underscore + openBracket + " " + closeBracket + backslash);
        System.out.println(" " + slash + " " + " " + " " + " " + " " + " " + backslash);
        System.out.println("" + slash + underscore + underscore + underscore + underscore + slash +
                backslash + underscore + underscore + backslash);

        System.out.println("\n\n8.Манипуляции с сотнями, десятками и единицами числа");
        int num = 123;
        int hundreds = num / num;
        int dozens = (num % 100) / 10;
        int units = (num % 100) % 20;
        int sumDigits = hundreds + dozens + units;
        int multiplyDigits = hundreds * dozens * units;
        System.out.println("Число " + num + " содержит:");
        System.out.println("\tсотен - " + hundreds);
        System.out.println("\tдесятков - " + dozens);
        System.out.println("\tединиц - " + units);
        System.out.println("Сумма разрядов = " + sumDigits);
        System.out.println("Произведение разрядов = " + multiplyDigits);

        System.out.println("\n\n9.Перевод секунд в часы, минуты и секунды");
        int allSeconds = 86399;
        int hours = allSeconds / 3600;
        int minutes = (allSeconds % 3600) / 60;
        int seconds = (allSeconds % 3600) % 60;
        System.out.println(hours + ":" + minutes + ":" + seconds);

        System.out.println("\n\n10.*Расчет стоимости товара со скидкой");
        var penCost = new BigDecimal("105.50");
        var bookCost = new BigDecimal("235.83");
        var percent = new BigDecimal("0.11");
        var total = penCost.add(bookCost);
        var bonus = total.multiply(percent).setScale(2, RoundingMode.HALF_UP);
        var promotionGoods = total.subtract(bonus);
        System.out.println("Стоимость товаров без скидки = " + total);
        System.out.println("Сумма скидки = " + bonus);
        System.out.println("Стоимость товаров со скидкой = " + promotionGoods);
    }
}