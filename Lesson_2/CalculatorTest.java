import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String response = "";

        while (!response.equals("no")) {
            response = "";
            System.out.print("\nВведите первое число: ");
            calculator.setFirstNum(scan.nextLong());
            System.out.print("\nВведите знак операции (+, -, *, /, ^, %): ");
            calculator.setMathSign(scan.next().charAt(0));
            System.out.print("\nВведите второе число: ");
            calculator.setSecondNum(scan.nextLong());
            calculator.calculate();

            while (!(response.equals("no") || response.equals("yes"))) {
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
                response = scan.next();
            }
        }
    }
}