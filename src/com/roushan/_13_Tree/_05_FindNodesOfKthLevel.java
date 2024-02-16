package com.roushan._13_Tree;

import java.util.Scanner;

public class _05_FindNodesOfKthLevel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        int k = 2;
        NODes(tree.root, k, 0);
    }

    //we need to find the nodes available at kth level of the tree.
    private static void NODes(_02_BinaryTreeDetail.Node node, int k, int i) {
        //and start returning when it reaches null.
        if (node == null) {
            return;
        }
        //if I become equal to k then it says we are on the required kth level.
        //so print the node value.
        if (i == k) {
            System.out.print(node.value + " ");
        } else {
            NODes(node.left, k, i + 1);
            NODes(node.right, k, i + 1);
        }
    }
}
