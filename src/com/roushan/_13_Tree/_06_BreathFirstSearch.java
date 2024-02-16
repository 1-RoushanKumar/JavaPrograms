package com.roushan._13_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Bfs also called as level order traversal.
public class _06_BreathFirstSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();

        //1st way :: one solution is to first find the height of the tree.
        //then traverse to each node from lever 0 to height -1 (k-1).
        //like we did in previous question no. 5.
        //this method will take O(n+h) time complexity.
        int k = height(tree.root);
        System.out.println("Level Order Traversal::");
        for (int i = 0; i < k; i++) {
            levelOrder(tree.root, i, 0);
        }

        //2nd way using queue data structure.
        //detail about this approach in notes.
        System.out.println();
        bfs(tree.root);
    }

    private static void levelOrder(_02_BinaryTreeDetail.Node node, int k, int i) {
        if (node == null) {
            return;
        }
        if (i == k) {
            System.out.print(node.value + " ");
        }
        levelOrder(node.left, k, i + 1);
        levelOrder(node.right, k, i + 1);
    }

    private static int height(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    private static void bfs(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return;
        }
        Queue<_02_BinaryTreeDetail.Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            _02_BinaryTreeDetail.Node curr = q.poll();
            System.out.print(curr.value + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }
}
