package com.roushan._13_Tree;

import java.util.Scanner;

public class _04_HeightOfTheBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        int ans = height(tree.root);
        System.out.print("Height of the tree::" + ans);
    }
    //Time Complexity = O(n)
    //Space complexity = O(h)
    private static int height(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }
    //how its working see in notes.
}
