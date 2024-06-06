package com.roushan._17_Graph;

import java.util.*;

class DisjointSet {
    // Lists to store rank and parent of each element
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    // Constructor to initialize the Disjoint Set with n elements
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0); // Initialize rank of each element to 0
            parent.add(i); // Initialize each element to be its own parent
        }
    }

    // Find the ultimate parent (representative) of the node with path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node; // If the node is its own parent, return the node
        }
        int ulp = findUPar(parent.get(node)); // Recursively find the ultimate parent
        parent.set(node, ulp); // Path compression: set the parent to the ultimate parent
        return parent.get(node); // Return the ultimate parent
    }

    // Union two sets by rank
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); // Find ultimate parent of u
        int ulp_v = findUPar(v); // Find ultimate parent of v

        if (ulp_u == ulp_v) return; // If both have the same ultimate parent, they are already in the same set

        // Union by rank: attach the smaller tree under the larger tree
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u); // If ranks are the same, make one the parent and increment its rank
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
}

public class _32_DisjointSetUnionByRank {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7); // Initialize Disjoint Set with 7 elements

        // Perform union operations
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // Check if 3 and 7 are in the same set
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        // Union 3 and 7
        ds.unionByRank(3, 7);

        // Check again if 3 and 7 are in the same set
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}

/*
 * Time Complexity:
 * - The `findUPar` operation has an amortized time complexity of O(α(n)),
 *   where α(n) is the inverse Ackermann function. This is due to the path
 *   compression optimization, which ensures that the tree remains flat.
 *
 * - The `unionByRank` operation also has an amortized time complexity of
 *   O(α(n)), as it uses the rank to keep the tree flat and combines two trees.
 *
 * - The α(n) function grows extremely slowly, so for all practical purposes,
 *   the time complexity of both operations is nearly constant time, O(1).
 */
