package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {

    private static final int ATTEMPTS = 10;
    private final int[] numbers = new int[ATTEMPTS];
    private final String name;
    private int currAttempt;

    public Player(String name) {
        this.name = name;
    }

    public int getAttempts() {
        return ATTEMPTS;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, currAttempt);
    }

    public int getNumber() {
        return numbers[currAttempt - 1];
    }

    public String getName() {
        return name;
    }

    public int getCurrAttempt() {
        return currAttempt + 1;
    }

    public void setCurrAttempt() {
        this.currAttempt = 0;
    }

    public void addNumber(int number) {
        if (number < GuessNumber.getStart() || number > GuessNumber.getEnd()) {
            throw new IllegalArgumentException("""
                    
                    Число должно входить в отрезок [1, 100].
                    Попробуйте еще раз:\s""");
        }
        numbers[currAttempt++] = number;
    }

    public void clear() {
        Arrays.fill(numbers, 0, currAttempt, 0);
    }
}