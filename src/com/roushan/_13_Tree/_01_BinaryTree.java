package com.roushan._13_Tree;
class Node {
    int key;
    Node left;
    Node right;
    public Node(int key) {
        this.key = key;
    }
}
public class _01_BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        System.out.println("Binary Tree::");
        display(root);
    }
    static void display(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key + " ");
        display(node.left);
        display(node.right);
    }
}
