package org.example.lesson2.homework02;

public class SelectionSort {
    public static <T> void sort(Comparable<T>[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo((T) arr[min]) < 0) {
                    min = j;
                }
            }

            Comparable<T> temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static <T> void sortOptimized(Comparable<T>[] arr) {
        int end = arr.length - 1;
        for (int i = 0; i < end; i++, end--) {
            int min = i;
            int max = end;

            for (int j = i + 1; j <= end; j++) {
                if (arr[j].compareTo((T) arr[min]) < 0) {
                    min = j;
                }
                int reversJ = arr.length - j - 1;
                if (arr[reversJ].compareTo((T) arr[max]) > 0) {
                    max = reversJ;
                }
            }

            if (i != min) {
                Comparable<T> temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            if (max != end && max != i) {
                Comparable<T> temp = arr[end];
                arr[end] = arr[max];
                arr[max] = temp;
            }
        }
    }
}
