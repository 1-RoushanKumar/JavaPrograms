package com.roushan._17_Graph;

import java.util.ArrayList;

public class _08_DFSCountConnectedComponent {
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
        int numConnectedComponents = DFS(g.adj, g.v);
        System.out.println("Number of Connected Components: " + numConnectedComponents);
    }

    // Method to initiate DFS traversal for a graph that may be disconnected
    public static int DFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v]; // Array to keep track of visited vertices
        int count = 0; // Counter for the number of connected components

        // Traverse all vertices to ensure that we cover disconnected components
        for (int i = 0; i < v; i++) {
            if (!visited[i]) { // If the vertex is not visited
                DFSRec(adj, i, visited); // Call the recursive helper function
                count++; // Increment the count of connected components
            }
        }

        return count; // Return the total number of connected components
    }

    // Recursive helper method for DFS traversal
    public static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true; // Mark the current vertex as visited

        // Recur for all the vertices adjacent to the current vertex
        for (int u : adj.get(s)) {
            if (!visited[u]) { // If the vertex is not visited
                DFSRec(adj, u, visited); // Recur for the adjacent vertex
            }
        }
    }
}
