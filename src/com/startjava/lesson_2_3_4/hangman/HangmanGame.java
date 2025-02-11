package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    private static final String[] HANGMAN = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private static final String[] WORDS = {"КЛАСС", "ОБЪЕКТ", "ЦИКЛ", "ДАННЫЕ", "МЕТОД"};
    private char[] secretLetters;
    private char[] hiddenLetters;
    private char[] wrongLetters;
    private int guessedLettersCount;
    private int attempts;

    Random random = new Random();

    public void play(Scanner scan) {
        secretLetters = chooseSecretWord(random);
        hiddenLetters = createMask(secretLetters.length);
        wrongLetters = new char[0];
        guessedLettersCount = 0;
        attempts = 0;
        char letter;
        while (guessedLettersCount != secretLetters.length && attempts != HANGMAN.length) {
            do {
                displayText(createMenu());
                letter = Character.toUpperCase(scan.next().charAt(0));
            } while (isWrongLetter(letter));
            if (hasSameLetter(letter, secretLetters)) {
                uncoverSecretLetter(letter);
            } else {
                hang(letter);
            }
        }
        displayText(guessedLettersCount == secretLetters.length ?
                "\nВы угадали слово - " : "\nВы проиграли!\nСекретное слово - ");
        displayText(makeStr(secretLetters) + "\n");
    }

    private char[] chooseSecretWord(Random random) {
        int randomNum = random.nextInt(0, WORDS.length);
        return WORDS[randomNum].toCharArray();
    }

    private char[] createMask(int len) {
        char[] array = new char[len];
        Arrays.fill(array, '*');
        return array;
    }

    private void displayText(String text) {
        System.out.print(text);
    }

    private String createMenu() {
        return "\n" + makeStr(hiddenLetters) +
                "\n" + "Попыток: " + (HANGMAN.length - attempts) +
                "\n" + "Ошибки: " + makeStr(wrongLetters) +
                "\n" + "Ваша буква -> ";
    }

    private String makeStr(char[] array) {
        return Arrays.toString(array).replaceAll("[\\[\\],]", "");
    }

    private boolean isWrongLetter(char letter) {
        if (letter < 'А' || letter > 'Я') {
            displayText("Введите русскую букву!\n");
            return true;
        }
        if (hasSameLetter(letter, hiddenLetters) || hasSameLetter(letter, wrongLetters)) {
            displayText("Такая буква уже была!\n");
            return true;
        }
        return false;
    }

    private boolean hasSameLetter(char letter, char[] array) {
        for (char item : array) {
            if (item == letter) return true;
        }
        return false;
    }

    private void uncoverSecretLetter(char letter) {
        for (int i = 0; i < secretLetters.length; i++) {
            if (letter == secretLetters[i]) {
                if (!hasSameLetter(letter, hiddenLetters) && attempts > 0) attempts--;
                hiddenLetters[i] = letter;
                guessedLettersCount++;
            }
        }
    }

    private void hang(char letter) {
        attempts++;
        wrongLetters = Arrays.copyOf(wrongLetters, wrongLetters.length + 1);
        wrongLetters[wrongLetters.length - 1] = letter;
        for (int i = 0; i < attempts; i++) {
            displayText("\n" + HANGMAN[i]);
        }
        displayText("\n");
    }
}