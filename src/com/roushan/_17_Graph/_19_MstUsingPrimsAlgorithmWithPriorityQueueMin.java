package com.roushan._17_Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

// Class to represent an edge with a vertex and weight
class Pair {
    int vertex;
    int weight;

    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class _19_MstUsingPrimsAlgorithmWithPriorityQueueMin {
    public static void main(String[] args) {
        int V = 5;
        WeightedAdjMatrix g = new WeightedAdjMatrix(V);

        // Adding weighted edges to the graph
        g.addWeightedEdge(0, 1, 2);
        g.addWeightedEdge(0, 3, 6);
        g.addWeightedEdge(1, 2, 3);
        g.addWeightedEdge(1, 3, 8);
        g.addWeightedEdge(1, 4, 5);
        g.addWeightedEdge(2, 4, 7);
        g.printAdjMatrix();

        // Finding the minimum spanning tree using Prim's algorithm
        int minST = primMST(g.Graph, g.V);
        System.out.println(minST);
    }

    // Function to find the minimum spanning tree using Prim's algorithm with Min-Heap
    public static int primMST(int[][] graph, int V) {
        boolean[] inMST = new boolean[V]; // Array to keep track of vertices included in MST
        int[] key = new int[V]; // Array to store the minimum weight to connect each vertex
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;  // Start from the first vertex
        int res = 0; // Result to store the sum of the weights of the MST

        // Priority queue to pick the minimum weight edge at each step
        PriorityQueue<Pair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.weight));
        pq.add(new Pair(0, key[0]));

        while (!pq.isEmpty()) {
            Pair edge = pq.poll();
            int u = edge.vertex;

            // If vertex u is not already in MST
            if (!inMST[u]) {
                inMST[u] = true;
                res += edge.weight;

                // Update key values of adjacent vertices of u
                for (int v = 0; v < V; v++) {
                    if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                        key[v] = graph[u][v];
                        pq.add(new Pair(v, key[v]));
                    }
                }
            }
        }
        return res; // Return the sum of the weights of the MST
    }
}

// Time Complexity Details:
// The time complexity of Prim's algorithm using a Min-Heap is O(E log V), where V is the number of vertices and E is the number of edges.
// This is because inserting and extracting the minimum value from the priority queue takes O(log V) time and this operation is performed E times.

// Explanation of V and Comparator.comparingInt(o -> o.weight):
// V: Represents the initial capacity of the priority queue, optimizing its internal data structures.
// Comparator.comparingInt(o -> o.weight): Creates a comparator for Edge objects based on their weight,
// ensuring the priority queue (Min-Heap) orders edges by their weight in ascending order.

