package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private static final int EXPR_SIZE = 3;

    private Calculator() {}

    public static double calculate(String expr) {
        String[] exprParts = expr.split(" ");
        checkExpr(exprParts);
        int firstNum = Integer.parseInt(exprParts[0]);
        int secondNum = Integer.parseInt(exprParts[2]);
        char mathSign = exprParts[1].charAt(0);

        return switch (mathSign) {
            case '+' -> firstNum + secondNum;
            case '-' -> firstNum - secondNum;
            case '*' -> firstNum * secondNum;
            case '/', '%' -> division(firstNum, secondNum, mathSign);
            case '^' -> Math.pow(firstNum, secondNum);
            default -> throw new IllegalStateException(
                    "\nОшибка: операция " + mathSign + " не поддерживается." +
                    "\nДоступны следующие операции: +, -, *, /, ^");
        };
    }

    private static void checkExpr(String[] array) {
        if (array.length != EXPR_SIZE) {
            throw new ExpressionLengthException("\nОшибка: неверное количество аргументов.");
        }
        if (!array[0].matches("-?\\d+") || !array[2].matches("-?\\d+")) {
            throw new NumberFormatException("\nОшибка: вводимые числа должны быть целыми.");
        }
        if (array[1].length() != 1) {
            throw new IllegalStateException("\nОшибка: операция " + array[1] + " не поддерживается." +
                    "\nДоступны следующие операции: +, -, *, /, ^");
        }
    }

    private static double division(int firstNum, int secondNum, char mathSign) {
        if (secondNum == 0) {
            throw new ArithmeticException("\nОшибка: деление на ноль запрещено.");
        }
        return mathSign == '/' ? (double) firstNum / secondNum : Math.floorMod(firstNum, secondNum);
    }
}