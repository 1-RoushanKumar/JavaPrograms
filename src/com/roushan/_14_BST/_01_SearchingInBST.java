package com.roushan._14_BST;
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
public class _01_SearchingInBST {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.right.left = new Node(18);
        root.right.right = new Node(80);
        root.right.left.left = new Node(16);

        prettyDisplay(root, 0);
        int target = 3;

        boolean flag = searchRec(root, target);
        System.out.println(flag);
        flag = searchIte(root, target);
        System.out.println(flag);
    }

    //Recursive way which will take
    //Time Complexity = O(h) where h is height of the tree.
    //Auxiliary space = O(h).
    public static boolean searchRec(Node root, int target) {
        if (root == null) {
            return false;
        } else if (root.value == target) {
            return true;
        } else if (root.value > target) {
            return searchRec(root.left, target);
        } else {
            return searchRec(root.right, target);
        }
    }


    //Iterative way which will take
    //Time Complexity = O(h) where h is height of the tree.
    //Auxiliary space = O(1).
    public static boolean searchIte(Node root, int target) {
        while (root != null) {
            if (root.value == target) {
                return true;
            } else if (root.value > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;
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
