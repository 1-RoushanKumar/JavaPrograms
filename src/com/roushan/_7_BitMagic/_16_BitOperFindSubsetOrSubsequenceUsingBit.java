//Bitmagic playlist lecture no 11 Power set.
//Only for distinct elements.
package com.roushan._7_BitMagic;

import java.util.ArrayList;
import java.util.Arrays;

public class _16_BitOperFindSubsetOrSubsequenceUsingBit {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("String Subset of::" + str);
        subsetString(str);

        System.out.println();
        System.out.println("-------------------------------------");

        int[] arr = {1,2,3};
        System.out.println("Array Subset of::" + Arrays.toString(arr));
        subSetInt(arr);
    }

    static void subsetString(String str) {
        int n = str.length();
        int powSize = (int) Math.pow(2, n);

        for (int i = 0; i < powSize; i++) {
            for (int j = 0; j < n; j++) {
                int val = (1 << j) & i;
                if (val != 0) {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.print(" ");
        }
    }

    static void subSetInt(int[] arr) {
        int n = arr.length;
        int powSize = (int) Math.pow(2, n);

        for (int i = 0; i < powSize; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int val = (1 << j) & i;
                if (val != 0) {
                    list.add(arr[j]);
                }
            }
            System.out.print(list + " ");
        }
    }
}
