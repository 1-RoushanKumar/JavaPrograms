package com.roushan._17_Graph;

import java.util.*;

// Represents a weighted adjacency list for a graph
class WeightedAdjList {
    int V;
    List<List<Pair>> adj;

    // Constructor to initialize the adjacency list
    public WeightedAdjList(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Method to add a weighted edge between two vertices
    public void addWeightedEdge(int u, int v, int weight) {
        adj.get(u).add(new Pair(v, weight));
        adj.get(v).add(new Pair(u, weight));
    }

    // Method to print the adjacency list
    public void printAdjList() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ":");
            for (Pair edge : adj.get(i)) {
                System.out.print(" -> " + edge.vertex + " (weight " + edge.weight + ")");
            }
            System.out.println();
        }
    }
}

public class _20_MstUsingPrimsWithPriorityAndAdjacencyList {
    public static void main(String[] args) {
        int V = 5;
        WeightedAdjList g = new WeightedAdjList(V);

        // Adding weighted edges to the graph
        g.addWeightedEdge(0, 1, 2);
        g.addWeightedEdge(0, 3, 6);
        g.addWeightedEdge(1, 2, 3);
        g.addWeightedEdge(1, 3, 8);
        g.addWeightedEdge(1, 4, 5);
        g.addWeightedEdge(2, 4, 7);

        // Finding the minimum spanning tree using Prim's algorithm
        int minST = primMST(g.adj, g.V);
        System.out.println(minST);
    }

    // Function to find the minimum spanning tree using Prim's algorithm with Fibonacci Heap
    public static int primMST(List<List<Pair>> adj, int V) {
        boolean[] inMST = new boolean[V]; // Array to keep track of vertices included in MST
        int[] key = new int[V]; // Array to store the minimum weight to connect each vertex
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight); // Priority queue for tracking the minimum edge weight
        pq.add(new Pair(0, 0)); // Start from the first vertex
        int res = 0; // Result to store the sum of the weights of the MST

        while (!pq.isEmpty()) {
            Pair minPair = pq.poll();
            int u = minPair.vertex;

            if (!inMST[u]) {
                inMST[u] = true;
                res += minPair.weight;

                // Update key values of adjacent vertices of u
                for (Pair neighbor : adj.get(u)) {
                    int v = neighbor.vertex;
                    int weight = neighbor.weight;
                    if (!inMST[v]) {
                        if (key[v] == 0 || weight < key[v]) {
                            key[v] = weight;
                            pq.add(new Pair(v, weight));
                        }
                    }
                }
            }
        }
        return res; // Return the sum of the weights of the MST
    }

    // Time complexity of Prim's algorithm with Priority Queue: O((V + E) log V)

    // Explanation of (a, b) -> a.weight - b.weight:
    // - (a, b) represents the two elements being compared in the priority queue.
    // - a.weight - b.weight is the comparison logic. It compares elements based on their weights,
    //   ensuring the priority queue orders elements by their weight in ascending order.
}
