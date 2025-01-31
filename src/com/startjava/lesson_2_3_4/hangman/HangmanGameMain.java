package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        HangmanGame game = new HangmanGame(random);

        String msg = "yes";
        while (game.getAttempts() < game.getHangman().length && msg.equals("yes")) {
            System.out.println();
            displayArray(game.getHiddenLetters());
            System.out.printf("%nПопыток: %d", game.getHangman().length - game.getAttempts());
            System.out.printf("%nОшибки: ");
            displayArray(game.getWrongLetters());
            System.out.printf("%nВаша буква -> ");
            char letter = Character.toUpperCase(scan.next().charAt(0));

            if (!isCorrectLetter(game, letter)) {
                System.out.print(letter < 'А' || letter > 'Я' ?
                        "Введите русскую букву!\n" :
                        "Такая буква уже была!\n");
                continue;
            }

            if (game.hasSameLetter(letter, game.getSecretLetters())) {
                game.revealLetter(letter);
            } else {
                game.hang(letter);
            }

            if (game.getGuessedLettersCount() == game.getSecretLetters().length ||
                    game.getAttempts() == game.getHangman().length) {
                System.out.printf(game.getGuessedLettersCount() == game.getSecretLetters().length ?
                        "%nВы угадали слово - " : "%n%nВы проиграли!%nСекретное слово - ");
                displayArray(game.getSecretLetters());
                System.out.println();

                game.setSecretLetters(random);
                game.setHiddenLetters();
                game.setWrongLetters();
                game.setGuessedLettersCount();
                game.setAttempts();

                String finalMsg = "Хотите продолжить игру? [yes / no]: ";
                do {
                    System.out.printf("%n%s", finalMsg);
                    msg = scan.next().toLowerCase();
                    if (!(msg.equals("no") || msg.equals("yes"))) {
                        finalMsg = "Введите корректный ответ [yes / no]: ";
                    }
                } while (!(msg.equals("no") || msg.equals("yes")));
            }
        }
    }

    private static void displayArray(char[] array) {
        System.out.printf("%s", Arrays.toString(array).replaceAll("[\\[\\],]", ""));
    }

    private static boolean isCorrectLetter(HangmanGame game, char letter) {
        if (letter < 'А' || letter > 'Я') return false;
        if (game.hasSameLetter(letter, game.getHiddenLetters())) return false;
        return !game.hasSameLetter(letter, game.getWrongLetters());
    }
}