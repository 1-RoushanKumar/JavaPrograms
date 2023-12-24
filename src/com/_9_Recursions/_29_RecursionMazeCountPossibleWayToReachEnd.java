//I only can go right and down.
//consider maze::
//|s| | |
//| | | |
//| | |e|
//No of way to go to the point e is 6.

package com._9_Recursions;

public class _29_RecursionMazeCountPossibleWayToReachEnd {
    public static void main(String[] args) {
        System.out.println("No. of ways are::" + count(3, 3));
    }

    static int count(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int left = count(row - 1, col);
        int right = count(row, col - 1);
        return left + right;
    }
}
