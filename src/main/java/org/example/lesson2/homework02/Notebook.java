package org.example.lesson2.homework02;

import java.util.Random;

public class Notebook implements Comparable<Notebook> {

    private static final int START_PRICE = 500;
    private static final int END_PRICE = 2000;
    private static final int STEP_PRICE = 50;
    private static final int BOUND_FOR_RANDOM_PRICE = (END_PRICE - START_PRICE) / STEP_PRICE + 1;

    private static final int START_COUNT_OF_RAM = 4;
    private static final int END_COUNT_OF_RAM = 20;
    private static final int STEP_COUNT_OF_RAM = 4;
    private static final int BOUND_FOR_RANDOM_COUNT_OF_RAM = (END_COUNT_OF_RAM - START_COUNT_OF_RAM) / STEP_COUNT_OF_RAM + 1;

    private final int price;
    private final int countRam;
    private Manufacturer manufacturer;

    public static Notebook RandomNotebookFactory(Manufacturer[] manufacturers) {
        if (manufacturers == null || manufacturers.length == 0) {
            throw new IllegalArgumentException("manufacturers must be not null.");
        }
        Random random = new Random();
        int price = random.nextInt(BOUND_FOR_RANDOM_PRICE) * STEP_PRICE + START_PRICE;
        int countRam = random.nextInt(BOUND_FOR_RANDOM_COUNT_OF_RAM) * STEP_COUNT_OF_RAM + START_COUNT_OF_RAM;
        Manufacturer manufacturer = manufacturers[random.nextInt(manufacturers.length)];
        return new Notebook(price, countRam, manufacturer);
    }

    private Notebook(int price, int countRam, Manufacturer manufacturer) {
        if (manufacturer == null) {
            throw new IllegalArgumentException("Manufacturer must be not null.");
        }
        this.price = price;
        this.countRam = countRam;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", RAM=" + countRam +
                ", " + manufacturer +
                '}';
    }

    @Override
    public int compareTo(Notebook notebook) {
        int resCompare;
        resCompare = this.price - notebook.price ;
        if (resCompare != 0) {
            return resCompare;
        }
        resCompare = this.countRam - notebook.countRam;
        if (resCompare != 0) {
            return resCompare;
        }
        return this.manufacturer.compareTo(notebook.manufacturer);
    }
}
