package org.basics;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;


public class BasicsMain {

    //Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
    public static void MaxMin(){
        int size = 100;
        double[] array = new double[size];
        for (int i=0; i < size; i++){
            array[i] = Math.random();
        }

        double max = array[0];
        double min = array[0];
        double avg = 0;
        for(int i=0; i < size; i++){
            if(array[i]>max){
                max = array[i];
            }
            if(array[i]>min){
                min = array[i];
            }
            avg += (max+min)/size;
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + avg);
    }


    public static void bubbleSort(){
        int size = 50;
        double[] array = new double[size];
        for (int i=0; i < size; i++){
            array[i] = Math.random();
        }
        for (int i=0; i < size; i++){
            for(int j= 0; j < size-1-i; j++){
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i=0; i < size; i++) {
            System.out.println(array[i]);
        }

    }

    //Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
    //Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.
    public static void simpleNum(){
        for (int i = 2; i <= 100; i++){
            boolean flag = true;
            for (int j = 2; j < i; j++){
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                System.out.println(i);
            }
        }
    }

    //Дан массив целых чисел и ещё одно целое число.
    //Удалите все вхождения этого числа из массива (пропусков быть не должно).
    public static void delete(){
//        int[] array = IntStream.generate(() -> new Random()
//                .nextInt(100))
//                .limit(100)
//                .toArray();
        int[] array = new int[100];
        for (int i=0; i < 100; i++){
            array[i] = i;
        }
        int N = 99;
        int offset = 0;
        for(int i=0; i< array.length; i++){
            if(array[i] == N){
                offset++;
            }
            else{
                array[i-offset] = array[i];
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(array).toArray()));
        System.out.println(N);
        System.out.println(Arrays.toString(Arrays.copyOf(array, array.length - offset)));
    }

    public static void main(String[] args) {
        MaxMin();
        bubbleSort();
        delete();
    }
}
