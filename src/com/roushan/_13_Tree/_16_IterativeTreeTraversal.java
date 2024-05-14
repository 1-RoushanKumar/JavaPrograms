package com.roushan._13_Tree;

import java.util.Scanner;
import java.util.Stack;

public class _16_IterativeTreeTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        System.out.println("InOrder::");
        inOrder(tree.root);
        System.out.println();
        System.out.println("PreOrder::");
        preOrder(tree.root);
        System.out.println();
        System.out.println("PostOrder::");
        postOrder(tree.root);
        System.out.println();
        postOrder2(tree.root);
    }

    //Iterative way.
    //time and space complexity O(n).
    private static void preOrder(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return;
        }
        Stack<_02_BinaryTreeDetail.Node> s = new Stack<>();
        s.add(node);
        //while stack is not empty
        while (!s.isEmpty()) {
            _02_BinaryTreeDetail.Node curr = s.pop();
            System.out.print(curr.value + " ");
            if (curr.right != null) {
                s.add(curr.right);
            }
            if (curr.left != null) {
                s.add(curr.left);
            }
        }
    }

    //InOrder Traversal.
    private static void inOrder(_02_BinaryTreeDetail.Node node) {
        Stack<_02_BinaryTreeDetail.Node> s = new Stack<>();
        _02_BinaryTreeDetail.Node curr = node;
        while (true) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                if (s.isEmpty()) {
                    break;
                }
                curr = s.pop();
                System.out.print(curr.value + " ");
                curr = curr.right;
            }
        }
    }


    //postOrder 1st way using two stacks.
    private static void postOrder(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return;
        }
        Stack<_02_BinaryTreeDetail.Node> s1 = new Stack<>();
        Stack<_02_BinaryTreeDetail.Node> s2 = new Stack<>();
        s1.push(node);
        while (!s1.isEmpty()) {
            _02_BinaryTreeDetail.Node curr = s1.pop();
            s2.push(curr);
            if (curr.left != null) {
                s1.push(curr.left);
            }
            if (curr.right != null) {
                s1.push(curr.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value + " ");
        }
    }

    //postOrder 2nd way using only on stack.
    //https://youtu.be/xLQKdq0Ffjg
    private static void postOrder2(_02_BinaryTreeDetail.Node node) {
        _02_BinaryTreeDetail.Node curr = node;
        Stack<_02_BinaryTreeDetail.Node> s = new Stack<>();
        while (curr != null || !s.isEmpty()) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                _02_BinaryTreeDetail.Node temp = s.peek().right;
                if (temp == null) {
                    temp = s.pop();
                    System.out.print(temp.value + " ");
                    while (!s.isEmpty() && temp == s.peek().right) {
                        temp = s.pop();
                        System.out.print(temp.value + " ");
                    }
                } else {
                    curr = temp;
                }
            }
        }
    }
}
