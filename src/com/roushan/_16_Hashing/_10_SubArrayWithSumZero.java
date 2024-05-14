package com.roushan._16_Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class _10_SubArrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {1, 4, 13, -3, -10, 5};
        boolean flag = check(arr);
        System.out.println(flag);
        flag = check2(arr);
        System.out.println(flag);
    }

    //Naive approach which will take time = O(n2)
    public static boolean check(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    //Optimal solution which will take time - O(n) and space = O(n)
    public static boolean check2(int[] arr) {
        int n = arr.length;
        HashSet<Integer> h = new HashSet<>();
        //the idea is we keep finding the prefix sum and adding them into hashtable
        //when we insert the same prefix sum in hashtable that means there exist a subArray
        //sum which is 0.
        int pre_sum = 0;
        for (int i = 0; i < n; i++) {
            pre_sum += arr[i];
            if (h.contains(pre_sum)) {
                return true;
            }
            //edge case sometimes the prefix sum not able to find sum = 0
            //ex [-3,2,1,4] while doing prefix sum it get ignored
            //so if the pre_sum itself become 0 then, it also indicates the sum can be 0.
            if (pre_sum == 0) {
                return true;
            }
            h.add(pre_sum);
        }
        return false;
    }
}
