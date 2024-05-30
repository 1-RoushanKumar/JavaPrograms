package com.roushan._15_Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _10_MergeKSortedArray {
    public static void main(String[] args) {
        //here instead of 2d Array, it is possible it contains list of list.
        int[][] KArray = {{10, 20, 30}, {5, 15}, {1, 9, 11, 18}};
        //1st way.
        merge(KArray);
        System.out.println();
        //2nd way.
        int[] res = mergeSort(KArray, 0, KArray.length-1);
        System.out.println(Arrays.toString(res));
    }

    public static int[] mergeSort(int[][] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        int[] left = mergeSort(lists, start, mid);
        int[] right = mergeSort(lists, mid + 1, end);
        return merge(left, right);
    }

    public static int[] merge(int[] l1, int[] l2) {
        int[] result = new int[l1.length + l2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l1.length && j < l2.length) {
            if (l1[i] > l2[j]) {
                result[k] = l2[j];
                j++;
            } else {
                result[k] = l1[i];
                i++;
            }
            k++;
        }
        while (i < l1.length) {
            result[k] = l1[i];
            i++;
            k++;
        }
        while (j < l2.length) {
            result[k] = l2[j];
            j++;
            k++;
        }
        return result;
    }

    //1st approach which take time = O((n*k)*log(n*k)).
    public static void merge(int[][] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        //O(n*k) for traversing.
        for (int[] ints : arr) {
            for (int anInt : ints) {
                res.add(anInt);
            }
        }
        //hence size of res is n*k then time complexity of sorting = O((n*k)*log(n*k)).
        Collections.sort(res);
        System.out.println(res);
    }
}

