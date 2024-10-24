import java.lang.Math;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private Scanner scan = new Scanner(System.in);
    private int secretNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        generateSecretNumber();
        changeCurrentPlayer();
        do {
            changeCurrentPlayer();
            makeMove();
        } while (!isGuessed());
    }

    private void generateSecretNumber() {
        secretNumber = 1 + (int) (Math.random() * 100);
    }

    private void changeCurrentPlayer() {
        Player temp = player1;
        player1 = player2;
        player2 = temp;
    }

    private void makeMove() {
        System.out.printf("%nХодит: %s ", player1.getName());
        player1.setNumber(scan.nextInt());
    }

    private boolean isGuessed() {
        boolean isEqual = false;
        if (player1.getNumber() >= 1 && player1.getNumber() <= 100) {
            if (player1.getNumber() < secretNumber) {
                System.out.printf("%n%d меньше того, что загадал компьютер%n",
                        player1.getNumber());
            } else if (player1.getNumber() > secretNumber) {
                System.out.printf("%n%d больше того, что загадал компьютер%n",
                        player1.getNumber());
            } else {
                isEqual = true;
                System.out.printf("%nВыиграл %s!%n", player1.getName());
            }
        } else {
            System.out.printf("%nЧисло должно быть в диапазоне 1-100%n");
        }
        return isEqual;
    }
}
