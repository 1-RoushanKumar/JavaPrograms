package com.roushan._17_Graph;

import java.util.*;

class Solution1 {
    public int V; // Number of vertices
    public ArrayList<ArrayList<Integer>> adj; // Adjacency list
    private int[] low;
    private int[] disc;
    private int time;

    // Constructor
    Solution1(int v) {
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

    // A function to perform DFS starting from vertex u
    void DFS(int u, int parent, boolean[] visited, List<List<Integer>> bridges) {
        visited[u] = true;
        disc[u] = low[u] = time++;

        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                // Recursive DFS
                DFS(v, u, visited, bridges);
                // Update low value
                low[u] = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree under v
                // is below u in DFS tree, then u-v is a bridge
                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else if (v != parent) {
                // Update low value if v is visited and is not parent of u
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // Function to find all bridges
    List<List<Integer>> findBridges() {
        boolean[] visited = new boolean[V];
        low = new int[V];
        Arrays.fill(low, -1);
        disc = new int[V];
        Arrays.fill(disc, -1);
        time = 0;
        List<List<Integer>> bridges = new ArrayList<>();

        // DFS traversal to find bridges
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                DFS(u, -1, visited, bridges);
            }
        }

        return bridges;
    }
}

public class _28_BridgeInGraphOptimalApproach {
    public static void main(String[] args) {
        System.out.println("Bridges in first graph ");
        Solution1 g1 = new Solution1(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 3);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(3, 4);

        List<List<Integer>> bridges = g1.findBridges();
        for (List<Integer> bridge : bridges) {
            System.out.println(bridge.get(0) + " " + bridge.get(1));
        }
    }
}

/*
Time Complexity Analysis:
1. Constructing the graph: O(V)
2. Adding an edge: O(1)
3. DFS traversal: O(V + E) - where V is the number of vertices and E is the number of edges.
4. Finding bridges: O(V + E) - Tarjan's algorithm runs in linear time.
   So, the total time complexity for finding bridges is O(V + E).
*/

