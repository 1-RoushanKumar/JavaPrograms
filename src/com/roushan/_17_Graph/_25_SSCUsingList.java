package com.roushan._17_Graph;

import java.util.*;

class DirectedList2 {
    int V;                   // Number of vertices
    List<List<Integer>> graph;  // Adjacency list

    // Constructor to initialize the graph with V vertices
    public DirectedList2(int v) {
        V = v;
        graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
    }

    // Method to add an edge from vertex i to vertex j
    public void addEdge(int i, int j) {
        graph.get(i).add(j);
    }

    // Method to transpose the graph
    public DirectedList2 transpose() {
        DirectedList2 newGraph = new DirectedList2(V);
        for (int i = 0; i < V; i++) {
            for (int j : graph.get(i)) {
                newGraph.addEdge(j, i);
            }
        }
        return newGraph;
    }
}

public class _25_SSCUsingList {
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        DirectedList2 g = new DirectedList2(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(3, 4);

        // Find and print strongly connected components
        SCC(g);
    }

    // Method to find and print all strongly connected components
    public static void SCC(DirectedList2 g) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[g.V];

        // Step 1: Fill the stack with vertices in the order of their finishing times
        for (int i = 0; i < g.V; i++) {
            if (!visited[i]) {
                fillStack(g, st, visited, i);
            }
        }

        // Step 2: Transpose the graph
        DirectedList2 transposedGraph = g.transpose();

        // Step 3: Mark all vertices as not visited for the second DFS
        visited = new boolean[g.V];

        // Step 4: Process all vertices in the order defined by the stack
        while (!st.isEmpty()) {
            int k = st.pop();
            if (!visited[k]) {
                dfs(transposedGraph, visited, k);
                System.out.println();
            }
        }
    }

    // Helper method to perform DFS and fill the stack with finishing times
    public static void fillStack(DirectedList2 g, Stack<Integer> st, boolean[] vi, int u) {
        vi[u] = true;
        for (int i : g.graph.get(u)) {
            if (!vi[i]) {
                fillStack(g, st, vi, i);
            }
        }
        st.push(u);
    }

    // Helper method to perform DFS and print a strongly connected component
    public static void dfs(DirectedList2 g, boolean[] vi, int u) {
        vi[u] = true;
        System.out.print(u + " ");
        for (int i : g.graph.get(u)) {
            if (!vi[i]) {
                dfs(g, vi, i);
            }
        }
    }
}

/*
 * Time Complexity Analysis:
 *
 * Step 1: Filling the stack with vertices based on their finishing times in the first DFS
 * - This requires visiting each vertex and exploring each edge, which takes O(V + E) time.
 *
 * Step 2: Transposing the graph
 * - This involves reversing the direction of each edge, which takes O(V + E) time.
 *
 * Step 3: Performing DFS on the transposed graph
 * - This again involves visiting each vertex and exploring each edge, which takes O(V + E) time.
 *
 * Overall Time Complexity:
 * - For adjacency list representation, the time complexity is O(V + E) for the entire algorithm.
 */

