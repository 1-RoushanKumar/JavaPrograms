package com.roushan._14_BST;

import java.util.HashSet;

public class _15_PairWithGivenSumInBST {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);
        int sum = 33;

        //1st approach performs inOrder in Bst and stores them in an array.
        //Then apply two pointer approach to find two values which is equal to sum or not.Return (true or false).
        //time = O(n) and space = O(n).

        
        //2nd approach this approach is optimal then above approach.
        //The Idea is to find the pair in early search, that is if we finded the pair equal to sum then we immediately return
        //true instead of traveling whole binary tree then storing them in array and then applying two pointer method.
        //it also take time complexity = O(n).
        //here we using hash to store the node immediately after traversing
        //then check hash set contain sum-current if yes then return true else false.
        HashSet<Integer> s = new HashSet<>();
        System.out.print(isPairSum(root, sum, s));
    }

    public static boolean isPairSum(Node root, int sum, HashSet<Integer> s) {
        if (root == null) return false;

        if (isPairSum(root.left, sum, s))
            return true;

        if (s.contains(sum - root.value))
            return true;
        else
            s.add(root.value);
        return isPairSum(root.right, sum, s);
    }
}
