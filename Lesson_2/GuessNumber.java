import java.lang.Math;
import java.util.Scanner;

public class GuessNumber {

    private int computerNumber;
    private Player player1;
    private Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void changeComputerNumber() {
        computerNumber = 1 + (int) (Math.random() * 100);
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        changeComputerNumber();
        Player currentPlayer = player2;
        do {
            currentPlayer = currentPlayer == player1 ? player2 : player1;
            System.out.printf("%nХодит: %s ", currentPlayer.getName());
            currentPlayer.setNumber(scan.nextInt());
            if (currentPlayer.getNumber() >= 1 && currentPlayer.getNumber() <= 100) {
                if (currentPlayer.getNumber() < computerNumber) {
                    System.out.printf("%n%d меньше того, что загадал компьютер%n",
                            currentPlayer.getNumber());
                } else if (currentPlayer.getNumber() > computerNumber) {
                    System.out.printf("%n%d больше того, что загадал компьютер%n",
                            currentPlayer.getNumber());
                }
            } else {
                System.out.printf("%nЧисло должно быть в диапазоне 1-100%n");
            }
        } while (computerNumber != currentPlayer.getNumber());
        System.out.printf("%nВыиграл %s!%n", currentPlayer.getName());
        return;
    }
}


