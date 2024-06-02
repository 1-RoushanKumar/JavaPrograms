package com.roushan._17_Graph;

import java.util.Arrays;

// Class to represent a weighted undirected graph using an adjacency matrix
class WeightedAdjMatrix {
    int[][] Graph;
    int V;

    // Constructor to initialize the graph with the given number of vertices
    public WeightedAdjMatrix(int v) {
        V = v;
        Graph = new int[v][v];
    }

    // Method to add a weighted edge between two vertices
    public void addWeightedEdge(int i, int j, int w) {
        Graph[i][j] = w;
        Graph[j][i] = w;
    }

    // Method to print the adjacency matrix
    public void printAdjMatrix() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class _18_MinimumSpanningTreePrimsAlgorithm {
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
        System.out.println();

        // Finding the minimum spanning tree using Prim's algorithm
        int minST = primMST(g.Graph, g.V);
        System.out.println(minST);
    }

    // Function to find the minimum spanning tree using Prim's algorithm
    public static int primMST(int[][] graph, int V) {
        // Array to store the minimum weight to connect each vertex
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;  // Start from the first vertex
        int res = 0; // Result to store the sum of the weights of the MST
        boolean[] mSet = new boolean[V]; // Array to keep track of vertices included in MST

        // Loop to find the MST
        for (int i = 0; i < V; i++) {
            int u = -1;

            // Find the vertex with the minimum key value not yet included in MST
            for (int j = 0; j < V; j++) {
                if (!mSet[j] && (u == -1 || key[j] < key[u])) {
                    u = j;
                }
            }

            mSet[u] = true; // Include the selected vertex in the MST
            res = res + key[u]; // Add the key value of the selected vertex to the result

            // Update the key values of the adjacent vertices of the selected vertex
            for (int v = 0; v < V; v++) {
                if (!mSet[v] && graph[u][v] != 0 && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
            }
        }
        return res; // Return the sum of the weights of the MST
    }
}

// Time Complexity Details:
// The time complexity of Prim's algorithm using an adjacency matrix is O(V^2), where V is the number of vertices in the graph.
// This is because we perform V iterations, and in each iteration, we potentially examine V vertices to find the minimum key value and update the keys of adjacent vertices.
