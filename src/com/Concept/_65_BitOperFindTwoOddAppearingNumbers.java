//here every number is repeating even number of times except two number which is
//appearing only two times.Find that two number.
package com.Concept;

public class _65_BitOperFindTwoOddAppearingNumbers {
    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 4, 5, 4, 4, 6, 7, 7};
        oddAppearing(arr);
    }

    //1st method with O(n^2) complexity.
//    static void oddAppearing(int[] arr) {
//        int n = arr.length;
//        System.out.println("Missing number are::");
//        for (int k : arr) {
//            int count = 0;
//            for (int i : arr) {
//                if (k == i) {
//                    count++;
//                }
//            }
//            if (count % 2 != 0) {
//                System.out.print(k + " ");
//            }
//        }
//    }

    //2nd method with O(n) complexity.
    static void oddAppearing(int[] arr) {
        int n = arr.length;
        int xor = 0, res1 = 0, res2 = 0;
        System.out.println("Missing number are::");

        for (int j : arr) {
            xor = xor ^ j;
        }
        int sn = xor & (-xor);
        for (int i = 0; i < n; i++) {
            if ((arr[i] & sn) != 0) {
                res1 = res1 ^ arr[i];
            } else {
                res2 = res2 ^ arr[i];
            }
        }
        System.out.println(res1 + " " + res2);
    }
}
//detail in gfg bit magic lecture no.3.
