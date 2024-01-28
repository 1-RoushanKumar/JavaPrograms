package com.roushan._12_StacksAndQueues;
//https://leetcode.com/problems/maximal-rectangle/description/
//https://youtu.be/oaN9ibZKMpA

import java.util.Stack;

public class _18_LargestRectangleOfAll_1s {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '1', '0', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}};
        int ans = maximalRectangle(matrix);
        System.out.println(ans);
    }

    public static int maximalRectangle(char[][] matrix) {
        //given matrix is in character form, so, we must first convert it into integer type matrix.
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[i][j] = (int) (matrix[i][j]) - 48;
            }
        }
        //now we send each row to function getMaxArea to find the maximum area each row of the matrix like the previous question.
        int[] currRow = newMatrix[0];
        int maxAns = getMaxArea(currRow);
        for (int i = 1; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                if (newMatrix[i][j] == 1) {
                    currRow[j] += 1;
                } else {
                    currRow[j] = 0;
                }
            }
            int currAns = getMaxArea(currRow);
            maxAns = Math.max(maxAns, currAns);
        }
        return maxAns;
    }

    public static int getMaxArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int res = 0;
        int tp;
        int curr;
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                tp = s.peek();
                s.pop();
                curr = arr[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
                res = Math.max(res, curr);
            }
            s.add(i);
        }
        while (!s.isEmpty()) {
            tp = s.peek();
            s.pop();
            curr = arr[tp] * (s.isEmpty() ? n : n - s.peek() - 1);
            res = Math.max(res, curr);
        }

        return res;

    }
}
