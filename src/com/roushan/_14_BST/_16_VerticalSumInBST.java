package com.roushan._14_BST;

import java.util.TreeMap;

public class _16_VerticalSumInBST {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);
        prettyDisplay(root, 0);

        printSum(root);
    }

    public static void printSum(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        vSum(root, 0, map);
        System.out.println("Vertical Sum::");
        System.out.println(map.values());
    }

    public static void vSum(Node root, int hp, TreeMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        vSum(root.left, hp - 1, map);
        int prevSum = (map.get(hp) == null) ? 0 : map.get(hp);
        map.put(hp, prevSum + root.value);
        vSum(root.right, hp + 1, map);
    }

    public static void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }
}
