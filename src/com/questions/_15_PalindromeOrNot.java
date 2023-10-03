//example 12321 after reversing it still remain the same so it is palindrome number

package com.questions;

import java.util.Scanner;

public class _15_PalindromeOrNot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value::");
        int num = input.nextInt();
        int sum = 0, rem, backupNum = num;
        while (num != 0) {
            rem = num % 10;
            sum = (sum * 10) + rem;
            num = num / 10;
        }
        if (sum == backupNum) {
            System.out.println(backupNum + " is Palindrome number.");
        } else {
            System.out.println(backupNum + " is not a Palindrome number.");
        }
    }
}
