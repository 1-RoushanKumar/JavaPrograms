package com.roushan._13_Tree;

import java.lang.*;
public class _15_BinaryTreeFromInorderAndPreorder{
    public static void main(String []args)
    {
        int []in={20,10,40,30,50};
        int []pre={10,20,30,40,50};
        int n= in.length;
        Node root=cTree(in, pre, 0, n-1);
        prettyDisplay(root,0);
    }
    static int preIndex=0;
    public static Node cTree(int []in,int []pre,int is,int ie){
        if(is>ie)return null;
        Node root=new Node(pre[preIndex++]);

        int inIndex=is;
        for(int i=is;i<=ie;i++){
            if(in[i]==root.key){
                inIndex=i;
                break;
            }
        }
        root.left=cTree(in, pre, is, inIndex-1);
        root.right=cTree(in, pre, inIndex+1, ie);
        return root;
    }
    public static void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.key);
        } else {
            System.out.println(node.key);
        }
        prettyDisplay(node.left, level + 1);
    }
    public static class Node{
        int key;
        Node left;
        Node right;
        Node(int k){
            key=k;
            left=right=null;
        }
    }
}
