package com.roushan._9_Recursions;

public class _10_RecursionCountNoOfZeroes {
    public static void main(String[] args) {
        int n = 305100061;
        int count = 0;
        int ans = countZeroes(n, count);
        System.out.println("Number of zeroes is " + n + " is " + ans);
        System.out.println();
        System.out.println(countZeroes1(n));
    }

//    static int count = 0;    //you can also solve it by taking static count but remove count from argument of the function.

    static int countZeroes(int n, int count) {
        if (n == 0) {
            return count;
        } else {
            if (n % 10 == 0) {
                return countZeroes(n / 10, count + 1);
            } else {
                return countZeroes(n / 10, count);
            }
        }
    }

    //2nd way
    static int countZeroes1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 10 == 0) {
            return 1 + countZeroes1(n / 10);
        } else {
            return countZeroes1(n / 10);
        }
    }
}
