package com._9_Recursions;

import java.util.ArrayList;
public class _28_RecursionDicePossibleCombinations {
    public static void main(String[] args) {
        dice("", 4);
        System.out.println();
        System.out.println(dice2("", 4));
    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.print(p + " ");
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static ArrayList<String> dice2(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> left = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            left.addAll(dice2(p + i, target - i));
        }
        return left;
    }
}
