package com._7_BitMagic;

public class _09_BitOperCountTheNoOfDigitsInAnyNum {
    public static void main(String[] args) {
        int n = 7;
        int base = 2;    //you can find it for any base (decimal,octal etc)

        int ans = (int) (Math.log(n) / Math.log(base)) + 1;
        System.out.println("No of digits of " + n + " in base " + base + " is " + ans);
    }
}
