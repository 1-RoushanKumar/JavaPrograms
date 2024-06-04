package com.roushan._17_Graph;

import java.util.Stack;

// Class to represent a directed graph using adjacency matrix
class DirectedMatrix {
    int V;           // Number of vertices
    int[][] graph;   // Adjacency matrix

    // Constructor to initialize the graph with V vertices
    public DirectedMatrix(int v) {
        V = v;
        graph = new int[V][V];
    }

    // Method to add an edge from vertex i to vertex j
    public void addEdge(int i, int j) {
        graph[i][j] = 1;
    }

    // Method to transpose the graph
    public int[][] transPose() {
        int[][] newGraph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                newGraph[i][j] = graph[j][i];
            }
        }
        return newGraph;
    }
}

// Main class to find strongly connected components using Kosaraju's algorithm
public class _24_StronglyConnectedComponentsKosaRajuAlgo {
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        DirectedMatrix g = new DirectedMatrix(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(3, 4);

        // Find and print strongly connected components
        SCC(g.graph, g.V, g);
    }

    // Method to find and print all strongly connected components
    public static void SCC(int[][] graph, int V, DirectedMatrix g) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step 1: Fill the stack with vertices in the order of their finishing times
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillStack(graph, st, visited, i);
            }
        }

        // Step 2: Transpose the graph
        int[][] transposedGraph = g.transPose();

        // Step 3: Mark all vertices as not visited for the second DFS
        visited = new boolean[V];

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
    public static void fillStack(int[][] graph, Stack<Integer> st, boolean[] vi, int u) {
        vi[u] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[u][i] != 0 && !vi[i]) {
                fillStack(graph, st, vi, i);
            }
        }
        st.push(u);
    }

    // Helper method to perform DFS and print a strongly connected component
    public static void dfs(int[][] graph, boolean[] vi, int u) {
        vi[u] = true;
        System.out.print(u + " ");
        for (int i = 0; i < graph.length; i++) {
            if (graph[u][i] != 0 && !vi[i]) {
                dfs(graph, vi, i);
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
 * - This involves reversing the direction of each edge, which also takes O(V^2) time for adjacency matrix representation.
 *
 * Step 3: Performing DFS on the transposed graph
 * - This again involves visiting each vertex and exploring each edge, which takes O(V + E) time.
 *
 * Overall Time Complexity:
 * - For adjacency matrix representation, the time complexity is O(V^2) for transposing the graph,
 *   and O(V^2) for the DFS traversal. Thus, the overall time complexity is O(V^2).
 * - For adjacency list representation, the time complexity is O(V + E) for the entire algorithm.
 */
