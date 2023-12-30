//position of first set-bit means if given 110000 then position of first 1 is 5th.
package com.roushan._7_BitMagic;

public class _06_BitOperFindPositionOfFirstSetBit {
    public static void main(String[] args) {
        int n = 48;
        int ans = pos(n);
        ans = (int) (Math.log(ans) / Math.log(2)) + 1;
        System.out.println("First position of set bit of " + Integer.toBinaryString(n) + " is::" + ans);
    }

    static int pos(int n) {
        return n & (1 + (~n));
    }
}
// 110000
//&010000 --> (~n=001111 now +1 in = 010000)
// 010000
// we get 010000 = 16 then position of first set-bit is log2(16)+1=5.
