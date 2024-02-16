package com.roushan._13_Tree;

import java.util.Scanner;

public class _12_CheckForBalancedTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        boolean flag = isBalanced(tree.root);
        System.out.println(flag);
        int check = isBalance(tree.root);
        System.out.println(check != -1);
    }

    //1st way.
    //Time complexity is O(N^2) because we calling height function.
    private static boolean isBalanced(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return true;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right));
    }

    private static int height(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    //2nd way.
    //Time Complexity is O(n).
    private static int isBalance(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        }
        //check for left subtree and find the left height.
        int lh = isBalance(node.left);
        if (lh == -1) {
            return -1;
        }
        //check for the right subtree and find the right height.
        int rh = isBalance(node.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        } else {
            return Math.max(lh, rh) + 1;
        }
    }
}
