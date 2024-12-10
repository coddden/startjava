package com.startjava.lesson_2_3_4.array;

public class TriangleOfChars {
    public static void main(String[] args) {
        StringBuilder triangleOfNums = create('0', '9', true);
        if (triangleOfNums != null) System.out.print(triangleOfNums);

        StringBuilder triangleOfSigns = create('/', '!', false);
        if (triangleOfSigns != null) System.out.print(triangleOfSigns);

        StringBuilder triangleOfLetters = create('A', 'J', false);
        if (triangleOfLetters != null) System.out.print(triangleOfLetters);
    }

    private static StringBuilder create(int start, int end, boolean asc) {
        if (isGreater(start, end)) return null;
        int len = end - start + 1;
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = asc ? (char) start++ : (char) end--;
        }
        int charAmount = 1;
        int offset = len;
        StringBuilder triangle = new StringBuilder();
        for (char character : chars) {
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