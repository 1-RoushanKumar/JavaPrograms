package com.roushan._2_Functions;

import java.util.Scanner;

public class _04_PassingValue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter three number::");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();
        float result = avg(num1, num2, num3);
        System.out.println("Average of three numbers is " + result);

    }

    static float avg(int a, int b, int c) {
        return  (float) (a + b + c) / 3;
    }
}
