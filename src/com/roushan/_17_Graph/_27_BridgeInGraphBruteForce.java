package com.roushan._17_Graph;

import java.util.*;

class Solution {
    public int V; // Number of vertices
    public ArrayList<ArrayList<Integer>> adj; // Adjacency list

    // Constructor
    Solution(int v) {
        V = v;
        adj = new ArrayList<>(v); // Initialize the adjacency list
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    // Function to add an edge into the graph
    public void addEdge(int u, int v) {
        adj.get(u).add(v); // Add v to the adjacency list of u
        adj.get(v).add(u); // Add u to the adjacency list of v (since the graph is undirected)
    }

    // Function to remove an edge from the graph
    void removeEdge(int v, int w) {
        adj.get(v).remove(Integer.valueOf(w));
        adj.get(w).remove(Integer.valueOf(v)); // Graph is undirected
    }

    // A function to perform DFS starting from vertex v
    void DFS(int s, boolean[] visited) {
        visited[s] = true;
        for (Integer i : adj.get(s)) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
    }

    // Function to check if the graph is connected
    boolean isConnected() {
        boolean[] visited = new boolean[V];

        int i = 0;
        DFS(i, visited);

        for (i = 0; i < V; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    // Function to find all bridges
    void findBridges() {
        for (int v = 0; v < V; v++) {
            for (int i = 0; i < adj.get(v).size(); i++) {
                int w = adj.get(v).getFirst();

                if (w > v) { // Consider the edge only if the destination vertex is greater than the source vertex
                    removeEdge(v, w); // Remove the edge

                    if (!isConnected()) {
                        System.out.println(v + " " + w);
                    }
                    addEdge(v, w);
                }
            }
        }
    }
}

public class _27_BridgeInGraphBruteForce {
    public static void main(String[] args) {
        System.out.println("Bridges in first graph ");
        Solution g1 = new Solution(12);
        g1.addEdge(0, 1);
        g1.addEdge(0, 3);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        g1.addEdge(4, 5);
        g1.addEdge(5, 6);
        g1.addEdge(5, 8);
        g1.addEdge(6, 7);
        g1.addEdge(7, 8);
        g1.addEdge(7, 9);
        g1.addEdge(9, 10);
        g1.addEdge(9, 11);
        g1.addEdge(10, 11);
        g1.findBridges();
    }
}

/*
Time Complexity Analysis:
1. Constructing the graph: O(V)
2. Adding an edge: O(1)
3. Removing an edge: O(V) - In the worst case, it might have to search the entire adjacency list to find the edge to remove.
4. DFS to check connectivity: O(V + E) - where V is the number of vertices and E is the number of edges.
5. Finding bridges: O(V * (V + E)) - In the worst case, for each vertex, we perform a DFS to check connectivity
 */
