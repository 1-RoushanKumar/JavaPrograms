//Q23. Array Playlist GFG.

package com.roushan._4_BinarySearch;

public class _18_MaximumLengthEvenOddSubArray {
    public static void main(String[] args) {
        int[] arr = {7,10,13,14};
        int ans = find(arr);
        System.out.println(ans);
    }

    //Naive Method O(n^2).
//    static int find(int[] arr) {
//        int n = arr.length;
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            int count = 1;
//            for (int j = i; j < n - 1; j++) {
//                if (arr[j] % 2 == 0) {
//                    if (arr[j + 1] % 2 == 0) {
//                        break;
//                    } else {
//                        count++;
//                    }
//                } else {
//                    if (arr[j + 1] % 2 != 0) {
//                        break;
//                    } else {
//                        count++;
//                    }
//                }
//            }
//            max = Math.max(count, max);
//        }
//        return max;
//    }

    //Optimal Solution O(n).
    static int find(int[] arr) {
        int n = arr.length;
        int max = 0, count = 1, val = arr[0];
        for (int i = 1; i < n; i++) {
            if (val % 2 == 0) {
                if (arr[i] % 2 != 0) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            } else {
                if (arr[i] % 2 == 0) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            val = arr[i];
        }
        max = Math.max(max, count);
        return max;
    }
}
