package com.startjava.lesson_2_3_4.array;

public class TriangleOfChars {
    public static void main(String[] args) {
        StringBuilder triangleOfNums = isLess('0', '9', true);
        if (triangleOfNums != null) System.out.print(triangleOfNums);

        StringBuilder triangleOfSigns = isLess('/', '!', false);
        if (triangleOfSigns != null) System.out.print(triangleOfSigns);

        StringBuilder triangleOfLetters = isLess('A', 'J', false);
        if (triangleOfLetters != null) System.out.print(triangleOfLetters);
    }

    private static StringBuilder isLess(int start, int end, boolean asc) {
        if (start > end) {
            System.out.printf("%nОшибка: левая граница (%d) > правой (%d)%n%n", start, end);
            return null;
        }
        return create(start, end, asc);
    }

    private static StringBuilder create(int start, int end, boolean asc) {
        int len = end - start + 1;
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = asc ? (char) start++ : (char) end--;
        }
        int charAmount = 1;
        int offset = len;
        StringBuilder triangle = new StringBuilder();
        for (char char1 : chars) {
            triangle.append(" ".repeat(offset--));
            triangle.append((char1 + "").repeat(charAmount)).append("\n");
            charAmount += 2;
        }
        return triangle;
    }
}