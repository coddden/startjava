package com.startjava.lesson_2_3_4.calculator;

import com.startjava.lesson_2_3_4.calculator.exception.ExpressionLengthException;

public class Calculator {

    private static final int EXPR_SIZE = 3;

    private Calculator() {}

    public static double calculate(String expr) {
        String[] exprParts = expr.split(" ");
        if (exprParts.length != EXPR_SIZE) {
            throw new ExpressionLengthException("\nОшибка: неверное количество аргументов.");
        }
        int firstNum;
        int secondNum;
        try {
            firstNum = Integer.parseInt(exprParts[0]);
            secondNum = Integer.parseInt(exprParts[2]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("\nОшибка: вводимые числа должны быть целыми!");
        }
        String mathSign = exprParts[1];

        return switch (mathSign) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            case "/", "%" -> division(firstNum, secondNum, mathSign);
            case "^" -> Math.pow(firstNum, secondNum);
            default -> throw new UnsupportedOperationException(
                    "\nОшибка: операция " + mathSign + " не поддерживается." +
                    "\nДоступны следующие операции: +, -, *, /, %, ^");
        };
    }

    private static double division(int firstNum, int secondNum, String mathSign) {
        if (secondNum == 0) {
            throw new ArithmeticException("\nОшибка: деление на ноль запрещено.");
        }
        return mathSign.equals("/") ? (double) firstNum / secondNum : Math.floorMod(firstNum, secondNum);
    }
}