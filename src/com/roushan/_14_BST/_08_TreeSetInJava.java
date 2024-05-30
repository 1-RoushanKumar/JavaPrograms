package com.roushan._14_BST;

import java.util.Iterator;
import java.util.TreeSet;

public class _08_TreeSetInJava {
    public static void main(String[] args) {
        //TreeSet internally a self-balancing Binary Search Tree.
        TreeSet<String> s = new TreeSet<>();
        //add function, which add all the elements in sorted order.
        s.add("My");
        s.add("Name");
        s.add("Is");
        s.add("Roushan");
        s.add("Kumar");
        //when we traverse the treeSet it will give output in sorted order.
        //you can see it printing the element in a sorted array.
        System.out.println(s);
        System.out.println(s.contains("Kumar"));
        //Similar to hashset it also ignore duplicate elements.
        //Printing throw iteration.
        for (String string : s) {
            System.out.println(string);
        }

        System.out.println("****************Another Example******************");
        //Another Example
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(10);
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(15);
        System.out.println(tree.lower(5));//it will return an element which is just smaller than 5.
        System.out.println(tree.higher(5));//it will return an element which is just greater than 5.
        System.out.println(tree.floor(5));//greatest-smaller or equal element to 5.
        System.out.println(tree.ceiling(5));//smallest-greater or equal element to 5.
        //if these values don't exit, then it will return null.

        System.out.println(tree.size());
        System.out.println(tree.remove(5));
        System.out.println(tree.size());
    }
}
//add(),contains(),remove(),floor(),ceiling(),higher(),lower() will take time complexity = O(log(n)).
//size(),isEmpty() will take O(1) time complexity.
//There are still more functions to check it out.
