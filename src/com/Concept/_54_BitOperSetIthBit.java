//set ith bit means ,if ith bit 0 than set it to 1 and if it is 1 than it will remain 1.
package com.Concept;

public class _54_BitOperSetIthBit {
    public static void main(String[] args) {
        int n = 45;
        int i = 5;
        int ans = set(n, i);
        System.out.println("Before " + Integer.toBinaryString(n) + " After setting " + i + "th bit::" + Integer.toBinaryString(ans));
    }

    static int set(int n, int i) {
        return n | (1 << (i - 1));     // |(or) bit operator.
    }
}
//--> 101101
//--> 010000 or
//--> 111101 ans.
