package com.roushan._17_Graph;

import java.util.*;

class Graph77 {
    public int V;   // No. of vertices
    public ArrayList<ArrayList<Integer>> adj; //Adjacency List
    public int time = 0;//timer

    //Constructor
    Graph77(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w);  // Add w to v's list.
    }

    // A recursive function that finds and prints strongly connected
    // components using DFS traversal
    // u --> The vertex to be visited next
    // disc[] --> Stores discovery times of visited vertices
    // low[] -- >> earliest visited vertex (the vertex with minimum
    //             discovery time) that can be reached from subtree
    //             rooted with current vertex
    // *st -- >> To store all the connected ancestors (could be part
    //           of SCC)
    // stackMember[] --> bit/index array for faster check whether
    //                  a node is in stack
    void DfsSCC(int u, int[] low, int[] disc, boolean[] stackMember, Stack<Integer> st) {
        // Initialize discovery time and low value
        disc[u] = time;
        low[u] = time;
        time += 1;
        stackMember[u] = true;
        st.push(u);

        // Go through all vertices adjacent to this
        for (int v : adj.get(u)) {
            // If v is not visited yet, then recur for it
            if (disc[v] == -1) {
                DfsSCC(v, low, disc, stackMember, st);
                //this will update the vertex of the treeEdge.
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                // Update low value of 'u' only if 'v' is still in stack
                // (i.e., it's a back edge, not cross edge).
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // head node found, pop the stack and print an SCC
        if (low[u] == disc[u]) {
            //after popping making stackMember[u] again false which point that vertex is no longer in stack.
            stackMember[u] = false;
            int ans = st.pop();
            System.out.print(ans + " ");
            while (ans != u) {
                ans = st.pop();
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }

    // The function to do DFS traversal. It uses recursive SCCUtil()
    void SCC() {
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] stackMember = new boolean[V];  //for representing, which vertex is in stack.
        Stack<Integer> st = new Stack<>();

        // Initialize disc and low, and stackMember arrays
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        // Call the recursive helper function to find strongly
        // connected components in a DFS tree with vertex 'i'
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {   //instead of using visited, we're using disc[i] for checking the vertex are visited or not.
                DfsSCC(i, low, disc, stackMember, st);
            }
        }
    }
}

public class _31_StronglyConnectedComponentsUsingTarjanAlgo {
    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph77 g = new Graph77(8);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 0);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 7);
        System.out.println("Strongly Connected Components in the given graph:");
        g.SCC();
    }
}

