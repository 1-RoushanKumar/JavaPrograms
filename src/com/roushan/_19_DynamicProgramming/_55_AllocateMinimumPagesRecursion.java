package com.roushan._19_DynamicProgramming;

public class _55_AllocateMinimumPagesRecursion {
    public static void main(String[] args) {
        int[] bookPages = {10, 20, 30, 40};
        int noOfStud = 2;
        int ans = minPage(bookPages, 0, bookPages.length - 1, noOfStud);
        System.out.println(ans);
    }

    public static int minPage(int[] arr, int start, int end, int k) {
        // Base cases
        if (k == 1) {
            return sum(arr, start, end); // Only one student, sum all pages from start to end
        }
        if (start == end) {
            return arr[start]; // Only one book
        }

        // Initialize result to a large value
        int res = Integer.MAX_VALUE;

        // Iterate over all possible partition points
        for (int i = start; i < end; i++) {
            // Sum of pages for the current partition
            int currentSum = sum(arr, start, i);
            // Minimum of the maximum pages for remaining partitions
            int remaining = minPage(arr, i + 1, end, k - 1);
            // Maximum pages a student has to read in the current partitioning
            int currentMax = Math.max(currentSum, remaining);
            // Update the result with the minimum of currentMax and res
            res = Math.min(res, currentMax);
        }

        return res;
    }

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
- Handles the base cases where there is only one student or one book.
- Initializes the result (`res`) to a large value.
- Iterates over all possible partition points of the array:
  - Calculates the sum of pages for the current partition (`sum(arr, start, i)`).
  - Recursively calculates the minimum of the maximum pages for the remaining partitions (`minPage(arr, i + 1, end, k - 1)`).
  - Takes the maximum of the current partition sum and the remaining partitions to find the maximum pages any student has to read in this partitioning.
  - Updates `res` with the minimum of the current maximum and the previous result.

The `sum` function:
- Calculates the sum of elements from index `i` to `j` in the array.

Time Complexity:
- The time complexity is exponential, as it explores all possible partitions. Specifically, it is \(O(n^k)\), where `n` is the number of books, and `k` is the number of students.

Space Complexity:
- The space complexity is \(O(k)\) due to the recursive call stack.
*/
