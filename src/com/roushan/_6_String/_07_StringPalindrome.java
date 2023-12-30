package com.roushan._6_String;

public class _07_StringPalindrome {
    public static void main(String[] args) {
        String str = "abcdcba";
        boolean flag = check(str);
        System.out.println(flag);
    }

    //Naive Method to solve.It will take O(n) time and also it require O(n) auxiliary space.
//    static boolean check(String str) {
//        StringBuilder rev = new StringBuilder(str);
//        rev.reverse();
//        return str.equals(rev.toString());
//    }

    //Efficient Method.It will take O(n) time and it require O(1)(constant) auxiliary space.
    static boolean check(String str) {
        int n = str.length();

        //1st way
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //2nd way.
    //        if (n == 0){
//            return true;
//        }
//        for (int i = 0; i <= n/2 ; i++) {
//            char start = str.charAt(i);
//            char end = str.charAt(n-1-i);
//
//            if (start!=end){
//                return false;
//            }
//        }
//        return true;
//    }
}
