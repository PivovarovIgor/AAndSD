package org.example.lesson5.homework;

public class Box {
    private int cost;
    private int weight;

    public Box(int cost, int weight) {
        this.cost = cost;
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Box{" +
                "cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}
