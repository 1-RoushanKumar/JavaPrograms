package com.roushan._17_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _14_DetectCycleOfDirectedGraphUsingBFS {
    public static void main(String[] args) {
        DirectedList g = new DirectedList(5); // Create a directed graph with 5 vertices
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1); // Adding an edge that creates a cycle
        g.addEdge(4, 1);

        g.printAdjList(); // Print the adjacency list of the graph

        int[] inDegree = new int[5]; // Array to store in-degrees of vertices

        // Calculate in-degrees of all vertices
        for (int u = 0; u < 5; u++) {
            for (int x : g.adj.get(u)) {
                inDegree[x]++;
            }
        }
        System.out.println("In-degrees: " + Arrays.toString(inDegree)); // Print in-degrees

        // Detect cycle using BFS (Kahn's Algorithm)
        boolean hasCycle = detect(g.adj, g.v, inDegree);
        System.out.println("Does the graph have a cycle? " + hasCycle);
    }

    /**
     * Method to detect a cycle in a directed graph using BFS (Kahn's Algorithm)
     * @param adj Adjacency list of the graph
     * @param V Number of vertices in the graph
     * @param inDegree Array storing in-degrees of all vertices
     * @return true if the graph contains a cycle, false otherwise
     */
    public static boolean detect(ArrayList<ArrayList<Integer>> adj, int V, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>(); // Queue to store vertices with in-degree 0

        // Add all vertices with in-degree 0 to the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0; // Count of visited vertices

        // Process vertices in the queue
        while (!q.isEmpty()) {
            int u = q.poll();

            // Decrease in-degree of all adjacent vertices
            for (int x : adj.get(u)) {
                if (--inDegree[x] == 0) {
                    q.add(x); // If in-degree becomes 0, add to queue
                }
            }
            count++; // Increment count of visited vertices
        }

        // If the count of visited vertices is not equal to the number of vertices,
        // then there is a cycle in the graph
        return count != V;
    }
}