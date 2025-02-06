package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        HangmanGame game = new HangmanGame(random);

        String response = "yes";
        while (response.equals("yes")) {
            if (!game.isPlaying(scan)) continue;
            String finalMsg = "\nХотите продолжить игру? [yes / no]: ";
            do {
                System.out.print(finalMsg);
                response = scan.next().toLowerCase();
                if (response.equals("yes")) game = new HangmanGame(random);
                if (!response.equals("no") && !response.equals("yes")) {
                    finalMsg = "\nВведите корректный ответ [yes / no]: ";
                }
            } while (!response.equals("no") && !response.equals("yes"));
        }
    }
}