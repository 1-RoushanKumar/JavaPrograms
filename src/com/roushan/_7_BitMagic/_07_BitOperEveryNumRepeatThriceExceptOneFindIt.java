//https://youtu.be/5Bb2nqA40JY
package com.roushan._7_BitMagic;

import java.util.*;

public class _07_BitOperEveryNumRepeatThriceExceptOneFindIt {

    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 6, 3, 3, 3};
        int ans = findSingleNumber(arr);
        System.out.println("Unique element is:: " + ans);
        ans = findSingleNumber2(arr);
        System.out.println("Unique element is:: " + ans);
        ans = findSingleNumber3(arr);
        System.out.println("Unique element is:: " + ans);
        ans = findSingleNumber4(arr);
        System.out.println("Unique element is:: " + ans);
    }

    //Naive approach::using map Time Complexity: O(N x log2M + M) Space Complexity: O(M)where M = N/3 + 1,
    public static int findSingleNumber(int[] nums) {
        // Initialise a hashmap to store the
        // element as key and frequency as value
        Map<Integer, Integer> mpp = new HashMap<>();

        // Populate the hashmap with
        // the frequency of each element
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        // Iterate through the hashmap to
        // find the element with frequency 1
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        // If no element with frequency 1 is
        // found, return -1 as input invalid
        return -1;
    }

    //Efficient approach with Time Complexity: O(32*N) and Space Complexity = O(1)
    public static int findSingleNumber2(int[] nums) {
        int ans = 0;

        // Iterate through each bit
        // position (from 0 to 31)
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            // Counter to count the number of
            // set bits at the current bit position
            int cnt = 0;

            // Iterate through each
            // number in the input array
            for (int i = 0; i < nums.length; i++) {
                // Check if the bit at bitIndex is
                // set in the current number nums.get(i)
                if ((nums[i] & (1 << bitIndex)) != 0) {
                    // Increment the counter
                    // if the bit is set
                    cnt++;
                }
            }
            // If the count of set bits at the current bit
            // position is not divisible by 3 (i.e., cnt % 3 == 1)
            // Set the corresponding bit in the answer variable ans
            if (cnt % 3 == 1) {
                ans |= (1 << bitIndex);
            }
        }
        // Return the decimal
        // representation of the answer
        return ans;
    }

    //More Efficient approach Time Complexity: O(N log2N) and Space Complexity = O(1)
    public static int findSingleNumber3(int[] nums) {
        // Sort the input array
        Arrays.sort(nums);

        // Traverse the sorted array and check
        // middle elements of groups of three
        for (int i = 1; i < nums.length; i += 3) {
            // If the current element is not equal to
            // the previous one, it's the unique element
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }

        // If the unique element is not found in the
        // loop then it has to be the last element
        return nums[nums.length - 1];
    }


    public static int findSingleNumber4(int[] arr) {
        int ones = 0, twos = 0;
        for (int i = 0; i < arr.length; i++) {
            ones = (ones ^ arr[i]) & ~twos;
            twos = (twos ^ arr[i]) & ~ones;
        }
        return ones;
    }

}