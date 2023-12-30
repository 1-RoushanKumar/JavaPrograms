package com.roushan._7_BitMagic;

public class _08_BitOperFindNthMagicNum {
    public static void main(String[] args) {
        int n = 5;
        int sum = 0;
        int base = 5;
        while (n != 0) {
            int last = n & 1;
            n = n >> 1;
            sum = sum + (last * base);
            base = base * 5;
        }
        System.out.println(sum);
    }
}
//detail in notes.
//Time complexity is log(n).Because it depend on the number of digit of given number.
//Here 6 = 110 (3 digit) = log(6)/log(2) + 1;Ultimately after removing less dominating term we O(log(n)).
