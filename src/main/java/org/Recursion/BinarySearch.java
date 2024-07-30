package org.Recursion;

import java.util.Arrays;

/* Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
    Используйте перебор и двоичный поиск для решения этой задачи.
    Сравните время выполнения обоих решений для больших массивов (например, 100000000 элементов).
*/

public class BinarySearch{
    public static int bruteForce(double[] array, double key){
        for(int i=0; i < array.length; i++){
            if (array[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchRecursively (double[] array, double key){
        return binarySearchRecursively(array, key, 0, array.length);
    };

    public static int binarySearchRecursively (double[] sortedArray, double key, int low, int high){
        int middle = (low + high) / 2;

        if (high < low) { // больше делить нечего
            return -1;
        }

        if (key == sortedArray[middle]) { // если нашёлся
            return middle;
        } else if (key < sortedArray[middle]) {
            return binarySearchRecursively (sortedArray, key, low, middle - 1); //левая половина
        } else {
            return binarySearchRecursively (sortedArray, key, middle + 1, high); //правая половина
        }
    }

    public static double[] generateRandomArray(int length){
        double[] array = new double[length];
        for (int i = 0; i < length; i++){
            array[i] = Math.random();
        }
        return array;
    }

    public static void main(String[] args) {
        double[] array = generateRandomArray(100000000);
        Arrays.sort(array);
        long time = System.currentTimeMillis(); // текущее время, unix-time

        bruteForce(array, 0.5);
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        binarySearchRecursively(array, 0.5);
        System.out.println(System.currentTimeMillis() - time);
    }
}
