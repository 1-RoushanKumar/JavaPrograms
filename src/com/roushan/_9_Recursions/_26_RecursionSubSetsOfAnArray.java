package com.roushan._9_Recursions;

import java.util.ArrayList;
import java.util.List;

public class _26_RecursionSubSetsOfAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        createSubset(arr, 0, res, subset);
        System.out.println(res);
    }

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

}