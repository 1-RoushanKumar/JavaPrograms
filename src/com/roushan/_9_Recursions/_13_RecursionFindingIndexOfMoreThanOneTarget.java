package com.roushan._9_Recursions;

import java.util.ArrayList;
import java.util.Arrays;

public class _13_RecursionFindingIndexOfMoreThanOneTarget {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 5, 8, 3, 0};
        int[] target = {5, 8};
        //1st method.Only for distinct.
        for (int j : target) {
            count(arr, j, 0);
        }
        System.out.println("Indices of the target elements::" + list);

        //2nd method.Only for distinct.
        int[] empty = new int[target.length];
        System.out.println(Arrays.toString(ans(arr, empty, target, 0, 0)));

        //3rd method.For Both
        ArrayList<Integer> val = new ArrayList<>();
        for (int j : target) {
            countTar(arr, j, 0, val);
        }
        System.out.println(val);
    }

    //1st method One problem with this is it not returning the index of the duplicate elements.
    static ArrayList<Integer> list = new ArrayList<>();

    static void count(int[] arr, int target, int i) {
        if (i == arr.length) {
            list.add(-1);
            return;
        }
        if (arr[i] == target) {
            list.add(i);
            return;
        }
        count(arr, target, i + 1);
    }

    //2nd Method same as above, but this time returning an array of indices.
    static int[] ans(int[] arr, int[] empty, int[] target, int i, int j) {
        if (j == target.length) {
            return empty;
        }
        if (i == arr.length) {
            empty[j] = -1;
            return ans(arr, empty, target, 0, j + 1);
        } else {
            if (arr[i] == target[j]) {
                empty[j] = i;
                return ans(arr, empty, target, 0, j + 1);
            } else {
                return ans(arr, empty, target, i + 1, j);
            }
        }
    }

    //3rd Method Above Problem solved
    static ArrayList<Integer> countTar(int[] arr, int target, int i, ArrayList<Integer> list) {
        if (i == arr.length) {
            if (list.isEmpty()) {
                list.add(-1);
            }
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        }
        return countTar(arr, target, i + 1, list);
    }
}
