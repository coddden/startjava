package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static final int START = 1;
    public static final int END = 100;
    private static final int ROUND_COUNT = 3;
    private final Player[] players;
    private int secretNumber;

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void play(Scanner scan) {
        System.out.printf("%nИгра началась!%nУ каждого игрока по %d попыток в каждом раунде." +
                "%nВсего %d раунда.%n", Player.ATTEMPTS, ROUND_COUNT);
        Random random = new Random();
        shuffle(random);
        clearPoints();
        for (int i = 1; i <= ROUND_COUNT; i++) {
            System.out.printf("%nРаунд № %d%n", i);
            clear();
            generateSecretNumber(random);
            Player currPlayer = players[players.length - 1];
            do {
                currPlayer = changeCurrPlayer(currPlayer);
                System.out.printf("%nПопытка № %d%nЧисло вводит %s: ",
                        currPlayer.getCurrAttempt() + 1, currPlayer.getName());
                while (true) {
                    try {
                        currPlayer.addNumber(scan.nextInt());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.print(e.getMessage());
                    }
                }
            } while (!isGuessed(currPlayer) && hasAttempts(currPlayer));
            displayPlayersNumbers();
        }
        displayWinner();
    }

    private void shuffle(Random random) {
        for (int i = players.length; i > 0; i--) {
            int randomIndex = random.nextInt(i);
            Player temp = players[randomIndex];
            players[randomIndex] = players[players.length - 1];
            players[players.length - 1] = temp;
        }
    }

    private void clearPoints() {
        for (Player player : players) {
            player.clearPoints();
        }
    }

    private void clear() {
        for (Player player : players) {
            player.clear();
        }
    }

    private void generateSecretNumber(Random random) {
        secretNumber = random.nextInt(START, END + 1);
    }

    private Player changeCurrPlayer(Player currPlayer) {
        for (int i = 0; i < players.length; i++) {
            if (currPlayer == players[i] && currPlayer != players[players.length - 1]) {
                return players[i + 1];
            }
        }
        return players[0];
    }
    
    private boolean isGuessed(Player currPlayer) {
        int playerNumber = currPlayer.getNumber();
        if (playerNumber == secretNumber) {
            System.out.printf("%n%s угадал число %d с %d-й попытки%n",
                    currPlayer.getName(), secretNumber, currPlayer.getCurrAttempt());
            currPlayer.addPoint();
            return true;
        }
        String msg = playerNumber > secretNumber ? "больше" : "меньше";
        System.out.printf("%n%d %s того, что загадал компьютер%n", playerNumber, msg);
        return false;
    }

    private boolean hasAttempts(Player currPlayer) {
        if (currPlayer.getCurrAttempt() == Player.ATTEMPTS) {
            System.out.printf("У %s закончились попытки!%n", currPlayer.getName());
        }
        return players[players.length - 1].getCurrAttempt() != Player.ATTEMPTS;
    }

    private void displayPlayersNumbers() {
        for (Player player : players) {
            System.out.printf("%nЧисла %s: %s", player.getName(),
                    Arrays.toString(player.getNumbers()).replaceAll("[^\\d\\s]+", ""));
        }
        System.out.println();
    }

    private void displayWinner() {
        for (Player player : players) {
            boolean isWinner = true;
            boolean isNoWinner = true;
            boolean isDraw = true;
            for (Player player1 : players) {
                if (player == player1) continue;
                if (player.getPoints() <= player1.getPoints()) isWinner = false;
                if (player.getPoints() != 0 || player1.getPoints() != 0) isNoWinner = false;
                if (player.getPoints() != player1.getPoints()) isDraw = false;
            }
            if (isWinner) {
                System.out.printf("%nПобедил %s!%n", player.getName());
                break;
            }
            if (isNoWinner) {
                System.out.printf("%nОбщий проигрыш!%n");
                break;
            }
            if (isDraw) {
                System.out.printf("%nНичья!%n");
                break;
            }
        }

        System.out.println("\nСчёт:");
        for (Player player : players) {
            System.out.printf("%s: %d%n", player.getName(), player.getPoints());
        }
    }
}
