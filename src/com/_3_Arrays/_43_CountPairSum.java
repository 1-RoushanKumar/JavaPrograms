//we have given an distinct array {-1,1,5,7} then we need to return total pair whose sum is equal to target
//here there are 3 pairs (-1,7),(1,5).
//Array can be unsorted also.Naive method is to use two for loop and count when sum is equal to target.(it works for both
//sorted and unsorted array but bad complexity.)
//Optimal solution is two pointer method which take O(n) when array is sorted.If array is not sorted then first we need
//to sort it first.Then complexity become O(nlog(n)) { O(nlog(n)) for sorting + O(n) for two pointer method hence O(nlog(n)) }
// better then O(n^2).
//https://www.geeksforgeeks.org/count-pairs-with-given-sum/

package com._3_Arrays;

public class _43_CountPairSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 7;
        //If array is not sorted then we sort with algorithm or inbuilt java Array.sort(arr).
        int ans = count(arr, target);
        System.out.println(ans);
    }

    static int count(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int Count = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                Count++;
                start++;
                end--;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return Count;
    }
}
//if array element is repeating then use Hashing technique that we will learn after some time.
