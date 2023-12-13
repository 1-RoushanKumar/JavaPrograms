package com.questions;

public class rough {
    public static void main(String[] args) {
        String s = "0000000000";
        int minJump = 2;
        int maxJump = 5;
        boolean flag = canReach(s, minJump, maxJump);
        System.out.println(flag);


    }


    static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }
        if (n % 2 == 0) {
            int k = 0;
            for (; k < n; k++) {
                if (s.charAt(k) != '0') {
                    break;
                }
            }
            if (k == n) {
                return true;
            }
        }
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (s.charAt(j) == '0') {
                if ((i + minJump <= j) && (j <= Math.min(i + maxJump, n - 1))) {
                    i = j;
                }
            }
        }
        return (i == n - 1);
    }
}
