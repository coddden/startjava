package com.startjava.lesson_2_3_4.array;

public class TriangleOfCharacters {
    public static void main(String[] args) {
        if (isLess('0', '9')) System.out.print(create('0', '9', true));
        if (isLess('/', '!')) System.out.print(create('/', '!', false));
        if (isLess('A', 'J')) System.out.print(create('A', 'J', false));
    }

    private static boolean isLess(int start, int end) {
        if (start > end) {
            System.out.printf("%nОшибка: левая граница (%d) > правой (%d)%n%n", start, end);
            return false;
        }
        return true;
    }

    private static StringBuilder create(int start, int end, boolean asc) {
        int len = end - start + 1;
        char[] characters = new char[len];
        for (int i = 0; i < len; i++) {
            characters[i] = asc ? (char) start++ : (char) end--;
        }
        int charAmount = 1;
        int offset = len;
        StringBuilder triangle = new StringBuilder();
        for (char character : characters) {
            triangle.append(" ".repeat(offset--));
            triangle.append((character + "").repeat(charAmount)).append("\n");
            charAmount += 2;
        }
        return triangle;
    }
}