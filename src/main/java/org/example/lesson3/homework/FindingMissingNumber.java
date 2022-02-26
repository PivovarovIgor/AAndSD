package org.example.lesson3.homework;

import java.util.Arrays;

/*
1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1). Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
        Примеры:
        [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
        [1, 2, 4, 5, 6] => 3
        [] => 1
*/
public class FindingMissingNumber {

    public static void main(String[] args) {

        printResultFind(new int[] {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16});
        printResultFind(new int[] {1, 2, 4, 5, 6});
        printResultFind(new int[] {1, 2, 3, 5, 6, 7});
        printResultFind(new int[] {1, 2, 3, 4, 5});
        printResultFind(new int[] {2, 3, 4, 5, 6});
        printResultFind(new int[] {});

    }

    private static void printResultFind(int[] arr) {
        int result = findMissingNumber(arr);
        System.out.println(Arrays.toString(arr) + " => " + result);
    }

    private static int findMissingNumber(int[] arr) {
        int startInterval = 0;
        int endInterval = arr.length - 1;
        int halfInterval = -1;

        while (startInterval <= endInterval) {
            halfInterval = (endInterval - startInterval) / 2 + startInterval;
            if (arr[halfInterval] == halfInterval + 1) {
                startInterval = halfInterval + 1;
            } else {
                endInterval = --halfInterval;
            }
        }

        return halfInterval + 2;
    }
}
