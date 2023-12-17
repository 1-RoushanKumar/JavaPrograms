package com.questions;

public class _94_RecursionReverseTheNumber {


    public static void main(String[] args) {
        int n = 123456789;
//        reverse(n);
//        System.out.println(sum);

        int ans = reverse2(n);
        System.out.println(ans);
    }

    //1st method.
//    static int sum = 0;    //I have taken a static variable sum.
//    static void reverse(int n) {
//        if (n == 0) {
//            return;
//        } else {
//            sum = sum * 10 + n % 10;
//            reverse(n / 10);
//        }
//    }

    //2nd method.Make helper function.
    static int reverse2(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (((n % 10) * (int) Math.pow(10, count(n / 10))) + reverse2(n / 10));
        }
    }

    //I have taken a count function which help to determine power of 10 which I am going to
    //Use to multiply with remainder.
    //ex--> n=568 then rem = 8*10^2=800 + rem=6*10^1=60 + rem=5*10^0=5 == 865.
    static int count(int n) {
        int coun = 0;
        while (n != 0) {
            coun++;
            n = n / 10;
        }
        return coun;
    }
}
