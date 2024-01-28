package com.roushan._12_StacksAndQueues;

import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class _17_LargestRectangleHistogram {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 2};
        int ans = largestRectangleArea(arr);
        System.out.println(ans);
        int ans2 = largestRectangleArea2(arr);
        System.out.println(ans2);
        int ans3 = getMaxArea(arr);
        System.out.println(ans3);
    }

    //solution in gfg stack playlist.
    //1st way naive approach which will take O(n^2) time complexity, And it's showing time limit exceed for large data.
    public static int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    //2nd way better approach it will not show time limit exceeds.
    public static int largestRectangleArea2(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[] ps = new int[n];
        int[] ns = new int[n];

        Stack<Integer> s = new Stack<>();
        s.push(0);

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();
            int pse = s.isEmpty() ? -1 : s.peek();
            ps[i] = pse;
            s.push(i);
        }

        while (!s.isEmpty()) {
            s.pop();
        }

        s.push(n - 1);
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();
            int nse = s.isEmpty() ? n : s.peek();
            ns[i] = nse;
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            curr += (i - ps[i] - 1) * arr[i];
            curr += (ns[i] - i - 1) * arr[i];
            res = Math.max(res, curr);
        }
        return res;
    }

    //3rd approach best way.
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
