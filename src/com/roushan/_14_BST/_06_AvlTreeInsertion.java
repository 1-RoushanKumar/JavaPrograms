package com.roushan._14_BST;

class Node6 {
    int key;
    Node6 left, right;
    int height;

    Node6(int d) {
        key = d;
        height = 1;
    }
}

public class _06_AvlTreeInsertion {
    Node6 root;

    // A utility function to get the height of the tree
    int height(Node6 N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node6 rightRotate(Node6 y) {
        Node6 x = y.left;
        Node6 T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node6 leftRotate(Node6 x) {
        Node6 y = x.right;
        Node6 T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node6 N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Recursive function to insert a key in the subtree rooted
    // with node and returns the new root of the subtree.
    Node6 insert(Node6 node, int key) {
        /* 1. Perform the normal BST insertion */
        if (node == null)
            return new Node6(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Equal keys are not allowed in BST
            return node;

        // Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this node
        int balance = getBalance(node);

        // If this node becomes unbalanced, there are four cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // If the node is already balanced, return it unchanged
        return node;
    }


    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void prettyDisplay(Node6 node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + node.key);
        } else {
            System.out.println(node.key);
        }

        prettyDisplay(node.left, level + 1);
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        _06_AvlTreeInsertion tree = new _06_AvlTreeInsertion();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 10);

        tree.prettyDisplay(tree.root, 0);
    }
}
