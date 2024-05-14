package com.roushan._14_BST;
//ceiling means value which just greater or equal to the given target(ie smallest greater or equal value)

class Node5 {
    int value;
    Node5 left;
    Node5 right;

    public Node5(int value) {
        this.value = value;
    }
}

public class _05_CeilingInBst {
    public static void main(String[] args) {
        Node5 root = new Node5(6);
        root.left = new Node5(2);
        root.right = new Node5(99);
        root.right.left = new Node5(7);
        root.left.left = new Node5(1);
        root.left.right = new Node5(4);
        root.left.right.left = new Node5(3);
        prettyDisplay(root, 0);
        System.out.println();
        Node5 ans = ceiling(root, 8);
        System.out.println("Ceiling of the tree::" + ans.value);
        ans = ceiling2(root, 8);
        System.out.println("Ceiling of the tree::" + ans.value);
    }

    //Recursive way
    //Time complexity = O(h),Space complexity = O(h)
    public static Node5 ceiling(Node5 node, int x) {
        if (node == null) {
            return null;
        }
        if (node.value == x) {
            return node;
        }
        if (node.value < x) {
            return ceiling(node.right, x);
        } else {
            Node5 res = ceiling(node.left, x);
            if (res != null) {
                return res;
            } else {
                return node;
            }
        }
    }

    //iterative way
    //time complexity = O(h),space complexity = O(1)
    public static Node5 ceiling2(Node5 node, int x) {
        Node5 res = null;
        while (node != null) {
            if (node.value == x) {
                return node;
            } else if (node.value < x) {
                node = node.right;
            } else {
                res = node;
                node = node.left;
            }
        }
        return res;
    }

    public static void prettyDisplay(Node5 node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }
}
