//https://youtu.be/sTdiMLom00U?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=3006
package com.roushan._9_Recursions;

import java.util.ArrayList;

public class _14_RecursionReturningArraylistFromFunction {
    public static void main(String[] args) {
        int[] arr = {1, 3, 52, 1};
        int target = 1;
        ArrayList<Integer> list = find(arr, target, 0);
        System.out.println(list);
    }

    static ArrayList<Integer> find(int[] arr, int target, int i) {
        ArrayList<Integer> list = new ArrayList<>();

        if (i == arr.length) {
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        }
        ArrayList<Integer> ansFromBelowCalls = find(arr, target, i + 1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}
