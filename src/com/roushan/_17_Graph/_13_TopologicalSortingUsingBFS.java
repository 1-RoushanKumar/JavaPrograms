package com.roushan._17_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _13_TopologicalSortingUsingBFS {
    public static void main(String[] args) {
        DirectedList g = new DirectedList(5); // Create a graph with 5 vertices
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3); // Adding edges

        g.printAdjList(); // Print the adjacency list of the graph

        int[] inDegree = new int[5]; // Array to store in-degrees of vertices

        // Calculate in-degrees of all vertices
        for (int u = 0; u < 5; u++) {
            for (int x : g.adj.get(u)) {
                inDegree[x]++;
            }
        }
        System.out.println("In-degrees: " + Arrays.toString(inDegree)); // Print in-degrees

        // Perform topological sorting using BFS (Kahn's Algorithm)
        sort(g.adj, g.v, inDegree);
    }

    /**
     * Method to perform topological sorting using BFS (Kahn's Algorithm)
     *
     * @param adj      Adjacency list of the graph
     * @param v        Number of vertices in the graph
     * @param inDegree Array storing in-degrees of all vertices
     */
    public static void sort(ArrayList<ArrayList<Integer>> adj, int v, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>(); // Queue to store vertices with in-degree 0

        // Add all vertices with in-degree 0 to the queue
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Process vertices in the queue
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " "); // Print the vertex

            // Decrease in-degree of all adjacent vertices
            for (int x : adj.get(u)) {
                if (--inDegree[x] == 0) {
                    q.add(x); // If in-degree becomes 0, add to queue
                }
            }
        }
    }
}