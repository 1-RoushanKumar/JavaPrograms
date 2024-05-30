package com.roushan._14_BST;

class Node4 {
    int value;
    Node4 left;
    Node4 right;

    public Node4(int value) {
        this.value = value;
    }
}

//the floor of the bst means value which just smaller than target or equal to target.(in another word, greatest smaller or equal values)
public class _04_FloorInBST {
    public static void main(String[] args) {
        Node4 root = new Node4(6);
        root.left = new Node4(2);
        root.right = new Node4(8);
        root.right.left = new Node4(7);
        root.left.left = new Node4(1);
        root.left.right = new Node4(4);
        prettyDisplay(root, 0);
        System.out.println();
        Node4 ans = floor(root, 3);
        System.out.println("Floor of the tree is::" + ans.value);
        ans = floor1(root, 3);
        System.out.println("Floor of the tree is::" + ans.value);
    }

    //Recursive way
    //Time Complexity = O(h) and space complexity = O(h)
    public static Node4 floor(Node4 node, int x) {
        if (node == null) {
            return null;
        }
        if (node.value == x) {
            return node;
        }
        if (node.value > x) {
            return floor(node.left, x);
        } else {
            Node4 res = floor(node.right, x);
            if (res != null) {
                return res;
            } else {
                return node;
            }
        }
    }

    //Iterative way
    //Time complexity = O(h)
    //space complexity = O(1)
    public static Node4 floor1(Node4 node, int x) {
        Node4 res = null;
        while (node != null) {
            if (node.value == x) {
                return node;
            } else if (node.value > x) {
                node = node.left;
            } else {
                res = node;
                node = node.right;
            }
        }
        return res;
    }

    public static void prettyDisplay(Node4 node, int level) {
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
