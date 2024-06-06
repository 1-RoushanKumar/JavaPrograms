package com.roushan._17_Graph;

import java.util.ArrayList;
import java.util.Arrays;

// Class representing a graph
class Solution11 {
    public int V; // Number of vertices
    public ArrayList<ArrayList<Integer>> adj; // Adjacency list
    private int[] low; // Stores the lowest vertex id reachable from the subtree under vertex i
    private int[] disc; // Stores the discovery times of visited vertices
    private int time; // Stores the discovery time of vertices
    public boolean[] ap; // Stores the articulation points

    // Constructor
    Solution11(int v) {
        V = v;
        adj = new ArrayList<>(v); // Initialize the adjacency list
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
        ap = new boolean[V]; // Initialize the articulation points array
    }

    // Function to add an edge into the graph
    public void addEdge(int u, int v) {
        adj.get(u).add(v); // Add v to the adjacency list of u
        adj.get(v).add(u); // Add u to the adjacency list of v (since the graph is undirected)
    }

    // A function to perform DFS starting from vertex u
    void DFS(int u, int parent, boolean[] visited) {
        // Mark the current node as visited and update discovery time and low value
        visited[u] = true;
        disc[u] = low[u] = ++time;

        int children = 0;

        // Go through all vertices adjacent to this
        for (Integer v : adj.get(u)) {
            // If v is not visited yet, then make it a child of u in DFS tree and recur for it
            if (!visited[v]) {
                children++;
                DFS(v, u, visited);

                // Check if the subtree rooted with v has a connection to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // If u is an articulation point, mark it
                if (low[v] >= disc[u] && parent != -1) {
                    ap[u] = true;
                }
            } else if (v != parent) {
                // Update low value of u for parent function calls
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // If u is the root of DFS tree and has two or more children
        if (parent == -1 && children > 1) {
            ap[u] = true;
        }
    }

    // Function to find all articulation points
    void findArticulationPoint() {
        // Initialize parent and visited arrays
        boolean[] visited = new boolean[V];
        low = new int[V];
        Arrays.fill(low, -1);
        disc = new int[V];
        Arrays.fill(disc, -1);
        time = 0;

        // Call the recursive helper function to find articulation points in a DFS tree rooted with vertex 'i'
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                DFS(u, -1, visited);
            }
        }

        // Print articulation points
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.print(i + " ");
            }
        }
    }
}

public class _30_ArticulationPointUsingOptimalApproach {
    public static void main(String[] args) {
        System.out.println("Articulation Points are::");
        Solution11 g1 = new Solution11(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 4);
        g1.addEdge(0, 3);
        g1.addEdge(1, 2);
        g1.addEdge(3, 4);
        g1.findArticulationPoint();
    }
}
