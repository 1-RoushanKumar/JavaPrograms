package com.roushan._17_Graph;

import java.util.*;

class UndirectedList {
    // Adjacency list to represent the graph
    public ArrayList<ArrayList<Integer>> adj;
    // Number of vertices in the graph

    public int v;

    // Constructor to initialize the graph with the given number of vertices
    public UndirectedList(int v) {
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
            System.out.print(i + " -> "); // Print the vertex number
            System.out.println(adj.get(i)); // Print the adjacency list of the vertex
        }
    }
}

public class _06_DFSInUndirectedGraph {
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        UndirectedList g = new UndirectedList(6);

        // Add edges to the graph
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(0,5);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(3,4);

        // Print the adjacency list of the graph
        g.printAdjList();

        // Perform DFS traversal starting from vertex 0
        DFS(g.adj, g.v, 1);
    }

    // Method to initiate DFS traversal
    public static void DFS(ArrayList<ArrayList<Integer>> adj, int v, int s) {
        boolean[] visited = new boolean[v]; // Array to keep track of visited vertices
        DFSRec(adj, s, visited); // Call the recursive helper function
    }

    // Recursive helper method for DFS traversal
    public static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true; // Mark the current vertex as visited
        System.out.print(s + " "); // Print the current vertex

        // Recur for all the vertices adjacent to the current vertex
        for (int u : adj.get(s)) {
            if (!visited[u]) { // If the vertex is not visited
                DFSRec(adj, u, visited); // Recur for the adjacent vertex
            }
        }
    }
}
