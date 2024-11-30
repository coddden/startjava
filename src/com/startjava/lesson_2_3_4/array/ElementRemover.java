package com.startjava.lesson_2_3_4.array;

public class ElementRemover {
    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};
        int srcArrayLength = 15;
        for (int index : indexes) {
            float[] srcArray = generateArray(index, srcArrayLength);
            if (srcArray == null) continue;
            displayArray("Исходный", srcArray);
            int zeroedCells = removeExceedElements(index, srcArray);
            displayArray("Изменённый", srcArray);
            System.out.printf("Индекс %d | Обнулённых ячеек %d%n", index, zeroedCells);
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
        return srcArray;
    }

    private static void displayArray(String modifiedOrNot, float[] array) {
        System.out.printf("%n%s массив%n", modifiedOrNot);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f%s", array[i], i == 7 ? "\n" : " ");
        }
        System.out.println();
    }

    private static int removeExceedElements(int index, float[] array) {
        int zeroedCells = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[index]) {
                array[i] = 0;
                zeroedCells++;
            }
        }
        return zeroedCells;
    }
}
