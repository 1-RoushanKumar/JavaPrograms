//example 48564647 how many times 4 appear in this number 3(ie is no. of occurence)

package com.questions;

import java.util.Scanner;

public class _05_countOccurrences {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number");
        int n = input.nextInt();
        System.out.println("Enter Target");
        int target = input.nextInt();
        int count = 0;
        while (n != 0) {
            int rem = n % 10;
            if (target == rem) {
                count++;
            }
            n /= 10;    //n= n/10.
        }
        System.out.println("No. of occurence of " + target + " is " + count);
    }
}
