//we know right rotate already Ex-->arr = [1,2,3,4,5] In right rotate when k =2 ans= [4,5,1,2,3].
//but in left rotate when k = 2 ans = [3,4,5,1,2].

package com.questions;

import java.util.Arrays;

public class _72_LeftRotateArrayByOne {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 12;
        rotate(arr, k%arr.length);
        System.out.println(Arrays.toString(arr));
    }

    //Naive Method to solve this
//    static void rotate(int[] arr, int k) {
//        for (int j = 0; j < k; j++) {
//            for (int i = 0; i < arr.length - 1; i++) {
//                int temp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = temp;
//            }
//        }
//    }

    //optimized method with one loop.
    static void rotate(int[] arr,int k){
        rev(arr,0,k-1);
        rev(arr,k,arr.length-1);
        rev(arr,0,arr.length-1);
    }

    static void rev(int[] arr,int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
