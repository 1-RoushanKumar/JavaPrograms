package com.roushan._16_Hashing;

import java.util.HashSet;

public class _09_TwoSumOnUnSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 2, 8, 15, -8};
        int sum = 17;
        boolean flag = check(arr, sum);
        System.out.println(flag);
        flag = check2(arr, sum);
        System.out.println(flag);
    }

    //1.Naive approach tm = O(n2) and space = O(1)
    public static boolean check(int[] arr, int sum) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }
    //2.Another Approach is First sort the array and use two pointer methods to find the two sum
    //it will take tm = O(nlog(n)) and space = O(1).

    //3.Third approach using hashset which will take Tm = O(n), Space = O(n)
    public static boolean check2(int[] arr, int sum) {
        int n = arr.length;
        HashSet<Integer> s = new HashSet<>();
        //here we check the difference of sum - arr[i] is in hash or not.
        for (int i = 0; i < n; i++) {
            if (s.contains(sum - arr[i])) {
                return true;
            }
            s.add(arr[i]);
        }
        return false;
    }
}
