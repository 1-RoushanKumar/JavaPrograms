package com.roushan._17_Graph;

import java.util.*;

class Graph3 {
    // Adjacency list to represent the graph
    private final ArrayList<ArrayList<Integer>> adj;
    // Number of vertices in the graph
    private final int v;

    // Constructor to initialize the graph with the given number of vertices
    public Graph3(int v) {
        this.v = v;
        adj = new ArrayList<>(v); // Initialize the adjacency list
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>()); // Add an empty list for each vertex
        }
    }

    // Method to add an edge between two vertices (u and v)
    public void addEdge(int u, int v) {
        adj.get(u).add(v); // Add v to the adjacency list of u
        adj.get(v).add(u); // Add u to the adjacency list of v (since the graph is undirected)
    }

    // Method to print the adjacency list representation of the graph
    public void printAdjList() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " -> ");
            System.out.println(adj.get(i));
        }
    }

    // Method to perform BFS traversal for a disconnected graph
    public void BFSDis() {
        boolean[] visited = new boolean[v]; // Array to track visited vertices
        // Traverse all vertices to cover disconnected components
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                BFS(visited, i);
            }
        }
    }

    // Method to perform BFS traversal starting from a given vertex
    private void BFS(boolean[] visited, int s) {
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS
        visited[s] = true; // Mark the starting vertex as visited
        q.add(s); // Enqueue the starting vertex

        while (!q.isEmpty()) {
            int u = q.poll(); // Dequeue a vertex
            System.out.print(u + " "); // Process the dequeued vertex

            // Iterate through all the adjacent vertices of u
            for (int neighbor : adj.get(u)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Mark the neighbor as visited
                    q.add(neighbor); // Enqueue the neighbor
                }
            }
        }
    }
}

public class _04_BFSForDisconnectedGraph {
    public static void main(String[] args) {
        Graph3 g = new Graph3(7);
        g.addEdge(0, 1); // Add edge between vertex 0 and 1
        g.addEdge(0, 2); // Add edge between vertex 0 and 2
        g.addEdge(1, 3); // Add edge between vertex 1 and 3
        g.addEdge(4, 5); // Add edge between vertex 4 and 5
        g.addEdge(5, 6); // Add edge between vertex 5 and 6
        g.addEdge(4, 6); // Add edge between vertex 4 and 6

        System.out.println("Adjacency List of the graph:");
        g.printAdjList(); // Print the adjacency list
        System.out.println();

        System.out.println("Following is Breadth First Traversal:");
        g.BFSDis(); // Perform BFS traversal for the entire graph
    }
}
