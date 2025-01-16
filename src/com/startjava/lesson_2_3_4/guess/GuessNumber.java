package com.startjava.lesson_2_3_4.guess;

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
        return currentPlayer == player2 ? player1 : player2;
    }

    private void makeMove(Player currentPlayer, Scanner scan) {
        System.out.printf("%nХодит: %s ", currentPlayer.getName());
        currentPlayer.setNumber(scan.nextInt());
    }
    
    private boolean isGuessed(Player currentPlayer) {
        int playerNumber = currentPlayer.getNumber();
        if (playerNumber > 0 && playerNumber < 101) {
            if (playerNumber == secretNumber) {
                System.out.printf("%nВыиграл %s!%n", currentPlayer.getName());
                return true;
            }
            String greaterOrLess = "меньше";
            if (playerNumber > secretNumber) {
                greaterOrLess = "больше";
            }
            System.out.printf("%n%d %s того, что загадал компьютер%n", playerNumber, greaterOrLess);
            return false;
        }
        System.out.printf("%nЧисло должно быть в диапазоне 1-100%n");
        return false;
    }
}
