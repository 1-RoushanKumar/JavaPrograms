package com.roushan._13_Tree;

import java.util.ArrayList;
import java.util.Scanner;

//lec - 23 and 24 gfg.
public class _20_LeastCommonAncestors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree = new _02_BinaryTreeDetail();
        tree.populate(sc);
        tree.prettyDisplay();
        System.out.println();
        int n1 = 40;
        int n2 = 50;
        _02_BinaryTreeDetail.Node ans = lca(tree.root, n1, n2);
        if (ans != null) {
            System.out.print(ans.value);
        }
        _02_BinaryTreeDetail.Node ans2 = lcaTwo(tree.root, n1, n2);
        System.out.print(ans2.value);
    }

    //1st way
    //Time complexity = O(n)(for findPath1 call) + O(n)(for findPath2 call) + O(n)(for loop for finding common ancestors)
    //                = 3O(n) = O(n).
    public static _02_BinaryTreeDetail.Node lca(_02_BinaryTreeDetail.Node node, int n1, int n2) {
        ArrayList<_02_BinaryTreeDetail.Node> path1 = new ArrayList<>();
        ArrayList<_02_BinaryTreeDetail.Node> path2 = new ArrayList<>();
        //this will check for given n1 and n2 path is available or not.
        if (!findPath(node, path1, n1) || !findPath(node, path2, n2)) {
            return null;   //if no path for any node then it will return null.
        }
        for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
            if (path1.get(i + 1) != path2.get(i + 1)) {
                return path1.get(i);
            }
        }
        return null;
    }

    //this will check path availability and path ancestors or route to reach n1 or n2.
    public static boolean findPath(_02_BinaryTreeDetail.Node node, ArrayList<_02_BinaryTreeDetail.Node> p, int n) {
        if (node == null) {
            return false;
        }
        p.add(node);
        if (node.value == n) {
            return true;
        }
        if (findPath(node.left, p, n) || findPath(node.right, p, n)) {
            return true;
        }
        p.removeLast();
        return false;
    }

    //2nd way but we need to assume that both n1 and n2 are present in the tree.
    //Time complexity = O(n) same as above but difference is here we need to do
    //only one traversal.
    public static _02_BinaryTreeDetail.Node lcaTwo(_02_BinaryTreeDetail.Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        if (node.value == n1 || node.value == n2) {
            return node;
        }
        _02_BinaryTreeDetail.Node lca1 = lcaTwo(node.left, n1, n2);
        _02_BinaryTreeDetail.Node lca2 = lcaTwo(node.right, n1, n2);

        if (lca1 != null && lca2 != null) {
            return node;
        }
        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }
}
