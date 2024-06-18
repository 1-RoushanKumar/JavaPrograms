package com.roushan._19_DynamicProgramming;

public class _10_EditDistanceUsingRecursion {
    public static void main(String[] args) {
        // Input strings
        String s1 = "SATURDAY";
        String s2 = "SUNDAY";

        // Lengths of the input strings
        int m = s1.length();
        int n = s2.length();

        // Calculate the minimum number of operations required to convert s1 to s2
        int ans = minOperation(s1, s2, m, n);

        // Print the result
        System.out.println(ans);
    }

    /**
     * This method calculates the minimum number of operations required to convert
     * string s1 to string s2 using recursion.
     *
     * @param s1 The first string
     * @param s2 The second string
     * @param m The current length of the first string being considered
     * @param n The current length of the second string being considered
     * @return The minimum number of operations required
     */
    public static int minOperation(String s1, String s2, int m, int n) {
        // If the first string is empty, the only option is to insert all characters of the second string
        if (m == 0) {
            return n;
        }

        // If the second string is empty, the only option is to remove all characters of the first string
        if (n == 0) {
            return m;
        }

        // If the last characters of both strings are the same, ignore the last character
        // and recursively find the edit distance for the remaining strings
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return minOperation(s1, s2, m - 1, n - 1);
        } else {
            // If the last characters are different, consider all three operations:
            // 1. Insert the last character of s2 into s1
            // 2. Remove the last character of s1
            // 3. Replace the last character of s1 with the last character of s2
            // Take the minimum of these three operations and add 1 (for the current operation)
            return 1 + Math.min(minOperation(s1, s2, m - 1, n), // Remove
                    Math.min(minOperation(s1, s2, m, n - 1), // Insert
                            minOperation(s1, s2, m - 1, n - 1))); // Replace
        }
    }
}

// Time Complexity Explanation:
// Since the maximum depth of the recursion is determined by the larger of the two strings' lengths (let’s call it max(m, n)),
// the time complexity is O(3^max(m, n)) in the worst case. This is because, in the worst case, each step can lead to three new
// recursive calls (for insert, remove, and replace operations).
