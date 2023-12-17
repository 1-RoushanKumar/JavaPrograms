package com.questions;

public class _95_RecursionPalindromeOrNot {
    public static void main(String[] args) {
        int n = 5698965;
        boolean flag = isPalindrome(n);
        System.out.println(flag);
    }

    static boolean isPalindrome(int n) {
        int new_n = reverse(n);
        return new_n == n;
    }

    static int reverse(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (((n % 10) * (int) Math.pow(10, count(n / 10))) + reverse(n / 10));
        }
    }

    static int count(int n) {
        int coun = 0;
        while (n != 0) {
            coun++;
            n = n / 10;
        }
        return coun;
    }
}
