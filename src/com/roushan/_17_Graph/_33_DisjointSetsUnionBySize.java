package com.roushan._17_Graph;

import java.util.ArrayList;
import java.util.List;

class DisjointSet2 {
    public List<Integer> size = new ArrayList<>();
    public List<Integer> parent = new ArrayList<>();

    // Constructor to initialize the Disjoint Set with n elements
    public DisjointSet2(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(1); // Initialize size of each set to 1
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

    // Union two sets by size
    public void UnionBySize(int u, int v) {
        int up_u = findUPar(u); // Find ultimate parent of u
        int up_v = findUPar(v); // Find ultimate parent of v

        if (up_u == up_v) {
            return; // If both have the same ultimate parent, they are already in the same set
        }

        // Union by size: attach the smaller tree under the larger tree
        if (size.get(up_u) < size.get(up_v)) {
            parent.set(up_u, up_v); // Make v the parent of u
            size.set(up_v, size.get(up_u) + size.get(up_v)); // Update the size of the new parent
        } else {
            parent.set(up_v, up_u); // Make u the parent of v
            size.set(up_u, size.get(up_u) + size.get(up_v)); // Update the size of the new parent
        }
    }
}

public class _33_DisjointSetsUnionBySize {
    public static void main(String[] args) {
        DisjointSet2 ds = new DisjointSet2(7); // Initialize Disjoint Set with 7 elements

        // Perform union operations
        ds.UnionBySize(1, 2);
        ds.UnionBySize(2, 3);
        ds.UnionBySize(4, 5);
        ds.UnionBySize(6, 7);
        ds.UnionBySize(5, 6);

        // Check if 3 and 7 are in the same set
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        // Union 3 and 7
        ds.UnionBySize(3, 7);

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
 *
 * - The `findUPar` operation has an amortized time complexity of O(α(n)),
 *   where α(n) is the inverse Ackermann function. This is due to the path
 *   compression optimization, which ensures that the tree remains flat.
 *
 * - The `UnionBySize` operation also has an amortized time complexity of
 *   O(α(n)), as it uses the size to keep the tree balanced and combines two trees.
 *
 * - The α(n) function grows extremely slowly, so for all practical purposes,
 *   the time complexity of both operations is nearly constant time, O(1).
 */
