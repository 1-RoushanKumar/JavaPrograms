package com._4_BinarySearch;

public class _19_SquareRootOfTheNumber {
    public static void main(String[] args) {
        int num = 379669;
        int precisionValue = 3;   //it is how decimal value you want to check ie(6.325) here 0.325 is 3 digit decimal.

        System.out.printf("%.3f", sqrt(num, precisionValue));
    }

    //This is taking only O(logn) complexity.
    static double sqrt(int n, int p) {
        long start = 0;
        long end = n;
        double root = 0.0;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            root = mid;
        }//if square root of the number is integer then it will return form here.

        //Both will take constant time p = 3 always and incr val with always be from 0.1 to 0.9

        //If square root of the number is not integer then below two case will satisfy.

        //Case 2 will run when product of root is smaller than requirement so we must add decimal value to find answer.
        double incr = 0.1;
        if (root * root <= n) {
            for (int i = 0; i < p; i++) {
                while (root * root <= n) {
                    root = root + incr;
                }
                root = root - incr;
                incr = incr / 10;
            }
            return root;
        }

        //Case 2 will run when product of root is smaller than requirement so we must add decimal value to find answer.        //1.case if root which is equal to mid have product greater than number than we need to decrease it decimal value.
        //for this case 1 will run.
        else {
            for (int i = 0; i < p; i++) {
                while (root * root >= n) {
                    root = root - incr;
                }
                root = root + incr;
                incr = incr / 10;
            }
        }
        return root;
    }
}
