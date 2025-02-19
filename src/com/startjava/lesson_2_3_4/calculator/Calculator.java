package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public double calculate(String expression) {
        String[] expressionParts = expression.split(" ");
        int firstNum = Integer.parseInt(expressionParts[0]);
        int secondNum = Integer.parseInt(expressionParts[2]);
        char mathSign = expressionParts[1].charAt(0);
        switch (mathSign) {
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '*':
                return firstNum * secondNum;
            case '/':
            case '%':
                return division(firstNum, secondNum, mathSign);
            case '^':
                return Math.pow(firstNum, secondNum);
            default:
                System.out.printf("%nОшибка: операция '%s' не поддерживается.%n", mathSign);
                System.out.printf("Доступны следующие операции: +, -, *, /, ^ %n");
                return Double.NaN;
        }
    }

    private double division(int firstNum, int secondNum, char mathSign) {
        if (secondNum == 0) {
            System.out.printf("%nОшибка: деление на ноль запрещено%n");
            return Double.NaN;
        }
        return mathSign == '/' ? (double) firstNum / secondNum : Math.floorMod(firstNum, secondNum);
    }
}