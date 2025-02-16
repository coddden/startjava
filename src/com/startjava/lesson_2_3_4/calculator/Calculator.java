package com.startjava.lesson_2_3_4.calculator;

import static java.lang.Double.NaN;

public class Calculator {

    private String[] expression;

    public void setExpression(String expression) {
        this.expression = expression.split(" ");
    }
    
    public double calculate() {
        int firstNum = Integer.parseInt(expression[0]);
        int secondNum = Integer.parseInt(expression[2]);
        char mathSign = expression[1].charAt(0);

        double result;
        switch (mathSign) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                if (secondNum != 0) {
                    result = (double) firstNum / secondNum;
                } else {
                    System.out.printf("%nОшибка: деление на ноль запрещено%n");
                    return NaN;
                }
                break;
            case '%':
                result = Math.floorMod(firstNum, secondNum);
                break;
            case '^':
                result = Math.pow(firstNum, secondNum);
                break;
            default:
                System.out.printf("%nОшибка: операция '%s' не поддерживается.%n", mathSign);
                System.out.printf("Доступны следующие операции: +, -, *, /, ^ %n");
                return NaN;
        }
        return result;
    }
}