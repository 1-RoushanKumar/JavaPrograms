package com.roushan._7_BitMagic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_BitOperReturnTwoNumberWhichIsNotRepeatingTwice {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 6, 3, 7, 7, 4};
        System.out.print("Initial array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        ArrayList<Integer> ans = findSingleNumber(nums);
        System.out.print("Elements that appear only once: ");
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.print("Unique Numbers: ");
        List<Integer> result = singleNumber3(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // Naive Approach: Time Complexity: O(N x log2M + M) where N is the number of elements in the input array
    // and M = (N/2 + 2) and Space Complexity : O(M) where M = N/2 + 1
    private static ArrayList<Integer> findSingleNumber(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (mpp.containsKey(nums[i])) {
                mpp.put(nums[i], mpp.get(nums[i]) + 1);
            } else {
                mpp.put(nums[i], 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (HashMap.Entry<Integer, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    // Optimal Approach: Time Complexity: O(2N) Space Complexity : O(1)
    public static List<Integer> singleNumber3(int[] nums) {
        int xorr = 0;

        for (int i = 0; i < nums.length; i++) {
            xorr = xorr ^ nums[i];
        }

        int rightmost;
        if (xorr == Integer.MIN_VALUE) {
            rightmost = Integer.MIN_VALUE;
        } else {
            rightmost = (xorr & (xorr - 1)) ^ xorr;
        }

        int bucket1 = 0;
        int bucket2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightmost) != 0) {
                bucket1 = nums[i] ^ bucket1;
            } else {
                bucket2 = nums[i] ^ bucket2;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(bucket1);
        result.add(bucket2);
        return result;
    }
}
