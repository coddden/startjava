package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("%nВведите имя первого игрока: ");
        Player player1 = new Player(scan.next());
        System.out.printf("%nВведите имя второго игрока: ");
        Player player2 = new Player(scan.next());
        GuessNumber game = new GuessNumber(player1, player2);

        String response = "yes";
        while (response.equals("yes")) {
            game.play();
            do {
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
                response = scan.next();
            } while (!(response.equals("no") || response.equals("yes")));
        }
    }
}