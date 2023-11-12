//given an integer array arr sorted in non-decreasing order return an array of the squares
//of each number sorted in non-decreasing order.
//Ex = arr = {2,3,4,7} then sorted arr ={4,9,16,49}
//Ex = arr ={-10,-3,-2,1,4,5} then sorted arr={1,4,9,16,25,100}
//https://youtu.be/FmXF2df9OVo?list=PLxgZQoSe9cg00xyG5gzb5BMkOClkch7Gr&t=2747

package com.questions;

import java.util.Arrays;
import java.util.Scanner;

public class _39_SortSquaresInNonDecreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the element of the array::");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before sorting " + Arrays.toString(arr));
        System.out.println("Array After sorting " + Arrays.toString(sortSquares(arr)));
    }
    static int[] sortSquares(int[] arr) {
        int[] ans = new int[arr.length];
        int start = 0;
        int end = arr.length - 1, k = 0;
        while (start <= end) {
            if (Math.abs(arr[start]) > Math.abs(arr[end])) {
                ans[k] = (int) Math.pow(arr[start], 2);
                k++;
                start++;
            } else {
                ans[k] = (int) Math.pow(arr[end], 2);
                k++;
                end--;
            }
        }
        //suppose we have arr = {-10,-3,-1,2,4,5}
        //then after doing above algorithm it will become {100,25,16,9,4,1}
        //so now we only need to reverse it for getting required answer.(ie {1,4,9,16,25,100}
        reverse(ans);
        return ans;
    }
    static void reverse(int[] ans) {
        int start = 0;
        int end = ans.length - 1;
        while (start < end) {
            int temp = ans[start];
            ans[start] = ans[end];
            ans[end] = temp;
            start++;
            end--;
        }
    }
}
