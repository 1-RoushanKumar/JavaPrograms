package com.questions;

public class _27_MaxUsingArrayFunc {
    public static void main(String[] args) {
        int[] arr = {100, 96, 85, 36, 12};
//        System.out.println("Maximum Value:"+max(arr));
        System.out.println("Maximum value:"+max1(arr,0,4));
    }
    //for finding max value in all array.
//    static int max(int[] arr){
//        int maxval = arr[0];
//        for (int i = 1; i < arr.length ; i++) {
//            if (arr[i]>maxval){
//                maxval = arr[i];
//            }
//        }
//        return maxval;
//    }

//    //for finding max value in specific range.
    static int max1(int[] arr,int start,int end){
        int maxN = arr[start];
        for (int i = start+1; i <= end ; i++) {
            if (arr[i]>maxN){
                maxN = arr[i];
            }
        }
        return maxN;
    }
}
