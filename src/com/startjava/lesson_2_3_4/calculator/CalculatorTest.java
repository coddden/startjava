package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String response = "yes";
        while (!response.equals("no")) {
            if (response.equals("yes")) {
                String expr = inputExpr(scan);
                try {
                    displayResult(expr, Calculator.calculate(expr));
                } catch (ArithmeticException | UnsupportedOperationException |
                        IllegalArgumentException | ExpressionLengthException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.print(response.equals("yes") ?
                    "\nХотите продолжить вычисления? [yes / no]: " :
                    "\nВведите корректный ответ [yes / no]: ");
            response = scan.nextLine().toLowerCase();
        }
    }

    private static String inputExpr(Scanner scan) {
        System.out.print("\nВведите выражение из трех аргументов, например, 2 ^ 10: ");
        return scan.nextLine().trim().replaceAll("\\s+", " ");
    }

    private static void displayResult(String expression, double result) {
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.printf("%s = %s", expression, df.format(result));
    }
}