package com.roushan._17_Graph;

import java.util.*;

class BellmanFord {
    // Inner class to represent edges
    static class Edge {
        int source, destination, weight;

        Edge() {
            source = destination = weight = 0;
        }
    }
    int V, E; // Number of vertices and edges
    Edge[] edge; // Array to store edges

    // Constructor to initialize the graph with given number of vertices and edges
    BellmanFord(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e]; // Initialize the edge array
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge(); // Initialize each edge
    }
    // Method to perform Bellman-Ford algorithm
    void bellmanFord(int src) {
        int[] dist = new int[V]; // Array to store shortest distances from source
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances to infinity
        dist[src] = 0; // Distance from source to itself is 0

        // Relax all edges V-1 times
        for (int i = 1; i < V; ++i) {
            // Iterate over all edges
            for (int j = 0; j < E; ++j) {
                int u = edge[j].source;
                int v = edge[j].destination;
                int weight = edge[j].weight;
                // Relax the edge
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Check for negative weight cycles
        for (int j = 0; j < E; ++j) {
            int u = edge[j].source;
            int v = edge[j].destination;
            int weight = edge[j].weight;
            // If relaxation is possible, it means negative weight cycle exists
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print shortest distances from source
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
}

public class _26_BellManFordAlgorithmForShortestPath {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 8; // Number of edges
        BellmanFord graph = new BellmanFord(V, E); // Create a graph object

        // Define edges
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = -1;

        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 4;

        graph.edge[2].source = 1;
        graph.edge[2].destination = 2;
        graph.edge[2].weight = 3;

        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 2;

        graph.edge[4].source = 1;
        graph.edge[4].destination = 4;
        graph.edge[4].weight = 2;

        graph.edge[5].source = 3;
        graph.edge[5].destination = 2;
        graph.edge[5].weight = 5;

        graph.edge[6].source = 3;
        graph.edge[6].destination = 1;
        graph.edge[6].weight = 1;

        graph.edge[7].source = 4;
        graph.edge[7].destination = 3;
        graph.edge[7].weight = -3;

        // Perform Bellman-Ford algorithm with source vertex 0
        graph.bellmanFord(0);
    }
}

