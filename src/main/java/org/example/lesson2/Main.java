package org.example.lesson2;

import org.example.lesson2.sort.InsertionSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArray.isRepeat = false;
        MyArray.isShuffle = false;
        final int SIZE = 50000;
        Integer[] arr = MyArray.getArray(SIZE, 2);

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, arr);

//        System.out.println(Arrays.toString(arr));

        SpeedTest.startTime();

//        BubbleSort.sort(arr); //при 50000 - 11704 / 3
//        CocktailSort.sort(arr); //12185
//        CombSort.sort(arr); // 42
//        SelectionSort.sort(arr); //3135 / 983
        InsertionSort.sort(arr); // 2310 / 6
//        CountingSort.sort(arr); // 12
//        Arrays.sort(arr); // 33
//        Collections.sort(list); // 33


        SpeedTest.endTime();

//        System.out.println(Arrays.toString(arr));

    }
}
