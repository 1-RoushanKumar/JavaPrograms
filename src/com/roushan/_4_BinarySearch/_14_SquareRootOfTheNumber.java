//need to return square root of the number.
//sqrt of 9 is 3. And if num = 35 then return previous found square root from that number .Hence, sqrt of 35 is 5.

package com.roushan._4_BinarySearch;

public class _14_SquareRootOfTheNumber {
    public static void main(String[] args) {
        int n = 2147395599;
        int ans = root(n);
        System.out.println(ans);
    }

    //Naive Method. O(sqrt(n)) complexity.
//    static int root(int n){
//        int i = 1;
//        while (i*i<=n) {
//            i++;
//        }
//        return (i-1);
//    }

    //binary search. O(log(n)) complexity.
    static int root(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //i used long for handling value when after multiplying mid goes out of the int range.
            if ((long)mid * mid == n) {
                return mid;
            } else if ((long)mid * mid > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
