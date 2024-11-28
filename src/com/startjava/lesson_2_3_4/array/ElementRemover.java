package com.startjava.lesson_2_3_4.array;

public class ElementRemover {
    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};
        int srcArrayLength = 15;
        for (int index : indexes) {
            displayResult(index, srcArrayLength,
                    removeExceedElements(index, generateArray(index, srcArrayLength)));
        }
    }

    private static float[] generateArray(int index, int srcArrayLength) {
        if (index < 0 || index >= srcArrayLength) {
            System.out.printf("%nОшибка! Индекса %d в массиве не существует!%nДоступные индексы 0-%d%n",
                    index, srcArrayLength - 1);
            return null;
        }
        float[] srcArray = new float[srcArrayLength];
        for (int i = 0; i < srcArray.length; i++) {
            srcArray[i] = (float) Math.random();
        }
        displayArray("Исходный", srcArray);
        return srcArray;
    }

    private static void displayArray(String modifiedOrNot, float[] array) {
        int len = array.length;
        System.out.printf("%n%s массив%n", modifiedOrNot);
        for (int i = 0; i < len; i++) {
            System.out.printf("%.3f%s", array[i], i == 7 ? "\n" : " ");
        }
        System.out.println();
    }

    private static int removeExceedElements(int index, float[] array) {
        int zeroedCells = 0;
        if (array == null) return zeroedCells;
        int len = array.length;
        float[] modifiedArray = new float[len];
        for (int i = 0; i < len; i++) {
            if (array[i] > array[index]) {
                modifiedArray[i] = 0;
                zeroedCells++;
            } else {
                modifiedArray[i] = array[i];
            }
        }
        displayArray("Изменённый", modifiedArray);
        return zeroedCells;
    }

    private static void displayResult(int index, int srcArrayLength, int zeroedCells) {
        if (index < 0 || index >= srcArrayLength) return;
        System.out.printf("Индекс %d | Обнулённых ячеек %d%n", index, zeroedCells);
    }
}
