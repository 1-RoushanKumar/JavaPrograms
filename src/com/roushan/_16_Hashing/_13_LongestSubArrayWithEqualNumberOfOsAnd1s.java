package com.roushan._16_Hashing;

import java.util.HashMap;

public class _13_LongestSubArrayWithEqualNumberOfOsAnd1s {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        int ans = longLen(arr);
        System.out.println("Longest SubArray of O and 1 ::" + ans);
        ans = longlen2(arr);
        System.out.println("Longest SubArray of O and 1 ::" + ans);
    }

    //Naive: Time = O(n2)
    public static int longLen(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int c0 = 0, c1 = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0) {
                    c0++;
                } else {
                    c1++;
                }
                if (c0 == c1) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    //Optimal: Time = O(n) and Space = O(n)
    public static int longlen2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int sum = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        int preSum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            if (preSum == sum) {
                res = i + 1; // Update result to include the current index
            }
            if (!h.containsKey(preSum)) {
                h.put(preSum, i);
            }
            if (h.containsKey(preSum - sum)) {
                int k = h.get(preSum - sum);
                res = Math.max(res, i - k); // Calculate the length of sub-array
            }
        }
        return res;
    }
}
