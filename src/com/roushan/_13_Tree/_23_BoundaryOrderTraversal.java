package com.roushan._13_Tree;

import java.util.ArrayList;
import java.util.List;
//https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/
public class _23_BoundaryOrderTraversal { 
    public static void main(String[] args) {
        Noddee root = new Noddee(10);
        root.left = new Noddee(8);
        root.left.left = new Noddee(12);
        root.right = new Noddee(30);
        root.right.left = new Noddee(40);
        root.right.right = new Noddee(50);

        List<Noddee> res = new ArrayList<>();
        if (!isLeaf(root)) {
            res.add(root);
        }
        addLeftBoundary(root, res);
        addLeaf(root, res);
        addRightBoundary(root, res);

        printt(res);
    }

    //Time complexity = O(N) and Space Complexity = O(n)
    public static boolean isLeaf(Noddee root) {
        return root.left == null && root.right == null;
    }

    //here we adding all the node of the left subtree of root until we reached the leaf node.
    public static void addLeftBoundary(Noddee root, List<Noddee> res) {
        Noddee curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    //here we using pre order traversal to travel all the node and only printing the leaf nodes.
    public static void addLeaf(Noddee root, List<Noddee> res) {
        if (isLeaf(root)) {
            res.add(root);
            return;
        }
        if (root.left != null) {
            addLeaf(root.left, res);
        }
        if (root.right != null) {
            addLeaf(root.right, res);
        }
    }

    //here we need storing nodes of right subtree in temp then reversing them to store in res.
    public static void addRightBoundary(Noddee root, List<Noddee> res) {
        Noddee curr = root.right;
        List<Noddee> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    public static void printt(List<Noddee> res) {
        for (Noddee node : res) {
            System.out.print(node.val + " ");
        }
    }
}

class Noddee {
    public int val;
    public Noddee left;
    public Noddee right;

    public Noddee(int val) {
        this.val = val;
    }
}
