package com.roushan._8_MathForDsa;

import java.util.Scanner;

public class _17_HCFOfTwoNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two number::");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int ans = gcd(num1, num2);
        System.out.println(ans);

//        1st method -->this method take O(min(num1,num2)) complexity.
//        int min = Math.min(num1, num2);
//        for (int i = min; i >= 1; i--) {
//            if (num1 % i == 0 && num2 % i == 0) {
//                System.out.println("Hcf of num1 and num2 is " + i);
//                break;
//            }
//        }

        //2nd method -->Euclidean Algorithm
        //if given a and b two numbers then Let b be the smaller than a
        //gcd(a,b) = gcd(a-b,b).

//        while (num1 != num2) {
//            if (num1 > num2) {
//                num1 = num1 - num2;
//            } else {
//                num2 = num2 - num1;
//            }
//
//        }
//        System.out.print("HCF is::" + num1);
    }

    //3rd method -->Optimized Euclidean Algorithm
//    static int gcd(int a, int b) {
//        if (b == 0) {
//            return a;
//        } else {
//            return gcd(b, a % b);
//        }
//    }

    //4way recursive way.
    static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        } else {
            if (a > b) {
                return gcd(a - b, b);
            } else {
                return gcd(a, b - a);
            }
        }
    }
}
