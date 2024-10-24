import java.lang.Math;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int secretNum;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    Scanner scan = new Scanner(System.in);
    Player currentPlayer = player2;

    public void play() {
        changeSecretNumber();
        do {
            changeCurrentPlayer();
            makeMove();
            checkNumber();
        } while (secretNum != currentPlayer.getNumber());
        System.out.printf("%nВыиграл %s!%n", currentPlayer.getName());
    }

    private void changeSecretNumber() {
        secretNum = 1 + (int) (Math.random() * 100);
    }

    private void changeCurrentPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    private void makeMove() {
        System.out.printf("%nХодит: %s ", currentPlayer.getName());
        currentPlayer.setNumber(scan.nextInt());
    }

    private void checkNumber() {
        if (currentPlayer.getNumber() >= 1 && currentPlayer.getNumber() <= 100) {
            if (currentPlayer.getNumber() < secretNum) {
                System.out.printf("%n%d меньше того, что загадал компьютер%n",
                        currentPlayer.getNumber());
            } else if (currentPlayer.getNumber() > secretNum) {
                System.out.printf("%n%d больше того, что загадал компьютер%n",
                        currentPlayer.getNumber());
            }
        } else {
            System.out.printf("%nЧисло должно быть в диапазоне 1-100%n");
        }
    }
}
