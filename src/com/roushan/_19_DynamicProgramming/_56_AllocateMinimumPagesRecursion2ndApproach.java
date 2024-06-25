package com.roushan._19_DynamicProgramming;

public class _56_AllocateMinimumPagesRecursion2ndApproach {
    public static void main(String[] args) {
        int[] bookPages = {10, 20, 30, 40};
        int n = bookPages.length;
        int noOfStud = 2;
        int ans = minPage(bookPages, n, noOfStud);
        System.out.println(ans);
    }

    public static int minPage(int[] arr, int n, int k) {
        // Base cases
        if (k == 1) { // If there is only one student
            return sum(arr, 0, n - 1);
        }
        if (n == 1) { // If there is only one book
            return arr[0];
        }

        // Initialize result to a large value
        int res = Integer.MAX_VALUE;

        // Iterate over all possible partitions
        for (int i = 1; i < n; i++) {
            // Compute the maximum pages for the current partition
            int currentPartition = sum(arr, i, n - 1);
            int remainingPartitions = minPage(arr, i, k - 1);
            int currentMax = Math.max(currentPartition, remainingPartitions);
            res = Math.min(res, currentMax);
        }

        return res;
    }

    // Helper function to compute the sum of elements from index i to j
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
1. The `main` function initializes the `bookPages` array, which represents the number of pages in each book.
2. The number of students (`noOfStud`) is set to 2, meaning we need to allocate books to 2 students.
3. The `minPage` function is called to determine the minimum possible maximum number of pages any student will read.

The `minPage` function:
- If `k` (number of students) is 1, we return the sum of all remaining books from index `0` to `n-1`.
- If `n` (number of books) is 1, we return the only book's page count.
- We initialize the result (`res`) to a large value.
- We try partitioning the books at every possible point `i` from 1 to `n-1`:
  - Calculate the sum of the pages for the current partition (`sum(arr, i, n - 1)`).
  - Recur for the left partition (`minPage(arr, i, k - 1)`).
  - Take the maximum of these two values, as we are trying to minimize the maximum pages read by any student.
  - Update `res` with the minimum of the current `res` and the calculated maximum pages.

The `sum` function:
- It calculates the sum of elements from index `i` to `j` in the array.

Time Complexity:
- The time complexity is exponential, as it explores all possible partitions. Specifically, it is \(O(n^k)\), where `n` is the number of books, and `k` is the number of students.

Space Complexity:
- The space complexity is \(O(k)\) due to the recursive call stack.
*/
