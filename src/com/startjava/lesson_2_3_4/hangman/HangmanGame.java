package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;

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
    private char[] wrongLetters = {};
    private int guessedLettersCount = 0;
    private int attempts = 0;

    public HangmanGame(Random random) {
        this.secretLetters = chooseSecretLetters(random);
        this.hiddenLetters = fill(secretLetters.length);
    }

    public String[] getHangman() {
        return HANGMAN;
    }

    public char[] getSecretLetters() {
        return secretLetters;
    }

    public void setSecretLetters(Random random) {
        this.secretLetters = chooseSecretLetters(random);
    }

    public char[] getHiddenLetters() {
        return hiddenLetters;
    }

    public void setHiddenLetters() {
        this.hiddenLetters = fill(secretLetters.length);
    }

    public char[] getWrongLetters() {
        return wrongLetters;
    }

    public void setWrongLetters() {
        this.wrongLetters = new char[0];
    }

    public int getGuessedLettersCount() {
        return guessedLettersCount;
    }

    public void setGuessedLettersCount() {
        this.guessedLettersCount = 0;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts() {
        this.attempts = 0;
    }

    public boolean hasSameLetter(char letter, char[] array) {
        for (char item : array) {
            if (item == letter) return true;
        }
        return false;
    }

    public void revealLetter(char letter) {
        for (int i = 0; i < secretLetters.length; i++) {
            if (letter == secretLetters[i]) {
                if (!hasSameLetter(letter, hiddenLetters) && attempts > 0) {
                    attempts--;
                }
                hiddenLetters[i] = letter;
                guessedLettersCount++;
            }
        }
    }

    public void hang(char letter) {
        attempts++;
        wrongLetters = Arrays.copyOf(wrongLetters, wrongLetters.length + 1);
        wrongLetters[wrongLetters.length - 1] = letter;
        for (int i = 0; i < getAttempts(); i++) {
            System.out.printf("%n%s", HANGMAN[i]);
        }
        System.out.println();
    }

    private char[] chooseSecretLetters(Random random) {
        int randomNum = random.nextInt(0, WORDS.length);
        return WORDS[randomNum].toCharArray();
    }

    private char[] fill(int len) {
        char[] array = new char[len];
        Arrays.fill(array, '*');
        return array;
    }
}