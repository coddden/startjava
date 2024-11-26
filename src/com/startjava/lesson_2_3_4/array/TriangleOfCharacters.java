package com.startjava.lesson_2_3_4.array;

public class TriangleOfCharacters {
    public static void main(String[] args) {
        sort('0', '9', true);
        sort('/', '!', false);
        sort('A', 'J', false);
    }

    private static void sort(int start, int end, boolean direction) {
        if (isGreater(start, end)) return;
        int len = end - start + 1;
        char[] characters = new char[len];
        for (int i = 0; i < len; i++) {
            characters[i] = direction ? (char) start++ : (char) end--;
        }
        makeTriangle(characters);
    }

    private static boolean isGreater(int start, int end) {
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", start, end);
            return true;
        }
        return false;
    }

    private static void makeTriangle(char[] characters) {
        int charAmount = 1;
        int offset = characters.length;
        StringBuilder triangle = new StringBuilder();
        for (char character : characters) {
            triangle.append(" ".repeat(offset--));
            triangle.append((character + "").repeat(charAmount)).append("\n");
            charAmount += 2;
        }
        System.out.println(triangle);
    }
}