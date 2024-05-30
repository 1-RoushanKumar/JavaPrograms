package com.roushan._15_Heap;

import java.util.*;

public class TimeOfExecutionOfCode10And11 {

    // 1st Code
    public static void merge1(int[][] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                res.add(anInt);
            }
        }
        Collections.sort(res);
    }

    // 2nd Code
    public static int[] mergeSort2(int[][] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge2(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        int[] left = mergeSort2(lists, start, mid);
        int[] right = mergeSort2(lists, mid + 1, end);
        return merge2(left, right);
    }

    public static int[] merge2(int[] l1, int[] l2) {
        int[] result = new int[l1.length + l2.length];
        int i = 0, j = 0, k = 0;
        while (i < l1.length && j < l2.length) {
            if (l1[i] > l2[j]) {
                result[k++] = l2[j++];
            } else {
                result[k++] = l1[i++];
            }
        }
        while (i < l1.length) {
            result[k++] = l1[i++];
        }
        while (j < l2.length) {
            result[k++] = l2[j++];
        }
        return result;
    }

    // Optimized 3rd Code
    public static List<Integer> merge3(ArrayList<ArrayList<Integer>> arr) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < arr.size(); i++) {
            pq.add(new int[]{arr.get(i).get(0), i, 0});
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            res.add(curr[0]);
            int ap = curr[1];
            int vp = curr[2];
            if (vp + 1 < arr.get(ap).size()) {
                pq.add(new int[]{arr.get(ap).get(vp + 1), ap, vp + 1});
            }
        }
        return res;
    }

    // Function to generate a large test case
    public static int[][] generateLargeTestCase(int numArrays, int arraySize) {
        Random rand = new Random();
        int[][] arr = new int[numArrays][arraySize];
        for (int i = 0; i < numArrays; i++) {
            arr[i][0] = rand.nextInt(10);
            for (int j = 1; j < arraySize; j++) {
                arr[i][j] = arr[i][j - 1] + rand.nextInt(10);
            }
        }
        return arr;
    }

    public static ArrayList<ArrayList<Integer>> generateLargeTestCaseArrayList(int numArrays, int arraySize) {
        Random rand = new Random();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < numArrays; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(rand.nextInt(10));
            for (int j = 1; j < arraySize; j++) {
                list.add(list.get(j - 1) + rand.nextInt(10));
            }
            arr.add(list);
        }
        return arr;
    }

    public static void main(String[] args) {
        int numArrays = 1000;
        int arraySize = 1000;

        int[][] arr1 = generateLargeTestCase(numArrays, arraySize);
        ArrayList<ArrayList<Integer>> arr2 = generateLargeTestCaseArrayList(numArrays, arraySize);

        // Number of repetitions for averaging the execution time
        int repetitions = 5;

        // Measure time for 1st code
        long totalTime1 = 0;
        for (int i = 0; i < repetitions; i++) {
            long start1 = System.nanoTime();
            merge1(arr1);
            long end1 = System.nanoTime();
            totalTime1 += (end1 - start1);
        }
        System.out.println("1st code average execution time: " + (totalTime1 / repetitions) / 1e6 + " ms");

        // Measure time for 2nd code
        long totalTime2 = 0;
        for (int i = 0; i < repetitions; i++) {
            long start2 = System.nanoTime();
            mergeSort2(arr1, 0, arr1.length - 1);
            long end2 = System.nanoTime();
            totalTime2 += (end2 - start2);
        }
        System.out.println("2nd code average execution time: " + (totalTime2 / repetitions) / 1e6 + " ms");

        // Measure time for 3rd code
        long totalTime3 = 0;
        for (int i = 0; i < repetitions; i++) {
            long start3 = System.nanoTime();
            merge3(arr2);
            long end3 = System.nanoTime();
            totalTime3 += (end3 - start3);
        }
        System.out.println("3rd code average execution time: " + (totalTime3 / repetitions) / 1e6 + " ms");
    }
}
