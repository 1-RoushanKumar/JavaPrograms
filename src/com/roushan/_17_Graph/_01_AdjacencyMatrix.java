package com.roushan._17_Graph;

import java.util.Arrays;

class Graph {
    // Adjacency matrix to store graph edges
    public int[][] adjMatrix;
    // Number of vertices in the graph
    public int noOfVertices;

    // Constructor to initialize the graph with a given number of vertices
    public Graph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjMatrix = new int[noOfVertices][noOfVertices]; // Initialize adjacency matrix with zeros
    }

    // Method to print the adjacency matrix
    public void printAdjMatrix() {
        // Iterate through each vertex
        for (int i = 0; i < noOfVertices; i++) {
            System.out.print(i + " -> ");
            // Print the adjacency matrix row corresponding to vertex 'i'
            System.out.println(Arrays.toString(adjMatrix[i]));
        }
    }

    // Method to add an edge between two vertices
    public void addEdge(int i, int j) {
        // Check if the vertex indices are within bounds
        if (i >= noOfVertices || j >= noOfVertices) {
            System.out.println("Vertex does not exist!");
            return; // Exit the method if indices are invalid
        }

        // Check if the edge is connecting a vertex to itself
        if (i == j) {
            System.out.println("Same Vertex!");
            return; // Exit the method if trying to connect a vertex to itself
        }

        // Add the edge by setting the corresponding matrix entries to 1
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1; // Since the graph is undirected, set both entries
    }

    // Method to remove an edge between two vertices
    public void removeEdge(int i, int j) {
        // Set the corresponding matrix entries to 0 to remove the edge
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0; // Since the graph is undirected, set both entries
    }

    // Method to add a new vertex to the graph
    public void addVertex() {
        // Create a new adjacency matrix with one additional row and column
        int[][] newAdjMatrix = new int[noOfVertices + 1][noOfVertices + 1];

        // Copy the existing entries to the new matrix
        for (int i = 0; i < noOfVertices; i++) {
            for (int j = 0; j < noOfVertices; j++) {
                newAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }

        // Update the adjacency matrix to the new matrix and increment vertex count
        adjMatrix = newAdjMatrix;
        noOfVertices++;
    }

    // Alternative method to remove a vertex from the graph
    public void removeVertex(int v) {
        // Check if the vertex index is within bounds
        if (v < 0 || v >= noOfVertices) {
            System.out.println("Vertex does not exist!");
            return;
        }

        // Create a new adjacency matrix with one less row and column
        int[][] newAdjMatrix = new int[noOfVertices - 1][noOfVertices - 1];

        // Copy the existing entries to the new matrix, skipping the row and column of the removed vertex
        for (int i = 0, new_i = 0; i < noOfVertices; i++) {
            // Skip the row corresponding to the removed vertex
            if (i == v) continue;
            for (int j = 0, new_j = 0; j < noOfVertices; j++) {
                // Skip the column corresponding to the removed vertex
                if (j == v) continue;
                // Copy the value from the old matrix to the new matrix
                newAdjMatrix[new_i][new_j] = adjMatrix[i][j];
                new_j++;
            }
            new_i++;
        }
        /*
        Here new_i and new_j is index for newAdjMatrix.
         Update the adjacency matrix to the new matrix and decrement vertex count
        */
        adjMatrix = newAdjMatrix;
        noOfVertices--;
    }
}

public class _01_AdjacencyMatrix {
    public static void main(String[] args) {
        // Create a graph with 4 vertices
        Graph g = new Graph(5);

        // Add edges between the vertices
        g.addEdge(0, 1); // Add edge between vertex 0 and 1
        g.addEdge(0, 3); // Add edge between vertex 0 and 3
        g.addEdge(1, 2); // Add edge between vertex 1 and 2
        g.addEdge(1, 3); // Add edge between vertex 2 and 3
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        // Print the adjacency matrix
        System.out.println("Adjacency Matrix after adding edges:");
        g.printAdjMatrix();
        System.out.println();

        // Remove some edges
        g.removeEdge(0, 1); // Remove edge between vertex 0 and 1

        // Print the adjacency matrix after removing edges
        System.out.println("Adjacency Matrix after removing edges:");
        g.printAdjMatrix();
        System.out.println();

        // Add a new vertex
        g.addVertex(); // Adds a new vertex 5

        // Add edges to the new vertex
        g.addEdge(0, 5);
        g.addEdge(3, 5);

        // Print the adjacency matrix after adding the new vertex and edges
        System.out.println("Adjacency Matrix after adding a new vertex and edges:");
        g.printAdjMatrix();
        System.out.println();

        // Remove a vertex
        g.removeVertex(2); // Remove vertex 2 from the graph

        // Print the adjacency matrix after removing the vertex
        System.out.println("Adjacency Matrix after removing vertex 2:");
        g.printAdjMatrix();
    }
}
