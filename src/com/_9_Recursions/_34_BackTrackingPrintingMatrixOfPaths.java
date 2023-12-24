//https://youtu.be/zg5v2rlV1tM?t=4459
package com._9_Recursions;

import java.util.Arrays;

public class _34_BackTrackingPrintingMatrixOfPaths {
    public static void main(String[] args) {
        boolean[][] obs = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[obs.length][obs[0].length];
        allPaths("", obs, 0, 0, path, 1);
    }

    static void allPaths(String p, boolean[][] maze, int row, int col, int[][] path, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            path[row][col] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[row][col]) {
            return;
        }

        //after visiting the path i am making false so, it will not again (by the above condition if(!maze[row][col]) and return)
        //that point and prevent stackoverflow.
        maze[row][col] = false;
        path[row][col] = step;

        if (row < maze.length - 1) {
            allPaths(p + 'D', maze, row + 1, col, path, step + 1);
        }
        if (col < maze[0].length - 1) {
            allPaths(p + 'R', maze, row, col + 1, path, step + 1);
        }
        if (row > 0) {
            allPaths(p + 'U', maze, row - 1, col, path, step + 1);
        }
        if (col > 0) {
            allPaths(p + 'L', maze, row, col - 1, path, step + 1);
        }

        //when we make the false it should also be made true for know further path so it can be used again when needed
        maze[row][col] = true;
        path[row][col] = 0;
    }

}
