package org.example.lesson6.homework;

import org.example.lesson6.Tree;
import org.example.lesson6.TreeImpl;

import java.util.Random;

public class App implements Runnable {

    private static final int COUNT_BINARY_TREE = 20;
    private static final int DEEP_TREE = 4;
    private static final int RANGE_OF_RANDOM_NUMBERS = 25;

    public static void main(String[] args) {

        App application = new App();
        application.run();
    }

    @Override
    public void run() {

        Random rnd = new Random();
        int countOfThreeCreated = 0;
        int isBalancedCount = 0;

        for (int i = 0; i < COUNT_BINARY_TREE; i++) {
            Tree<Integer> currentTree = new TreeImpl<>();
            for (int j = 0; j <= DEEP_TREE; j++) {
                currentTree.add(rnd.nextInt(RANGE_OF_RANDOM_NUMBERS * 2 + 1) - RANGE_OF_RANDOM_NUMBERS);
            }
            countOfThreeCreated++;
            currentTree.display();
            if (currentTree.isBalanced()) {
                isBalancedCount++;
            }
        }

        System.out.println("Count of tree created: " + countOfThreeCreated);
        System.out.println("balanced three: " + isBalancedCount);
        System.out.printf("percent of balanced three: %.0f%%", (float) isBalancedCount / countOfThreeCreated * 100);
    }
}
