package com.roushan._16_Hashing;

import java.util.*;

public class _04_HashMap {
    public static void main(String[] args) {
        // Create an empty hash map
        HashMap<String, Integer> m = new HashMap<>();

        // Add elements to the map
        m.put("gfg", 10);
        m.put("ide", 15);
        m.put("courses", 20);

        // Print size and content
        System.out.println(m);
        System.out.println(m.size());

        // Iterating over HashMap
        for (Map.Entry<String, Integer> e : m.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());

        // Check for a key
        if (m.containsKey("ide"))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Remove key "ide"
        // and returns the associated value 15
        m.remove("ide");
        System.out.println(m.size());

        // Check for a Value
        if (m.containsValue(15))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Get value corresponding to passed key
        // <"ide", 15>
        System.out.println(m.get("gfg"));

        // The given key is absent
        System.out.println(m.get("practice"));
    }
}
