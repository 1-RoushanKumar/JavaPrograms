//I only can go right and down.
//consider maze::
//|s| | |
//| | | |
//| | |e|
//No of way to go to the point e is 6.

package com.roushan._9_Recursions;

public class _29_RecursionMazeCountPossibleWayToReachEnd {
    public static void main(String[] args) {
        System.out.println("No. of ways are::" + count(3, 3));
    }

    static int count(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int left = 0, right = 0;
        if (row > 0) {
            left = count(row - 1, col);
        }
        if (col > 0) {
            right = count(row, col - 1);
        }
        return left + right;
    }
}

