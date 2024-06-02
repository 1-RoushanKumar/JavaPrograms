package com.roushan._17_Graph;

import java.util.ArrayList;

class DirectedListWeighted {
    int v;  // Number of vertices
    ArrayList<ArrayList<Pair>> adj;  // Adjacency list to store the graph

    // Pair class to store destination vertex and weight of the edge
    static class Pair {
        int dest;  // Destination vertex
        int weight;  // Weight of the edge

        Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Constructor to initialize the graph
    DirectedListWeighted(int v) {
        this.v = v;
        adj = new ArrayList<>(v);
        // Initialize each adjacency list for each vertex
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Pair(dest, weight));
    }

    // Method to print the adjacency list representation of the graph
    void printAdjList() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + ": ");
            for (Pair pair : adj.get(i)) {
                System.out.print("(" + pair.dest + ", " + pair.weight + ") ");
            }
            System.out.println();
        }
    }
}

public class _16_DirectedListWithWeightedEdge {
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        DirectedListWeighted graph = new DirectedListWeighted(5);

        // Add edges to the graph
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 20);
        graph.addEdge(1, 2, 30);
        graph.addEdge(1, 3, 40);
        graph.addEdge(1, 4, 50);
        graph.addEdge(2, 3, 60);
        graph.addEdge(3, 4, 70);

        // Print the adjacency list representation of the graph
        graph.printAdjList();
    }
}
