package com.roushan._4_BinarySearch;

public class _13_CountTheOccurrencesOfTargetElement {
    public static void main(String[] args) {
        int[] arr = {5, 10, 10, 15, 20, 20, 20};
        int target = 20;
        int ans = count(arr, target);
        System.out.println(ans);
    }

    //Simple Algorithm I first find the firstOccurrence of the target and then lastOccurrence of the target
    //then simple subtract both indexes and add 1 .
    static int count(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        int last;
        if (first == -1) {
            return 0;
        } else {
            last = lastOccurrence(arr, target);
        }
        return ((last - first) + 1);
    }

    static int firstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                if (mid > start && arr[mid] == arr[mid - 1]) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int lastOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                if (mid < end && arr[mid] == arr[mid + 1]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
