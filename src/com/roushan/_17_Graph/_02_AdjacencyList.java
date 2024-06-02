package com.roushan._17_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graph1 {
    // List of lists to represent the adjacency list
    private final List<List<Integer>> adjList;
    // Number of vertices in the graph
    private int noOfVertices;

    // Constructor to initialize the graph with a given number of vertices
    public Graph1(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjList = new ArrayList<>(noOfVertices); // Initialize adjacency list
        for (int i = 0; i < noOfVertices; i++) {
            adjList.add(new LinkedList<>()); // Create a new list for each vertex
        }
    }

    // Getter for the number of vertices
    public int getNoOfVertices() {
        return noOfVertices;
    }

    // Getter for the adjacency list
    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    // Method to print the adjacency list
    public void printAdjList() {
        for (int i = 0; i < noOfVertices; i++) {
            System.out.print(i + " -> ");
            System.out.println(adjList.get(i)); // Print the adjacency list for vertex 'i'
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

        // Add the edge by adding 'j' to the list of 'i' and 'i' to the list of 'j'
        adjList.get(i).add(j);
        adjList.get(j).add(i); // Since the graph is undirected
    }

    // Method to remove an edge between two vertices
    public void removeEdge(int i, int j) {
        // Check if the vertex indices are within bounds
        if (i >= noOfVertices || j >= noOfVertices) {
            System.out.println("Vertex does not exist!");
            return; // Exit the method if indices are invalid
        }

        // Remove the edge by removing 'j' from the list of 'i' and 'i' from the list of 'j'
        adjList.get(i).remove(Integer.valueOf(j));
        adjList.get(j).remove(Integer.valueOf(i)); // Since the graph is undirected
    }

    // Method to add a new vertex to the graph
    public void addVertex() {
        // Add a new list for the new vertex
        adjList.add(new LinkedList<>());
        noOfVertices++; // Increment the vertex count
    }

    // Method to remove a vertex from the graph
    public void removeVertex(int v) {
        // Check if the vertex index is within bounds
        if (v < 0 || v >= noOfVertices) {
            System.out.println("Vertex does not exist!");
            return;
        }

        // Remove all edges associated with the vertex 'v'
        for (int i = 0; i < noOfVertices; i++) {
            adjList.get(i).remove(Integer.valueOf(v));
        }

        // Remove the adjacency list of the vertex 'v'
        adjList.remove(v);

        // Decrement the vertex count
        noOfVertices--;

        // Adjust the remaining adjacency lists to account for the removed vertex
        for (int i = 0; i < noOfVertices; i++) {
            List<Integer> newList = new LinkedList<>();
            for (int adj : adjList.get(i)) {
                if (adj > v) {
                    newList.add(adj - 1);
                } else {
                    newList.add(adj);
                }
            }
            adjList.set(i, newList);
        }
    }
}

public class _02_AdjacencyList {
    public static void main(String[] args) {
        // Create a graph with 4 vertices
        Graph1 g = new Graph1(4);

        // Add edges between the vertices
        g.addEdge(0, 1); // Add edge between vertex 0 and 1
        g.addEdge(0, 3); // Add edge between vertex 0 and 3
        g.addEdge(1, 2); // Add edge between vertex 1 and 2
        g.addEdge(2, 3); // Add edge between vertex 2 and 3

        // Print the adjacency list
        System.out.println("Adjacency List after adding edges:");
        g.printAdjList();
        System.out.println();

        // Remove some edges
        g.removeEdge(0, 1); // Remove edge between vertex 0 and 1
        g.removeEdge(2, 3); // Remove edge between vertex 2 and 3

        // Print the adjacency list after removing edges
        System.out.println("Adjacency List after removing edges:");
        g.printAdjList();
        System.out.println();

        // Add a new vertex
        g.addVertex(); // Adds a new vertex 4

        // Add edges to the new vertex
        g.addEdge(3, 4); // Add edge between vertex 3 and 4
        g.addEdge(2, 4); // Add edge between vertex 2 and 4

        // Print the adjacency list after adding the new vertex and edges
        System.out.println("Adjacency List after adding a new vertex and edges:");
        g.printAdjList();
        System.out.println();

        // Remove a vertex
        g.removeVertex(2); // Remove vertex 2 from the graph

        // Print the adjacency list after removing the vertex
        System.out.println("Adjacency List after removing vertex 2:");
        g.printAdjList();
        System.out.println("Number of vertices: " + g.getNoOfVertices()); // Print the current number of vertices
    }
}
