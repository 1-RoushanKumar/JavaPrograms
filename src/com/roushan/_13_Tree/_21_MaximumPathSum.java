package com.roushan._13_Tree;

import java.util.Scanner;

public class _21_MaximumPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        int ans = maxPath(tree.root);
        System.out.print("Maximum Path::" + max);
    }

    static int max = 0;

    public static int maxPath(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        }
        int leftSum = maxPath(node.left);
        if (leftSum < 0) {
            leftSum = 0;
        }
        int rightSum = maxPath(node.right);
        if (rightSum < 0) {
            rightSum = 0;
        }

        max = Math.max(max, (leftSum + rightSum + node.value));
        return node.value + Math.max(leftSum, rightSum);
    }
}
//https://youtu.be/WszrfSwMz58?si=pm7YsMk9s_V5gOk1