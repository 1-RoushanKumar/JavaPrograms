package com.roushan._17_Graph;

import java.util.ArrayList;

public class _12_DetectCycleOfDirectedGraph {
    public static void main(String[] args) {
        DirectedList g = new DirectedList(6);
        g.addEdge(0, 1);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        g.printAdjList();
        boolean flag = detect(g.adj, g.v);
        System.out.println(flag);
    }

    // Method to detect a cycle in a directed graph
    public static boolean detect(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v]; // Array to keep track of visited vertices
        boolean[] recStack = new boolean[v]; // Array to keep track of vertices in the recursion stack

        // Traverse all vertices to ensure we cover disconnected components
        for (int i = 0; i < v; i++) {
            if (!visited[i]) { // If the vertex is not visited
                if (dfsRec(adj, i, visited, recStack)) { // Call the recursive DFS helper function
                    return true; // If a cycle is detected, return true
                }
            }
        }
        return false; // If no cycle is detected, return false
    }

    // Recursive helper method for DFS traversal to detect a cycle
    public static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recStack) {
        visited[s] = true; // Mark the current vertex as visited
        recStack[s] = true; // Add the current vertex to the recursion stack

        // Traverse all adjacent vertices of the current vertex
        for (int u : adj.get(s)) {
            if (!visited[u]) { // If the adjacent vertex is not visited
                if (dfsRec(adj, u, visited, recStack)) { // Recur for the adjacent vertex
                    return true; // If a cycle is detected, return true
                }
            } else if (recStack[u]) { // If the adjacent vertex is visited and is in the recursion stack
                return true; // A cycle is detected, return true
            }
        }
        recStack[s] = false; // Remove the vertex from the recursion stack before returning
        return false; // If no cycle is detected, return false
    }
}

// Supporting Graph class
class DirectedList {
    int v;
    ArrayList<ArrayList<Integer>> adj;

    DirectedList(int v) {
        this.v = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int src, int dest) {
        adj.get(src).add(dest);
    }

    void printAdjList() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + ": ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
