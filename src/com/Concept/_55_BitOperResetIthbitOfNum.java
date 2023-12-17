//reset ith bit means ,if ith bit 1 than set it to 0 and if it is 0 than it will remain 0.
package com.Concept;

public class _55_BitOperResetIthbitOfNum {
    public static void main(String[] args) {
        int n = 86;
        int i = 5;
        int ans = set(n, i);
        System.out.println("Before " + Integer.toBinaryString(n) + " After resetting " + i + "th bit::" + Integer.toBinaryString(ans));
    }

    static int set(int n, int i) {
        return n & (~(1 << (i - 1)));     // ~ represent complement sign.
    }
}
//-->1010110
//-->1101111  (0010000 after complementing 1101111)
//-->1000110