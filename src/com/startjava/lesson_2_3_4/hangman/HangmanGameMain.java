package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HangmanGame game = new HangmanGame();
        String response = "yes";
        while (response.equals("yes")) {
            game.play(scan);
            String finalMsg = "\nХотите продолжить игру? [yes / no]: ";
            do {
                System.out.print(finalMsg);
                response = scan.next().toLowerCase();
                if (!response.equals("no") && !response.equals("yes")) {
                    finalMsg = "\nВведите корректный ответ [yes / no]: ";
                }
            } while (!response.equals("no") && !response.equals("yes"));
        }
    }
}