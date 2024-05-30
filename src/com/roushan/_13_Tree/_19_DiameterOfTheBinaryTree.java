package com.roushan._13_Tree;

import java.util.Scanner;

public class _19_DiameterOfTheBinaryTree {
    //the diameter of the binary tree means the longest distance between two leaf nodes.lec no. 22 gfg.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        int ans = diameter(tree.root);
        System.out.println("Diameter of the Binary Tree::" + ans);
        int ans1 = diameter2(tree.root);
        System.out.println("Diameter of the Binary Tree::" + ans);
        int ans2 = diameterWithHeightFunction(tree.root);
        System.out.println("Height of the tree::" + ans2);
        System.out.println("Diameter of the Binary Tree::" + res);
        int ans3 = diameterOfBinaryTree(tree.root);
        System.out.println("Diameter = " + ans3);
    }

    //1st way which will take O(n^2) time complexity.
    //Find the height of the left subtree (we know which will go up to leaf node for finding the height) and similarly
    //height of the right subtree.Hence, the Formula for getting diameter is (Lh+rh+1) for each subtree
    //then find the maximum diameter between these subtrees.
    public static int diameter(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);

        return (Math.max((lh + rh), Math.max(diameter(node.left), diameter(node.right))));
    }

    private static int height(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    //writing the same code in other way.
    public static int diameter2(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        }
        int d1 = height(node.left) + height(node.right);
        int d2 = diameter(node.left);
        int d3 = diameter(node.right);

        return Math.max(d1, Math.max(d2, d3));
    }

    //2nd way with O(n) time complexity finding height and diameter in the same function.
    static int res = 0;

    public static int diameterWithHeightFunction(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        }
        int lh = diameterWithHeightFunction(node.left);
        int rh = diameterWithHeightFunction(node.right);

        res = Math.max(res, lh + rh);  //this will give the diameter
        return 1 + Math.max(lh, rh);  //this will give height.
    }

    //Same as 2nd approach but it is not possible to return global variable in coding platform like leetcode.
    //so we need a way so we can return so taken an diameter array of size one which will store the final diameter of
    //the tree.(we did'nt take variable in diameterOfBinaryTree because we need reference so value be changed when
    //height function called.
    public static int diameterOfBinaryTree(_02_BinaryTreeDetail.Node root) {
        int[] diameter = new int[1];
        height1(root, diameter);
        return diameter[0];
    }

    public static int height1(_02_BinaryTreeDetail.Node node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height1(node.left, diameter);
        int rh = height1(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
    //3rd way.
    //one optimal approach is also for this we need to learn hashmap.
    //idea is precompute height of every node and store it in a map.
    //which help to solve this in O(n) time and require extra O(n) space for map.
}
