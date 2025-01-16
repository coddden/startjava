package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        String[] hangman = {
                "_______",
                "|     |",
                "|     @",
                "|    /|\\",
                "|    / \\",
                "| GAME OVER!"
        };
        int attempts = hangman.length;

        String secretWord = chooseRandomWord();
        char[] guessedWord = new char[secretWord.length()];

        int turnNum = 1;
        boolean isGuesed = false;
        int guessedLettersCount = 0;

        Scanner scan = new Scanner(System.in);
        while (turnNum <= attempts && !isGuesed) {
            Arrays.fill(guessedWord, '*');
            String mask = Arrays.toString(guessedWord).replaceAll("[\\[\\],]", "");
            System.out.printf("%n%s%n", mask);
            char letter = scan.next().charAt(0);
            boolean hasMatch = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (letter == secretWord.charAt(i)) {
                    hasMatch = true;
                    break;
                }
            }
            if (hasMatch) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (letter == secretWord.charAt(i)) {
                        guessedLettersCount++;
                        guessedWord[i] = letter;
                    }
                }
            } else {
                for (int i = 0; i < turnNum; i++) {
                    System.out.println(hangman[i]);
                }
                turnNum++;
            }
            if (guessedLettersCount == secretWord.length()) {
                isGuesed = true;
            }
        }
        System.out.println("Хотите продолжить?");
    }

    private static String chooseRandomWord() {
        String[] randomWords = {"цикл", "класс", "объект", "метод", "переменная", "инкапсуляция"};
        Random random = new Random();
        int randomNum = random.nextInt(0, randomWords.length);
        return randomWords[randomNum];
    }
}
