package com.roushan._19_DynamicProgramming;

public class _05_LongestSubSequenceSpaceOptimized {
    public static void main(String[] args) {
        String s1 = "AXYZ";
        String s2 = "BAZ";
        int n = s1.length();
        int m = s2.length();

        // Calculate and print the length of LCS
        System.out.println("Length of LCS: " + lcs(n, m, s1, s2));
    }

    // Function to find the length of longest common subsequence in two strings.
    public static int lcs(int n, int m, String str1, String str2) {
        // Space complexity: O(m)
        // Explanation: prev and curr arrays are of size m + 1.
        int[] prev = new int[m + 1];

        // Iterate through each character of str1
        for (int i = 0; i < n; i++) {
            // Initialize the current row array
            int[] curr = new int[m + 1];

            // Iterate through each character of str2
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i) == str2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }

            // Update prev array to curr array for next iteration
            prev = curr;
        }

        // Return the length of LCS stored in prev[m]
        return prev[m];

        // Time complexity: O(n * m)
        // Explanation: Two nested loops iterate through str1 (n iterations) and str2 (m iterations) respectively.
        // Inside the inner loop, constant-time operations are performed (comparison and maximum function).
    }
}
