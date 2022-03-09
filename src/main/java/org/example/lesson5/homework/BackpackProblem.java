package org.example.lesson5.homework;

import java.util.Arrays;
/*
2. «Задача о рюкзаке» с помощью рекурсии.
 */
public class BackpackProblem {

    private Box[] optimal = new Box[]{};
    private int maxCost = 0;

    public static void main(String[] args) {
        BackpackProblem app = new BackpackProblem();
        Box[] arr = new Box[]{
                new Box(2, 1),
                new Box(3, 4),
                new Box(3, 3),
                new Box(0, 1),
        };
        System.out.println(Arrays.toString(app.findSolution(arr, 7)));
    }

    private Box[] findSolution(Box[] allBox, int backpackCapacity) {
        findSolution(Arrays.copyOf(allBox, allBox.length), backpackCapacity, allBox.length);
        return optimal;
    }

    private Box[] findSolution(Box[] allBox, int backpackCapacity, int newSize) {
        if (newSize == 1) {
            return allBox;
        }
        for (int i = allBox.length - newSize; i < newSize - 1; i++) {
            allBox = findSolution(Arrays.copyOf(allBox, allBox.length), backpackCapacity, newSize - 1);
            //System.out.println(Arrays.toString(allBox));
            Box[] current = getSubSetToCapacity(allBox, backpackCapacity);
            int currentCost = Arrays.stream(current)
                    .mapToInt(Box::getCost)
                    .sum();
            if (currentCost > maxCost) {
                maxCost = currentCost;
                optimal = current;
            }
            rotate(allBox, newSize);
        }
        return allBox;
    }

    private void rotate(Box[] arr, int size) {
        int i;
        int pos = arr.length - size;
        Box temp = arr[pos];
        for (i = pos + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[i - 1] = temp;
    }

    private Box[] getSubSetToCapacity(Box[] newSequence, int backpackCapacity) {
        int totalWeight = 0;
        for (int i = 0; i < newSequence.length; i++) {
            totalWeight += newSequence[i].getWeight();
            if (totalWeight > backpackCapacity) {
                return Arrays.copyOf(newSequence, i);
            }
        }
        return newSequence;
    }
}
