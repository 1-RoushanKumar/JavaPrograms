package com.roushan._12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/sum-of-subarray-ranges/description/
public class _36_SumOfSubArrayRanges {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        //here sub-arrays are {{1},{2},{3},{1,2},{2,3},{1,2,3}}
        long ans = sumRanges(arr);
        System.out.println(ans);

        ans = subArrayRanges(arr);
        System.out.println(ans);
    }

    public static long sumRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return (int) res;
    }

    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        Deque<Integer> q = new ArrayDeque<>(); // store index

        q.add(-1);
        for (int i = 0; i <= n; i++) {
            while (q.peekLast() != -1 && (i == n || nums[q.peekLast()] <= nums[i])) {
                int cur = q.removeLast();
                int left = q.peekLast();
                int right = i;
                sum += (long) (cur - left) * (right - cur) * nums[cur];
            }
            q.add(i);
        }

        q.clear();
        q.add(-1);
        for (int i = 0; i <= n; i++) {
            while (q.peekLast() != -1 && (i == n || nums[q.peekLast()] >= nums[i])) {
                int cur = q.removeLast();
                int left = q.peekLast();
                int right = i;
                sum -= (long) (cur - left) * (right - cur) * nums[cur];
            }
            q.add(i);
        }
        return sum;
    }
}
