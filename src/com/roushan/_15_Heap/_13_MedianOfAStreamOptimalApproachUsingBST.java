package com.roushan._15_Heap;

class Node {
    double data;
    Node left, right;
    int lCount;

    Node(double x) {
        data = x;
        left = right = null;
        lCount = 0;
    }
}

class _13_MedianOfAStreamOptimalApproachUsingBST {

    public static Node insert(Node root, double x) {
        if (root == null)
            return new Node(x);

        if (x < root.data) {
            root.left = insert(root.left, x);
            root.lCount++;
        } else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }

    public static Node kthSmallest(Node root, int k) {

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
        Node root = null;
        double[] keys = new double[]{25, 7, 10, 15, 20};
        int size = 0;

        for (double x : keys) {
            size++;
            root = insert(root, x);
            double res;
            if (size % 2 != 0) {
                res = (kthSmallest(root, (size / 2) + 1)).data;
            } else {
                res = (((kthSmallest(root, (size / 2) + 1)).data) + ((kthSmallest(root, (size / 2))).data)) / 2;
            }
            System.out.print(res + " ");
        }
    }
}

