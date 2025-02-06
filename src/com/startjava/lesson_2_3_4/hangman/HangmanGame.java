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
    private final char[] secretLetters;
    private final char[] hiddenLetters;
    private char[] wrongLetters = {};
    private int guessedLettersCount = 0;
    private int attempts = 0;

    public HangmanGame(Random random) {
        this.secretLetters = chooseSecretWord(random);
        this.hiddenLetters = createMask(secretLetters.length);
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

    public boolean isPlaying(Scanner scan) {
        displayText(createMenu());
        char letter = Character.toUpperCase(scan.next().charAt(0));
        if (!isCorrectLetter(letter)) return false;
        if (hasSameLetter(letter, secretLetters)) {
            uncoverSecretLetter(letter);
        } else {
            hang(letter);
        }
        return isFinished();
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

    private boolean isCorrectLetter(char letter) {
        if (letter < 'А' || letter > 'Я') {
            displayText("Введите русскую букву!\n");
            return false;
        }
        if (hasSameLetter(letter, hiddenLetters) || hasSameLetter(letter, wrongLetters)) {
            displayText("Такая буква уже была!\n");
            return false;
        }
        return true;
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

    private boolean isFinished() {
        if (!(guessedLettersCount == secretLetters.length || attempts == HANGMAN.length)) return false;
        displayText(guessedLettersCount == secretLetters.length ?
                "\nВы угадали слово - " : "\nВы проиграли!\nСекретное слово - ");
        displayText(makeStr(secretLetters) + "\n");
        return true;
    }
}