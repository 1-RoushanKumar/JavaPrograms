package com.roushan._16_Hashing;

import java.util.*;

public class _03_HashSet {
    public static void main(String[] args) {
        HashSet<String> h = new HashSet<String>();
        h.add("My");
        h.add("Name");
        h.add("is");
        h.add("Roushan");

        System.out.println(h);

        System.out.println(h.contains("Name"));
        System.out.println(h.contains("Rohit"));

        for (String string : h) {
            System.out.print(string + " ");
        }
        System.out.println();
        System.out.println(h.size());

        h.remove("Name");
        System.out.println(h.size());

        for (String s : h) {
            System.out.print(s + " ");
        }
        System.out.println("\n" + h.isEmpty());
        h.clear();
        System.out.println(h.isEmpty());
    }
}
