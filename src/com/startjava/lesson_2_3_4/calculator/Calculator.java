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
                if (isZero(secondNum)) return Double.NaN;
                return (double) firstNum / secondNum;
            case '%':
                if (isZero(secondNum)) return Double.NaN;
                return Math.floorMod(firstNum, secondNum);
            case '^':
                return Math.pow(firstNum, secondNum);
            default:
                System.out.printf("%nОшибка: операция '%s' не поддерживается.%n", mathSign);
                System.out.printf("Доступны следующие операции: +, -, *, /, ^ %n");
                return Double.NaN;
        }
    }

    private boolean isZero(int num) {
        if (num == 0) {
            System.out.printf("%nОшибка: деление на ноль запрещено%n");
            return true;
        }
        return false;
    }
}