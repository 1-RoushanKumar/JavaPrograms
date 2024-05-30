package com.roushan._14_BST;

import java.util.TreeSet;

public class _11_KthSmallestNumber {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.right = new Node(8);
        root.right.right = new Node(30);
        root.right.right.left = new Node(15);
        root.right.right.left.left = new Node(12);
        root.right.right.left.right = new Node(25);
        int k = 3;

        System.out.print("Kth Smallest: ");
        printKth(root, k);
    }

    static int count = 0;

    public static void printKth(Node root, int k) {
        if (root != null) {
            printKth(root.left, k);
            count++;
            if (count == k) {
                System.out.print(root.value);
                return;
            }
            printKth(root.right, k);
        }
    }
}
