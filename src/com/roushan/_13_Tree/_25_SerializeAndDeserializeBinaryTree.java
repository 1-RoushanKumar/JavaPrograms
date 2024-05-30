package com.roushan._13_Tree;

import java.util.ArrayList;

public class _25_SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.left.left.left = new Node(80);
        root.left.left.right = new Node(90);

        prettyDisplay(root, 0);
        System.out.println();
        ArrayList<Integer> list = new ArrayList<>();
        serialize(root, list);
        System.out.println(list);
        Node ans = deserialize(list);
        prettyDisplay(ans, 0);
    }

    public static void serialize(Node root, ArrayList<Integer> list) {
        if (root == null) {
            list.add(-1);
            return;
        }
        list.add(root.key);
        serialize(root.left, list);
        serialize(root.right, list);
    }

    static int index = 0;

    public static Node deserialize(ArrayList<Integer> list) {
        if (index == list.size()) {
            return null;
        }
        int val = list.get(index);
        index++;
        if (val == -1) {
            return null;
        }
        Node root = new Node(val);
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    private static void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.key);
        } else {
            System.out.println(node.key);
        }
        prettyDisplay(node.left, level + 1);
    }
}
