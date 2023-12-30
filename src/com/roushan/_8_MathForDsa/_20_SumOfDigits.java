package com.roushan._8_MathForDsa;

import java.util.Scanner;

public class _20_SumOfDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter any Value");
        int num = in.nextInt();
        int sum = 0, rem;
        while (num != 0) {
            rem = num % 10;
            sum = sum + rem;
            num = num / 10;
        }
        System.out.println("Sum of the digit of number is " + sum);
    }
}
