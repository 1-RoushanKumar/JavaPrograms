//I only can go down and right.
//consider maze::
//|s| | |
//| | | |
//| | |e|
//No of way to go to the point e is 6.
//Path how it's reaching to the end point.1st way Down,Down,Right,Right.Similarly, there are 5 more way.
package com.roushan._9_Recursions;

import java.util.ArrayList;

public class _30_RecursionPathForPreviousQuestion {
    public static void main(String[] args) {
        path("", 3, 3);
        System.out.println();
        System.out.println(path2("", 3, 3));
    }

    static void path(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.print(p + " ");
            return;
        }
        if (row > 1) {
            path(p + 'D', row - 1, col);
        }
        if (col > 1) {
            path(p + 'R', row, col - 1);
        }
    }

    static ArrayList<String> path2(String p, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();

        if (row > 1) {
            left = path2(p + 'D', row - 1, col);
        }
        if (col > 1) {
            right = path2(p + 'R', row, col - 1);
        }
        left.addAll(right);
        return left;
    }
}
