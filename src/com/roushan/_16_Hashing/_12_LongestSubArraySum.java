package com.roushan._16_Hashing;

import java.util.HashMap;

public class _12_LongestSubArraySum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 3, 1, 0, 1, 6};
        int sum = 5;
        int count = check1(arr, sum);
        System.out.println("Longest Sub-array::" + count);
        count = check2(arr, sum);
        System.out.println("Longest Sub-array::" + count);
    }

    // Naive Approach which takes time = O(n2)
    private static int check1(int[] arr, int sum) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = i; j < n; j++) {
                s = s + arr[j];
                if (s == sum) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static int check2(int[] arr, int sum) {
        int n = arr.length;
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
