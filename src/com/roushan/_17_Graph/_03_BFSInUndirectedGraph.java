package com.roushan._17_Graph;

import java.util.*;

class Graph2 {
    // Adjacency list to represent the graph
    private final ArrayList<ArrayList<Integer>> adj;
    // Number of vertices in the graph
    private final int v;

    // Constructor to initialize the graph with the given number of vertices
    public Graph2(int v) {
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

    // Method to perform BFS traversal starting from vertex s
    public void BFS(int s) {
        boolean[] visited = new boolean[v]; // Array to track visited vertices
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
    // Method to print the adjacency list representation of the graph
    public void printAdjList() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " -> ");
            System.out.println(adj.get(i));
        }
    }
}

public class _03_BFSInUndirectedGraph {
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        Graph2 g = new Graph2(6);

        // Add edges between vertices
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(0,5);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(3,4);

        // Print the adjacency list of the graph
        System.out.println("Adjacency List of the graph:");
        g.printAdjList();
        System.out.println();

        // Perform BFS traversal starting from vertex 0
        System.out.println("Following is Breadth First Traversal starting from vertex 0:");
        g.BFS(1);
    }
}
