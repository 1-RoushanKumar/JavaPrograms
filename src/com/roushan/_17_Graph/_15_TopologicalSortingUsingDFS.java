package com.roushan._17_Graph;

import java.util.ArrayList;
import java.util.Stack;

public class _15_TopologicalSortingUsingDFS {
    public static void main(String[] args) {
        DirectedList g = new DirectedList(5); // Create a directed graph with 5 vertices
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);

        g.printAdjList(); // Print the adjacency list of the graph

        // Perform topological sorting using DFS
        sort(g.adj, g.v);
    }

    /**
     * Method to perform topological sorting using DFS
     * @param adj Adjacency list of the graph
     * @param V Number of vertices in the graph
     */
    public static void sort(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V]; // Array to keep track of visited vertices
        Stack<Integer> stack = new Stack<>(); // Stack to store the topological sort order

        // Call the recursive helper method for all vertices
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(adj, i, stack, visited);
            }
        }

        // Print the contents of the stack which gives the topological order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    /**
     * Recursive helper method for DFS traversal
     * @param adj Adjacency list of the graph
     * @param u Current vertex
     * @param stack Stack to store the topological sort order
     * @param visited Array to keep track of visited vertices
     */
    public static void DFS(ArrayList<ArrayList<Integer>> adj, int u, Stack<Integer> stack, boolean[] visited) {
        visited[u] = true; // Mark the current vertex as visited

        // Recur for all adjacent vertices
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                DFS(adj, v, stack, visited);
            }
        }

        stack.push(u); // Push the current vertex to the stack after visiting all adjacent vertices
    }
}