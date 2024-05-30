package com.roushan._14_BST;

import java.util.ArrayList;


public class _14_MakingTreeBSTWithTwoNodeSwap {
    public static void main(String[] args) {
        Node root = new Node(18);
        root.left = new Node(60);
        root.right = new Node(70);
        root.left.left = new Node(4);
        root.right.left = new Node(8);
        root.right.right = new Node(80);

        System.out.println("Original Tree:");
        prettyDisplay(root, 0);
        System.out.println();
//
//        //first approach Inorder traversal a storing the nodes in list and finding in the list which nodes causing the
//        //tree not to be balanced then swap that two node.
//        //This approach will take Time complexity = O(N) but here we doing lot of operation first storing into the
//        //list or array then finding the node to be swapped then swapping.
//        ArrayList<Node> list = new ArrayList<>();
//        InorderList(root, list);  //it will store nodes in the list.
//
//        //Now we using first and second to store the node which has to be swapped.
//        Node prev = null;
//        Node first = null;
//        Node second = null;
//
//        for (Node current : list) {
//            if (prev != null && current.value < prev.value) {
//                if (first == null) {
//                    first = prev;
//                }
//                second = current;
//            }
//            prev = current;
//        }
//
//        //swap first and second.
//        swap(first, second);


        //2nd approach finding the first and second nodes while inorder traversal.
        swap(first1, second1);
        System.out.println("Corrected Tree:");
        prettyDisplay(root, 0);
    }

    public static void InorderList(Node root, ArrayList<Node> list) {
        if (root == null) {
            return;
        }
        InorderList(root.left, list);
        list.add(root);
        InorderList(root.right, list);
    }

    public static void swap(Node first, Node second) {
        if (first != null && second != null) {
            int temp = first.value;
            first.value = second.value;
            second.value = temp;
        }
    }

    //2nd approach.
    static Node prev = null, first1 = null, second1 = null;
    public static void fixBst(Node root) {
        if (root == null) {
            return;
        }
        fixBst(root.left);
        if (prev != null && root.value < prev.value) {
            if (first1 == null) {
                first1 = prev;
            }
            second1 = root;
        }
        prev = root;
        fixBst(root.right);
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
