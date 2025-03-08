package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private final String name;
    private int attempts;
    private int currentAttempt;
    private int[] numbers;

    public Player(String name) {
        this.name = name;
        this.attempts = 10;
        this.numbers = new int[attempts];
    }

    public String getName() {
        return name;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts() {
        this.attempts = 10;
    }

    public int getCurrentAttempt() {
        return currentAttempt + 1;
    }

    public void setCurrentAttempt() {
        this.currentAttempt = 0;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, currentAttempt);
    }

    public void setNumbers() {
        Arrays.fill(numbers, 0);
    }

    public int getNumber() {
        return numbers[currentAttempt - 1];
    }

    public void setNumber(int number) {
        if (number < GuessNumber.START || number > GuessNumber.END) {
            throw new IllegalArgumentException("Число должно входить в отрезок [1, 100]." +
                    "\nПопробуйте еще раз: ");
        }
        this.numbers[currentAttempt++] = number;
        attempts--;
    }
}