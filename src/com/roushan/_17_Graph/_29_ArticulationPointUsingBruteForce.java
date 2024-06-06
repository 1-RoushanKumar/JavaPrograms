package com.roushan._17_Graph;

import java.util.*;

// Class representing a graph
class Graph11 {
    public int V; // Number of vertices
    public ArrayList<ArrayList<Integer>> adj; // Adjacency list

    // Constructor
    Graph11(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w); // Add w to v's list
        adj.get(w).add(v); // Add v to w's list, since this is an undirected graph
    }

    // A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        for (Integer n : adj.get(v)) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // Returns true if given graph is connected, else false
    boolean isConnected() {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        int i;
        // Find a vertex with non-zero degree
        for (i = 0; i < V; i++)
            if (!adj.get(i).isEmpty())
                break;

        // If no edges in the graph, return true
        if (i == V)
            return true;

        // Start DFS traversal from a vertex with non-zero degree
        DFSUtil(i, visited);

        // Check if all non-zero degree vertices are visited
        for (i = 0; i < V; i++)
            if (!visited[i] && !adj.get(i).isEmpty())
                return false;

        return true;
    }

    // The function to print articulation points in given graph
    void articulationPoints() {
        // Initialize result
        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            // Backup the adjacency list of vertex i
            ArrayList<Integer> temp = adj.get(i);
            // Remove vertex i and its edges from graph
            adj.set(i, new ArrayList<>());

            // Check if graph remains connected (or this vertex is an AP)
            if (!isConnected()) {
                points.add(i);
            }

            // Restore the graph
            adj.set(i, temp);
        }

        // Print the articulation points
        System.out.println("Articulation Points: " + points);
    }
}

public class _29_ArticulationPointUsingBruteForce {
    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph11 g1 = new Graph11(7);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(4, 6);
        g1.addEdge(5, 6);
        g1.articulationPoints();
    }
}
