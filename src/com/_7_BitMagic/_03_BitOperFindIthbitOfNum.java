package com._7_BitMagic;

public class _03_BitOperFindIthbitOfNum {
    public static void main(String[] args) {
        int n = 45;  //45=101101
        int i = 4;   //we need to find the 4th bit.
        int ans = find(n, i);
        System.out.println(i + "th bit is of " + Integer.toBinaryString(n) + " is " + ans);
    }

    static int find(int n, int i) {
        if (Math.pow(2, i - 1) > n) {     //here i checking value of i doesn't exceed no. of bit in n.
            return -1;
        }
        int val = (n & (1 << (i - 1)));  //1
        return (val >> (i - 1));  //2
    }
}
//In eqn 1 --> val = (101101 & (1 << (4-1))  where &(and bit operator) and <<(left shift operator)
//-----------> val = (101101 & (1 << 3)
//-----------> val = (101101 & 1000)
//Now 101101
//----001000 &
//----001000  //here fourth bit is one (bit index start from 1)
//Now we need to return the fourth bit which 1(one). If i return it now it will show answer 8(1000) but we need 1 so we
//do right shift , From equ 2 --> 1000 >> (i-1) ---> 1000 >> (3) = 1.
//more detail in note.
