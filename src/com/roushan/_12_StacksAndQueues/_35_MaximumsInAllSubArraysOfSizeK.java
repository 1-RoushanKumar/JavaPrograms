package com.roushan._12_StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

public class _35_MaximumsInAllSubArraysOfSizeK {

    //Naive approach this will take time complexity of O(n*k).
    static void maxINSubArray(int[] arr, int k) {
        //using with for loop.
        //the number of subArrays possible is (n-k+1)
        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = arr[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            System.out.print(max + " ");
        }

        //we can use while loop also like below.
//        int i = 0;
//        while (true) {
//            int z = k + i;
//            if (z > arr.length) {
//                break;
//            }
//            int max = arr[i];
//            for (int j = i; j < z; j++) {
//                max = Math.max(max, arr[j]);
//            }
//            System.out.print(max + " ");
//            i++;
//        }
    }

    //Efficient approach.This will take time complexity of O(n).
    void maxInSubArray(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for (int i = k; i < n; i++) {
            System.out.print(arr[dq.peek()] + " ");
            while (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && arr[i] >= dq.removeLast()) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        System.out.print(arr[dq.peek()] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {20, 5, 3, 8, 6, 15};
        int k = 4;
        maxINSubArray(arr, k);
        System.out.println();
        maxINSubArray(arr, k);
    }
}
