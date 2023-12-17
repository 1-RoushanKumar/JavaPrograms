package com.questions;

public class _23_PrintingArmstrong {
    public static void main(String[] args) {
        int num;
        //Printing armstrong number between 1 and 100000.
        for (num = 1; num < 1000; num++) {
            if (isArmstrong(num)) {
                System.out.print(num + " ");
            }
        }
    }

    private static boolean isArmstrong(int num) {
        int backUpNum = num;

        int rem, sum = 0, count = 0;
        while (num != 0) {
            count++;
            num = num / 10;
        }
        num = backUpNum;
        for (int i = 1; i <= count; i++) {
            rem = num % 10;
            sum = sum + (int) Math.pow(rem, count);
            num = num / 10;
        }
        return sum == backUpNum;
    }
}
