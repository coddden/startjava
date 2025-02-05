package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        HangmanGame game = new HangmanGame(random);
        String msg = "yes";
        while (msg.equals("yes")) {
            game.displayMenu();
            char letter = Character.toUpperCase(scan.next().charAt(0));
            if (!game.isCorrectLetter(letter)) continue;
            game.play(letter);
            if (!game.isFinish()) continue;
            String finalMsg = "Хотите продолжить игру? [yes / no]: ";
            do {
                System.out.printf("%n%s", finalMsg);
                msg = scan.next().toLowerCase();
                if (msg.equals("yes")) game.initialize(random);
                if (!(msg.equals("no") || msg.equals("yes"))) {
                    finalMsg = "Введите корректный ответ [yes / no]: ";
                }
            } while (!(msg.equals("no") || msg.equals("yes")));
        }
    }
}