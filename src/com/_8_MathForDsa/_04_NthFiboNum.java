package com._8_MathForDsa;

import java.util.Scanner;

public class _04_NthFiboNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter which fibo number::");
        int n = in.nextInt();

        int fibo1 = 0, fibo2 = 1, newfibo = 0, i = 3;
        while (i <= n) {
            newfibo = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = newfibo;
            i++;
        }
        System.out.println(n + "th Fibonacci Number is " + newfibo);
    }
}
