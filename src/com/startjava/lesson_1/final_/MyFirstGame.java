package com.startjava.lesson_1.final_;

import java.util.Scanner;

public class MyFirstGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int coumputerNum = 49;
        int playerNum = 0;
        System.out.printf("%nПривет! Отгадай число от 1 до 100%n");
        while (playerNum != coumputerNum) {
            playerNum = in.nextInt();
            if (playerNum >= 1 && playerNum <= 100) {
                if (playerNum < coumputerNum) {
                    System.out.printf("%n%d меньше того, что загадал компьютер%n", playerNum);
                } else if (playerNum > coumputerNum) {
                    System.out.printf("%n%d больше того, что загадал компьютер%n", playerNum);
                }
            } else {
                System.out.printf("%nЧисло должно быть в диапазоне 1-100%n");
            }
        }
        System.out.println("Вы победили!");
    }
}