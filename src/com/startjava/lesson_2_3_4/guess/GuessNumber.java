package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private static final int START = 1;
    private static final int END = 100;
    private static final int PLAYER_COUNT = 2;
    private final Player[] players = new Player[PLAYER_COUNT];
    private int secretNumber;

    public GuessNumber(Player player1, Player player2) {
        players[0] = player1;
        players[1] = player2;
    }

    public static int getStart() {
        return START;
    }

    public static int getEnd() {
        return END;
    }

    public void play(Scanner scan) {
        for (Player player : players) {
            player.setCurrAttempt();
            player.clear();
        }
        Player currPlayer = players[1];
        System.out.printf("%nИгра началась! У каждого игрока по %d попыток%n",
                currPlayer.getAttempts());
        generateSecretNumber();
        do {
            currPlayer = changeCurrPlayer(currPlayer);
            System.out.printf("%nПопытка № %d%nЧисло вводит %s: ",
                    currPlayer.getCurrAttempt(), currPlayer.getName());
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

    private void generateSecretNumber() {
        Random random = new Random();
        secretNumber = random.nextInt(START, END + 1);
    }

    private Player changeCurrPlayer(Player currPlayer) {
        return currPlayer == players[1] ? players[0] : players[1];
    }
    
    private boolean isGuessed(Player currPlayer) {
        int playerNumber = currPlayer.getNumber();
        if (playerNumber == secretNumber) {
            System.out.printf("%n%s угадал число %d с %d-й попытки%n",
                    currPlayer.getName(), secretNumber, currPlayer.getCurrAttempt() - 1);
            return true;
        }
        String msg = playerNumber > secretNumber ? "больше" : "меньше";
        System.out.printf("%n%d %s того, что загадал компьютер%n", playerNumber, msg);
        return false;
    }

    private boolean hasAttempts(Player currPlayer) {
        if (currPlayer.getCurrAttempt() - 1 == currPlayer.getAttempts()) {
            System.out.printf("У %s закончились попытки!%n", currPlayer.getName());
        }
        return players[0].getCurrAttempt() - 1 != players[0].getAttempts() ||
                players[1].getCurrAttempt() - 1 != players[1].getAttempts();
    }

    private void displayPlayersNumbers() {
        for (Player player : players) {
            System.out.printf("%nЧисла %s: %s", player.getName(),
                    Arrays.toString(player.getNumbers()).replaceAll("[^\\d\\s]+", ""));
        }
    }
}
