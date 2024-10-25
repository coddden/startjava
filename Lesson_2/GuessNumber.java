import java.lang.Math;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int secretNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        Player currentPlayer = player2;
        generateSecretNumber();
        do {
            currentPlayer = changeCurrentPlayer(currentPlayer);
            makeMove(currentPlayer, scan);
        } while (!isGuessed(currentPlayer));
    }

    private void generateSecretNumber() {
        secretNumber = 1 + (int) (Math.random() * 100);
    }

    private Player changeCurrentPlayer(Player currentPlayer) {
        return currentPlayer = currentPlayer == player2 ? player1 : player2;
    }

    private void makeMove(Player currentPlayer, Scanner scan) {
        System.out.printf("%nХодит: %s ", currentPlayer.getName());
        currentPlayer.setNumber(scan.nextInt());
    }

    private boolean isGuessed(Player currentPlayer) {
        if (currentPlayer.getNumber() >= 1 && currentPlayer.getNumber() <= 100) {
            if (currentPlayer.getNumber() < secretNumber) {
                System.out.printf("%n%d меньше того, что загадал компьютер%n",
                        currentPlayer.getNumber());
                return false;
            } else if (currentPlayer.getNumber() > secretNumber) {
                System.out.printf("%n%d больше того, что загадал компьютер%n",
                        currentPlayer.getNumber());
                return false;
            }
            System.out.printf("%nВыиграл %s!%n", currentPlayer.getName());
            return true;
        }
        System.out.printf("%nЧисло должно быть в диапазоне 1-100%n");
        return false;
    }
}
