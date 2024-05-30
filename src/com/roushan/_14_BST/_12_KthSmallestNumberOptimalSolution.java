package com.roushan._14_BST;

public class _12_KthSmallestNumberOptimalSolution {

    // Function to insert a new node in the BST
    public static Node8 insert(Node8 root, int x) {
        if (root == null)
            return new Node8(x);

        if (x < root.data) {
            root.left = insert(root.left, x);
            root.lCount++;
        } else if (x > root.data) {
            root.right = insert(root.right, x);
        }
        return root;
    }

    // Function to find the k-th smallest element in the BST
    public static Node8 kthSmallest(Node8 root, int k) {
        if (root == null)
            return null;

        int count = root.lCount + 1;
        if (count == k)
            return root;

        if (count > k)
            return kthSmallest(root.left, k);

        return kthSmallest(root.right, k - count);
    }

    public static void main(String[] args) {
        Node8 root = null;
        int[] keys = {20,8,30,15,25,12};

        for (int x : keys)
            root = insert(root, x);

        int k = 3;
        Node8 res = kthSmallest(root, k);
        if (res == null)
            System.out.println("There are less than k nodes in the BST");
        else
            System.out.println("K-th Smallest Element is " + res.data);
    }
}

class Node8 {
    int data;
    Node8 left, right;
    int lCount;

    Node8(int x) {
        data = x;
        lCount = 0;
        left = right = null;
    }
}
