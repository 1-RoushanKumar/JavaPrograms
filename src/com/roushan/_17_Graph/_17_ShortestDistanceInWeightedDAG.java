package com.roushan._17_Graph;

import java.util.Arrays;
import java.util.Stack;

public class _17_ShortestDistanceInWeightedDAG {
    public static void main(String[] args) {
        DirectedListWeighted g = new DirectedListWeighted(6);

        // Adding edges to the graph
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 6);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 5, 4);
        g.addEdge(5, 3, 1);

        // Print the adjacency list of the graph
        g.printAdjList();

        // Find the shortest paths from vertex 0
        shortestPath(0, g);
    }

    // Utility function to perform topological sort
    public static void topologicalSortUtil(int v, Boolean[] visited, Stack<Integer> stack, DirectedListWeighted graph) {
        // Mark the current node as visited
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        for (DirectedListWeighted.Pair pair : graph.adj.get(v)) {
            if (!visited[pair.dest]) {
                topologicalSortUtil(pair.dest, visited, stack, graph);
            }
        }

        // Push the current vertex to stack which stores the result
        stack.push(v);
    }

    // Function to find the shortest path in a weighted DAG
    public static void shortestPath(int s, DirectedListWeighted graph) {
        Stack<Integer> stack = new Stack<>();
        int V = graph.v; // Number of vertices
        int[] dist = new int[V]; // Array to store the shortest distance to each vertex

        // Initialize all vertices as not visited
        Boolean[] visited = new Boolean[V];
        Arrays.fill(visited, false);

        // Perform topological sort for all vertices
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack, graph);
            }
        }

        // Initialize distances to all vertices as infinite and distance to source as 0
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[s] = 0;

        // Process vertices in topological order
        while (!stack.empty()) {
            int u = stack.pop();

            // Update distances of all adjacent vertices of u
            if (dist[u] != Integer.MAX_VALUE) {
                for (DirectedListWeighted.Pair pair : graph.adj.get(u)) {
                    if (dist[pair.dest] > dist[u] + pair.weight) {
                        dist[pair.dest] = dist[u] + pair.weight;
                    }
                }
            }
        }

        // Print the calculated shortest distances
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
    }
}
