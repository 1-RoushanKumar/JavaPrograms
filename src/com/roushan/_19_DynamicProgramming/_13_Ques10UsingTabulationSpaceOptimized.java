package com.roushan._19_DynamicProgramming;

public class _13_Ques10UsingTabulationSpaceOptimized {
    public static void main(String[] args) {
        // Input strings
        String s1 = "SATURDAY";
        String s2 = "SUNDAY";

        // Lengths of the input strings
        int m = s1.length();
        int n = s2.length();

        // Initialize the DP table for the previous row with dimensions (m+1)
        int[] prev = new int[m + 1];

        // Fill the first row (converting empty s1 to s2)
        for (int i = 0; i <= m; i++) {
            prev[i] = i;
        }

        // Fill the DP table using only two rows (previous and current)
        for (int i = 1; i <= n; i++) {
            // Initialize the current row with size (m+1)
            int[] curr = new int[m + 1];
            // Fill the first column (converting empty s2 to s1)
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                // If characters are the same, no new operation is needed
                if (s1.charAt(j - 1) == s2.charAt(i - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    // If characters are different, consider all three operations:
                    // 1. Insert (curr[j - 1])
                    // 2. Remove (prev[j])
                    // 3. Replace (prev[j - 1])
                    curr[j] = 1 + Math.min(curr[j - 1], Math.min(prev[j - 1], prev[j]));
                }
            }
            // Move current row to previous row for the next iteration
            prev = curr;
        }

        // Print the result from the bottom-right corner of the DP table
        System.out.println(prev[m]);
    }
}

// Time Complexity Explanation:
// The time complexity of this algorithm is O(m * n) where m and n are the lengths of the input strings s1 and s2.
// This is because the nested loops iterate through all characters of both strings, and each cell computation takes constant time.

// Space Complexity Explanation:
// The space complexity of this algorithm is O(m) because only two rows of the DP table are maintained at any time.
// Instead of storing the entire (m+1)x(n+1) table, we only store two (m+1)-sized arrays, reducing the space requirement.
