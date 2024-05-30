package com.roushan._13_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//GFG LEc 21.
public class _18_SpiralTraversal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        int h = height(tree.root);
        for (int i = 1; i <= h; i++) {
            spiral(tree.root, i, 1);
        }
        System.out.println();
        spiral2(tree.root);

        System.out.println();
        spiral3(tree.root);
    }

    //1st way first find the height of the tree then go to each level of the tree say level as k
    //if level 1 ie odd then print left to right and when level k = 2 then print right to left.
    //Time complexity = O(n2)
    private static int height(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    static void spiral(_02_BinaryTreeDetail.Node node, int k, int i) {
        if (node == null) {
            return;
        }
        if (k % 2 == 0) {
            if (i == k) {
                System.out.print(node.value + " ");
            }
            spiral(node.right, k, i + 1);
            spiral(node.left, k, i + 1);
        } else {
            if (i == k) {
                System.out.print(node.value + " ");
            }
            spiral(node.left, k, i + 1);
            spiral(node.right, k, i + 1);
        }
    }

    //2nd way Time Complexity and space complexity will be O(n).
    //This way is similar to the Line by line LevelOrder traversal.However, here we used an extra data structure stack
    //we have taken a reverse boolean which keeps changes itself alternatively which will give the idea about
    //printing from left to right and then  right to left alternatively.When traversal is from right to left, then we push the values
    //to stack then print it.
    static void spiral2(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return;
        }
        Queue<_02_BinaryTreeDetail.Node> q = new LinkedList<>();  //first, we add the elements in the queue.
        Stack<Integer> s = new Stack<>();
        boolean reverse = false;     //here initially reverse is false assume it telling us to print from left to right.
        //and when reverse true, then we push the queue value to stack and then print them.
        q.add(node);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                _02_BinaryTreeDetail.Node curr = q.poll();
                if (reverse) {
                    s.push(curr.value);
                } else {
                    System.out.print(curr.value + " ");
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (reverse) {
                while (!s.isEmpty()) {
                    System.out.print(s.pop() + " ");
                }
            }
            reverse = !reverse;
        }
    }

    //3rd way by using two stacks.
    //1.Push root to the stack s1.
    //2.while any of the two stacks is not empty
    //      while s1 is not empty
    //          1.Take out a node,print it.
    //          2.Push children of the take-out node into s2 from left to right.
    //      while s2 is not empty,
    //          1.Take out a node,print it.
    //          2.Push children of the take-out node into s1 in right to left.
    static void spiral3(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return;
        }
        Stack<_02_BinaryTreeDetail.Node> s1 = new Stack<>();
        Stack<_02_BinaryTreeDetail.Node> s2 = new Stack<>();
        s1.push(node);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                _02_BinaryTreeDetail.Node curr = s1.pop();
                System.out.print(curr.value + " ");
                if (curr.left != null) {
                    s2.push(curr.left);
                }
                if (curr.right != null) {
                    s2.push(curr.right);
                }
            }
            while (!s2.isEmpty()) {
                _02_BinaryTreeDetail.Node curr = s2.pop();
                System.out.print(curr.value + " ");
                if (curr.right != null) {
                    s1.push(curr.right);
                }
                if (curr.left != null) {
                    s1.push(curr.left);
                }
            }
        }
    }
}
