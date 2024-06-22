package com.roushan._19_DynamicProgramming;

public class _35_EggDroppingPuzzleUsingRecursion {
    public static void main(String[] args) {
        int e = 2; // Number of eggs
        int f = 36 ; // Number of floors
        int ans = trial(f, e); // Call the trial function
        System.out.println(ans); // Output the minimum number of trials
    }

    /**
     * Function to determine the minimum number of trials needed to find the critical floor
     * @param f - the number of floors
     * @param e - the number of eggs
     * @return minimum number of trials needed
     */
    public static int trial(int f, int e) {
        // Base case 1: If there is only one egg, we need to try each floor one by one
        if (e == 1) {
            return f;
        }

        // Base case 2: If there is only one floor, we need only one trial
        if (f == 1) {
            return 1;
        }

        // Base case 3: If there are no floors, no trials are needed
        if (f == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE; // Initialize the result to a large number

        // Consider dropping the egg from each floor and calculate the number of trials in the worst case
        for (int i = 1; i <= f; i++) {
            // If the egg breaks, we need to check the floors below (i-1) with one less egg (e-1)
            // If the egg doesn't break, we need to check the floors above (f-i) with the same number of eggs (e)
            int subRes = Math.max(trial(i - 1, e - 1), trial(f - i, e)) + 1;

            // Find the minimum of these trials
            res = Math.min(subRes, res);
        }

        return res; // Return the minimum number of trials needed
    }
}

/*
Time Complexity:
The time complexity of this recursive solution is exponential, specifically O(2^f * e), where f is the number of floors and e is the number of eggs. This is because the function makes two recursive calls for each floor.

Space Complexity:
The space complexity is O(f * e) due to the recursion stack, where f is the number of floors and e is the number of eggs.
*/
