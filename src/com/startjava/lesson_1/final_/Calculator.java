package com.startjava.lesson_1.final_;

public class Calculator {
    public static void main(String[] args) {
        int firstNum = 2;
        int secondNum = 10;
        char mathSign = '^';
        int result = 0;
        boolean isComputed = false;
        if (firstNum > 0 && secondNum > 0) {
            if (mathSign == '+' || mathSign == '-' || mathSign == '*' ||
                    mathSign == '/' || mathSign == '%' || mathSign == '^') {
                isComputed = true;
                if (mathSign == '+') {
                    result = firstNum + secondNum;
                } else if (mathSign == '-') {
                    result = firstNum - secondNum;
                } else if (mathSign == '*') {
                    result = firstNum * secondNum;
                } else if (mathSign == '/') {
                    result = firstNum / secondNum;
                } else if (mathSign == '%') {
                    result = firstNum % secondNum;
                } else if (mathSign == '^') {
                    result = 1;
                    for (int i = 0; i < secondNum; i++) {
                        result *= firstNum;
                    }
                }
            } else {
                System.out.printf("%nНе верный оператор%n");
            }
        } else {
            System.out.printf("%nВыражение содержит не натуральное число%n");
        }
        if (isComputed) {
            System.out.printf("%n%d %c %d = %d%n",
                    firstNum, mathSign, secondNum, result);
        }
    }
}