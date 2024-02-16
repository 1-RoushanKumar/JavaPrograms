package com.roushan._13_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//gfg lec:15.
public class _10_PrintLeftViewOfBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        printLeftView(tree.root);
        System.out.println();
        printLeft(tree.root);
    }
    //1st::Recursive Solution::
    private static void printLeftView(_02_BinaryTreeDetail.Node root) {
        printLeftView(root, 1);
    }
    static int maxLevel = 0;
    private static void printLeftView(_02_BinaryTreeDetail.Node node, int level) {
        if (node == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.print(node.value + " ");
            maxLevel = level;
        }
        printLeftView(node.left, level + 1);
        printLeftView(node.right, level + 1);
    }

    //2nd::Iterative Solution::
    private static void printLeft(_02_BinaryTreeDetail.Node node) {
        if (node == null){
            return;
        }
        Queue<_02_BinaryTreeDetail.Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int count = q.size();
            for (int i = 0; i < count; i++) {
                _02_BinaryTreeDetail.Node curr = q.poll();
                if (i == 0){
                    System.out.print(curr.value+" ");
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }
}
