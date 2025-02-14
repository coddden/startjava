package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    private static final String[] hangman = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private static final String[] words = {"КЛАСС", "ОБЪЕКТ", "ЦИКЛ", "ДАННЫЕ", "МЕТОД"};
    private char[] secretWord;
    private char[] mask;
    private char[] wrongLetters;
    private int attempts;

    public void play(Scanner scan) {
        Random random = new Random();
        secretWord = chooseSecretWord(random);
        mask = createMask(secretWord.length);
        wrongLetters = new char[33 - secretWord.length];
        attempts = hangman.length;
        int index = 0;
        char letter;
        while (!Arrays.equals(mask, secretWord) && attempts > 0) {
            do {
                displayText(createGameInfo());
                letter = Character.toUpperCase(scan.next().charAt(0));
            } while (isWrongLetter(letter));
            if (hasSameLetter(letter, secretWord)) {
                uncoverSecretLetter(letter);
            } else {
                attempts--;
                wrongLetters[index++] = letter;
                hang();
            }
        }
        displayText(attempts == 0 ? "\nВы проиграли!\nСекретное слово - " : "\nВы угадали слово - ");
        displayText(makeStr(secretWord) + "\n");
    }

    private char[] chooseSecretWord(Random random) {
        int randomNum = random.nextInt(words.length);
        return words[randomNum].toCharArray();
    }

    private char[] createMask(int len) {
        char[] array = new char[len];
        Arrays.fill(array, '*');
        return array;
    }

    private String createGameInfo() {
        return "\n" + makeStr(mask) +
                "\n" + "Попыток: " + attempts +
                "\n" + "Ошибки: " + makeStr(wrongLetters) +
                "\n" + "Ваша буква -> ";
    }

    private boolean isWrongLetter(char letter) {
        if (letter < 'А' || letter > 'Я') {
            displayText("Введите русскую букву!\n");
            return true;
        }
        if (hasSameLetter(letter, mask) || hasSameLetter(letter, wrongLetters)) {
            displayText("Такая буква уже была!\n");
            return true;
        }
        return false;
    }

    private void uncoverSecretLetter(char letter) {
        for (int i = 0; i < secretWord.length; i++) {
            if (letter == secretWord[i]) {
                if (!hasSameLetter(letter, mask) && attempts < hangman.length) {
                    attempts++;
                }
                mask[i] = letter;
            }
        }
    }

    private boolean hasSameLetter(char letter, char[] array) {
        for (char item : array) {
            if (item == letter) return true;
        }
        return false;
    }

    private void hang() {
        for (int i = 0; i < hangman.length - attempts; i++) {
            displayText("\n" + hangman[i]);
        }
        displayText("\n");
    }

    private void displayText(String text) {
        System.out.print(text);
    }

    private String makeStr(char[] array) {
        return Arrays.toString(array).replaceAll("[\\[\\],\\u0000]", "");
    }
}