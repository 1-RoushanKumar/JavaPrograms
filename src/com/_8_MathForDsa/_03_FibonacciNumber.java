//Fibonacci number = 0,1,1,2,3,5,8,13....
//sum of two previous terms is equal to next value of fibonacci number.

package com._8_MathForDsa;

import java.util.Scanner;

public class _03_FibonacciNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of terms");
        int n = in.nextInt();

        System.out.println("Fibonacci Series are");
        int fibo1 = 0, fibo2 = 1, newfibo;   //initially taken first two fibonacci number.
        System.out.print(fibo1+" ");
        System.out.print(fibo2+" ");

        for (int i = 3; i <= n; i++) {       //i = 3 because we already have two fibo numbers
            newfibo = fibo1 + fibo2;
            System.out.print(newfibo+" ");
            fibo1 = fibo2;
            fibo2 = newfibo;
        }
    }
}
