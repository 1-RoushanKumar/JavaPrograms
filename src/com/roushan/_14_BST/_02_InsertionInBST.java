package com.roushan._14_BST;

class Node1 {
    int value;
    Node1 left;
    Node1 right;

    public Node1(int value) {
        this.value = value;
    }
}

public class _02_InsertionInBST {
    public static void main(String[] args) {
        int data = 6;
        Node1 root = new Node1(10);
        root.left = new Node1(5);
        root.right = new Node1(15);
        root.right.left = new Node1(12);
        root.right.right = new Node1(18);
        prettyDisplay(root, 0);
        insert(root, data);
        System.out.println();
        prettyDisplay(root, 0);
        System.out.println();
        insert1(root, data);
        prettyDisplay(root, 0);
    }

    //Recursive way.
    public static Node1 insert(Node1 node, int data) {
        if (node == null) {
            return new Node1(data);
        }
        if (node.value > data) {
            node.left = insert(node.left, data);
        } else if (node.value < data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    //Iterative way.
    public static Node1 insert1(Node1 node, int data) {
        Node1 temp = new Node1(data);
        Node1 parent = null;
        Node1 curr = node;
        while (curr != null) {
            parent = curr;
            if (curr.value > data) {
                curr = curr.left;
            } else if (curr.value < data) {
                curr = curr.right;
            } else {
                return node;
            }
        }
        if (parent == null) {
            return temp;
        }
        if (parent.value > data) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }
        return node;
    }

    public static void prettyDisplay(Node1 node, int level) {
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
