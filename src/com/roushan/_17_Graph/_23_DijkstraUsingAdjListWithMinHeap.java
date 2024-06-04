package com.roushan._17_Graph;

import java.util.*;

public class _23_DijkstraUsingAdjListWithMinHeap {
    public static void main(String[] args) {
        // Create a graph with 9 vertices
        WeightedAdjList g = new WeightedAdjList(9);

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

        // Print the adjacency list representation of the graph
        g.printAdjList();

        // Find the shortest path from vertex 0 to all other vertices using Dijkstra's algorithm
        int[] ans = dijkstra(g.adj, 0);

        // Print the shortest path distances
        System.out.println(Arrays.toString(ans));
    }

    /**
     * Dijkstra's algorithm to find the shortest path from a source vertex to all other vertices
     * in a graph represented by an adjacency list.
     *
     * @param adj The adjacency list representation of the graph
     * @param src The source vertex
     * @return The array containing the shortest distance from the source to each vertex
     */
    public static int[] dijkstra(List<List<Pair>> adj, int src) {
        int V = adj.size(); // Number of vertices in the graph
        int[] dis = new int[V]; // Array to store the shortest distance from source to each vertex
        Arrays.fill(dis, Integer.MAX_VALUE); // Initialize all distances as infinite
        dis[src] = 0; // Distance from source to itself is 0

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight)); // Priority queue for tracking the minimum edge weight
        pq.add(new Pair(src, 0)); // Start from the source vertex

        while (!pq.isEmpty()) {
            Pair minPair = pq.poll();
            int u = minPair.vertex;
            int distU = minPair.weight;

            // If we have already processed this vertex, skip
            if (distU > dis[u]) continue;

            // Update the distance value of the adjacent vertices of the selected vertex
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;
                int newDist = distU + weight;
                if (newDist < dis[v]) { // If the new distance is smaller than the current distance
                    dis[v] = newDist;
                    pq.add(new Pair(v, newDist));
                }
            }
        }
        return dis; // Return the array containing the shortest distances from the source
    }
}
// Time complexity of Dijkstra's algorithm with adjacency list and min-heap: O((V + E) log V)

// Explanation of time complexity:
// - The while loop runs at most V times, each time extracting the minimum element from the priority queue,
//   which takes O(log V) time.
// - Inside the while loop, we iterate over all adjacent vertices of the selected vertex, resulting in a time complexity of O(E).
// - Therefore, the overall time complexity is O((V + E) log V).
