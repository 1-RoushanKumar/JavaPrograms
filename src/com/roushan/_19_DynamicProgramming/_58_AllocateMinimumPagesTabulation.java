package com.roushan._19_DynamicProgramming;

public class _58_AllocateMinimumPagesTabulation {
    public static void main(String[] args) {
        int[] bookPages = {10, 20, 10, 30};
        int noOfStud = 2;
        int ans = minPage(bookPages, noOfStud);
        System.out.println(ans);
    }

    public static int minPage(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n + 1][k + 1];
        int[] prefixSum = new int[n + 1];

        // Compute prefix sums for the books
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        // Initialize dp for one student
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefixSum[i];
        }

        // Fill the dp table
        for (int j = 2; j <= k; j++) { // for each number of students
            for (int i = 1; i <= n; i++) { // for each number of books
                dp[i][j] = Integer.MAX_VALUE;
                for (int p = 1; p < i; p++) { // partition point
                    int maxPages = Math.max(dp[p][j - 1], prefixSum[i] - prefixSum[p]);
                    dp[i][j] = Math.min(dp[i][j], maxPages);
                }
            }
        }

        return dp[n][k];
    }
}

/*
Explanation:
1. `main` function initializes the `bookPages` array, representing the number of pages in each book, and the number of students (`noOfStud`).
2. The `minPage` function calculates the minimum possible maximum number of pages any student will read.

The `minPage` function:
- Uses a prefix sum array to efficiently calculate the sum of pages from the start to any given index.
- Initializes the `dp` table where `dp[i][1]` is the sum of the first `i` books (because there's only one student).
- Fills the `dp` table by considering all possible partition points for the allocation of books to students.

Time Complexity:
- The time complexity is \(O(n^2 * k)\) due to the nested loops for filling the dp table.

Space Complexity:
- The space complexity is \(O(n * k)\) for the dp table and \(O(n)\) for the prefix sum array.
*/
