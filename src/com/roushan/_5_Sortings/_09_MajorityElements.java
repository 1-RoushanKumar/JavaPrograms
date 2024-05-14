package com.roushan._5_Sortings;
//https://leetcode.com/problems/majority-element/
//https://youtu.be/wD7fs5P_MVo
//majority elements are those whose occurrences are greater than the (half of the size of the array).

import java.util.*;

public class _09_MajorityElements {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int ans  = majority1(arr);
        System.out.println("Majority elements are:: "+ans);
        ans = majority2(arr);
        System.out.println("Majority elements are:: "+ans);
        ans = majority3(arr);
        System.out.println("Majority elements are:: "+ans);
        ans = majority4(arr);
        System.out.println("Majority elements are:: "+ans);
    }
    //brute force O(n2) time complexity.
    public static int majority1(int[] nums){
        int k = nums.length/2;
        for(int i=0;i<nums.length;i++){
            int count = 0;
            for(int j=0;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count > k){
                return nums[i];
            }
        }
        return -1;
    }

    //optimal approach O(nlogN) time complexity
    //if the elements appear more than n/2 then it must crossing n/2 th index of the array.
    public static int majority2(int[] nums){
        Arrays.sort(nums);
        int k= nums.length/2;
        return nums[k];
    }

    //using hashtable O(n) time complexity and O(n) space complexity.
    public static int majority3(int[] nums){
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            n = n / 2;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > n) {
                    return entry.getKey();
                }
            }
            return 0;
    }

    //using algorithm name moore's voting algorithm which take only O(n) time complexity.
    public static int majority4(int[] nums){
        int majority = nums[0];
        int votes = 1;

        for (int i = 1; i < nums.length; i++) {
            if (votes == 0){
                votes++;
                majority = nums[i];
            } else if (majority == nums[i]) {
                votes++;
            }else{
                votes--;
            }
        }
        return majority;
    }
}
