package org.example.lesson7.homework;

import org.example.lesson7.Vertex;

import java.util.*;

public class WeightedGraphImpl implements WeightedGraph {

    private final List<Vertex> vertexList;
    private final Integer[][] adjMatrix;

    public WeightedGraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new Integer[maxVertexCount][maxVertexCount];
    }

    @Override
    public WeightedGraph addVertex(String label) {
        vertexList.add(new Vertex(label));
        return this;
    }

    @Override
    public WeightedGraph addEdge(int weight, String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неопределено вершина " + startLabel);
        }
        if (endIndex == -1) {
            throw new IllegalArgumentException("Неопределено вершина " + secondLabel);
        }

        adjMatrix[startIndex][endIndex] = weight;

        return this;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public WeightedGraph addEdge(int weight, String startLabel, String secondLabel, String... others) {
        addEdge(weight, startLabel, secondLabel);

        for (String other : others) {
            addEdge(weight, startLabel, other);
        }

        return this;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String[] findShortestWey(String startLabel, String endLabel) {
        Vertex[] theShortestWey = new Vertex[]{};
        int minWey = Integer.MAX_VALUE;

        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        int endIndex = indexOf(endLabel);
        if (endIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + endLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Stack<Integer> weightStack = new Stack<>();
        Vertex currentVertex = vertexList.get(startIndex);
        final Vertex endVertex = vertexList.get(endIndex);
        int currentLongWey = 0;

        visitVertex(stack, currentVertex);
        while (!stack.isEmpty()) {
            Vertex nextVertex = getNearUnvisitedVertex(currentVertex);
            if (nextVertex == null) {
                currentVertex  = stack.pop();
                currentLongWey -= weightStack.pop();
            } else {
                weightStack.push(getWeight(currentVertex, nextVertex));
                currentLongWey += weightStack.peek();
                if (nextVertex.equals(endVertex)) {
                    if (minWey > currentLongWey) {
                        minWey = currentLongWey;
                        stack.push(endVertex);
                        theShortestWey = stack.toArray(new Vertex[0]);
                    }
                    stack.clear();
                    currentVertex = vertexList.get(startIndex);
                    currentLongWey = 0;
                    visitVertex(stack, currentVertex);
                } else {
                    visitVertex(stack, nextVertex);
                    currentVertex = nextVertex;
                }
            }
        }

        return Arrays.stream(theShortestWey)
                .map(Vertex::getLabel)
                .toArray(String[]::new);
    }

    private int getWeight(Vertex firstVertex, Vertex secondVertex) {
        int firstIndex = indexOf(firstVertex.getLabel());
        int secondIndex = indexOf(secondVertex.getLabel());
        Integer weight = adjMatrix[firstIndex][secondIndex];
        if (weight == null) {
            throw new IllegalArgumentException("Между вершинами " + firstVertex.getLabel() + " и "
                    + secondVertex.getLabel() + " - нет связи");
        }
        return weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                Integer weight = adjMatrix[i][j];
                if (weight != null) {
                    sb
                            .append(" -[")
                            .append(weight)
                            .append("]-> ")
                            .append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != null && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setIsVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setIsVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
    }
}
