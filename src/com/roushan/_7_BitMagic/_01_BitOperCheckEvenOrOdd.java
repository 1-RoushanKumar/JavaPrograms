package com.roushan._7_BitMagic;

public class _01_BitOperCheckEvenOrOdd {
    public static void main(String[] args) {
        int n = 69;
        boolean flag = check(n);
        if (flag) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }

    static boolean check(int n) {
        return (n & 1) == 1;
    }
}
//&(and) Bit wise operator if any number &(and) with 1 if it give 1 then it is odd else even.
// 1 0 1 (5)
// 0 0 1 &  ---> 1&1=1 and 0&0=0 and 1&0=0
// 0 0 1  (1) that means odd.