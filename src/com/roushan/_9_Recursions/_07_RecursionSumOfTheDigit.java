package com.roushan._9_Recursions;

public class _07_RecursionSumOfTheDigit {
    public static void main(String[] args) {
        int n = 564;
        int ans = digitSum(n);
        System.out.println("Sum of digit of " + n + " is " + ans);
    }

    static int digitSum(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (n % 10) + digitSum(n / 10);
        }
    }
}
