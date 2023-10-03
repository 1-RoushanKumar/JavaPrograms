package com.questions;

import java.util.Scanner;

public class _16_LcmOftwoNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two number::");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int max = Math.max(num1, num2);    //here i taken max variable because instead of starting loop i = 1,
                                            // i started from max of two number for decreasing checking.

        for (int i = max; i <= num1 * num2; i++) {
            if (i % num1 == 0 && i % num2 == 0) {
                System.out.println("Lcm of num1 and num2 is " + i);
                break;
            }
        }
    }
}
