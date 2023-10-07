//Armstrong number -- A number is thought of as an Armstrong number if the sum of its own
// digits raised to the power number of digits gives the number itself.
// For example, 0, 1, 153, 370, 371, 407 are three-digit Armstrong numbers and, 1634, 8208, 9474
// are four-digit Armstrong numbers and there are many more.

package com.questions;

import java.util.Scanner;

public class _22_ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value::");
        int num = input.nextInt();
        boolean flag = isArmstrong(num);
        if (flag) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an armstrong Number");
        }
    }

    private static boolean isArmstrong(int num) {
        int backupnum = num;
        int rem, sum = 0, count = 0;
        while (num != 0) {
            count++;
            num = num / 10;
        }
        num = backupnum;
        for (int i = 1; i <= count; i++) {
            rem = num % 10;
            sum = sum + (int) Math.pow(rem, count);
            num = num / 10;
        }
        if (sum == backupnum) {
            return true;
        } else {
            return false;
        }
    }
}
