package com.startjava.lesson_2_3_4.array;

public class ElementRemover {
    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};
        for (int index : indexes) {
            if (!isValidIndex(index)) continue;
            float[] srcArray = generateArray();
            float[] modifiedArray = removeExceedElements(index, srcArray);
            int zeroedCells = countZeroedCells(modifiedArray);
            displayArrays(index, zeroedCells, srcArray, modifiedArray);
        }
    }

    private static boolean isValidIndex(int index) {
        if (index >= 0 && index < 15) return true;
        System.out.printf("%nОшибка! Индекс не найден!%n");
        return false;
    }

    private static float[] generateArray() {
        float[] array = new float[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) Math.random();
        }
        return array;
    }

    private static float[] removeExceedElements(int index, float[] array) {
        int len = array.length;
        float[] modifiedArray = new float[len];
        for (int i = 0; i < len; i++) {
            modifiedArray[i] = array[index] < array[i] ? 0 : array[i];
        }
        return modifiedArray;
    }

    private static int countZeroedCells(float[] array) {
        int zeroedCells = 0;
        for (float num : array) {
            if (num == 0) zeroedCells++;
        }
        return zeroedCells;
    }

    private static void displayArrays(int index, int zeroedCells, float[]... arrays) {
        String modifiedOrNot = "Исходный массив";
        for (float[] array : arrays) {
            int len = array.length;
            System.out.printf("%n%s%s", modifiedOrNot, modifiedOrNot.equals("Исходный массив") ? "\n" : "");
            if (modifiedOrNot.equals("Изменённый массив")) {
                System.out.printf(" | Индекс %d | Обнулённых ячеек %d%n", index, zeroedCells);
            }
            for (int i = 0; i < len; i++) {
                System.out.printf("%.3f%s", array[i], i == 7 ? "\n" : " ");
            }
            modifiedOrNot = "Изменённый массив";
            System.out.println();
        }
    }
}
