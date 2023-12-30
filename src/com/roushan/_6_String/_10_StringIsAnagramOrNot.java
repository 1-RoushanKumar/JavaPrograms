//anagram means
//consider example = listen . all permutation of listen with same no. of character is called anagram.
// here silent,tensil,etc. are the anagram.
package com.roushan._6_String;

public class _10_StringIsAnagramOrNot {
    public static void main(String[] args) {
        String str1 = "aab";
        String str2 = "bab";
        boolean flag = checkAnagram(str1, str2);
        System.out.println(flag);
    }

    //Naive Approach with time complexity of O(nlog(n)).
//    static boolean checkAnagram(String str1, String str2) {
//        int n = str1.length();
//        int m = str2.length();
//        if (n != m) {
//            return false;
//        }
//        char[] arr = str1.toCharArray();
//        Arrays.sort(arr);
//        str1 = new String(arr);
//
//        char[] arr2 = str2.toCharArray();
//        Arrays.sort(arr2);
//        str2 = new String(arr2);
//
//        return str1.equals(str2);
//    }

    //Efficient way .O(n).
    static final int CHAR = 256;

    static boolean checkAnagram(String s1, String s2) {
        {

            if (s1.length() != s2.length())
                return false;

            int[] count = new int[CHAR];
            for (int i = 0; i < s1.length(); i++) {
                count[s1.charAt(i)]++;
                count[s2.charAt(i)]--;
            }

            for (int i = 0; i < CHAR; i++) {
                if (count[i] != 0) return false;
            }
            return true;
        }
    }

    //My Solution.
//    static boolean checkAnagram(String str1, String str2) {
//        int n = str1.length();
//        int m = str2.length();
//        if (n!=m){
//            return false;
//        }
//        StringBuilder builder = new StringBuilder(str1);
//        int j = 0;
//        for (int i = 0; i < n && j < m; i++) {
//            if (builder.charAt(i) == str2.charAt(j)) {
//                j++;
//                builder.deleteCharAt(i);
//                i = -1;
//                n = n - 1;
//            }
//        }
//        return (j == m);
//    }
}
