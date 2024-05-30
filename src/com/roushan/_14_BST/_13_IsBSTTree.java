package com.roushan._14_BST;

public class _13_IsBSTTree {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.right = new Node(20);
        root.right.left = new Node(18);
        root.right.left.left = new Node(16);
        root.right.right = new Node(80);

        //1st way using range concept time = O(n).
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        boolean flag = isBST(root, min, max);
        System.out.println(flag);

        System.out.println();
        //2nd way using inorder traversal.time = O(n).
        flag = isBSTInorder(root);
        System.out.println(flag);
    }

    public static boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        return ((root.value > min && root.value < max) && isBST(root.left, min, root.value) && isBST(root.right, root.value, max));
    }

    static int prev = Integer.MIN_VALUE;

    public static boolean isBSTInorder(Node root) {
        if (root == null) {
            return true;
        }
        if (!isBSTInorder(root.left)) {
            return false;
        }
        if (root.value <= prev) {
            return false;
        }
        prev = root.value;
        return isBSTInorder(root.right);
    }
}
