package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    public static final int ATTEMPTS = 10;
    private final int[] numbers = new int[ATTEMPTS];
    private final String name;
    private int currAttempt;
    private int points;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrAttempt() {
        return currAttempt;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint() {
        points++;
    }

    public void clearPoints() {
        points = 0;
    }

    public void clear() {
        Arrays.fill(numbers, 0, currAttempt, 0);
        currAttempt = 0;
    }

    public void addNumber(int number) {
        if (number < GuessNumber.START || number > GuessNumber.END) {
            throw new IllegalArgumentException("\nЧисло должно входить в отрезок " +
                    "[" + GuessNumber.START + ", " + GuessNumber.END + "].\n" +
                    "Попробуйте еще раз: ");
        }
        numbers[currAttempt++] = number;
    }

    public int getNumber() {
        return numbers[currAttempt - 1];
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, currAttempt);
    }
}