//We need to find frequency of the element in the sorted array.

package com._3_Arrays;

public class _48_FrequencyOfTheElement {
    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 40,40,40};
        freq(arr);
    }

    //Optimized way O(n) only.
    static void freq(int[] arr) {
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                System.out.println(arr[i] + " " + count);
                count = 1;
            }
        }
        System.out.println(arr[arr.length - 1] + " " + count);
    }
}
//I initialized count with 1 because at least one frequency of element is present.
//I make a condition where I check arr[i] is equal to arr[i+1] or not if it is then count get incremented.When next element
//is not equal then I printed the value and Again make count=1.
//But here one situation arising that loop running for only arr.length-2, Due to this reason it will not able to reach else
// condition ,So I printed last element after loop.
