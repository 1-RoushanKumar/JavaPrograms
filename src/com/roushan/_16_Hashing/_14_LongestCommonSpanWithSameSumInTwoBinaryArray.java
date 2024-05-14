package com.roushan._16_Hashing;

import java.util.HashMap;

public class _14_LongestCommonSpanWithSameSumInTwoBinaryArray {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 0, 0, 0};
        int[] arr2 = {1, 0, 1, 0, 0, 1};
        int ans = LongestCommon(arr1, arr2);
        System.out.println("Longest Common Sum::" + ans);
        ans = LongestCommon2(arr1, arr2);
        System.out.println("Longest Common Sum::" + ans);
    }

    //Naive : time = O(n2)
    public static int LongestCommon(int[] arr1, int[] arr2) {
        int res = 0;
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = i; j < n; j++) {
                sum1 += arr1[j];
                sum2 += arr2[j];
                if (sum1 == sum2) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    //Optimal Solution Time = O(n) and space = O(N)
    public static int LongestCommon2(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr1[i] - arr2[i];
        }
        int sum = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        int preSum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            preSum += temp[i];
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
