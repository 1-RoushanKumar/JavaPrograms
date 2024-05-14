package com.roushan._13_Tree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class _03_TreeTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        //using recursion
        System.out.println("InOrder::");
        inOrder(tree.root);
        System.out.println();
        System.out.println("PreOrder::");
        preOrder(tree.root);
        System.out.println();
        System.out.println("PostOrder::");
        postOrder(tree.root);
    }

    //Recursive way solution.
    //Time Complexity = O(n)
    //Auxiliary Space = O(H) where H is the height of the tree.
    //For all traversals.
    private static void inOrder(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    private static void preOrder(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void postOrder(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
}
