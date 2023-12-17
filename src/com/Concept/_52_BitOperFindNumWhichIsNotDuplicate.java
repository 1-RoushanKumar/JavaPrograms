package com.Concept;

public class _52_BitOperFindNumWhichIsNotDuplicate {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 2, 1, 3, 6, 4};
        System.out.println(ans(arr));
    }

    private static int ans(int[] arr) {
        int unique = 0;
        for (int j : arr) {
            unique = unique ^ j;  //here ^ means xor.
        }
        return unique;
    }
}
//detail in notebook.
//This method is applicable for all array where some element repeating even number of time but one element is repeating only one time.

