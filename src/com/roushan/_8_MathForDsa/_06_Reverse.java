package com.roushan._8_MathForDsa;

import java.util.Scanner;

public class _06_Reverse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number");
        int n = input.nextInt();
        int rem, rev = 0;
        
        while (n != 0) {
            rem = n % 10;
            rev = (rev * 10) + rem;
            n /= 10;
        }
        System.out.println("After Reversing: "+rev);
    }
}
