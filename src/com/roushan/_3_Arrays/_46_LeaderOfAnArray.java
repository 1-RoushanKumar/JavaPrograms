//Element are leader when all the right element from that element is smaller than it.
//Ex-->{5,3,2,6,1} here 6 and 1 is the leader.
package com.roushan._3_Arrays;

public class _46_LeaderOfAnArray {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 10, 6, 5, 2};
        find(arr);
    }

    //Naive Method Which take O(n^2) complexity.
//    static void find(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            boolean flag = false;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] <= arr[j]) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//                System.out.print(arr[i]+" ");
//            }
//        }
//    }

    //Optimized way with time complexity of O(n).
    //Here I started with the last element. And last element is always a leader because no element after it.
    //Now I start comparing element with the current leader from right to left.
    static void find(int[] arr){
        int Max = arr[arr.length-1]; //here max represent current leader
        System.out.print(Max);
        for (int i = arr.length-2; i >= 0 ; i--) {
            if (Max<arr[i]){
                Max=arr[i];
                System.out.print(" "+Max);
            }
        }
    }
}
