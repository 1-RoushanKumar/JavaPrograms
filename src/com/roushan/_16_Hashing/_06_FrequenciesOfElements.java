package com.roushan._16_Hashing;

import java.util.HashMap;
import java.util.Map;

public class _06_FrequenciesOfElements {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 10, 20, 30};
        printFreq(arr);
        System.out.println("**********************************************************");
        printFreq2(arr);
    }

    //Naive approach which will take time complexity of O(n2) and space complexity = O(1).
    public static void printFreq(int[] arr) {
        int n = arr.length;
        //we check all elements and count their frequency one by one
        //ie, start with 10 and count frequencies of 10 then check for second element.
        for (int i = 0; i < n; i++) {
            //but there is a chance where a similar element gets counted again.
            //for this we using a boolean and for loop will check that element is counted or not
            //if it is already counted then flag became true and we ignore this element and check for others.
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                continue;
            }
            int freq = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    freq++;
                }
            }
            System.out.println(arr[i] + " " + freq);
        }
    }

    //efficient solution we use hashmap which will take time complexity = O(n) and space complexity = O(n)
    public static void printFreq2(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i : arr) {
            h.put(i, h.getOrDefault(i, 0) + 1);
//               this will count the element i using h.getOrDefault(i, 0).
//               This method returns the value associated with the key i if it exists in the HashMap; otherwise, it returns a default value of 0.
        }
        for (Map.Entry<Integer, Integer> e : h.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
//        Map.Entry<Integer, Integer>: This part specifies the type of each entry in the HashMap. In this case, each entry consists of a key of type Integer and a value of type Integer.
//        e: This variable represents each entry in the HashMap h during each iteration of the loop.
//        e.getKey(): This method retrieves the key associated with the current entry e.
//        e.getValue(): This method retrieves the value associated with the current entry e.
    }
}
