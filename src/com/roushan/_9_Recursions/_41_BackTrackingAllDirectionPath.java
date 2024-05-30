//https://youtu.be/zg5v2rlV1tM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=2883

//consider maze::
//|s| | |
//| | | |
//| | |e|
//s(start),e(exit).
//In previous question I am going only right and down.
//But what happen I want to travel towards the exit with all four direction.Like Up,Down,Right,Left.
//In recursion, we can simply add new condition to go up and left also.
//But this will show stackoverflow because when we change path there is a chance of calling the same function parameter
//again which will cause recursion to run infinitely

//One solution is to mark the path which is already cover by false so, it will not go to the same path again and then
//prevent stackoverflow.

//But one problem is when we get new call it must be true so, we can access that path again for future possibilities
//So, we need to make that false path true which don't cause overflow.
//How we make that false statement true solution is backtracking.
//Backtracking is also a recursion.

package com.roushan._9_Recursions;

public class _41_BackTrackingAllDirectionPath {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true} 
        };
        allPaths("", maze, 0, 0);
    }

    static void allPaths(String p, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.print(p + " ");
            return;
        }
        if (!maze[row][col]) {
            return;
        }

        //after visiting the path i am making false so, it will not again (by the above condition if(!maze[row][col]) and return)
        //that point and prevent stackoverflow.
        maze[row][col] = false;

        if (row < maze.length - 1) {
            allPaths(p + 'D', maze, row + 1, col);
        }
        if (col < maze[0].length - 1) {
            allPaths(p + 'R', maze, row, col + 1);
        }
        if (row > 0) {
            allPaths(p + 'U', maze, row - 1, col);
        }
        if (col > 0) {
            allPaths(p + 'L', maze, row, col - 1);
        }

        //when we make the false it should also be made true for know further path so it can be used again when needed
        maze[row][col] = true;
    }

}
//What backtracking says?
//Backtracking says,
//Whatever changes we're making via recursion call ,when these recursion call is over then those changes should also be gone.
