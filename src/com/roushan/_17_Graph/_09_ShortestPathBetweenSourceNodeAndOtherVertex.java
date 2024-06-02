package com.roushan._17_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _09_ShortestPathBetweenSourceNodeAndOtherVertex {
    public static void main(String[] args) {
        // Create a graph with 4 vertices
        UndirectedList g = new UndirectedList(4);

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        // Print the adjacency list of the graph
        System.out.println("Adjacency List of the Graph:");
        g.printAdjList();

        // Perform BFS to find the shortest path from source vertex 0
        System.out.println("\nShortest path from source vertex 0 to all other vertices:");
        bfsShort(g.adj, g.v, 0);
    }

    // Method to initiate BFS and find the shortest path from the source vertex
    public static void bfsShort(ArrayList<ArrayList<Integer>> adj, int v, int source) {
        int[] distance = new int[v]; // Array to store the shortest distance from the source vertex to each vertex
        bfs(adj, v, distance, source); // Call the BFS method to compute the distances
    }

    // BFS method to compute the shortest path from the source vertex
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int v, int[] dis, int s) {
        boolean[] visited = new boolean[v]; // Array to keep track of visited vertices
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS

        // Initialize the source vertex
        q.add(s); // Enqueue the source vertex
        dis[s] = 0; // The Distance from the source to itself is 0
        visited[s] = true; // Mark the source vertex as visited

        // Perform BFS
        while (!q.isEmpty()) {
            int u = q.poll(); // Dequeue a vertex from the queue
            // Traverse all adjacent vertices of the dequeued vertex
            for (int vertex : adj.get(u)) {
                if (!visited[vertex]) { // If the vertex is not visited
                    dis[vertex] = dis[u] + 1; // Update the distance to the adjacent vertex
                    visited[vertex] = true; // Mark the adjacent vertex as visited
                    q.add(vertex); // Enqueue the adjacent vertex
                }
            }
        }

        // Print the shortest distance from the source vertex to each vertex
        System.out.println("Distances: " + Arrays.toString(dis));
    }
}

/*
 * Time Complexity Analysis:
 * - Initializing the graph and adjacency list takes O(V) time, where V is the number of vertices.
 * - Adding edges takes O(E) time, where E is the number of edges.
 * - The BFS traversal:
 *   - Each vertex is enqueued and dequeued exactly once, taking O(V) time.
 *   - For each vertex, we check all its adjacent vertices. The total number of operations for all vertices is O(E).
 * - Therefore, the overall time complexity of the BFS traversal is O(V + E).
 * - The space complexity is O(V) for the distance and visited arrays and the queue.
 */
