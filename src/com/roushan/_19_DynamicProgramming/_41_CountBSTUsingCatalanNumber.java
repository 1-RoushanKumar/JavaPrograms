package com.roushan._19_DynamicProgramming;

public class _41_CountBSTUsingCatalanNumber {
    public static void main(String[] args) {
        int n = 4; // Number of nodes
        int ans = countBSTsUsingCatalan(n);
        System.out.println(ans); // Output the result
    }

    /**
     * Function to calculate the number of unique Binary Search Trees (BSTs) using the Catalan number formula.
     *
     * @param n Number of nodes
     * @return Number of unique BSTs

     * Time Complexity: O(n)
     * - The time complexity is O(n) because we are using a single loop to calculate the binomial coefficient.

     * Space Complexity: O(1)
     * - The space complexity is O(1) since we are only using a few extra variables and not storing intermediate results.
     */
    public static int countBSTsUsingCatalan(int n) {
        // Calculate the 2n choose n value (binomial coefficient)
        //taken long because value can be very large.
        long binomialCoeff = 1;
        for (int i = 0; i < n; i++) {
            binomialCoeff = binomialCoeff * (2L * n - i) / (i + 1);   //2L means 2 is long.
        }

        // Catalan number formula: C_n = (1 / (n + 1)) * binomialCoeff
        return (int) (binomialCoeff / (n + 1));
    }
}

