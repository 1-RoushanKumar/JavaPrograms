//Write a function that returns all prime numbers between two given numbers.

package com.questions;

import java.util.Scanner;

public class _25_PrintingPrimeNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Starting point::");
        int start = in.nextInt();
        System.out.println("Enter the Ending point::");
        int end = in.nextInt();

        System.out.println("Prime Number between " + start + " and " + end);
        for (int i = start; i <= end; i++) {
            if (checkPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean checkPrime(int num) {
        if (num == 1) {
            return false;
        } else {
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
