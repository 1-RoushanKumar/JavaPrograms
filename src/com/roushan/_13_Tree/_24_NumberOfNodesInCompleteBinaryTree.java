package com.roushan._13_Tree;

public class _24_NumberOfNodesInCompleteBinaryTree {

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
        System.out.print("Number of nodes are::" + countNode(root));
    }

    public static int countNode(Node root) {
        int lh = 0, rh = 0;
        Node curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        } else {
            return 1 + countNode(root.left) + countNode(root.right);
        }
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
