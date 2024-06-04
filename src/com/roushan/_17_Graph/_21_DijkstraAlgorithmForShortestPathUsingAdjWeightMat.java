package com.roushan._17_Graph;

import java.util.Arrays;

public class _21_DijkstraAlgorithmForShortestPathUsingAdjWeightMat {
    public static void main(String[] args) {
        // Create a graph with 9 vertices
        WeightedAdjMatrix g = new WeightedAdjMatrix(9);

        // Add weighted edges to the graph
        g.addWeightedEdge(0, 1, 4);
        g.addWeightedEdge(0, 2, 8);
        g.addWeightedEdge(1, 2, 11);
        g.addWeightedEdge(1, 3, 8);
        g.addWeightedEdge(2, 4, 7);
        g.addWeightedEdge(2, 5, 1);
        g.addWeightedEdge(3, 4, 2);
        g.addWeightedEdge(3, 6, 7);
        g.addWeightedEdge(3, 7, 4);
        g.addWeightedEdge(4, 5, 6);
        g.addWeightedEdge(5, 7, 2);
        g.addWeightedEdge(6, 7, 14);
        g.addWeightedEdge(6, 8, 9);
        g.addWeightedEdge(7, 8, 10);

        // Print the adjacency matrix representation of the graph
        g.printAdjMatrix();

        // Find the shortest path from vertex 0 to all other vertices using Dijkstra's algorithm
        int[] ans = dijkstra(g.Graph, 0);

        // Print the shortest path distances
        System.out.println(Arrays.toString(ans));
    }

    /**
     * Dijkstra's algorithm to find the shortest path from a source vertex to all other vertices
     * in a graph represented by an adjacency matrix.
     *
     * @param graph The adjacency matrix representation of the graph
     * @param src The source vertex
     * @return The array containing the shortest distance from the source to each vertex
     */
    public static int[] dijkstra(int[][] graph, int src) {
        int V = graph.length; // Number of vertices in the graph
        int[] dis = new int[V]; // Array to store the shortest distance from source to each vertex
        Arrays.fill(dis, Integer.MAX_VALUE); // Initialize all distances as infinite
        dis[src] = 0; // Distance from source to itself is 0

        boolean[] fix = new boolean[V]; // Boolean array to track fixed vertices

        // Iterate over all vertices to find the shortest path
        for (int i = 0; i < V - 1; i++) {
            int u = -1;

            // Find the vertex with the smallest distance that is not yet fixed
            for (int j = 0; j < V; j++) {
                if (!fix[j] && (u == -1 || dis[j] < dis[u])) {
                    u = j;
                }
            }

            // Mark the selected vertex as fixed
            fix[u] = true;

            // Update the distance value of the adjacent vertices of the selected vertex
            for (int k = 0; k < V; k++) {
                if (graph[u][k] != 0 && !fix[k]) {
                    dis[k] = Math.min(dis[k], dis[u] + graph[u][k]);
                }
            }
        }

        return dis; // Return the array containing the shortest distances from the source
    }
}

/*
 * Time Complexity Analysis:
 * The time complexity of Dijkstra's algorithm in this implementation (using an adjacency matrix) is O(V^2), where V is the number of vertices in the graph.
 * - The outer loop runs V-1 times, which is O(V).
 * - Inside the outer loop:
 *   - Finding the vertex u with the minimum distance that is not yet fixed takes O(V) time.
 *   - Updating the distance values of the adjacent vertices of u takes O(V) time in the worst case.
 * Hence, the overall time complexity is O(V) * O(V) = O(V^2).
 */
