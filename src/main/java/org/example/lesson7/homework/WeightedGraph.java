package org.example.lesson7.homework;

public interface WeightedGraph {

    WeightedGraph addVertex(String label);

    WeightedGraph addEdge(int weight, String startLabel, String secondLabel, String... others);
    WeightedGraph addEdge(int weight, String startLabel, String secondLabel);

    int getSize();

    void display();

    String[] findShortestWey(String startLabel, String endLabel);

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

}
