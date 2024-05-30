package com.roushan._13_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//gfg lec 13.
//the size of the tree means the total number of nodes in the tree.
public class _08_SizeOfTheBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        int ans = sizeOfTree(tree.root);
        System.out.println("Size of the tree::" + ans);
        int ans2 = getSize(tree.root);
        System.out.println("Size of the tree::" + ans2);
    }

    //1st way: queue solution.
    private static int sizeOfTree(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        }
        //Just use breath first search method and keep counting the nodes while popping the node from the queue.
        Queue<_02_BinaryTreeDetail.Node> q = new LinkedList<>();
        q.add(node);
        int count = 0;
        while (!q.isEmpty()) {
            _02_BinaryTreeDetail.Node curr = q.poll();
            count++;
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return count;
    }

    //2nd way::recursive solution
    private static int getSize(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSize(node.left) + getSize(node.right);
        }
    }
}

