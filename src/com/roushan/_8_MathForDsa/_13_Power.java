//Power in Java
//example num = 2 and power = 3, Hence = 2^3 = 8.

package com.roushan._8_MathForDsa;

import java.util.Scanner;

public class _13_Power {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter value::");
        int num = input.nextInt();
        System.out.println("Enter power::");
        int power = input.nextInt();

        int result = 1;
        for (int i = 1; i <= power; i++) {
            result = result * num;
        }
        System.out.println(num + " to the power " + power + " is " + result);
    }
}
