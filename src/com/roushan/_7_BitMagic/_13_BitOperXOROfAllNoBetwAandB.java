package com.roushan._7_BitMagic;

public class _13_BitOperXOROfAllNoBetwAandB {
    public static void main(String[] args) {
        int a = 3;
        int b = 9;
        int ans = xor(b) ^ xor(a - 1);
//        int ans2 = find(a, b);
//        System.out.println(ans2);
        System.out.println(ans);
    }

    //1st method.With Bad complexity
//    static int find(int a, int b) {
//        int ans = 0;
//        for (int i = a; i <= b; i++) {
//            ans = ans ^ i;
//        }
//        return ans;
//    }

    //Efficient method
    static int xor(int b) {
        if (b % 4 == 0) {
            return b;
        }
        if (b % 4 == 1) {
            return 1;
        }
        if (b % 4 == 2) {
            return b + 1;
        }
        return 0;
    }
}
