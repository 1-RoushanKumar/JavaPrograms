package com.roushan._14_BST;

import java.util.*;
import java.lang.*;

class Pair {
    Node node;
    int hd;

    Pair(Node n, int h) {
        node = n;
        hd = h;
    }
}

class _19_BottomViewOfTree {

    //it is also similar to the vertical traversal and the differences are
    public static void topView(Node root) {
        Queue<Pair> q = new LinkedList<>();
        //here we taking map of integer with integer value.
        Map<Integer, Integer> mp = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            //here we keep add the current node value to the map and it already key hd present in the map
            //then it will overwrite the value.
            mp.put(hd, curr.value);
            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            System.out.print(x.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        prettyDisplay(root, 0);
        System.out.println();
        topView(root);
    }

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

