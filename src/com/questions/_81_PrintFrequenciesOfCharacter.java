//Print Frequencies of character (in sorted order) in a string of lower case alphabets.

package com.questions;

public class _81_PrintFrequenciesOfCharacter {
    public static void main(String[] args) {
        String str = "banana";
        int[] count = new int[26];   //here i created a count array of size 26 which we use in counting frequency of each character in string.
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;   //count['b' - 'a'] = count[98-97]=count[1]++
        }//count[1] = b so value at count array index 1 will incremented by 1.Similarly we count all.
        //finally count array look like this [3,1,0,0,....,2,0,0...]. ie (3fora) (1forb) (2forn).

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                System.out.println((char) (i + 'a') + " " + count[i]); //here i simply printing the corresponding character frequency.
            }
        }
    }
}
