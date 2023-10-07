//Define two methods to print the maximum and
// the minimum number respectively among three numbers entered by the user.

package com.questions;

import java.util.Scanner;

public class _24_MinandMax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter three values");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int maxNum = Maximum(a, b, c);
        int minNum = Minimum(a, b, c);

        System.out.println("Largest Number is :: " + maxNum);
        System.out.println("Smallest Number is :: " + minNum);
    }

    private static int Minimum(int a, int b, int c) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    private static int Maximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
}
