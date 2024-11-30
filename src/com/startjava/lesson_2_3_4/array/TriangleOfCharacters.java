package com.startjava.lesson_2_3_4.array;

public class TriangleOfCharacters {
    public static void main(String[] args) {
        StringBuilder TriangleOfNums = create('0', '9', true);
        System.out.print(TriangleOfNums == null ? "" : TriangleOfNums);

        StringBuilder TriangleOfSigns = create('/', '!', false);
        System.out.print(TriangleOfSigns == null ? "" : TriangleOfSigns);

        StringBuilder TriangleOfLetters = create('A', 'J', false);
        System.out.print(TriangleOfLetters == null ? "" : TriangleOfLetters);
    }

    private static StringBuilder create(int start, int end, boolean direction) {
        if (isGreater(start, end)) return null;
        int len = end - start + 1;
        char[] characters = new char[len];
        for (int i = 0; i < len; i++) {
            characters[i] = direction ? (char) start++ : (char) end--;
        }
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

    private static boolean isGreater(int start, int end) {
        if (start > end) {
            System.out.printf("%nОшибка: левая граница (%d) > правой (%d)%n%n", start, end);
            return true;
        }
        return false;
    }
}