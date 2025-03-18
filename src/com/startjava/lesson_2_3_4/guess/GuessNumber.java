package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static final int START = 1;
    public static final int END = 100;
    private static final int ROUND_COUNT = 3;
    private static final int PLAYER_COUNT = 3;
    private static final Player[] PLAYERS = new Player[PLAYER_COUNT];
    private int secretNumber;

    public GuessNumber(Player player1, Player player2, Player player3) {
        PLAYERS[0] = player1;
        PLAYERS[1] = player2;
        PLAYERS[2] = player3;
    }

    public void play(Scanner scan) {
        System.out.printf("%nИгра началась!%n" +
                        "У каждого игрока по %d попыток в каждом раунде.%n" +
                        "Всего %d раунда.%n", Player.ATTEMPTS, ROUND_COUNT);
        shuffle();
        clearPoints();
        for (int i = 1; i <= ROUND_COUNT; i++) {
            System.out.printf("%nРаунд № %d%n", i);
            clear();
            generateSecretNumber();
            Player currPlayer = PLAYERS[2];
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

    private static void shuffle() {
        Random random = new Random();
        Player[] playersCopy = Arrays.copyOf(PLAYERS, PLAYERS.length);
        int randomNum;
        int index = 0;

        for (int i = PLAYERS.length; i > 0; i--) {
            randomNum = random.nextInt(i);
            PLAYERS[index++] = playersCopy[randomNum];
            playersCopy[randomNum] = playersCopy[playersCopy.length - 1];
            playersCopy = Arrays.copyOf(playersCopy, playersCopy.length - 1);
        }
    }

    private void clearPoints() {
        for (Player player : PLAYERS) {
            player.clearPoints();
        }
    }

    private void clear() {
        for (Player player : PLAYERS) {
            player.clear();
        }
    }

    private void generateSecretNumber() {
        Random random = new Random();
        secretNumber = random.nextInt(START, END + 1);
    }

    private Player changeCurrPlayer(Player currPlayer) {
        if (currPlayer == PLAYERS[0]) return PLAYERS[1];
        if (currPlayer == PLAYERS[1]) return PLAYERS[2];
        return PLAYERS[0];
    }
    
    private boolean isGuessed(Player currPlayer) {
        int playerNumber = currPlayer.getNumber();
        if (playerNumber == secretNumber) {
            System.out.printf("%n%s угадал число %d с %d-й попытки%n",
                    currPlayer.getName(), secretNumber, currPlayer.getCurrAttempt());
            currPlayer.addPoints();
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
        return PLAYERS[0].getCurrAttempt() != Player.ATTEMPTS ||
                PLAYERS[1].getCurrAttempt() != Player.ATTEMPTS ||
                PLAYERS[2].getCurrAttempt() != Player.ATTEMPTS;
    }

    private void displayPlayersNumbers() {
        for (Player player : PLAYERS) {
            System.out.printf("%nЧисла %s: %s", player.getName(),
                    Arrays.toString(player.getNumbers()).replaceAll("[^\\d\\s]+", ""));
        }
        System.out.println();
    }

    private void displayWinner() {
        int player1Points = PLAYERS[0].getPoints();
        int player2Points = PLAYERS[1].getPoints();
        int player3Points = PLAYERS[2].getPoints();

        if (player1Points > player2Points && player1Points > player3Points) {
            System.out.printf("%nПобедил %s!", PLAYERS[0].getName());
        }
        if (player2Points > player1Points && player2Points > player3Points) {
            System.out.printf("%nПобедил %s!", PLAYERS[1].getName());
        }
        if (player3Points > player1Points && player3Points > player2Points) {
            System.out.printf("%nПобедил %s!", PLAYERS[2].getName());
        }
        if (player1Points == player2Points && player1Points > player3Points) {
            System.out.printf("%n%s и %s делят победу!",
                    PLAYERS[0].getName(), PLAYERS[1].getName());
        }
        if (player1Points == player3Points && player1Points > player2Points) {
            System.out.printf("%n%s и %s делят победу!",
                    PLAYERS[0].getName(), PLAYERS[2].getName());
        }
        if (player2Points == player3Points && player2Points > player1Points) {
            System.out.printf("%n%s и %s делят победу!",
                    PLAYERS[1].getName(), PLAYERS[2].getName());
        }
        if (player1Points == 0 && player2Points == 0 && player3Points == 0) {
            System.out.printf("%nОбщий проигрыш!");
        }
        if (player1Points == player2Points && player2Points == player3Points &&
                player1Points != 0) {
            System.out.printf("%nНичья!");
        }
        System.out.printf("%n%nСчёт:%n%s: %d%n%s: %d%n%s: %d%n",
                PLAYERS[0].getName(), player1Points,
                PLAYERS[1].getName(), player2Points,
                PLAYERS[2].getName(), player3Points);
    }
}
