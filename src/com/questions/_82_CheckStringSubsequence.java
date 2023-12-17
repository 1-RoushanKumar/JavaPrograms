//String Subsequence Suppose i have an String ABC then subsequences of ABC are
//"","A","B","C","AB","AC","BC"and "ABC".Total 2^3 sequence = 8.
//we need to check given str2 is a subsequence of the str1 or not.

package com.questions;

public class _82_CheckStringSubsequence {
    public static void main(String[] args) {
        String str1 = "ABC";
        String str2 = "AB";
        
        boolean flag = isSubSeq(str1,str2);
        System.out.println(flag);

        int n = str1.length();
        int m = str2.length();
        boolean flagRec = isSubSeqRec(str1,str2,n,m);
        System.out.println(flagRec);
    }
    //iterative method.
    static boolean isSubSeq(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        if(n<m){
            return false;
        }
        int j = 0;
        for (int i = 0; i < n && j<m; i++) {
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
        }
        return (j==m);
    }

    //recursive way.
    static boolean isSubSeqRec(String str1 ,String str2 , int n, int m){
        if(m==0){
            return true;
        }
        if (n==0){
            return false;
        }
        if (str1.charAt(n-1) == str2.charAt(m-1)) {
            return isSubSeqRec(str1,str2,n-1,m-1);
        }
        else{
            return isSubSeqRec(str1,str2,n-1,m);
        }
    }
}
