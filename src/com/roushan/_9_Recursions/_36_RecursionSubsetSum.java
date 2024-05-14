package com.roushan._9_Recursions;

import java.util.ArrayList;
import java.util.List;

//we need to count the number of subsets whose sum is equal to the Sum value.
public class _36_RecursionSubsetSum {
    public static void main(String[] args) {
        int[] arr = {10, 35, 25};
        int sum = 35;
        int ans = count(arr, sum);
        System.out.println("There are " + ans + " subset whose sum is equal to the required sum:" + sum);
    }

    public static int count(int[] arr, int sum) {
        //1st way first finding the subset then checking each subset for the sum.
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> subset = new ArrayList<>();
//        createSubset(arr, 0, res, subset);
//        System.out.println("Subsets are::" + res);
//        int count = 0;
//        for (List<Integer> re : res) {
//            int temp = 0;
//            for (Integer insideList : re) {
//                temp = temp + insideList;
//            }
//            if (temp == sum) {
//                count++;
//            }
//        }
//        return count;

        //2nd way
        int n = arr.length;
        int ans = countSubsets(arr, n, sum);
        return ans;
    }

    //1st way finding the subset then adding them them to check it is equal to sum or not.
    private static void createSubset(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        //Including the element.
        subset.add(nums[index]);
        createSubset(nums, index + 1, res, subset);
        //not including the element.
        subset.removeLast();
        createSubset(nums, index + 1, res, subset);
    }

    //2nd way finding checking sum while finding the subsets.
    public static int countSubsets(int[] arr, int n, int sum) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        return countSubsets(arr, n - 1, sum) + countSubsets(arr, n - 1, sum - arr[n - 1]);
    }
}
