package com.questions;

public class _92_RecursionSumOfNNumber {
    public static void main(String[] args) {
        int n = 10;
        int ans = sum(n);
        System.out.println("Sum of " + n + " natural number is " + ans);
    }

    static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }
}
