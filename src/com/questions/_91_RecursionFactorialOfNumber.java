package com.questions;

public class _91_RecursionFactorialOfNumber {
    public static void main(String[] args) {
        int n = 5;
        int ans = fact(n);
        System.out.println("Factorial of " + n + " is " + ans);
    }

    static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
