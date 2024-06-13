package com.roushan._17_Graph;

import java.util.*;

// Disjoint Set data structure for Union-Find operations
class DisjointSet3 {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    // Constructor to initialize disjoint set with n elements
    public DisjointSet3(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    // Function to find the parent of a node with path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    // Function to perform union operation by rank
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
}

// Edge class representing an edge in the graph
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Constructor to initialize an edge with source, destination, and weight
    Edge(int _src, int _dest, int _wt) {
        this.src = _src;
        this.dest = _dest;
        this.weight = _wt;
    }

    // Comparator function used for sorting edges based on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

// Class implementing Kruskal's algorithm to find Minimum Spanning Tree
class Solution3 {
    // Function to find the sum of weights of edges of the Minimum Spanning Tree
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>();

        // Construct a list of edges from the adjacency list representation of the graph
        // O(N + E)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                Edge temp = new Edge(i, adjNode, wt);
                edges.add(temp);
            }
        }

        DisjointSet3 ds = new DisjointSet3(V);

        // Sort the edges by weight
        Collections.sort(edges); // O(M log M)

        int mstWt = 0;
        // Process each edge in ascending order of weight
        // M x 4 x alpha x 2
        for (Edge edge : edges) {
            int wt = edge.weight;
            int u = edge.src;
            int v = edge.dest;

            // Check if adding this edge creates a cycle in the MST
            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt; // Add the weight of the edge to the MST weight
                ds.unionByRank(u, v); // Union the sets of vertices connected by this edge
            }
        }

        return mstWt;
    }
}

public class _34_MinimumSpanningTreeUsingKruskalAlgo {
    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>(); // Adjacency list representation of the graph
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}}; // Edges of the graph

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<>();
            ArrayList<Integer> tmp2 = new ArrayList<>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        // Find the sum of weights of edges of the Minimum Spanning Tree using Kruskal's algorithm
        int mstWt = Solution3.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + mstWt);
    }
}
// Time Complexity Analysis:
// The overall time complexity of the Kruskal's algorithm is O(M log M + M * alpha(N)),
// where M is the number of edges and N is the number of vertices in the graph.
// O(M log M) for sorting the edges by weight.
// O(M * alpha(N)) for performing the disjoint set operations, where alpha(N) is the inverse Ackermann function,
// which is very slow-growing and practically considered as constant for all practical values of N.
