package com.roushan._17_Graph;

import java.util.*;

public class _11_Ques_10UsingBFS {
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        UndirectedList g = new UndirectedList(5);

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        // Print the adjacency list of the graph
        System.out.println("Adjacency List of the Graph:");
        g.printAdjList();

        // Detect cycle in the graph
        boolean hasCycle = detectCycleUsingBFS(g.adj, g.v);
        System.out.println("\nCycle detected: " + hasCycle);
    }

    // Method to detect a cycle in an undirected graph using BFS
    public static boolean detectCycleUsingBFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v]; // Array to keep track of visited vertices
        int[] parent = new int[v]; // Array to keep track of parent nodes
        Arrays.fill(parent, -1); // Initialize a parent array with -1

        // Traverse all vertices to ensure we cover disconnected components
        for (int i = 0; i < v; i++) {
            if (!visited[i]) { // If the vertex is not visited
                if (bfs(adj, i, visited, parent)) { // Call the BFS helper function
                    return true; // If a cycle is detected, return true
                }
            }
        }
        return false; // If no cycle is detected, return false
    }

    // BFS helper method to detect a cycle
    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    parent[v] = u;
                } else if (parent[u] != v) {
                    return true; // A cycle is detected
                }
            }
        }
        return false;
    }
}