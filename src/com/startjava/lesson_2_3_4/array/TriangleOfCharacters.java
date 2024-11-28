package com.startjava.lesson_2_3_4.array;

public class TriangleOfCharacters {
    public static void main(String[] args) {
        create('0', '9', true);
        create('/', '!', false);
        create('A', 'J', false);
    }

    private static void create(int start, int end, boolean direction) {
        if (isGreater(start, end)) return;
        int len = end - start + 1;
        char[] characters = new char[len];
        for (int i = 0; i < len; i++) {
            characters[i] = direction ? (char) start++ : (char) end--;
        }
        System.out.println(construct(characters));
    }

    private static boolean isGreater(int start, int end) {
        if (start > end) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n%n", start, end);
            return true;
        }
        return false;
    }

    private static StringBuilder construct(char[] characters) {
        int charAmount = 1;
        int offset = characters.length;
        StringBuilder triangle = new StringBuilder();
        for (char character : characters) {
            triangle.append(" ".repeat(offset--));
            triangle.append((character + "").repeat(charAmount)).append("\n");
            charAmount += 2;
        }
        return triangle;
    }
}