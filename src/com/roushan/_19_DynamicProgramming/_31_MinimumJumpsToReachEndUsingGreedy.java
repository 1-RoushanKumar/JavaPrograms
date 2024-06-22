package com.roushan._19_DynamicProgramming;
//https://youtu.be/9kyHYVxL4fw
public class _31_MinimumJumpsToReachEndUsingGreedy {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        int n = arr.length;
        int jump = 0; // Number of jumps needed to reach the end
        int farthest = 0; // The Farthest index that can be reached with the current number of jumps
        int prevMaxJumpIndex = 0; // The end of the range that can be reached with the current number of jumps

        for (int i = 0; i < n - 1; i++) { // Loop until the second last element
            farthest = Math.max(farthest, i + arr[i]); // Update the farthest index that can be reached
            if (i == prevMaxJumpIndex) { // If we've reached the end of the current range
                prevMaxJumpIndex = farthest; // Update the range to the farthest index we can reach
                jump++; // Increment the jump count
                if (farthest >= n - 1) { // If the farthest index is beyond or at the last element
                    break; // Break out of the loop as we've reached the end
                }
            }
        }
        System.out.println(jump); // Output the minimum number of jumps to reach the end
    }
}

/*
Time Complexity:
The time complexity of this solution is O(n), where n is the length of the array.
This is because we are making a single pass through the array.

Space Complexity:
The space complexity is O(1) because we are using a constant amount of extra space.
*/
