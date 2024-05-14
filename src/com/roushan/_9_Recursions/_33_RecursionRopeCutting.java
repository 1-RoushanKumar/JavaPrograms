package com.roushan._9_Recursions;

//the problem say we have given ex = (n=5,a=2,b=5,c=1) we need to find which length rope should be cut which give maximum number of rope cuts.
//here if we cut n=5 in c=1(length), then we can get 5 pieces of rope cut which the maximum.
//GFG Recursion PlayList Lec 12.
public class _33_RecursionRopeCutting {
    public static void main(String[] args) {
        int n = 23, a = 11, b = 12, c = 23;
        int ans = cut(n, a, b, c);
        System.out.println(ans);
    }

    public static int cut(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int res = Math.max(cut(n - a, a, b, c), cut(n - b, a, b, c));
        res = Math.max(res, cut(n - c, a, b, c));
        //we need to find max of all three cases, but in math.max we can only store two at time
        //so, we again compare a result with a remaining case.
        if (res == -1) {
            return -1;
        }
        return res + 1;
    }
}
