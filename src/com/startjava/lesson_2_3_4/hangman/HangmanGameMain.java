package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HangmanGame game = new HangmanGame();
        String response = "yes";
        while (!response.equals("no")) {
            if (response.equals("yes")) game.play(scan);
            System.out.print(response.equals("yes") ?
                    "\nХотите продолжить игру? [yes / no]: " :
                    "\nВведите корректный ответ [yes / no]: ");
            response = scan.next().toLowerCase();
        }
    }
}