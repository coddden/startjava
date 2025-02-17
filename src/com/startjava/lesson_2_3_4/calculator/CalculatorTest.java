package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");
        Calculator calculator = new Calculator();

        String response = "yes";
        while (!response.equals("no")) {
            System.out.print("\nВведите выражение из трех аргументов, например, 2 ^ 10: ");
            String expression = scan.nextLine();
            double result = calculator.calculate(expression);
            if (Double.isNaN(result)) continue;
            displayResult(expression, df, result);
            System.out.print("\nХотите продолжить вычисления? [yes / no]: ");
            response = scan.nextLine().toLowerCase();
            if (!response.equals("yes") && !response.equals("no")) {
                System.out.print("\nВведите корректный ответ [yes / no]: ");
                response = scan.nextLine().toLowerCase();
            }
        }
    }

    private static void displayResult(String expression, DecimalFormat df, double result) {
        System.out.printf("%s = %s", expression, df.format(result));
    }
}