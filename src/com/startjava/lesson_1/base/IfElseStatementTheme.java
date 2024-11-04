package com.startjava.lesson_1.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("\n1.Перевод псевдокода на язык Java");
        boolean isMale = false;
        if (!isMale) {
            System.out.println("Объект мужчина");
        } else {
            System.out.println("Объект женщина");
        }
        int age = 19;
        if (age > 18) {
            System.out.println("Совершеннолетний");
        } else {
            System.out.println("Несовершеннолетний");
        }
        double height = 1.9;
        if (height < 1.8) {
            System.out.println("Средний или низкий рост");
        } else {
            System.out.println("Высокий рост");
        }
        char firstNameLetter = "Smith".charAt(0);
        if (firstNameLetter == 'M') {
            System.out.println("Добро пожаловать агент \"М\"!");
        } else if (firstNameLetter == 'I') {
            System.out.println("Добро пожаловать агент \"I\"!");
        } else {
            System.out.println("Тревога! Пароль скомпрометирован!");
        }

        System.out.println("\n2.Поиск большего числа");
        int a = 351624;
        int b = 326598;
        if (a < b) {
            System.out.println(a + " меньше " + b);
        } else if (a > b) {
            System.out.println(a + " больше " + b);
        } else {
            System.out.println("Значения равны!");
        }

        System.out.println("\n3.Проверка числа");
        int num = -123455;
        if (num == 0) {
            System.out.println("Число является нулем");
        } else {
            if (num > 0) {
                System.out.print(num + " является положительным и ");
            } else {
                System.out.print(num + " является отрицательным и ");
            }
            if (num % 2 == 0) {
                System.out.println("четным");
            } else {
                System.out.println("нечетным");
            }
        }

        System.out.println("\n4.Поиск одинаковых цифр в числах");
        int num1 = 123;
        int hundreds1 = num1 / 100;
        int tens1 = num1 % 100 / 10;
        int ones1 = num1 % 10;
        int num2 = 223;
        int hundreds2 = num2 / 100;
        int tens2 = num2 % 100 / 10;
        int ones2 = num2 % 10;
        if (hundreds1 == hundreds2 || tens1 == tens2 || ones1 == ones2) {
            System.out.println("Исходные числа " + num1 + " и " + num2);
            System.out.println("Содержат одинаковые цифры: ");
            if (hundreds1 == hundreds2) {
                System.out.println(hundreds1 + " - 3 разряд"); 
            }
            if (tens1 == tens2) {
                System.out.println(tens1 + " - 2 разряд");
            }
            if (ones1 == ones2) {
                System.out.println(ones1 + " - 1 разряд");
            }
        } else {
            System.out.println("Одинаковых цифр нет");
        }

        System.out.println("\n5.Определение символа по его коду");
        char symbolCode = '\u0057';
        if (symbolCode >= 'A' && symbolCode <= 'Z') {
            System.out.println("'" + symbolCode + "'" + " - большая буква");
        } else if (symbolCode >= 'a' && symbolCode <= 'z') {
            System.out.println("'" + symbolCode + "'" + " - маленькая буква");
        } else if (symbolCode >= '0' && symbolCode <= '9') {
            System.out.println("'" + symbolCode + "'" + " - цифра");
        } else {
            System.out.println("'" + symbolCode + "'" + " - ни буква и ни цифра");
        }

        System.out.println("\n6.Подсчет начисленных банком %");
        double deposit = 321_123.59;
        double interestRate = 0.1;
        if (deposit <= 100_000) {
            interestRate = 0.05;
        } else if (deposit > 100_000 && deposit <= 300_000) {
            interestRate = 0.07;
        }
        double interest = deposit * interestRate;
        System.out.println("Сумма вклада - " + deposit);
        System.out.println("Сумма начисленного % - " + interest);
        System.out.println("Итоговая сумма с % - " + (deposit + interest));

        System.out.println("\n7.Определение оценки по предметам");
        int historyPercent = 59;
        int historyGrade = 5;
        if (historyPercent > 0 && historyPercent <= 60) {
            historyGrade = 2;
        } else if (historyPercent > 60 && historyPercent <= 73) {
            historyGrade = 3;
        } else if (historyPercent > 73 && historyPercent <= 91) {
            historyGrade = 4;
        }
        int programmingPercent = 92;
        int programmingGrade = 5;
        if (programmingPercent > 0 && programmingPercent <= 60) {
            programmingGrade = 2;
        } else if (programmingPercent > 60 && programmingPercent <= 73) {
            programmingGrade = 3;
        } else if (programmingPercent > 73 && programmingPercent <= 91) {
            programmingGrade = 4;
        }
        double averagePercent = (historyPercent + programmingPercent) / 2d;
        double averageGrade = (historyGrade + programmingGrade) / 2d;
        System.out.println("История - " + historyGrade);
        System.out.println("Программирование - " + programmingGrade);
        System.out.println("Средний процент - " + averagePercent);
        System.out.println("Средний балл - " + averageGrade);

        System.out.println("\n8.Расчет годовой прибыли");
        double monthAmountSales = 13025.233;
        double monthRoomRent = 5123.018;
        double monthProductionCost = 9001.729;
        double yearProfit = (monthAmountSales - (monthRoomRent + monthProductionCost)) * 12;
        if (yearProfit <= 0) {
            System.out.println("Прибыль за год " + yearProfit + " руб.");
        } else {
            System.out.println("Прибыль за год +" + yearProfit + " руб.");
        }

        System.out.println("\n9.*Расчет годовой прибыли");
        var monthAmountSales1 = new BigDecimal("13025.233");
        var monthRoomRent1 = new BigDecimal("5123.018");
        var monthProductionCost1 = new BigDecimal("9001.729");
        var yearProfit1 = (monthAmountSales1.subtract(monthRoomRent1.add(monthProductionCost1)))
                .multiply(BigDecimal.valueOf(12)).setScale(2, RoundingMode.HALF_UP);
        if (yearProfit1.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Прибыль за год " + yearProfit1 + " руб.");
        } else {
            System.out.println("Прибыль за год +" + yearProfit1 + " руб.");
        }

        System.out.println("\n10.*Подсчет начисленных банком %");
        var deposit1 = new BigDecimal("321123.59");
        var interestRate1 = new BigDecimal("0.1");
        if (deposit1.compareTo(BigDecimal.valueOf(100000)) <= 0) {
            interestRate1 = new BigDecimal("0.05");
        } else if (deposit1.compareTo(BigDecimal.valueOf(100000)) > 0 &&
                deposit1.compareTo(BigDecimal.valueOf(300000)) <= 0) {
            interestRate1 = new BigDecimal("0.07");
        }
        var interest1 = deposit1.multiply(interestRate1).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Сумма вклада - " + deposit1);
        System.out.println("Сумма начисленного % - " + interest1);
        System.out.println("Итоговая сумма с % - " + (deposit1.add(interest1))
                .setScale(2, RoundingMode.HALF_UP));
    }
}