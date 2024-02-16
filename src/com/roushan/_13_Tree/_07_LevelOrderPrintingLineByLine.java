package com.roushan._13_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//same as previous code, we only need to print each level line by line.
public class _07_LevelOrderPrintingLineByLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        bfs(tree.root);
        System.out.println();
        bfs2(tree.root);
    }

    //1st method::
    //all things are the same as previous code
    //we're only adding null value to queue when we encounter null that means we need to print new line
    //after printing pop it and then again push it.
    //Time Complexity O(n+H) ~ O(n).
    //Auxiliary Space O(N).
    private static void bfs(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return;
        }
        Queue<_02_BinaryTreeDetail.Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);

        //i taken q.size() > 1 because queue will never be empty
        //because null value always remains.
        while (q.size() > 1) {
            _02_BinaryTreeDetail.Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(curr.value + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    //time complexity O(n)
    //auxiliary space O(n).
    private static void bfs2(_02_BinaryTreeDetail.Node node) {
        if (node == null) {
            return;
        }
        Queue<_02_BinaryTreeDetail.Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                _02_BinaryTreeDetail.Node curr = q.poll();
                System.out.print(curr.value + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }
}
