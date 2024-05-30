package com.roushan._14_BST;

import java.util.Map;
import java.util.TreeMap;

public class _09_TreeMapInJava {
    public static void main(String[] args) {
        //tree map is used to implement a key value pair.
        //it also follows a self-Balancing Binary Tree.
        TreeMap<Integer, String> t = new TreeMap<>();
        t.put(1, "My");
        t.put(3, "Name");
        t.put(2, "is");
        t.put(8, "Roushan");
        //sorting done on the basis of key.
        System.out.println(t);
        System.out.println(t.containsKey(10));
        System.out.println(t.containsValue("Roushan"));
        //Iterative way for printing.
        for (Map.Entry<Integer, String> e : t.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        System.out.println(t.size());
        t.remove(2);
        System.out.println(t.size());
        System.out.println(t.containsKey(2));
        System.out.println();

        System.out.println(t.higherKey(3)); //it will give only key.
        System.out.println(t.lowerKey(3));
        System.out.println(t.floorKey(3));
        System.out.println(t.ceilingKey(3));
        System.out.println();

        System.out.println(t.higherEntry(3)); //it will give a key-value pair.
        System.out.println(t.higherEntry(3).getValue());//it will correspond key value.
        //similarly, we can use this with lowerEntry, floorEntry.
    }
}
//time complexity is O(log(n) for all.
//except size() and isEmpty() which will take O(1)
