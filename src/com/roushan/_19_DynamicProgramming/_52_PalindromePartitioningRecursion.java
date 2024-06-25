package com.roushan._19_DynamicProgramming;

public class _52_PalindromePartitioningRecursion {
    public static void main(String[] args) {
        String str = "geek";
        int n = str.length();
        int ans = patPal(str, 0, n - 1);
        System.out.println(ans);
    }

    // Function to find the minimum cuts needed for palindrome partitioning
    public static int patPal(String str, int i, int j) {
        // Base case: If the substring is a palindrome, no cuts are needed
        if (isPalindrome(str, i, j)) {
            return 0;
        }

        // Initialize the result to a large value
        int res = Integer.MAX_VALUE;

        // Try all possible cuts from i to j
        for (int k = i; k < j; k++) {
            // Recur for the left and right halves and add 1 for the current cut
            res = Math.min(res, 1 + patPal(str, i, k) + patPal(str, k + 1, j));
        }

        return res;
    }

    // Helper function to check if a substring is a palindrome
    public static boolean isPalindrome(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}

/*
Explanation:
1. `patPal` function:
   - The function takes the string `str` and indices `i` and `j` as input.
   - If the substring from `i` to `j` is a palindrome, no cuts are needed, so it returns 0.
   - It initializes `res` to a large value and iterates over all possible cuts from `i` to `j`.
   - For each possible cut, it recursively calculates the minimum cuts for the left and right parts and adds 1 for the current cut.
   - It returns the minimum cuts found.

2. `isPalindrome` function:
   - This function checks if the substring from `s` to `e` is a palindrome.
   - It compares characters from the start and end of the substring and moves towards the center.
   - If all characters match, it returns true; otherwise, it returns false.

Time Complexity:
- The time complexity is \(O(2^n)\) in the worst case due to the exponential number of recursive calls.

Space Complexity:
- The space complexity is \(O(n)\) due to the recursive call stack.
*/
