package com.roushan._19_DynamicProgramming;

public class _59_AllocateMinimumPagesLinearAndBinarySearch {
    public static void main(String[] args) {
        int[] bookPages = {25, 46, 28, 49, 24};
        int noOfStud = 4;
        int ans = linear(bookPages, noOfStud);
        System.out.println("Linear Search Result: " + ans);
        ans = binarySearch(bookPages, noOfStud);
        System.out.println("Binary Search Result: " + ans);
    }

    // Linear Search Approach
    public static int linear(int[] arr, int k) {
        int max = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        int start = max;
        int end = sum;
        for (int i = start; i <= end; i++) {
            int count = countStudent(arr, i);
            if (count <= k) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search Approach
    public static int binarySearch(int[] arr, int k) {
        int max = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        int start = max;
        int end = sum;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = countStudent(arr, mid);
            if (count <= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    // Helper method to count the number of students required to allocate books such that no student reads more than maxPage pages
    public static int countStudent(int[] arr, int maxPage) {
        int stud = 1;
        int pagePerStud = 0;
        for (int j : arr) {
            if (pagePerStud + j <= maxPage) {
                pagePerStud += j;
            } else {
                stud++;
                pagePerStud = j;
            }
        }
        return stud;
    }
}

/*
Explanation:

1. Main Method:
   - Initializes the array `bookPages` and the number of students `noOfStud`.
   - Calls the `linear` and `binarySearch` methods and prints the results.

2. Linear Search Approach:
   - Finds the maximum number of pages in a single book (`max`).
   - Computes the total sum of pages (`sum`).
   - Iterates from `max` to `sum`, checking for each possible maximum if the number of students required is less than or equal to `k`.
   - Returns the first valid maximum.

3. Binary Search Approach:
   - Similar to linear search but uses binary search for efficiency.
   - Adjusts the search range based on the number of students required.

4. countStudent Method:
   - Helper method to count the number of students required for a given maximum number of pages (`maxPage`).
   - Iterates over the books, summing pages until `maxPage` is exceeded, then increments the student count and resets the sum.

Time Complexity:
- Linear Search: O(n * (sum(arr) - max(arr)))
- Binary Search: O(n * log(sum(arr) - max(arr)))

Space Complexity:
- Both approaches use O(1) extra space (excluding input and output storage).
*/
