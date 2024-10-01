public class Calculator {
    public static void main(String[] args) {
        int clientFirstNum = 2;
        int clientSecondNum = 10;
        char clientMathSymbol = '^';
        int answer = 0;
        boolean isComputed = false;
        if (clientFirstNum >= 0 && clientSecondNum >= 0) {
            if (clientMathSymbol == '+' || clientMathSymbol == '-' || clientMathSymbol == '*' ||
                    clientMathSymbol == '/' || clientMathSymbol == '%' || clientMathSymbol == '^') {
                isComputed = true;
                if (clientMathSymbol == '+') {
                    answer = clientFirstNum + clientSecondNum;
                } else if (clientMathSymbol == '-') {
                    if (clientFirstNum >= clientSecondNum) {
                        answer = clientFirstNum - clientSecondNum;
                    } else {
                        isComputed = false;
                        System.out.printf("%nПервый операнд должен быть больше второго%n");
                    }
                } else if (clientMathSymbol == '*') {
                    answer = clientFirstNum * clientSecondNum;
                } else if (clientMathSymbol == '/') {
                    if (clientFirstNum % clientSecondNum == 0) {
                        answer = clientFirstNum / clientSecondNum;
                    } else {
                        isComputed = false;
                        System.out.printf("%nКалькулятор работает только с натуральными числами%n");
                    }
                } else if (clientMathSymbol == '%') {
                    if (clientFirstNum > clientSecondNum) {
                        answer = clientFirstNum % clientSecondNum;
                    } else {
                        isComputed = false;
                        System.out.printf("%nПервый операнд должен быть больше второго%n");
                    }
                } else if (clientMathSymbol == '^') {
                    answer = 1;
                    for (int i = 0; i < clientSecondNum; i++) {
                        answer *= clientFirstNum;
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
                    clientFirstNum, clientMathSymbol, clientSecondNum, answer);
        }
    }
}