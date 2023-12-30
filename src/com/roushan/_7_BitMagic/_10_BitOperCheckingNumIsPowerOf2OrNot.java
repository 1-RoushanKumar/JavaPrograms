package com.roushan._7_BitMagic;

import java.util.Scanner;

public class _10_BitOperCheckingNumIsPowerOf2OrNot {
    public static void main(String[] args) {
        System.out.println("Enter the value of n:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = check(n);
        System.out.println(flag);
    }

    //Time complexity for this is O(log(n)).
//    static boolean check(int n) {
//        int count = 0;
//        while (n != 0) {
//            int val = n & 1;
//            if (val == 1) {
//                count++;
//            }
//            n = n >> 1;
//            if (count > 1) {
//                return false;
//            }
//        }
//        return true;
//    }

    //Efficient approach with only O(1) time complexity.
    static boolean check(int n) {
        return (n & (n - 1)) == 0;
    }
    //8-->1000
    //--->0111
    //&-->0000  (if zero return true) else false.
}
