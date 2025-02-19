package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HangmanGame game = new HangmanGame();
        String response = "yes";
        while (!response.equals("no")) {
            if (!response.equals("yes")) {
                response = proceed(scan, response);
                continue;
            }
            game.play(scan);
            response = proceed(scan, response);
        }
    }

    private static String proceed(Scanner scan, String response) {
        System.out.print(response.equals("yes") ?
                "\nХотите продолжить игру? [yes / no]: " :
                "\nВведите корректный ответ [yes / no]: ");
        return scan.next().toLowerCase();
    }
}