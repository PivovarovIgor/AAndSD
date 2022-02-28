package org.example.lesson2.homework02;

public class Manufacturer implements Comparable<Manufacturer> {

    private static int countOrder = 0;

    private final String name;
    private final int order;

    public Manufacturer(String name) {
        this.name = name;
        this.order = countOrder++;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Manufacturer manufacturer) {
        return this.order - manufacturer.order;
    }
}
