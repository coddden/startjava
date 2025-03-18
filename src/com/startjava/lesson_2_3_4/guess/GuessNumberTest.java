package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {

    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nВведите имя первого игрока: ");
        Player player1 = new Player(scan.next());
        System.out.print("Введите имя второго игрока: ");
        Player player2 = new Player(scan.next());
        System.out.print("Введите имя третьего игрока: ");
        Player player3 = new Player(scan.next());
        GuessNumber game = new GuessNumber(player1, player2, player3);

        String response = YES;
        while (!response.equals(NO)) {
            if (response.equals(YES)) game.play(scan);
            System.out.print(response.equals(YES) ?
                    "\n\nХотите продолжить игру? [yes / no]: " :
                    "\nВведите корректный ответ [yes / no]: ");
            response = scan.next().toLowerCase();
        }
    }
}