package com.roushan._7_BitMagic;

public class _12_BitOperFindNoOfSetBits {
    public static void main(String[] args) {
        int n = 56778;
        int ans = count(n);
        System.out.println("Number of set bit in " + Integer.toBinaryString(n) + " is::" + ans);
    }

    //1st method Time complexity logn.
//    static int count(int n) {
//        int count = 0;
//        while (n != 0) {
//            int val = (n & 1);
//            if (val == 1) {
//                count++;
//            }
//            n = n >> 1;
//        }
//        return count;
//    }

    //2nd method time complexity logn
//    static int count(int n) {
//        int count = 0;
//        while (n > 0) {
//            count++;
//            n = n - (n & (-n));
//        }
//        return count;
//    }

    //3rd method This method is know as Brian Kerningam's algorithm
    static int count(int n) {
        int count = 0;
        while (n > 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }
}
