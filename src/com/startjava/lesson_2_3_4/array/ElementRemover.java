package com.startjava.lesson_2_3_4.array;

public class ElementRemover {
    public static void main(String[] args) {
        int[] limiters = {-1, 15, 0, 14};
        for (int limiter : limiters) {
            float[] srcArray = generateArray();
            float[] modifiedArray = removeExcessElements(limiter, srcArray);
            int zeroedCells = countZeroedCells(modifiedArray);
            displayArrays(limiter, zeroedCells, srcArray, modifiedArray);
        }
    }

    private static float[] generateArray() {
        float[] srcArray = new float[15];
        for (int i = 0; i < srcArray.length; i++) {
            srcArray[i] = (float) Math.random();
        }
        return srcArray;
    }

    private static float[] removeExcessElements(int limiter, float[] srcArray) {
        int len = srcArray.length;
        if (limiter < 0 || limiter >= len) return srcArray;
        float[] modifiedArray = new float[len];
        for (int i = 0; i < len; i++) {
            modifiedArray[i] = srcArray[limiter] < srcArray[i] ? 0 : srcArray[i];
        }
        return modifiedArray;
    }

    private static int countZeroedCells(float[] modifiedArray) {
        int zeroedCells = 0;
        for (float num : modifiedArray) {
            if (num == 0) zeroedCells++;
        }
        return zeroedCells;
    }

    private static void displayArrays(int limiter, int zeroedCells, float[]... arrays) {
        String modifiedOrNot = "Исходный массив";
        for (float[] array : arrays) {
            int len = array.length;
            System.out.printf("%n%s%s", modifiedOrNot, modifiedOrNot.equals("Исходный массив") ? "\n" : "");
            if (!modifiedOrNot.equals("Исходный массив")) {
                System.out.printf(" | Индекс %d | Обнулённых ячеек %d%n", limiter, zeroedCells);
            }
            for (int i = 0; i < len; i++) {
                System.out.printf("%.3f%s", array[i], i == 7 ? "\n" : " ");
            }
            if (limiter < 0 || limiter >= len) {
                modifiedOrNot = "Ошибка! Массив не изменён";
                System.out.println();
                continue;
            }
            modifiedOrNot = "Изменённый массив";
            System.out.println();
        }
    }
}
