package com.roushan._13_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _13_MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        int ans = maxWidth(tree.root);
    }
    private static int maxWidth(_02_BinaryTreeDetail.Node root) {
        if (root == null) {
            return 0;
        }
        Queue<_02_BinaryTreeDetail.Node> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            int count = q.size();
            res = Math.max(res, count);
            for (int i = 0; i < count; i++) {
                _02_BinaryTreeDetail.Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return res;
    }
}
