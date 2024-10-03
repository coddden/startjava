import java.util.Scanner;

public class MyFirstGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int coumputerNum = 49;
        int clientNum = 0;
        System.out.printf("%nПривет! Отгадай число от 1 до 100%n");
        while (clientNum != coumputerNum) {
            clientNum = in.nextInt();
            if (clientNum >= 1 && clientNum <= 100) {
                if (clientNum == coumputerNum) {
                    System.out.println("Вы победили!");
                } else if (clientNum < coumputerNum) {
                    System.out.printf("%n%d меньше того, что загадал компьютер%n", clientNum);
                } else if (clientNum > coumputerNum) {
                    System.out.printf("%n%d больше того, что загадал компьютер%n", clientNum);
                }
            } else {
                System.out.printf("%nЧисло должно быть в диапозоне 1-100%n");
            }
        }
    }
}