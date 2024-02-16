package com.roushan._13_Tree;

import java.util.Scanner;

public class _14_BinaryTreeToDoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        _02_BinaryTreeDetail.Node head = convert(tree.root);
        printList(head);
    }

    static _02_BinaryTreeDetail.Node prev = null;

    private static _02_BinaryTreeDetail.Node convert(_02_BinaryTreeDetail.Node root) {
        if (root == null) {
            return root;
        }
        _02_BinaryTreeDetail.Node head = convert(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
        return head;
    }

    public static void printList(_02_BinaryTreeDetail.Node head) {
        _02_BinaryTreeDetail.Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.right;
        }
    }
}
