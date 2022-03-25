package org.example.lesson7.homework;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        WeightedGraph weightedGraph = new WeightedGraphImpl(10);

        weightedGraph
                .addVertex("Москва")
                .addVertex("Тула")
                .addVertex("Липецк")
                .addVertex("Воронеж")
                .addVertex("Рязань")
                .addVertex("Тамбов")
                .addVertex("Саратов")
                .addVertex("Калуга")
                .addVertex("Орел")
                .addVertex("Курск");

        weightedGraph
                .addEdge(10, "Москва", "Тула")
                .addEdge(5, "Тула", "Липецк")
                .addEdge(15, "Липецк", "Воронеж")
        ;

        weightedGraph
                .addEdge(14, "Москва", "Рязань")
                .addEdge(3, "Рязань", "Тамбов")
                .addEdge(7, "Тамбов", "Саратов")
                .addEdge(5, "Саратов", "Воронеж")
        ;

        weightedGraph
                .addEdge(3, "Москва", "Калуга")
                .addEdge(5, "Калуга", "Орел")
                .addEdge(8, "Орел", "Курск")
                .addEdge(14, "Курск", "Воронеж")
        ;

        System.out.println(weightedGraph);
        System.out.println("Самый короткий путь: " + Arrays.toString(weightedGraph.findShortestWey("Москва", "Воронеж")));
    }
}
