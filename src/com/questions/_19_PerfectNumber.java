//In number theory, a perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. For example, 6
// has divisors 1, 2, and 3(excluding itself), and 1+2+3=6, so 6is a perfect number. Other perfect numbers are 28, 496, and 8128.

package com.questions;

import java.util.Scanner;

public class _19_PerfectNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Value");
        int num = in.nextInt(), sum = 0;

        System.out.println("Factors are::");
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                System.out.print(i+" ");
                sum = sum + i;
            }
        }
        System.out.println("\nSum of the factors is "+sum);
        if (sum == num) {
            System.out.println("So Perfect Number.");
        } else {
            System.out.println("Not a Perfect Number");
        }
    }
}
