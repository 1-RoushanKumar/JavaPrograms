package com.roushan._13_Tree;

public class _27_CheckTreeIsCompleteTree {
    public static void main(String[] args) {
        Node69 root = new Node69(10);
        root.left = new Node69(20);
        root.left.left = new Node69(40);
        root.left.right = new Node69(60);
        root.right = new Node69(30);
        root.right.right = new Node69(70);

        int noOfNodes = count(root);
        boolean flag = checkComplete(root, 0, noOfNodes);
        System.out.println(flag);
    }

    //the idea is we first count the no of nodes in tree and then if index of left or right is greater than or equal to
    //noOfNodes then we say tree is not complete.
    public static boolean checkComplete(Node69 root, int index, int noOfNodes) {
        if (root == null) {
            return true;
        }
        if (index >= noOfNodes) {
            return false;
        }
        boolean left = checkComplete(root.left, 2 * index + 1, noOfNodes);
        boolean right = checkComplete(root.right, 2 * index + 2, noOfNodes);
        return left && right;
    }

    public static int count(Node69 root) {
        if (root == null) {
            return 0;
        }
        return (count(root.left) + count(root.right) + 1);
    }
}

class Node69 {
    int data;
    Node69 left;
    Node69 right;

    public Node69(int data) {
        this.data = data;
    }
}
