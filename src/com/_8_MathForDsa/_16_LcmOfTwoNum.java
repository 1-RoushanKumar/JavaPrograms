package com._8_MathForDsa;

import java.util.Scanner;

public class _16_LcmOfTwoNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two number::");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int LCM = lcm(num1, num2);
        System.out.println(LCM);

        //1st method.
//        int max = Math.max(num1, num2);    //here I have taken max variable because instead of starting loop i = 1,
//                                            // I started from max of two number for decreasing checking.
//
//        for (int i = max; i <= num1 * num2; i++) {
//            if (i % num1 == 0 && i % num2 == 0) {
//                System.out.println("Lcm of num1 and num2 is " + i);
//                break;
//            }
//        }
    }

    //2nd method First find gcd with euclid method then
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
