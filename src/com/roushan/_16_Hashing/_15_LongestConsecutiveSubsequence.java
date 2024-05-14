package com.roushan._16_Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class _15_LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {3, 8, 4, 5, 7};
        int ans = maxCon(arr);
        System.out.println("Longest Consecutive Subsequence is ::" + ans);
        ans = maxCon2(arr);
        System.out.println("Longest Consecutive Subsequence is ::" + ans);
    }

    //1.Sorting which takes time = O(nlog(N)) and space = O(1).
    public static int maxCon(int[] arr) {
        int n = arr.length;
        //the idea is first sort the array and increment one by one consecutive elements
        //elements and keep counting them when consecutive elements not fount save that count
        //in res variable and continue search for next consecutive.
        Arrays.sort(arr);
        int res = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        return res;
    }

    //2.Using Hashset which will take time = O(n) and space = O(n)
    //But we may want to know how time = O(n) because it look like its taking O(n2).(GFG 26)
    public static int maxCon2(int[] arr) {
        int res = 0;
        int n = arr.length;
        //the idea is first add all the element in hashTable
        HashSet<Integer> h = new HashSet<>();
        for (int i : arr) {
            h.add(i);
        }
        //Now we check does it contain element which just 1 smaller than the required element
        //if not then we take curr = 1 and using while loop we keep checking is hashtable contain
        //then consecutive of arr[i]
        for (int i = 0; i < n; i++) {
            if (!h.contains(arr[i] - 1)) {
                int curr = 1;
                while (h.contains(arr[i] + curr)) {
                    curr++;
                }
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
