package com.roushan._9_Recursions;

public class _02_FibonacciNumber {
    public static void main(String[] args) {
        int n = 4;
        int ans = fibo(n);
        System.out.println("Fibo of " + n + " th place is " + ans);
    }

//    static int fibo(int n) {
//        if (n==0){
//            return 0;
//        }
//        if (n==1){
//            return 1;
//        }
//        return fibo(n - 1) + fibo(n - 2);
//    }

    //Direct Formula for fibonacci.
    static int fibo(int n) {
        return (int) (((Math.pow((1 + Math.sqrt(5)) / 2, n)) - (Math.pow((1 - Math.sqrt(5)) / 2, n)))/Math.sqrt(5));
    }
}
