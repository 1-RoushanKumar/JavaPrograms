package com.roushan._8_MathForDsa;

public class _26_PrimeNumberBetweenN {
    public static void main(String[] args) {
        int n = 40;
        System.out.println("Prime Number Between 0 to " + n + " are::");
        for (int i = 0; i <= n; i++) {
            boolean flag = checkPrime(i);
            if (flag) {
                System.out.print(i + " ");
            }
        }
    }

    static boolean checkPrime(int n) {
        if (n == 1 || n == 0) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}
