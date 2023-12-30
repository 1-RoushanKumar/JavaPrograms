//example num = 153 is armstrong because check = 1^3+5^3+3^3 = 153 (ie num = check)
//power depends on the number of digits . if num = 1634 then 1^4+6^4+3^4+4^4 = 1634.


package com.roushan._8_MathForDsa;

import java.util.Scanner;

public class _14_ArmstrongNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value::");
        int num = input.nextInt();
        int count = 0, backupNum = num, rem, sum = 0; //taken backupNum for storing initial num because after iteration it get changed
        //counting digit for taking power.
        while (num != 0) {
            count++;
            num = num / 10;
        }
        num = backupNum;
        for (int i = 1; i <= count; i++) {
            rem = backupNum % 10;
            sum = sum + (int) (Math.pow(rem, count));    //powering digit(rem) and keep adding until num = 0;
            backupNum = backupNum / 10;
        }
        if (sum == num) {
            System.out.println(num + " is an armstrong number.");
        } else {
            System.out.println(num + " is not an armstrong number.");
        }
    }

}
