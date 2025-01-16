package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private long firstNum;
    private long secondNum;
    private char mathSign;

    public void setFirstNum(long firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(long secondNum) {
        this.secondNum = secondNum;
    }

    public void setMathSign(char mathSign) {
        this.mathSign = mathSign;
    }

    public void calculate() {
        double result = 0;
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
                    return;
                }
                break;
            case '%':
                result = firstNum % secondNum;
                break;
            case '^':
                result = 1;
                for (int i = 0; i < Math.abs(secondNum); i++) {
                    result *= firstNum;
                }
                result = secondNum < 0 ? 1 / result : result;
                break;
            default:
                System.out.printf("%nОшибка: операция '%s' не поддерживается.%n", mathSign);
                System.out.printf("Доступны следующие операции: +, -, *, /, ^ %n");
                return;
        }
        System.out.println("\nОтвет: " + result);
    }
}