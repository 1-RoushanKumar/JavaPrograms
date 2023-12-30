//newton raphson formula = sqrt(n) = 0.5*(x+(n/X)
//where n is any number and x is the closet value to the sqrt of n.
package com.roushan._4_BinarySearch;

public class _20_SquareRootOfTheNum2ndMethod {
    public static void main(String[] args) {
        long n = 37966989669L;
        System.out.printf("%.3f", sqrt(n));
    }
    //This method work well for small value like 379669596
    //But this method is efficient only take O(logn) time complexity.
//    static double sqrt(long n) {
//        long start = 0;
//        long end = n;
//        double root = 0.0;
//        while (start < end) {
//            long mid = start + (end - start) / 2;
//            if (mid * mid == n) {
//                return mid;
//            } else if (mid * mid > n) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//            root = mid;
//        }
//        root = 0.5 * (root + (n / root));
//        return root;
//    }

    //This method is work for all type of value.
    //Its approx time complexity is O(sqrt(n))
    static double sqrt(long n) {
        double x = n;
        double root;
        while (true) {
            root = 0.5 * (x + (n / x));    //This formula is know as newton raphson sqrt formula.
            if (Math.abs(root - x) < 0.1) {
                break;
            }
            x = root;
        }
        return root;
    }
}
