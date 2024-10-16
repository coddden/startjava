public class Calculator {

    private int firstNum;
    private int secondNum;
    private char mathSign;
    private double result;
    private boolean isShow = true;

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public void setMathSign(char mathSign) {
        this.mathSign = mathSign;
    }

    public void calculate() {
        result = 0;
        isShow = true;
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
                    isShow = false;
                    System.out.printf("%nОшибка: деление на ноль запрещено%n");
                }
                break;
            case '%':
                result = firstNum % secondNum;
                break;
            case '^':
                result = 1;
                if (secondNum < 0) {
                    secondNum *= -1;
                    for (int i = 0; i < secondNum; i++) {
                        result *= firstNum;
                    }
                    result = 1 / result;
                } else {
                    for (int i = 0; i < secondNum; i++) {
                        result *= firstNum;
                    }
                }
                break;
            default:
                isShow = false;
                System.out.printf("%nОшибка: операция '%s' не поддерживается.%n", mathSign);
                System.out.printf("Доступны следующие операции: +, -, *, /, ^ %n");
                break;
        }
        if (isShow) {
            System.out.println("\nОтвет: " + result);
        }
    }
}