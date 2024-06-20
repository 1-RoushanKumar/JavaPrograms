package com.roushan._19_DynamicProgramming;

public class _22_MaximumCutUsingRecursion {
    public static void main(String[] args) {
        int n = 5; // Total length of the rope
        int a = 1, b = 2, c = 3; // Lengths of the cuts we can make
        int ans = maxCut(n, a, b, c); // Calculate the maximum number of cuts
        System.out.println(ans); // Print the result
    }

    // Recursive function to find the maximum number of cuts
    private static int maxCut(int n, int a, int b, int c) {
        // Base case: if the length becomes negative, it's not possible to make further cuts
        if (n < 0) {
            return -1;
        }

        // Base case: if the length becomes zero, we've successfully made all possible cuts
        if (n == 0) {
            return 0;
        }

        // Recursively calculate the maximum cuts by considering each cut length
        int res = Math.max(
                maxCut(n - a, a, b, c), // Max cuts by making a cut of length 'a'
                Math.max(
                        maxCut(n - b, a, b, c), // Max cuts by making a cut of length 'b'
                        maxCut(n - c, a, b, c) // Max cuts by making a cut of length 'c'
                )
        );

        // If no valid cuts can be made, return -1
        if (res == -1) {
            return res;
        } else {
            // Otherwise, return the result incremented by 1 to include the current cut
            return res + 1;
        }
    }
}

/*
 * Time Complexity Analysis:
 * Let T(n) be the time complexity of the maxCut function for length n.
 * In the worst case, for each call of maxCut(n), we make three recursive calls:
 * - maxCut(n - a)
 * - maxCut(n - b)
 * - maxCut(n - c)
 * Therefore, the recurrence relation for the time complexity is:
 * T(n) = T(n - a) + T(n - b) + T(n - c)
 * If a, b, and c are constants and assuming the worst-case scenario (e.g., all values of n-a, n-b, n-c are distinct and lead to further recursive calls),
 * the time complexity grows exponentially as it explores all combinations of cuts. Specifically, this results in an exponential time complexity:
 * T(n) = O(3^n)
 * Note: In practice, the actual time complexity might be lower due to overlapping problems, but without memoization or dynamic programming, it remains exponential in the worst case.
 * Space Complexity Analysis:
 * The space complexity is determined by the maximum depth of the recursion stack.
 * In the worst case, the recursion depth is n (when n is reduced by 1 in each step).

 * Therefore, the space complexity is O(n).
 */
