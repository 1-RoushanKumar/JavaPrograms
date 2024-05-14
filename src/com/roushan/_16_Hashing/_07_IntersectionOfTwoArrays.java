package com.roushan._16_Hashing;

import java.util.HashSet;

//count the number of elements which is similar in both arrays.
public class _07_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {10, 15, 20, 15, 30, 30, 5};
        int[] arr2 = {30, 5, 30, 80};
        int count = findIntersection(arr1, arr2);
        System.out.println("Number of intersections are::" + count);
        count = findIntersection2(arr1, arr2);
        System.out.println("Number of intersections are::" + count);
    }

    //Naive approach timeComplexity = O(n*(n+m)) and space complexity O(1).
    private static int findIntersection(int[] arr1, int[] arr2) {
        int count = 0;
        int n = arr1.length;
        int m = arr2.length;
        //this loop iterates through all elements of the array 1.
        for (int i = 0; i < n; i++) {
            //this boolean for checking duplicates.
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr1[i] == arr1[j]) {
                    flag = true;
                }
            }
            if (flag == true) {
                continue;
            }
            //here finding intersection and counting them
            for (int k = 0; k < m; k++) {
                if (arr1[i] == arr2[k]) {
                    count++;
                    break;  //this break condition is important because we only need to count one element intersection one time and break.
                }
            }
        }
        return count;
    }

    //Optimal solution:Time complexity O(n+m) and Space Complexity O(n).
    public static int findIntersection2(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int count = 0;
        //add all the elements of the array1 in hashset.
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {  //time = O(n)
            s.add(arr1[i]);
        }
        //now check each element of array2 that contained in hashset or not
        for (int j = 0; j < m; j++) {    //time = O(m)
            if (s.contains(arr2[j])) {
                count++;
                //but there is a chance array 2 contain duplicate which search the same element again in hashset
                //for this when we counted the element we remove it from the hashset
                s.remove(arr2[j]);
            }
        }
        return count;
    }
}
