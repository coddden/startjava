package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String response = "yes";
        while (!response.equals("no")) {
            if (!response.equals("yes")) {
                response = proceed(scan, response);
                continue;
            }
            System.out.print("\nВведите выражение из трех аргументов, например, 2 ^ 10: ");
            String expr = scan.nextLine().replaceAll("\\s+", " ").trim();
            try {
                displayResult(expr, Calculator.calculate(expr));
            } catch (ArithmeticException | IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            response = proceed(scan, response);
        }
    }

    private static void displayResult(String expression, double result) {
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.printf("%s = %s", expression, df.format(result));
    }

    private static String proceed(Scanner scan, String response) {
        System.out.print(response.equals("yes") ?
                "\nХотите продолжить вычисления? [yes / no]: " :
                "\nВведите корректный ответ [yes / no]: ");
        return scan.nextLine().toLowerCase();
    }
}