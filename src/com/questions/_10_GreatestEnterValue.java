//Take integer inputs till the user enters 0 and print the largest number from all.

package com.questions;

import java.util.Scanner;

public class _10_GreatestEnterValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        while (true) {
            System.out.print("Enter value:: ");
            int num = input.nextInt();
            if (num == 0) {
                break;
            } else if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum among all entered value is:: " + max);
    }
}
