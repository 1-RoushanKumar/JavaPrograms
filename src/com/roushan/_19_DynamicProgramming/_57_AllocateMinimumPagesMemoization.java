package com.roushan._19_DynamicProgramming;

import java.util.Arrays;

public class _57_AllocateMinimumPagesMemoization {
    public static void main(String[] args) {
        int[] bookPages = {10, 20, 30, 40};
        int noOfStud = 2;
        int n = bookPages.length;

        // Initialize memoization table with -1
        int[][] memo = new int[n][noOfStud + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int ans = minPage(bookPages, 0, noOfStud, memo);
        System.out.println(ans);
    }

    public static int minPage(int[] arr, int start, int k, int[][] memo) {
        int n = arr.length;

        // Base case: if there's only one student, they take all the remaining books
        if (k == 1) {
            return sum(arr, start, n - 1);
        }

        // Base case: if there's only one book, it must be taken by one student
        if (start == n - 1) {
            return arr[start];
        }

        // If already computed, return the stored value
        if (memo[start][k] != -1) {
            return memo[start][k];
        }

        // Initialize result to a large value
        int res = Integer.MAX_VALUE;

        // Iterate over all possible partition points
        for (int i = start; i < n - 1; i++) { // run loop from start to n - 1
            // Sum of pages for the current partition
            int currentSum = sum(arr, start, i);
            // Minimum of the maximum pages for remaining partitions
            int remaining = minPage(arr, i + 1, k - 1, memo);
            // Maximum pages a student has to read in the current partitioning
            int currentMax = Math.max(currentSum, remaining);
            // Update the result with the minimum of currentMax and res
            res = Math.min(res, currentMax);
        }

        // Store the computed value in memo table
        memo[start][k] = res;

        return res;
    }

    // Helper function to calculate the sum of elements from index i to j
    public static int sum(int[] arr, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }
}

/*
Explanation:
1. The `main` function initializes the `bookPages` array, representing the number of pages in each book, and the number of students.
2. The `minPage` function is called to determine the minimum possible maximum number of pages any student will read, using memoization to store intermediate results.
3. A 2D `memo` array is used to store results of subproblems. If `memo[start][k]` is not -1, it means the result has already been computed.

The `minPage` function:
- Handles the base cases where there is only one student (sum all pages from start to end) or one book (the student reads that book).
- Checks if the result for the current state is already computed and stored in `memo`.
- Iterates over possible partition points to compute the sum for each partition and recursively solve for the remaining books.
- Use memoization to store and reuse results of subproblems to avoid redundant computations.

The `sum` function:
- Calculates the sum of elements from index `i` to `j` in the array.

Time Complexity:
- The time complexity is reduced compared to the pure recursion approach, but it is still \(O(n^2 * k)\) due to the nested loops and memoization table.

Space Complexity:
- The space complexity is \(O(n * k)\) for the memoization table.
*/
