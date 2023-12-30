//consider maze::
//|s| | |
//| | | |
//| | |e|

package com.roushan._9_Recursions;

public class _31_RecursionSameAsPreviousButWeCanGoDiagonally {
    public static void main(String[] args) {
        path("", 3, 3);
    }

    static void path(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.print(p + " ");
            return;
        }
        if (row > 1) {
            path(p + 'D', row - 1, col);
        }
        if (row > 1 && col > 1) {
            path(p + 'X', row - 1, col - 1); //X represent diagonal.
        }
        if (col > 1) {
            path(p + 'R', row, col - 1);
        }
    }
}
