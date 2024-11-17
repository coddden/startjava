package com.startjava.lesson_2_3_4.array;

public class ElementRemover {
    public static void main(String[] args) {
        int[] limiters = {-1, 15, 0, 14};
        for (int limiter : limiters) {
            double[] srcArray = generateArray();
            double[] modifiedArray = removeExcessElements(limiter, srcArray);
            int zeroedCells = countZeroedCells(modifiedArray);
            showArrays(limiter, zeroedCells, srcArray, modifiedArray);
        }
    }

    private static double[] generateArray() {
        double[] srcArray = new double[15];
        for (int i = 0; i < srcArray.length; i++) {
            srcArray[i] = Math.random();
        }
        return srcArray;
    }

    private static double[] removeExcessElements(int limiter, double[] srcArray) {
        int len = srcArray.length;
        double[] modifiedArray = new double[len];
        for (int i = 0; i < len; i++) {
            modifiedArray[i] = i > limiter ? 0 : srcArray[i];
        }
        return modifiedArray;
    }

    private static int countZeroedCells(double[] modifiedArray) {
        int zeroedCells = 0;
        for (double num : modifiedArray) {
            if (num == 0) zeroedCells++;
        }
        return zeroedCells;
    }

    private static void showArrays(int limiter, int zeroedCells, double[]... arrays) {
        String modifiedOrNot = "Исходный";
        for (double[] array : arrays) {
            System.out.printf("%n%s массив%s", modifiedOrNot, modifiedOrNot.equals("Исходный") ? "\n" : "");
            if (modifiedOrNot.equals("Изменённый")) {
                System.out.printf(" | Индекс %d | Обнулённых ячеек %d%n", limiter, zeroedCells);
            }
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%.3f%s", array[i], i == 7 ? "\n" : " ");
            }
            modifiedOrNot = "Изменённый";
            System.out.println();
        }
    }
}
