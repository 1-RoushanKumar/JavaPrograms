package com.roushan._16_Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _17_MoreThanNDivideKOccurrences {
    public static void main(String[] args) {
        int[] arr = {30, 10, 20, 20, 10, 20, 30, 30};
        int k = 4;
        printOccurrence1(arr, k);
        System.out.println("******************************************************************");
        printOccurrences(arr, k);
    }

    //Naive Solution which takes time = O(nlog(N)) and space = O(1)
    //The idea is sort the array and count the element and check
    //it is greater than n/k or not.
    public static void printOccurrence1(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            }
            if (count > n / k) {
                System.out.println(arr[i]);
                count = 1;
            }
        }
    }

    //Optimal Solution which takes time = O(n) and space = O(n)
    //The idea is we add that key in the hashset and also add the value which increment if same value added again.
    //After adding them in hashset, we check which keys have value greater n/k and print them.
    public static void printOccurrences(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int j : arr) {
            h.put(j, h.getOrDefault(j, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : h.entrySet()) {
            if (e.getValue() > n / k) {
                System.out.println(e.getKey() + " ");
            }
        }
    }
}
//HashMap solution is good, but it's not better because first we're adding the element in the hash and then traveling in it
//there is one more optimal solution of this in GFG Lec = 29 (Use Moore Voting Algorithm).