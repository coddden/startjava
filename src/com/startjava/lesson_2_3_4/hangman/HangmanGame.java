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
        this.secretLetters = chooseSecretWord(random);
        this.hiddenLetters = makeMask(secretLetters.length);
    }

    public void displayMenu() {
        System.out.printf("%n%s", makeStr(hiddenLetters));
        System.out.printf("%nПопыток: %d", HANGMAN.length - attempts);
        System.out.printf("%nОшибки: %s", makeStr(wrongLetters));
        System.out.printf("%nВаша буква -> ");
    }

    public boolean isCorrectLetter(char letter) {
        if (letter < 'А' || letter > 'Я') {
            System.out.printf("Введите русскую букву!%n");
            return false;
        }
        if (hasSameLetter(letter, hiddenLetters) || hasSameLetter(letter, wrongLetters)) {
            System.out.printf("Такая буква уже была!%n");
            return false;
        }
        return true;
    }

    public void play(char letter) {
        if (!hasSameLetter(letter, secretLetters)) {
            attempts++;
            wrongLetters = Arrays.copyOf(wrongLetters, wrongLetters.length + 1);
            wrongLetters[wrongLetters.length - 1] = letter;
            for (int i = 0; i < attempts; i++) {
                System.out.printf("%n%s", HANGMAN[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < secretLetters.length; i++) {
            if (letter == secretLetters[i]) {
                if (!hasSameLetter(letter, hiddenLetters) && attempts > 0) attempts--;
                hiddenLetters[i] = letter;
                guessedLettersCount++;
            }
        }
    }

    public boolean isFinish() {
        if (!(guessedLettersCount == secretLetters.length || attempts == HANGMAN.length)) return false;
        System.out.printf("%n%s", guessedLettersCount == secretLetters.length ?
                "Вы угадали слово - " : "Вы проиграли!\nСекретное слово - ");
        System.out.print(makeStr(secretLetters));
        System.out.println();
        return true;
    }

    public void initialize(Random random) {
        secretLetters = chooseSecretWord(random);
        hiddenLetters = makeMask(secretLetters.length);
        wrongLetters = new char[0];
        guessedLettersCount = 0;
        attempts = 0;
    }

    private char[] chooseSecretWord(Random random) {
        int randomNum = random.nextInt(0, WORDS.length);
        return WORDS[randomNum].toCharArray();
    }

    private char[] makeMask(int len) {
        char[] array = new char[len];
        Arrays.fill(array, '*');
        return array;
    }

    private String makeStr(char[] array) {
        return Arrays.toString(array).replaceAll("[\\[\\],]", "");
    }

    private boolean hasSameLetter(char letter, char[] array) {
        for (char item : array) {
            if (item == letter) return true;
        }
        return false;
    }
}