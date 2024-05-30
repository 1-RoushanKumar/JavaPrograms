package com.roushan._13_Tree;

public class _26_BinaryTreeFromInorderAndPostorder {
    public static void main(String[] args) {
        int[] in = {50, 30, 60, 20, 40};
        int[] pos = {50, 60, 30, 40, 20};
        int n = in.length;
        int[] postIndex = {n - 1};
        Node root = cTree(in, pos, 0, n - 1, postIndex);
        prettyDisplay(root, 0);
    }

    public static Node cTree(int[] in, int[] pos, int is, int ie, int[] postIndex) {
        if (is > ie) return null;
        Node root = new Node(pos[postIndex[0]--]);

        int inIndex = is;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.key) {
                inIndex = i;
                break;
            }
        }
        root.right = cTree(in, pos, inIndex + 1, ie, postIndex);
        root.left = cTree(in, pos, is, inIndex - 1, postIndex);
        return root;
    }

    public static void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.key);
        } else {
            System.out.println(node.key);
        }
        prettyDisplay(node.left, level + 1);
    }

    public static class Node {
        int key;
        Node left;
        Node right;

        Node(int k) {
            key = k;
            left = right = null;
        }
    }
}
