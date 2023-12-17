package com.questions;

public class _89_TrailingZeroesInFactorialOfNum {
    public static void main(String[] args) {
        int n = 100;
        //1st method --> this have time complexity O(n) but don't count trailing zeroes of big number.
//        long fact = 1;
//        for (int i = 1; i <= n; i++) {
//            fact = fact * i;
//        }
//        System.out.println(fact);
//        int count = 0;
//        while (fact != 0) {
//            long rem = fact % 10;
//            if (rem == 0) {
//                count++;
//            }
//            fact /= 10;
//        }
//        System.out.println(count);

        //2nd method to count no. of trailing zeroes. with Log(n) complexity.
        //Try to do in _90_RecursionPrintNNaturalNumber paper.For detail go to Mathematics playlist Qno. 5
        int count = 0;
        for (int i = 5; i <= n; i *= 5) {
            count = count + n / i;
        }
        System.out.println(count);
    }
}
