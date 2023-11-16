package com.questions;

import java.util.Scanner;

public class _17_HcfOftwoNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two number::");
        int num1 = in.nextInt();
        int num2 = in.nextInt();

//        this method take O(min(num1,num2)) complexity.
//        int min = Math.min(num1, num2);
//        for (int i = min; i >= 1; i--) {
//            if (num1 % i == 0 && num2 % i == 0) {
//                System.out.println("Hcf of num1 and num2 is " + i);
//                break;
//            }
//        }

        //optimized way to do this. With time complexity O(log(min(a,b)).
        //https://youtu.be/1xNbjMdbjug?t=3636
        while (num1 > 0 && num2 > 0) {
            if (num1 > num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }
        }
        if (num1 == 0) {
            System.out.println("HCF is "+num2);
        } else {
            System.out.println("LCM is "+num1);
        }
    }
}
