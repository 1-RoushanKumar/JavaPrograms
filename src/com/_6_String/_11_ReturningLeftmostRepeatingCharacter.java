//we need to return leftmost character which repeated first.
package com._6_String;

public class _11_ReturningLeftmostRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abcbd";
        int ans = leftRep(str);
        System.out.println(ans);
    }

    //Naive method.O(n^2) time complexity.
//    static int leftRep(String str) {
//        int n = str.length();
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (str.charAt(i) == str.charAt(j)) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }

    //efficient way O(n) time complexity
    static final int CHAR = 256;

    static int leftRep(String str) {
        int n = str.length();
        int[] count = new int[CHAR];
        for (int i = 0; i < n; i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < n; i++) {
            if (count[str.charAt(i)] > 1) {
                return i;
            }
        }
        return -1;
    }//lecture no. 07 of gfg String.
}
