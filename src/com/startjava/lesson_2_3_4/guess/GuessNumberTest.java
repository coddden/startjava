package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    private static final int PLAYER_COUNT = 3;
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GuessNumber game = new GuessNumber(createPlayers(scan));

        String response = YES;
        while (!response.equals(NO)) {
            if (response.equals(YES)) game.play(scan);
            System.out.print(response.equals(YES) ?
                    "\nХотите продолжить игру? [yes / no]: " :
                    "\nВведите корректный ответ [yes / no]: ");
            response = scan.next().toLowerCase();
        }
    }

    public static Player[] createPlayers(Scanner scan) {
        Player[] players = new Player[PLAYER_COUNT];
        for (int i = 0; i < PLAYER_COUNT; i++) {
            System.out.printf("Введите имя %d-го игрока: ", i + 1);
            players[i] = new Player(scan.next());
        }
        return players;
    }
}