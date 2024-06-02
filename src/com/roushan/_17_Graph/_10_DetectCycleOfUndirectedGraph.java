package com.roushan._17_Graph;

import java.util.ArrayList;

public class _10_DetectCycleOfUndirectedGraph {
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
        boolean hasCycle = detect(g.adj, g.v);
        System.out.println("\nCycle detected: " + hasCycle);
    }

    // Method to detect a cycle in an undirected graph
    public static boolean detect(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v]; // Array to keep track of visited vertices

        // Traverse all vertices to ensure we cover disconnected components
        for (int i = 0; i < v; i++) {
            if (!visited[i]) { // If the vertex is not visited
                if (dfsRec(adj, i, visited, -1)) { // Call the recursive DFS helper function
                    return true; // If a cycle is detected, return true
                }
            }
        }
        return false; // If no cycle is detected, return false
    }

    // Recursive helper method for DFS traversal to detect a cycle
    public static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int parent) {
        visited[s] = true; // Mark the current vertex as visited

        // Traverse all adjacent vertices of the current vertex
        for (int u : adj.get(s)) {
            if (!visited[u]) { // If the adjacent vertex is not visited
                if (dfsRec(adj, u, visited, s)) { // Recur for the adjacent vertex
                    return true; // If a cycle is detected, return true
                }
            } else if (u != parent) { // If the adjacent vertex is visited and is not the parent
                return true; // A cycle is detected, return true
            }
        }
        return false; // If no cycle is detected, return false
    }
}

/*
 * Time Complexity Analysis:
 * - Initializing the graph and adjacency list takes O(V) time, where V is the number of vertices.
 * - Adding edges takes O(E) time, where E is the number of edges.
 * - The DFS traversal:
 *   - Each vertex is visited once, taking O(V) time.
 *   - For each vertex, we check all its adjacent vertices. The total number of operations for all vertices is O(E).
 * - Therefore, the overall time complexity of the DFS traversal to detect a cycle is O(V + E).
 * - The space complexity is O(V) for the visited array and the recursion stack.
 */
