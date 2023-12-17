//given an array of n number that has values in range [1..n+1]. every no appears exactly once.
//Hence one no. is missing. Find the missing no.
package com.Concept;

public class _64_BitOperFindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 6, 4, 8};
        int ans = find(arr);
        System.out.println("Missing Element is::" + ans);
    }

    static int find(int[] arr) {
        int n = arr.length;
        int val1 = 0;
        int val2 = 0;
        //first xor all elements of the array.
        for (int j : arr) {
            val2 = val2 ^ j;
        }
        //now xor all the element from 1 to n+1(including the missing number)
        for (int i = 1; i <= n + 1; i++) {
            val1 = val1 ^ (i);
        }
        //when i xor both val1 and val2 then missing value remained.
        return val1 ^ val2;
    }
    //example arr = {1,3}.Array of length of 2. and number from 1 to 3(1,2,3).
    //first xor array element = 1^3 = 01^11=10
    //second xor all element from 1 to 3 = 1^2^3 =01^10^11=00
    //xor of 10^00=10 ie 10=2 hence missing number is 2.
}
