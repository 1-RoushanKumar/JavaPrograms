package com.questions;

import java.util.Scanner;

public class _21_PrimeNumberorNot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter any number::");
        int num = in.nextInt();
        boolean flag = isPrime(num);
        if (flag) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}
