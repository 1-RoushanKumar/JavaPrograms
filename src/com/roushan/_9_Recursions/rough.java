package com.roushan._9_Recursions;

import java.util.ArrayList;
import java.util.Arrays;

public class rough {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 2, 8, 3, 0};
        int[] target = {2, 0};
        call(arr,target,0,0);
        System.out.println(list);
    }

    static ArrayList<Integer> list = new ArrayList<>();

    static void call(int[] arr, int[] target, int i, int s) {
        if (s == target.length) {
            return;
        }
        if (i == arr.length) {
            list.add(-1);
            call(arr, target, 0, s + 1);
        } else {
            if (arr[i] == target[s]) {
                list.add((i));
                call(arr, target, i, s + 1);
            } else {
                call(arr, target, i + 1, s);
            }
        }
    }
}
