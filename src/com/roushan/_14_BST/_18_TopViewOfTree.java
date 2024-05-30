package com.roushan._14_BST;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class _18_TopViewOfTree {
    static class pair1 {
        Node node;  // Tree node
        int hp;     // Horizontal distance (horizontal position)

        pair1(Node n, int h) {
            node = n;
            hp = h;
        }
    }

    public static void main(String[] args) {
        //top view means seeing node from above the root node.
        //and printing only those which are visible from top.
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        prettyDisplay(root, 0);
        System.out.println();
        topView(root);
    }

    //the approach is similar to the vertical traversal differences are:
    public static void topView(Node root) {
        Queue<pair1> q = new LinkedList<>();
        //here we taken map of integer with value integer.
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        q.add(new pair1(root, 0));
        while (!q.isEmpty()) {
            pair1 p = q.poll();
            Node curr = p.node;
            int hp = p.hp;
            //adding key and value to the map only if it doesn't contain any key similar to the hp.
            if (!mp.containsKey(hp)) mp.put(hp, curr.value);
            if (curr.left != null) q.add(new pair1(curr.left, hp - 1));
            if (curr.right != null) q.add(new pair1(curr.right, hp + 1));
        }
        //printing map
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            System.out.print(x.getValue() + " ");
        }
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
