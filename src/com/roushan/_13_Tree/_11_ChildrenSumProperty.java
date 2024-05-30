package com.roushan._13_Tree;

import java.util.Scanner;

//if a sum of the child nodes is equal to the parent node, then we return true else false.
public class _11_ChildrenSumProperty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        boolean flag = isCSum(tree.root);
        System.out.println(flag);
    }

    private static boolean isCSum(_02_BinaryTreeDetail.Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.value;
        }
        if (root.right != null) {
            sum += root.right.value;
        }
        return (root.value == sum && isCSum(root.left) && isCSum(root.right));
    }
}
