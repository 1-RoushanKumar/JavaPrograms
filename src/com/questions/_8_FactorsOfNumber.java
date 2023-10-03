//Input a number and print all the factors of that number (use loops).

package com.questions;

import java.util.Scanner;

public class _8_FactorsOfNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter any number::");
        int n = in.nextInt();
        System.out.println("Factors of number " + n + " is :");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i+" ");
            }
        }
    }
}
