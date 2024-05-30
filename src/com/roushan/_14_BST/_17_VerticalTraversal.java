package com.roushan._14_BST;

import java.util.*;

// Main class for vertical traversal
public class _17_VerticalTraversal {

    // Helper class to store node and its horizontal distance
    static class pair {
        Node node;  // Tree node
        int hp;     // Horizontal distance (horizontal position)

        pair(Node n, int h) {
            node = n;
            hp = h;
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Creating the binary tree.
        //It works for all types of tree.
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(12);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        // Display the tree structure
        prettyDisplay(root, 0);
        System.out.println();

        // TreeMap to store the vertical order traversal
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticalOrder(root, map);

        // Printing the vertical order traversal
        for (Map.Entry<Integer, ArrayList<Integer>> p : map.entrySet()) {
            ArrayList<Integer> al = p.getValue();
            for (int x : al) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    // Method to perform vertical order traversal
    public static void verticalOrder(Node root, TreeMap<Integer, ArrayList<Integer>> map) {
        if (root == null) {
            return; // If the tree is empty, return
        }

        // Queue for level order traversal
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0)); // Start with the root node at horizontal distance 0

        while (!q.isEmpty()) {
            pair p = q.poll(); // Get the next node and its horizontal distance
            Node curr = p.node;
            int hp = p.hp;

            // Add the current node's value to the list at its horizontal distance
            if (map.containsKey(hp)) {
                map.get(hp).add(curr.value);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(curr.value);
                map.put(hp, al);
            }

            // Enqueue left child with horizontal distance hp - 1
            if (curr.left != null) {
                q.add(new pair(curr.left, hp - 1));
            }

            // Enqueue right child with horizontal distance hp + 1
            if (curr.right != null) {
                q.add(new pair(curr.right, hp + 1));
            }
        }
    }

    // Method to display the tree structure visually
    public static void prettyDisplay(Node node, int level) {
        if (node == null) {
            return; // If the node is null, return
        }
        prettyDisplay(node.right, level + 1); // Recur for right subtree

        // Print the current node after spaces proportional to its level
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1); // Recur for left subtree
    }
}
