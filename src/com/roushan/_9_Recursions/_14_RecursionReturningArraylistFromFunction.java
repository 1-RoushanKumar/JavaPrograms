//https://youtu.be/sTdiMLom00U?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=3006
package com.roushan._9_Recursions;

import java.util.ArrayList;

public class _14_RecursionReturningArraylistFromFunction {
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 1};
        int target = 1;
        ArrayList<Integer> list = find(arr, target, 0);
        System.out.println(list);
        ArrayList<Integer> ls = new ArrayList<>();
        ls = find1(arr, target, 0, ls);
        System.out.println(ls);
    }

    //taking a list inside the function.
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

    //passing list as arguments.
    static ArrayList<Integer> find1(int[] arr, int target, int i, ArrayList<Integer> ls) {
        if (i >= arr.length) {
            if (ls.isEmpty()) {
                ls.add(-1);
            }
            return ls;
        }
        if (arr[i] == target) {
            ls.add(i);
        }
        return find1(arr, target, i + 1, ls);
    }
}
