//consider maze::
//|s| | |
//| |O| |
//| | |e|
//s(start),e(exit),O(obstacles).

package com.roushan._9_Recursions;

public class _32_RecursionMazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] obs = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        System.out.println("The no. of way to exit::");
        path("", obs, 0, 0);
    }

    static void path(String p, boolean[][] maze, int row, int coloum) {
        if (row == maze.length - 1 && coloum == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[row][coloum]) {
            return;
        }
        if (row < maze.length - 1) {
            path(p + 'D', maze, row + 1, coloum);
        }
        if (coloum < maze[0].length - 1) {
            path(p + 'R', maze, row, coloum + 1);
        }
    }
}
