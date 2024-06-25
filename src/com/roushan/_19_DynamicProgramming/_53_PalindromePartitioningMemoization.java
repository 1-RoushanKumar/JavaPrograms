package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _53_PalindromePartitioningMemoization {
    public static void main(String[] args) {
        String str = "geek"; // Example string
        int n = str.length();
        int[][] memo = new int[n][n]; // Memoization table to store results of subproblems
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1); // Initialize the memo table with -1
        }
        int ans = patPal(str, 0, n - 1, memo); // Call the recursive function
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(memo[i])); // Print the memo table
        }
        System.out.println(ans); // Output the result
    }

    // Function to find the minimum cuts needed for palindrome partitioning using memoization
    public static int patPal(String str, int i, int j, int[][] memo) {
        // Base case: If the substring is a palindrome, no cuts are needed
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        // Check if the result is already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Initialize the result to a large value
        int res = Integer.MAX_VALUE;

        // Try all possible cuts from i to j
        for (int k = i; k < j; k++) {
            // Recur for the left and right halves and add 1 for the current cut
            res = Math.min(res, 1 + patPal(str, i, k, memo) + patPal(str, k + 1, j, memo));
        }
        // Store the result in the memo table
        memo[i][j] = res;
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
1. The `main` function initializes the string `str`, its length `n`, and the memoization table `memo`.
2. The memoization table is initialized with -1 to indicate uncomputed values.
3. The `patPal` function is called to find the minimum cuts needed for palindrome partitioning.
4. The memoization table is printed for debugging purposes.
5. The result is printed.

`patPal` Function:
- The function takes the string `str`, indices `i` and `j`, and the memoization table `memo` as input.
- If the substring from `i` to `j` is a palindrome, no cuts are needed, so it returns 0.
- If the result is already computed, it returns the stored value.
- It initializes `res` to a large value and iterates over all possible cuts from `i` to `j`.
- For each possible cut, it recursively calculates the minimum cuts for the left and right parts and adds 1 for the current cut.
- It stores the minimum cuts in the memoization table and returns the value.

`isPalindrome` Function:
- This function checks if the substring from `s` to `e` is a palindrome.
- It compares characters from the start and end of the substring and moves towards the center.
- If all characters match, it returns true; otherwise, it returns false.

Time Complexity:
- The time complexity is \(O(n^3)\) due to the nested loops and recursive calls.

Space Complexity:
- The space complexity is \(O(n^2)\) because of the memoization table.
- The space complexity is also affected by the recursion stack, which is \(O(n)\).
*/
