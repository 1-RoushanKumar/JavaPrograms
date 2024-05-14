package com.roushan._14_BST;

class Node3 {
    int value;
    Node3 left;
    Node3 right;

    public Node3(int value) {
        this.value = value;
    }
}

//time complexity = O(h) and space complexity = O(h)
public class _03_DeletionInBST {
    public static void main(String[] args) {
        Node3 root = new Node3(6);
        root.left = new Node3(2);
        root.right = new Node3(8);
        root.right.left = new Node3(7);
        root.left.left = new Node3(1);
        root.left.right = new Node3(4);
        root.left.right.left = new Node3(3);
        prettyDisplay(root, 0);
        System.out.println();
        delNode(root, 6);
        prettyDisplay(root, 0);
    }

    public static Node3 delNode(Node3 root, int x) {
        if (root == null) {
            return null;
        }
        if (root.value > x) {
            root.left = delNode(root.left, x);
        } else if (root.value < x) {
            root.right = delNode(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node3 succ = getSucc(root);
                root.value = succ.value;
                root.right = delNode(root.right, succ.value);
            }
        }
        return root;
    }

    public static Node3 getSucc(Node3 root) {
        Node3 curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void prettyDisplay(Node3 node, int level) {
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
