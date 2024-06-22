package com.roushan._19_DynamicProgramming;

public class _38_CountBSTUsingRecursion {
    public static void main(String[] args) {
        int n = 4; // Number of nodes
        int ans = countBSTs(n); // Call the function to count the number of unique BSTs
        System.out.println(ans); // Output the result
    }

    /**
     * Function to count the number of unique Binary Search Trees (BSTs) that can be
     * formed with 'n' distinct nodes.
     *
     * @param n Number of nodes
     * @return Number of unique BSTs
     * Time Complexities: O(2^n)
     * - This is an exponential time complexity because for each node, we recursively
     *   calculate the number of unique BSTs for the left and right subtrees, leading
     *   to a very high number of recursive calls. The actual number of recursive calls
     *   is related to the Catalan numbers, which have a growth rate of approximately
     *   O(4^n / n^{3/2}).
     * Space Complexity: O(n)
     * - The space complexity is O(n) due to the maximum depth of the recursion stack,
     *   which can go as deep as 'n' in the worst case.
     */
    public static int countBSTs(int n) {
        // Base case: An empty tree or a single-node tree has exactly one unique BST
        if (n == 0 || n == 1) {
            return 1;
        }

        int res = 0; // Initialize result to 0

        // Iterate through all possible root positions (1 to n)
        for (int i = 1; i <= n; i++) {
            // Count the number of unique BSTs with `i` as the root
            // The left subtree contains `i-1` nodes, and the right subtree contains `n-i` nodes
            int leftTrees = countBSTs(i - 1);
            int rightTrees = countBSTs(n - i);

            // The total number of unique BSTs with `i` as the root is the product of
            // the number of unique BSTs in the left and right subtrees
            res += leftTrees * rightTrees;
        }

        return res; // Return the total count of unique BSTs
    }
}
