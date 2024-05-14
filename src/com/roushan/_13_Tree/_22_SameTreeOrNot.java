package com.roushan._13_Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class _22_SameTreeOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Using a previous made binary tree.
        _02_BinaryTreeDetail tree1 = new _02_BinaryTreeDetail();
        tree1.populate(sc);
        tree1.prettyDisplay();
        System.out.println();

        _02_BinaryTreeDetail tree2 = new _02_BinaryTreeDetail();
        tree2.populate(sc);
        tree2.prettyDisplay();
        System.out.println();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        //for finding, trees are the same or not just finds inorder or preorder or postorder of the tree and compares it.
        preOrder(tree1.root, list1);
        preOrder(tree2.root, list2);

//        (list1 == list2)
//        This comparison checks for reference equality between list1 and list2, which is not what we want
//        We should check whether the elements within list1 and list2 are the same.
//        Additionally, comparing two lists using == operator will always return false, even if their contents are the same.
//        So we use equals symbol (list1.equals(list2)) this will compare elements of the list1 and list2.
        if (list1.equals(list2)) {
            System.out.println("Both tree are same.");
        } else {
            System.out.println("Both tree are not same.");
        }

        //2nd way
        boolean flag = isSame(tree1.root, tree2.root);
        System.out.println(flag);
    }

    //1st way.
    public static void preOrder(_02_BinaryTreeDetail.Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.value);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    //2nd way.
    //comparing each node of both trees.
    public static boolean isSame(_02_BinaryTreeDetail.Node node1, _02_BinaryTreeDetail.Node node2) {
        if (node1 == null || node2 == null) {
            return (node1 == node2);
        }
        return (node1.value == node2.value) && isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }
}
