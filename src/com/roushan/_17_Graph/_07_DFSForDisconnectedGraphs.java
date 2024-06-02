package com.roushan._17_Graph;

import java.util.ArrayList;

public class _07_DFSForDisconnectedGraphs {
    public static void main(String[] args) {
        // Create a graph with 9 vertices
        UndirectedList g = new UndirectedList(9);

        // Add edges to the first connected component
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);

        // Add edges to the second connected component
        g.addEdge(3, 4);

        // Add edges to the third connected component
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(5, 8);
        g.addEdge(6, 7);
        g.addEdge(8, 7);

        // Print the adjacency list of the graph
        System.out.println("Adjacency List of the Graph:");
        g.printAdjList();

        // Perform DFS traversal for the entire graph (including disconnected parts)
        System.out.println("\nDFS Traversal of the Graph:");
        DFS(g.adj, g.v);
    }

    // Method to initiate DFS traversal for a graph that may be disconnected
    public static void DFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v]; // Array to keep track of visited vertices

        // Traverse all vertices to ensure that we cover disconnected components
        for (int i = 0; i < v; i++) {
            if (!visited[i]) { // If the vertex is not visited
                DFSRec(adj, i, visited); // Call the recursive helper function
            }
        }
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
