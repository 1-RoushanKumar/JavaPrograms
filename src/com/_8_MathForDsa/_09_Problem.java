//Take integer inputs till the user enters 0 and print the sum of all numbers (HINT: while loop)

package com._8_MathForDsa;

import java.util.Scanner;

public class _09_Problem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        while (true) {
            System.out.print("Enter value:: ");
            int n = in.nextInt();
            if (n == 0) {
                break;
            } else {
                sum = sum + n;
            }
        }
        System.out.println("Sum of all the entered number is:: " + sum);
    }
}
