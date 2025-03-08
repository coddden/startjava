package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private final Player[] players = new Player[2];
    public static final int START = 1;
    public static final int END = 100;
    private int secretNumber;

    public GuessNumber(Player player1, Player player2) {
        this.players[0] = player1;
        this.players[1] = player2;
    }

    public void play(Scanner scan) {
        for (Player player : players) {
            player.setAttempts();
            player.setCurrentAttempt();
            player.setNumbers();
        }
        Player currentPlayer = players[1];
        System.out.printf("%nИгра началась! У каждого игрока по %d попыток%n",
                currentPlayer.getAttempts());
        generateSecretNumber();
        do {
            currentPlayer = changeCurrentPlayer(currentPlayer);
            while (true) {
                System.out.printf("%nПопытка № %d%nЧисло вводит %s: ",
                        currentPlayer.getCurrentAttempt(), currentPlayer.getName());
                try {
                    currentPlayer.setNumber(scan.nextInt());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("\n" + e.getMessage());
                }
            }
        } while (!isFinished(currentPlayer));
        displayPlayersNumbers();
    }

    private void generateSecretNumber() {
        Random random = new Random();
        secretNumber = random.nextInt(START, END + 1);
    }

    private Player changeCurrentPlayer(Player currentPlayer) {
        return currentPlayer == players[1] ? players[0] : players[1];
    }
    
    private boolean isFinished(Player currentPlayer) {
        int playerNumber = currentPlayer.getNumber();
        if (players[0].getAttempts() == 0 && players[1].getAttempts() == 0) {
            System.out.println("\nУ всех игроков закончились попытки!\nИгра окончена!");
            return true;
        }
        if (playerNumber == secretNumber) {
            System.out.printf("%n%s угадал число %d с %d-й попытки%n",
                    currentPlayer.getName(), secretNumber, currentPlayer.getCurrentAttempt() - 1);
            return true;
        }
        String msg = playerNumber > secretNumber ? "больше" : "меньше";
        System.out.printf("%n%d %s того, что загадал компьютер%n", playerNumber, msg);
        if (currentPlayer.getAttempts() == 0) {
            System.out.printf("У %s закончились попытки!%n", currentPlayer.getName());
        }
        return false;
    }

    private void displayPlayersNumbers() {
        for (Player player : players) {
            System.out.printf("%nЧисла %s: %s", player.getName(),
                    Arrays.toString(player.getNumbers()).replaceAll("[^\\d\\s]+", ""));
        }
    }
}
