package com.roushan._13_Tree;

import java.util.Scanner;

public class _09_MaximumInBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        int ans = getMax(tree.root);
        System.out.println("Maximum in Binary Tree::" + ans);
    }

    //1st method.
    //Time Complexity = O(n)
    //Auxiliary Space = O(h).
    private static int getMax(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(node.value, Math.max(getMax(node.left), getMax(node.right)));
        }
    }
    //2nd method.
    //we can use loop with queue like some previous questions.

}
